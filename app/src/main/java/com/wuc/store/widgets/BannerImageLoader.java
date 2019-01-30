package com.wuc.store.widgets;

import android.content.Context;
import android.widget.ImageView;

import com.wuc.store.util.GlideUtils;
import com.youth.banner.loader.ImageLoader;

/**
 * @author: wuchao
 * @date: 2018/11/6 17:33
 * @desciption: Banner 图片加载器
 */
public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        GlideUtils.loadImage(context, (String) path, imageView);
    }

    /**
     * 自定义ImageView的创建
     * @param context
     * @return
     */
    @Override
    public ImageView createImageView(Context context) {
        return super.createImageView(context);
    }
}
