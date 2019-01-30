package com.wuc.store.ui.fragment.main;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wuc.store.R;
import com.wuc.store.base.BaseLazyFragment;
import com.wuc.store.bean.AppInfo;
import com.wuc.store.bean.PageBean;
import com.wuc.store.mvp.model.AppInfoModel;
import com.wuc.store.mvp.presenter.AppInfoPresenter;
import com.wuc.store.mvp.view.AppInfoView;
import com.wuc.store.ui.activity.AppDetailActivity;
import com.wuc.store.ui.adapter.AppInfoAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * @author: wuchao
 * @date: 2018/11/12 17:48
 * @desciption:
 */
public abstract class BaseAppInfoFragment extends BaseLazyFragment<AppInfoView, AppInfoPresenter>
        implements AppInfoView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private AppInfoPresenter mPresenter;
    private int page = 0;
    private AppInfoAdapter mAdapter;
    private boolean isRefresh;

    @Override
    protected AppInfoPresenter initPresenter() {
        AppInfoModel model = new AppInfoModel();
        mPresenter = new AppInfoPresenter(model);
        return mPresenter;
    }

    @Override
    protected AppInfoView initPresenterView() {
        return this;
    }

    @Override
    protected void loadData() {
        loadingData();
    }

    @Override
    protected void initView() {
        mAdapter = buildAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setPreLoadNumber(2);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                //防止下来刷新时还可以上拉加载
                mAdapter.setEnableLoadMore(false);
                isRefresh = true;
                loadingData();
            }
        });
        mAdapter.setEnableLoadMore(true);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                isRefresh = false;
                loadingData();
            }
        }, mRecyclerView);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mApplication.setView(view);
                Intent intent = new Intent(getHoldingActivity(), AppDetailActivity.class);
                AppInfo appInfo = mAdapter.getItem(position);
                intent.putExtra("appinfo", appInfo);
                startActivity(intent);
            }
        });
    }

    /**
     * 适配器
     *
     * @return
     */
    protected abstract AppInfoAdapter buildAdapter();

    @Override
    protected Object setLayout() {
        return R.layout.fragment_main;
    }

    /**
     * 请求网络数据
     */
    private void loadingData() {
        mPresenter.getApps(appType(), page, isRefresh);
    }

    /**
     * APP 类型（排行，游戏）
     *
     * @return
     */
    protected abstract int appType();

    @Override
    public void onResult(PageBean<AppInfo> pageBean) {
        List<AppInfo> list = pageBean.getDatas();
        if (isRefresh) {
            mSwipeRefreshLayout.setRefreshing(false);
            mAdapter.setNewData(list);
            mAdapter.setEnableLoadMore(true);
        } else {
            mAdapter.addData(list);
        }
        if (pageBean.isHasMore()) {
            page++;
            //加载完成（注意不是加载结束，而是本次数据加载结束并且还有下页数据）
            mAdapter.loadMoreComplete();
        } else {
            //数据全部加载完毕
            mAdapter.loadMoreEnd();
        }
        mAdapter.setEnableLoadMore(pageBean.isHasMore());
    }
}
