package com.wuc.store.mvp.presenter;

import com.wuc.store.base.mvpbase.BasePresenter;
import com.wuc.store.bean.RecommendBean;
import com.wuc.store.mvp.model.AppInfoModel;
import com.wuc.store.mvp.view.RecommendView;
import com.wuc.store.net.rx.BaseObserver;

/**
 * @author: wuchao
 * @date: 2018/10/29 17:54
 * @desciption: 推荐 P 层
 */
public class RecommendPresenter extends BasePresenter<RecommendView> {

    private AppInfoModel mAppInfoModel;

    public RecommendPresenter(AppInfoModel appInfoModel) {
        mAppInfoModel = appInfoModel;
    }

    /**
     * 获取推荐数据
     */
    public void getRecommendData() {
        mAppInfoModel.getRecommendData().subscribe(new BaseObserver<RecommendBean>(mPresentView) {
            @Override
            public void onNext(RecommendBean indexBean) {
                super.onNext(indexBean);
                mPresentView.onRecommendResult(indexBean);
            }
        });
    }
}
