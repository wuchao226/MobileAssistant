package com.wuc.store.ui.fragment.main;

import com.wuc.store.R;
import com.wuc.store.base.BaseLazyFragment;
import com.wuc.store.bean.Category;
import com.wuc.store.mvp.model.CategoryModel;
import com.wuc.store.mvp.presenter.CategoryPresenter;
import com.wuc.store.mvp.view.CategoryView;

import java.util.List;

/**
 * @author: wuchao
 * @date: 2018/10/26 15:22
 * @desciption: 分类
 */
public class CategoryFragment extends BaseLazyFragment<CategoryView, CategoryPresenter> implements CategoryView {

    private CategoryPresenter mPresenter;

    @Override
    protected CategoryPresenter initPresenter() {
        CategoryModel model = new CategoryModel();
        mPresenter = new CategoryPresenter(model);
        return mPresenter;
    }

    @Override
    protected CategoryView initPresenterView() {
        return this;
    }

    @Override
    protected void loadData() {
        mPresenter.getCategoryData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected Object setLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void onCategoryResult(List<Category> result) {

    }
}
