package com.wuc.store.widgets;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wuc.store.R;

/**
 * @author: wuchao
 * @date: 2018/11/9 10:35
 * @desciption: 加载对话框封装
 */
public class ProgressLoading extends Dialog {

    private static AnimationDrawable sAnimationDrawable;

    private ProgressLoading(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    /**
     * 创建加载对话框
     *
     * @param context
     * @return
     */
    public static ProgressLoading create(Context context) {
        //样式引入
        ProgressLoading dialog = new ProgressLoading(context, R.style.LightProgressDialog);
        //设置布局
        dialog.setContentView(R.layout.progress_dialog);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setGravity(Gravity.CENTER);
            WindowManager.LayoutParams params = window.getAttributes();
            //dimAmount 在0.0f和1.0f之间，0.0f完全不暗，即背景是可见的 ，1.0f时候，背景全部变黑暗。
            //如果要达到背景全部变暗的效果，需要设置 window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND); 否则，背景无效果。
            params.dimAmount = 0.2f;
            //设置属性
            window.setAttributes(params);
        }
        AppCompatImageView loadingView = dialog.findViewById(R.id.iv_loading);
        sAnimationDrawable = (AnimationDrawable) loadingView.getBackground();
        return dialog;
    }

    /**
     * 显示加载对话框，动画开始
     */
    public void showLoading() {
        super.show();
        sAnimationDrawable.start();
    }

    /**
     * 隐藏加载对话框，动画停止
     */
    public void hideLoading() {
        super.dismiss();
        sAnimationDrawable.stop();
    }
}
