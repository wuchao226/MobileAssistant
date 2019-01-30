package com.wuc.store.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.wuc.store.R;
import com.wuc.store.base.BaseActivity;
import com.wuc.store.common.Constant;
import com.wuc.store.ui.fragment.GuideFragment;
import com.wuc.store.util.SpUtils;
import com.wuc.store.util.UiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: wuchao
 * @date: 2018/11/12 18:41
 * @desciption: 向导
 */
public class GuideActivity extends BaseActivity {
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.iv1)
    ImageView mIv1;
    @BindView(R.id.iv2)
    ImageView mIv2;
    @BindView(R.id.iv3)
    ImageView mIv3;
    @BindView(R.id.btn_start)
    Button mBtnStart;

    private List<GuideFragment> mFragments;

    @Override
    public int setLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mFragments = new ArrayList<>();
        mFragments.add(GuideFragment.newInstance(UiUtils.getColor(R.color.color_bg_guide1),
                R.drawable.guide_1, UiUtils.getString(R.string.guide_1)));
        mFragments.add(GuideFragment.newInstance(UiUtils.getColor(R.color.color_bg_guide2),
                R.drawable.guide_2, UiUtils.getString(R.string.guide_2)));
        mFragments.add(GuideFragment.newInstance(UiUtils.getColor(R.color.color_bg_guide3),
                R.drawable.guide_3, UiUtils.getString(R.string.guide_3)));
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new MyPagerChangeListener());
    }

    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        SpUtils.putBoolean(Constant.IS_SHOW_GUIDE, true);
        openActivity(MainActivity.class);
        this.finish();
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mBtnStart.setVisibility(View.GONE);
            mIv1.setImageResource(R.mipmap.dot_normal);
            mIv2.setImageResource(R.mipmap.dot_normal);
            mIv3.setImageResource(R.mipmap.dot_normal);
            if (position == 0) {
                mIv1.setImageResource(R.mipmap.dot_focus);
            } else if (position == 1) {
                mIv2.setImageResource(R.mipmap.dot_focus);
            } else if (position == 2) {
                mIv3.setImageResource(R.mipmap.dot_focus);
                mBtnStart.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
