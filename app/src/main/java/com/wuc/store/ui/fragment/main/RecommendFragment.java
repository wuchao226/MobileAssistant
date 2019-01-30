package com.wuc.store.ui.fragment.main;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wuc.store.R;
import com.wuc.store.base.BaseLazyFragment;
import com.wuc.store.bean.RecommendBean;
import com.wuc.store.mvp.model.AppInfoModel;
import com.wuc.store.mvp.presenter.RecommendPresenter;
import com.wuc.store.mvp.view.RecommendView;
import com.wuc.store.ui.adapter.RecommendAdapter;

import butterknife.BindView;

/**
 * @author: wuchao
 * @date: 2018/10/26 15:22
 * @desciption: 推荐
 */
public class RecommendFragment extends BaseLazyFragment<RecommendView, RecommendPresenter> implements RecommendView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private RecommendPresenter mPresenter;

    @Override
    protected RecommendPresenter initPresenter() {
        AppInfoModel mainModel = new AppInfoModel();
        mPresenter = new RecommendPresenter(mainModel);
        return mPresenter;
    }

    @Override
    protected RecommendView initPresenterView() {
        return this;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void loadData() {
        mPresenter.getRecommendData();
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
    }

    /**
     * 推荐 回调
     *
     * @param result
     */
    @Override
    public void onRecommendResult(RecommendBean result) {
        RecommendAdapter adapter = new RecommendAdapter(getHoldingActivity(), result);
        mRecyclerView.setAdapter(adapter);
    }

}
