package com.wuc.store.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wuc.store.base.mvpbase.BasePresenter;
import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.widgets.ProgressLoading;

/**
 * @author: wuchao
 * @date: 2018/10/28 14:30
 * @desciption: activity 实现 MVP 的基类
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>>
        extends BaseActivity implements BaseView {

    private P mPresenter;
    private ProgressLoading mProgressLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = initPresenter();
        mPresenter.attachView(initPresenterView());
        //初始化加载对话框
        mProgressLoading = ProgressLoading.create(this);

        loadData();
    }

    @Override
    protected void onDestroy() {
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

    /**
     * 加载数据
     */
    protected void loadData() {

    }

    @Override
    public void showLoading() {
        mProgressLoading.showLoading();
    }

    @Override
    public void hideLoading() {
        mProgressLoading.hideLoading();
    }
}
