package com.wuc.store.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wuc.store.R;
import com.wuc.store.bean.RecommendBean;
import com.wuc.store.util.LoggerUtils;
import com.wuc.store.widgets.BannerImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: wuchao
 * @date: 2018/11/5 14:25
 * @desciption: 推荐 适配器
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int ITEM_BANNER = 0;
    private final int ITEM_NAV = 1;
    private final int ITEM_APP = 2;
    private final int ITEM_GAME = 3;

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private RecommendBean mBean;

    public RecommendAdapter(Context context, RecommendBean bean) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mBean = bean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == ITEM_BANNER) {
            return new BannerHolder(mLayoutInflater
                    .inflate(R.layout.item_list_recommend_banner, viewGroup, false));
        } else if (viewType == ITEM_NAV) {
            return new NavHolder(mLayoutInflater
                    .inflate(R.layout.item_list_recommend_nav, viewGroup, false));
        } else if (viewType == ITEM_APP) {
            return new AppHolder(mLayoutInflater
                    .inflate(R.layout.item_list_recommend_hot_app, null, false));
        } else if (viewType == ITEM_GAME) {
            return new AppHolder(mLayoutInflater
                    .inflate(R.layout.item_list_recommend_hot_app, null, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ITEM_BANNER) {
            List<String> imageUrls = new ArrayList<>();
            for (int i = 0; i < mBean.getBanners().size(); i++) {
                imageUrls.add(mBean.getBanners().get(i).getThumbnail());
            }
            BannerHolder bannerHolder = (BannerHolder) holder;
            bannerHolder.mBanner
                    .setImageLoader(new BannerImageLoader())
                    .setImages(imageUrls)
                    .isAutoPlay(true)
                    .start();

        } else if (holder.getItemViewType() == ITEM_NAV) {

        } else {
            AppHolder appHolder = (AppHolder) holder;
            AppInfoAdapter adapter = AppInfoAdapter.builder().setShowPosition(true).build();
            if (holder.getItemViewType() == ITEM_APP) {
                appHolder.mTvTitle.setText(mContext.getText(R.string.hot_app));
                adapter.addData(mBean.getRecommendApps());
                LoggerUtils.d("app size-->" + mBean.getRecommendApps().size());
            } else if (holder.getItemViewType() == ITEM_GAME) {
                appHolder.mTvTitle.setText(mContext.getText(R.string.hot_game));
                adapter.addData(mBean.getRecommendGames());
                LoggerUtils.d("game size-->" + mBean.getRecommendGames().size());
            }
            appHolder.mRecyclerApp.setLayoutManager(new LinearLayoutManager(mContext));
            appHolder.mRecyclerApp.setAdapter(adapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_BANNER;
        } else if (position == 1) {
            return ITEM_NAV;
        } else if (position == 2) {
            return ITEM_APP;
        } else if (position == 3) {
            return ITEM_GAME;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class BannerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner mBanner;

        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class NavHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nav_app)
        TextView mNavApp;
        @BindView(R.id.nav_game)
        TextView mNavGame;
        @BindView(R.id.nav_theme)
        TextView mNavTheme;

        public NavHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class AppHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.recycler_app)
        RecyclerView mRecyclerApp;

        public AppHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
