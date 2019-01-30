package com.wuc.store.mvp.presenter;

import com.wuc.store.base.mvpbase.BasePresenter;
import com.wuc.store.bean.AppInfoDetail;
import com.wuc.store.mvp.model.AppDetailModel;
import com.wuc.store.mvp.view.AppDetailView;
import com.wuc.store.net.rx.BaseObserver;

/**
 * @author: wuchao
 * @date: 2018/11/27 10:46
 * @desciption: APP 详情
 */
public class AppDetailPresenter extends BasePresenter<AppDetailView> {

    private AppDetailModel mModel;

    public AppDetailPresenter(AppDetailModel model) {
        mModel = model;
    }

    public void getAppDetailData(int id) {
        mModel.getAppDetailData(id)
                .subscribe(new BaseObserver<AppInfoDetail>(mPresentView) {
                    @Override
                    public void onNext(AppInfoDetail appInfoDetail) {
                        super.onNext(appInfoDetail);
                        mPresentView.onAppDetailData(appInfoDetail);
                    }
                });
    }
}
