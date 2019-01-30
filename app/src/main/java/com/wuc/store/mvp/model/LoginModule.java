package com.wuc.store.mvp.model;

import com.wuc.store.bean.LoginBean;
import com.wuc.store.bean.requestbean.LoginRequestBean;
import com.wuc.store.net.RetrofitFactory;
import com.wuc.store.net.api.ApiService;
import com.wuc.store.net.rx.RxTransformResponse;

import io.reactivex.Observable;

/**
 * @author: wuchao
 * @date: 2018/11/13 17:19
 * @desciption: 登录
 */
public class LoginModule {
    /**
     * 登录接口
     *
     * @param param
     * @return
     */
    public Observable<LoginBean> login(LoginRequestBean param) {
        return RetrofitFactory.getInstance().create(ApiService.class)
                .login(param).compose(RxTransformResponse.<LoginBean>compatResult());
    }
}
