package com.wuc.store.mvp.model;

import com.wuc.store.bean.AppInfo;
import com.wuc.store.bean.PageBean;
import com.wuc.store.bean.RecommendBean;
import com.wuc.store.net.RetrofitFactory;
import com.wuc.store.net.api.ApiService;
import com.wuc.store.net.rx.RxTransformResponse;

import io.reactivex.Observable;

/**
 * @author: wuchao
 * @date: 2018/10/29 17:57
 * @desciption: 首页Model
 */
public class AppInfoModel {
    /**
     * 获取推荐数据
     *
     * @return
     */
    public Observable<RecommendBean> getRecommendData() {
        return RetrofitFactory.getInstance().create(ApiService.class).getRecommendData()
                .compose(RxTransformResponse.<RecommendBean>compatResult());
    }

    /**
     * 获取排行榜数据
     *
     * @param page
     * @return
     */
    public Observable<PageBean<AppInfo>> getRankData(int page) {
        return RetrofitFactory.getInstance().create(ApiService.class).topList(page)
                .compose(RxTransformResponse.<PageBean<AppInfo>>compatResult());
    }

    /**
     * 获取游戏数据
     *
     * @param page
     * @return
     */
    public Observable<PageBean<AppInfo>> getGameData(int page) {
        return RetrofitFactory.getInstance().create(ApiService.class).games(page)
                .compose(RxTransformResponse.<PageBean<AppInfo>>compatResult());
    }
}
