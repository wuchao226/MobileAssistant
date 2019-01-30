package com.wuc.store.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author: wuchao
 * @date: 2018/10/29 10:32
 * @desciption: 推荐数据
 */
public class RecommendBean implements MultiItemEntity {

    public static final int ITEM_BANNER = 0;
    public static final int ITEM_NAV = 1;
    public static final int ITEM_APP = 2;
    public static final int ITEM_GAME = 3;

    private int itemType;
    private List<Banner> banners;
    private List<AppInfo> recommendApps;
    private List<AppInfo> recommendGames;
    public RecommendBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<AppInfo> getRecommendApps() {
        return recommendApps;
    }

    public void setRecommendApps(List<AppInfo> recommendApps) {
        this.recommendApps = recommendApps;
    }

    public List<AppInfo> getRecommendGames() {
        return recommendGames;
    }

    public void setRecommendGames(List<AppInfo> recommendGames) {
        this.recommendGames = recommendGames;
    }

}
