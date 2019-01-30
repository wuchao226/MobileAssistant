package com.wuc.store.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.wuc.store.base.mvpbase.BasePresenter;
import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.widgets.ProgressLoading;

/**
 * @author: wuchao
 * @date: 2018/10/28 14:30
 * @desciption: 懒加载 Fragment 实现 MVP 的基类
 */
public abstract class BaseLazyFragment<V extends BaseView, P extends BasePresenter<V>>
        extends BaseFragment implements BaseView {

    private P mPresenter;
    private ProgressLoading mProgressLoading;

    /**
     * view 是否初始化完成
     */
    private boolean isPrepared;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLazyLoad(true);
        isPrepared = true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onVisibleToUser();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isPrepared = false;
    }

    /**
     * 判断是否需要加载数据
     */
    private void onVisibleToUser() {
        //如果初始化完成，并且显示给用户
        if (isPrepared && getUserVisibleHint()) {
            loadData();
        }
    }

    /**
     * 如果与ViewPager一起使用，调用的是setUserVisibleHint
     *
     * @param isVisibleToUser 是否显示出来
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //显示状态发生变化
        onVisibleToUser();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attachView(initPresenterView());
        //初始化加载对话框
        mProgressLoading = ProgressLoading.create(getHoldingActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * 完成注入并返回注入的Presenter对象
     *
     * @return
     */
    protected abstract P initPresenter();

    /**
     * 初始化 Presenter 绑定的 view
     *
     * @return
     */
    protected abstract V initPresenterView();

    @Override
    public void showLoading() {
        mProgressLoading.showLoading();
    }

    @Override
    public void hideLoading() {
        mProgressLoading.hideLoading();
    }

}
