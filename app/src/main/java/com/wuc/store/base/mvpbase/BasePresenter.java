package com.wuc.store.base.mvpbase;

/**
 * @author: wuchao
 * @date: 2018/10/27 22:52
 * @desciption: MVP P层基类
 */
public class BasePresenter<V extends BaseView> {

    protected V mPresentView;

    /**
     * 绑定view
     *
     * @param view
     */
    public void attachView(V view) {
        this.mPresentView = view;
    }

    /**
     * 解绑view
     */
    public void detachView() {
        this.mPresentView = null;
    }
}
