package com.wuc.store.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuchao
 * @date: 2018/11/13 17:50
 * @desciption: 文本输入辅助类，通过管理多个EditText输入是否为空来启用或者禁用按钮的点击事件
 */
public class EditTextInputHelper implements TextWatcher {

    /**
     * 操作按钮的view
     */
    private View mView;
    /**
     * 是否禁用后设置半透明
     */
    private boolean isAlpha;
    /**
     * EditText 集合
     */
    private List<EditText> mViewSet;

    public EditTextInputHelper(View view) {
        this(view, true);
    }

    /**
     * 构造函数
     *
     * @param view  跟随EditText输入为空来判断启动或者禁用这个View
     * @param alpha 是否需要设置透明度
     */
    public EditTextInputHelper(View view, boolean alpha) {
        if (view == null) {
            throw new IllegalArgumentException("The view is empty");
        }
        this.mView = view;
        this.isAlpha = alpha;
    }

    /**
     * 加入EditText
     *
     * @param views 传入一个或多个EditText
     */
    public void addViews(EditText... views) {
        if (views == null) {
            return;
        }
        if (mViewSet == null) {
            mViewSet = new ArrayList<>(views.length - 1);
        }
        for (EditText et : views) {
            et.addTextChangedListener(this);
            mViewSet.add(et);
        }
        afterTextChanged(null);
    }

    /**
     * 设置view的事件
     *
     * @param enable 启用或禁用view的事件
     */
    private void setEnable(boolean enable) {
        if (enable == mView.isEnabled()) {
            return;
        }
        if (enable) {
            //启用View的事件
            mView.setEnabled(true);
            if (isAlpha) {
                //设置不透明
                mView.setAlpha(1f);
            }
        } else {
            //禁用View的事件
            mView.setEnabled(false);
            if (isAlpha) {
                //设置半透明
                mView.setAlpha(0.5f);
            }
        }
    }

    /**
     * 移除EditText监听，避免内存泄漏
     */
    public void removeViews() {
        if (mViewSet == null) {
            return;
        }
        for (EditText et : mViewSet) {
            et.removeTextChangedListener(this);
        }
        mViewSet.clear();
        mViewSet = null;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mViewSet == null) {
            return;
        }
        for (EditText et : mViewSet) {
            if ("".equals(et.getText().toString())) {
                setEnable(false);
                return;
            }
        }
        setEnable(true);
    }
}
