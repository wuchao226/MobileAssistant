package com.wuc.store.mvp.presenter;

import com.wuc.store.base.mvpbase.BasePresenter;
import com.wuc.store.bean.LoginBean;
import com.wuc.store.bean.requestbean.LoginRequestBean;
import com.wuc.store.mvp.model.LoginModule;
import com.wuc.store.mvp.view.LoginView;
import com.wuc.store.net.rx.BaseObserver;

/**
 * @author: wuchao
 * @date: 2018/11/13 11:51
 * @desciption: 登录
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginModule mLoginModule;

    public LoginPresenter(LoginModule loginModule) {
        mLoginModule = loginModule;
    }

    public void login(String phone, String password) {
        LoginRequestBean param = new LoginRequestBean();
        param.setEmail(phone);
        param.setPassword(password);
        mLoginModule.login(param)
                .subscribe(new BaseObserver<LoginBean>(mPresentView) {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        super.onNext(loginBean);
                        mPresentView.onLoginResult(loginBean);
                    }
                });
    }
}
