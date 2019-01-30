package com.wuc.store.mvp.view;

import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.bean.AppInfo;
import com.wuc.store.bean.PageBean;

/**
 * @author: wuchao
 * @date: 2018/10/29 17:54
 * @desciption: app 回调视图
 */
public interface AppInfoView extends BaseView {

    /**
     * app 数据结果回调
     * @param pageBean
     */
    void onResult(PageBean<AppInfo> pageBean);
}
