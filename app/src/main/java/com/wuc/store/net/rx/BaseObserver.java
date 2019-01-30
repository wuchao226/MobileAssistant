package com.wuc.store.net.rx;

import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.net.exception.BaseException;
import com.wuc.store.net.exception.ErrorMessageFactory;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: wuchao
 * @date: 2018/10/29 13:34
 * @desciption: Rx 订阅者默认实现
 */
public class BaseObserver<T> implements Observer<T> {

    private BaseView mBaseView;

    protected BaseObserver(BaseView baseView) {
        this.mBaseView = baseView;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (isShowLoading()) {
            mBaseView.showLoading();
        }
    }

    /**
     * 是否显示加载框，默认显示
     *
     * @return
     */
    protected boolean isShowLoading() {
        return true;
    }

    @Override
    public void onNext(T t) {
        mBaseView.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        mBaseView.hideLoading();
        BaseException exception = ErrorMessageFactory.handleError(e);
        ErrorMessageFactory.showErrorMessage(exception);
    }

    @Override
    public void onComplete() {
        mBaseView.hideLoading();
    }
}
