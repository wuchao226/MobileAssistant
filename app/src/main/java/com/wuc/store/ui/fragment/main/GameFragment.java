package com.wuc.store.ui.fragment.main;

import com.wuc.store.mvp.presenter.AppInfoPresenter;
import com.wuc.store.ui.adapter.AppInfoAdapter;

/**
 * @author: wuchao
 * @date: 2018/10/26 15:22
 * @desciption: 游戏
 */
public class GameFragment extends BaseAppInfoFragment {

    @Override
    protected AppInfoAdapter buildAdapter() {
        return AppInfoAdapter.builder().setShowPosition(false).build();
    }

    @Override
    protected int appType() {
        return AppInfoPresenter.GAME;
    }

}
