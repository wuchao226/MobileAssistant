package com.wuc.store.mvp.view;

import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.bean.AppInfoDetail;

/**
 * @author: wuchao
 * @date: 2018/11/27 10:45
 * @desciption: APP详情
 */
public interface AppDetailView extends BaseView {
    /**
     * APP详情回调
     *
     * @param appInfoDetail
     */
    void onAppDetailData(AppInfoDetail appInfoDetail);
}
