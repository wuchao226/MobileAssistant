package com.wuc.store.mvp.presenter;

import com.wuc.store.base.mvpbase.BasePresenter;
import com.wuc.store.bean.AppInfo;
import com.wuc.store.bean.PageBean;
import com.wuc.store.mvp.model.AppInfoModel;
import com.wuc.store.mvp.view.AppInfoView;
import com.wuc.store.net.rx.BaseObserver;

/**
 * @author: wuchao
 * @date: 2018/10/29 17:54
 * @desciption: app P 层
 */
public class AppInfoPresenter extends BasePresenter<AppInfoView> {
    /**
     * 排行榜标识
     */
    public static final int RANK = 1;
    /**
     * 游戏标识
     */
    public static final int GAME = 2;

    private AppInfoModel mAppInfoModel;

    public AppInfoPresenter(AppInfoModel appInfoModel) {
        mAppInfoModel = appInfoModel;
    }

    /**
     * 获取排行榜数据
     */
    public void getApps(int type, final int page, final boolean isRefresh) {
        BaseObserver<PageBean<AppInfo>> observer = new BaseObserver<PageBean<AppInfo>>(mPresentView) {
            @Override
            protected boolean isShowLoading() {
                return page == 0 && !isRefresh;
            }

            @Override
            public void onNext(PageBean<AppInfo> appInfoPageBean) {
                super.onNext(appInfoPageBean);
                mPresentView.onResult(appInfoPageBean);
            }
        };
        switch (type) {
            //排行榜
            case RANK:
                mAppInfoModel.getRankData(page).subscribe(observer);
                break;
            //游戏
            case GAME:
                mAppInfoModel.getGameData(page).subscribe(observer);
                break;
            default:
        }
    }
}
