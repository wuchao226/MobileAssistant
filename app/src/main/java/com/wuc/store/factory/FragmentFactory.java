package com.wuc.store.factory;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.wuc.store.ui.fragment.main.CategoryFragment;
import com.wuc.store.ui.fragment.main.GameFragment;
import com.wuc.store.ui.fragment.main.RankFragment;
import com.wuc.store.ui.fragment.main.RecommendFragment;

/**
 * @author: wuchao
 * @date: 2018/10/26 15:26
 * @desciption:
 */
public class FragmentFactory {
    /**
     * 推荐
     */
    public static final int TAB_RECOMMEND = 0;
    /**
     * 排行
     */
    public static final int TAB_RANK = 1;
    /**
     * 游戏
     */
    public static final int TAB_GAME = 2;
    /**
     * 分类
     */
    public static final int TAB_CATEGORY = 3;

    //private static HashMap<Integer, Fragment> mFragments = new HashMap<>();
    private static SparseArray<Fragment> mFragments = new SparseArray<>();

    public static Fragment crerateFragment(int index) {
        Fragment fragment = mFragments.get(index);
        //如果没有创建，则创建新的fragment
        if (fragment == null) {
            switch (index) {
                case TAB_RECOMMEND:
                    fragment = new RecommendFragment();
                    break;
                case TAB_RANK:
                    fragment = new RankFragment();
                    break;
                case TAB_GAME:
                    fragment = new GameFragment();
                    break;
                case TAB_CATEGORY:
                    fragment = new CategoryFragment();
                    break;
                default:
            }
            //把创建的fragment存起来
            mFragments.put(index, fragment);
        }
        return fragment;
    }
}
