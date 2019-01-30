package com.wuc.store.net;

import com.wuc.store.common.Constant;
import com.wuc.store.net.interceptor.CommonParamInterceptor;
import com.wuc.store.util.LoggerUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: wuchao
 * @date: 2018/10/28 14:53
 * @desciption: Retrofit 单例
 */
public class RetrofitFactory {

    private RetrofitFactory() {
    }

    public static RetrofitFactory getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 具体服务实例化
     */
    public <T> T create(Class<T> tClass) {
        return RetrofitHolder.RETROFIT_CLIENT.create(tClass);
    }

    private static class Holder {
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();
    }

    /**
     * 构建全局retrofit
     */
    private static class RetrofitHolder {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 构建全局okhttp
     */
    private static class OkHttpHolder {
        /**
         * 连接超时时长x秒
         */
        private static final int CONNECT_TIME_OUT = 10;
        /**
         * 读数据超时时长x秒
         */
        private static final int READ_TIME_OUT = 10;
        /**
         * 写数据接超时时长x秒
         */
        private static final int WRITE_TIME_OUT = 10;

        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient().newBuilder()
                .addInterceptor(LogInterceptorHolder.INTERCEPTOR)
                .addInterceptor(new CommonParamInterceptor())
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 构建全局日志拦截
     */
    private static class LogInterceptorHolder {
        private static final HttpLoggingInterceptor INTERCEPTOR = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LoggerUtils.d(message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
