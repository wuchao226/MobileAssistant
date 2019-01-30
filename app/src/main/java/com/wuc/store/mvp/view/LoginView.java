package com.wuc.store.mvp.view;

import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.bean.LoginBean;

/**
 * @author: wuchao
 * @date: 2018/11/13 11:51
 * @desciption: 登录界面回调
 */
public interface LoginView extends BaseView {
    /**
     * 登录数据返回
     *
     * @param loginBean
     */
    void onLoginResult(LoginBean loginBean);
}
