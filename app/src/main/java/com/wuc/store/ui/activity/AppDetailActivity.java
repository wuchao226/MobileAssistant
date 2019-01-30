package com.wuc.store.ui.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;

import com.wuc.store.R;
import com.wuc.store.base.BaseMvpActivity;
import com.wuc.store.bean.AppInfo;
import com.wuc.store.bean.AppInfoDetail;
import com.wuc.store.mvp.model.AppDetailModel;
import com.wuc.store.mvp.presenter.AppDetailPresenter;
import com.wuc.store.mvp.view.AppDetailView;
import com.wuc.store.util.UiUtils;

import butterknife.BindView;

/**
 * @author: wuchao
 * @date: 2018/11/23 17:06
 * @desciption: APP详情页
 */
public class AppDetailActivity extends BaseMvpActivity<AppDetailView, AppDetailPresenter> implements AppDetailView {

    @BindView(R.id.img_catch_view)
    AppCompatImageView mImgCatchView;


    private AppDetailPresenter mPresenter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_app_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        View view = mApplication.getView();
        Bitmap bitmap = getViewImageCache(view);
        if (bitmap != null) {
            mImgCatchView.setBackgroundDrawable(new BitmapDrawable(null, bitmap));
        }

        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];


        ViewGroup.MarginLayoutParams marginParams =
                new ViewGroup.MarginLayoutParams(mImgCatchView.getLayoutParams());

        marginParams.leftMargin = left;
        marginParams.topMargin = top - UiUtils.getStatusBarHeight();
        marginParams.height = view.getHeight();
        marginParams.width = view.getWidth();
        LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(marginParams);
        mImgCatchView.setLayoutParams(params);

    }

    private Bitmap getViewImageCache(View view) {
        view.setDrawingCacheEnabled(true);
        //view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        if (bitmap == null) {
            return null;
        }
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight());
        view.destroyDrawingCache();
        return bitmap;
    }


    @Override
    protected AppDetailPresenter initPresenter() {
        AppDetailModel model = new AppDetailModel();
        mPresenter = new AppDetailPresenter(model);
        return mPresenter;
    }

    @Override
    protected AppDetailView initPresenterView() {
        return this;
    }

    @Override
    protected void loadData() {
        AppInfo appInfo = (AppInfo) getIntent().getSerializableExtra("appinfo");
        mPresenter.getAppDetailData(appInfo.getId());
    }

    @Override
    public void onAppDetailData(AppInfoDetail appInfoDetail) {

    }
}
