package com.wuc.store.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author: wuchao
 * @date: 2018/11/6 17:34
 * @desciption: Glide 工具类
 */
public class GlideUtils {
    public static void loadImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(context).load(url).apply(options).into(imageView);
    }
}
