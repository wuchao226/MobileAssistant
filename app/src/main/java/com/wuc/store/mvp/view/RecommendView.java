package com.wuc.store.mvp.view;

import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.bean.RecommendBean;

/**
 * @author: wuchao
 * @date: 2018/10/29 17:54
 * @desciption: 推荐 回调视图
 */
public interface RecommendView extends BaseView {

    /**
     * 推荐结果回调
     * @param result
     */
    void onRecommendResult(RecommendBean result);
}
