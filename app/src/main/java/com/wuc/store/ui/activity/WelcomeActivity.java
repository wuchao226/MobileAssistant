package com.wuc.store.ui.activity;

import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.wuc.store.R;
import com.wuc.store.base.BaseActivity;
import com.wuc.store.common.Constant;
import com.wuc.store.util.SpUtils;

import butterknife.BindView;

/**
 * @author: wuchao
 * @date: 2018/11/12 18:29
 * @desciption: 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.pathView)
    PathView mPathView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mPathView.getPathAnimator()
                .delay(100)
                .duration(5000)
                .interpolator(new AccelerateDecelerateInterpolator())
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        jump();
                    }
                })
                .start();
    }

    /**
     * 跳转
     */
    private void jump() {
        boolean isShowGuide = SpUtils.getBoolean(Constant.IS_SHOW_GUIDE);
        if (!isShowGuide) {
            openActivity(GuideActivity.class);
        } else {
            openActivity(MainActivity.class);
        }
        this.finish();
    }
}
