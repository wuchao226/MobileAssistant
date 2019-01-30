package com.wuc.store.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wuc.store.common.AppApplication;
import com.wuc.store.util.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author: wuchao
 * @date: 2018/10/27 22:34
 * @desciption: activity 的基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected RxBus mRxBus;
    private Unbinder mUnbinder;

    protected AppApplication mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mRxBus = RxBus.get();
        mApplication= (AppApplication) getApplication();
        initView(savedInstanceState);
    }

    /**
     * layoutResID 布局的id
     *
     * @return
     */
    public abstract int setLayoutId();

    /**
     * 初始化view
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    /**
     * 打开Activity
     *
     * @param cls
     */
    protected void openActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
