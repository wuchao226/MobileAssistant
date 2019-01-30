package com.wuc.store.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuc.store.common.AppApplication;
import com.wuc.store.util.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author: wuchao
 * @date: 2018/10/27 22:38
 * @desciption: fragment 的基类
 */
public abstract class BaseFragment extends Fragment {

    protected View rootView;
    private Unbinder mUnbinder;
    private BaseActivity mActivity;
    protected RxBus mRxBus;
    /**
     * 是否启用懒加载，仅对 BaseLazyFragment 有效
     */
    private boolean isLazyLoad;

    protected AppApplication mApplication;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxBus = RxBus.get();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("setLayout() type must be int or View");
        }
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
        mApplication= (AppApplication) getHoldingActivity().getApplication();
        //如果不是懒加载，创建后就加载数据
        if (!isLazyLoad) {
            loadData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    /**
     * 加载数据
     */
    protected abstract void loadData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * layoutRes 布局的
     *
     * @return
     */
    protected abstract Object setLayout();

    /**
     * 是否启用懒加载，仅对 BaseLazyFragment 有效
     */
    public void setLazyLoad(boolean lazyLoad) {
        isLazyLoad = lazyLoad;
    }

    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    /**
     * findViewById 查找view
     *
     * @param id
     * @return
     */
    protected <T extends View> T findViewById(int id) {
        return (T) getContentView().findViewById(id);
    }

    /**
     * 子类传递过来的view视图
     *
     * @return
     */
    protected View getContentView() {
        return rootView;
    }
}
