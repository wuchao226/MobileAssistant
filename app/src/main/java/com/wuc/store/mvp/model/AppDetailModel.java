package com.wuc.store.mvp.model;

import com.wuc.store.bean.AppInfoDetail;
import com.wuc.store.net.RetrofitFactory;
import com.wuc.store.net.api.ApiService;
import com.wuc.store.net.rx.RxTransformResponse;

import io.reactivex.Observable;

/**
 * @author: wuchao
 * @date: 2018/11/27 10:47
 * @desciption: APP详情
 */
public class AppDetailModel {

    public Observable<AppInfoDetail> getAppDetailData(int id) {
        return RetrofitFactory.getInstance().create(ApiService.class)
                .getAppDetailData(id).compose(RxTransformResponse.<AppInfoDetail>compatResult());
    }
}
