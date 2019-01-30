package com.wuc.store.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wuc.store.bean.AppInfo;

import java.util.List;

/**
 * @author: wuchao
 * @date: 2018/11/5 14:25
 * @desciption: 排行榜 适配器
 */
public class RankAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {

    private String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";

    public RankAdapter(@Nullable List<AppInfo> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfo item) {

    }
}
