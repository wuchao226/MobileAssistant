package com.wuc.store.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuc.store.R;
import com.wuc.store.base.BaseFragment;

import butterknife.BindView;

/**
 * @author: wuchao
 * @date: 2018/11/12 23:15
 * @desciption: 向导 Fragment
 */
public class GuideFragment extends BaseFragment {

    public static final String IMG_ID = "IMG_ID";
    public static final String COLOR_ID = "COLOR_ID";
    public static final String TEXT_ID = "TEXT_ID";
    @BindView(R.id.imgView)
    AppCompatImageView mImgView;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.rootView)
    LinearLayout mRootView;

    public GuideFragment() {
    }

    public static GuideFragment newInstance(int bgResId, int imgResId, String txt) {
        GuideFragment fragment = new GuideFragment();
        Bundle args = new Bundle();
        args.putInt(COLOR_ID, bgResId);
        args.putInt(IMG_ID, imgResId);
        args.putString(TEXT_ID, txt);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        int colorId = bundle.getInt(COLOR_ID);
        int imgId = bundle.getInt(IMG_ID);
        String txt = bundle.getString(TEXT_ID);
        mRootView.setBackgroundColor(colorId);
        mImgView.setImageResource(imgId);
        mText.setText(txt);
    }

    @Override
    protected Object setLayout() {
        return R.layout.fragment_guide;
    }
}
