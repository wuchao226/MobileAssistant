package com.wuc.store.ui.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wuc.store.R;
import com.wuc.store.bean.AppInfo;
import com.wuc.store.common.Constant;
import com.wuc.store.util.GlideUtils;

import java.util.ArrayList;

/**
 * @author: wuchao
 * @date: 2018/11/5 14:25
 * @desciption: app 信息 适配器
 */
public class AppInfoAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {

    private Builder mBuilder;

    public AppInfoAdapter(Builder builder) {
        super(R.layout.item_list_app, new ArrayList<AppInfo>());
        mBuilder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfo item) {
        GlideUtils.loadImage(mContext, Constant.BASE_IMG_URL + item.getIcon(),
                (ImageView) helper.getView(R.id.img_app_icon));
        helper.setText(R.id.txt_app_name, item.getDisplayName())
                .setText(R.id.txt_position, (helper.getLayoutPosition() + 1) + ".")
                .setText(R.id.txt_publisher_name, item.getPublisherName())
                .setText(R.id.txt_brief, Formatter.formatFileSize(mContext, item.getApkSize()));
        AppCompatTextView txt_position = helper.getView(R.id.txt_position);
        txt_position.setVisibility(mBuilder.isShowPosition ? View.VISIBLE : View.GONE);
    }

    public static class Builder {
        private boolean isShowPosition;

        public Builder setShowPosition(boolean showPosition) {
            isShowPosition = showPosition;
            return this;
        }

        public AppInfoAdapter build() {
            return new AppInfoAdapter(this);
        }
    }
}
