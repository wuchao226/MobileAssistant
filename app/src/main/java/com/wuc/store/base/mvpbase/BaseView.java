package com.wuc.store.base.mvpbase;

/**
 * @author: wuchao
 * @date: 2018/10/27 22:52
 * @desciption: MVP 视图回调基类
 */
public interface BaseView {
    /**
     * 显示加载框
     */
    void showLoading();

    /**
     * 隐藏加载框
     */
    void hideLoading();
}
