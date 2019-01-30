package com.wuc.store.net.interceptor;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.wuc.store.common.Constant;
import com.wuc.store.net.HttpMethod;
import com.wuc.store.util.DevUtils;
import com.wuc.store.util.SpUtils;
import com.wuc.store.util.UiUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * @author: wuchao
 * @date: 2018/11/2 11:25
 * @desciption: 公共请求参数
 */
public class CommonParamInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HashMap<String, Object> rootMap = new HashMap<>();
        HashMap<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("imei", "5284047f4ffb4e04824a2fd1d1f0cd62");
        //paramsMap.put("imei", DevUtils.getIMEI());
        paramsMap.put("model", DevUtils.getModel());
        paramsMap.put("la", DevUtils.getLanguage());
        paramsMap.put("os", DevUtils.getBuildVersionIncremental());
        paramsMap.put("resolution", UiUtils.getScreenWidth() + "*" + UiUtils.getScreenHeight());
        paramsMap.put("sdk", DevUtils.getBuildVersionSDK() + "");
        paramsMap.put("densityScaleFactor", UiUtils.getResources().getDisplayMetrics().density + "");
        paramsMap.put("token", SpUtils.getString(Constant.KEY_SP_TOKEN));

        if (HttpMethod.GET.equals(request.method())) {
            HttpUrl httpUrl = request.url();
            Set<String> keys = httpUrl.queryParameterNames();
            for (String key : keys) {
                if ("p".equals(key)) {
                    String json = httpUrl.queryParameter("p");
                    if (!TextUtils.isEmpty(json)) {
                        HashMap<String, Object> map = new Gson().fromJson(json, HashMap.class);
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            rootMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    rootMap.put(key, httpUrl.queryParameter(key));
                }
            }
            rootMap.put("publicParams", paramsMap);
            String newJsonParams = new Gson().toJson(rootMap);
            String url = httpUrl.scheme() + "://" + httpUrl.host() + ":" + httpUrl.port() + httpUrl.encodedPath();
            //112.124.22.238/course_api/cniaoplay/featured2?p={"publicParams":{"resolution":"720*1184","sdk":"22","la":"en","densityScaleFactor":"2.0","os":"3728910","model":"Android SDK built for x86"},"page":0.0}
            url = url + "?" + "p" + "=" + newJsonParams;
            request = request.newBuilder().url(url).build();
        } else if (HttpMethod.POST.equals(request.method())) {
            RequestBody requestBody = request.body();
            if (requestBody instanceof FormBody) {
                FormBody body = (FormBody) requestBody;
                FormBody.Builder builder = new FormBody.Builder();
                for (int i = 0; i < body.size(); i++) {
                    builder.add(body.encodedName(i), body.encodedValue(i));
                }
                body = builder.build();
                request.newBuilder().post(body).build();
            } else {
                Buffer buffer = new Buffer();
                if (requestBody != null) {
                    requestBody.writeTo(buffer);
                }
                String oldJsonParams = buffer.readUtf8();
                rootMap = new Gson().fromJson(oldJsonParams, HashMap.class);
                rootMap.put("publicParams", paramsMap);
                String newJsonParams = new Gson().toJson(rootMap);
                request = request.newBuilder().post(RequestBody
                        .create(MediaType.parse("application/json; charset=utf-8"),
                                newJsonParams)).build();
            }
        }
        return chain.proceed(request);
    }
}
