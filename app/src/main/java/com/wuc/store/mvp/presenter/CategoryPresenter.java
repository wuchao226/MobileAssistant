package com.wuc.store.mvp.presenter;

import com.wuc.store.base.mvpbase.BasePresenter;
import com.wuc.store.bean.Category;
import com.wuc.store.mvp.model.CategoryModel;
import com.wuc.store.mvp.view.CategoryView;
import com.wuc.store.net.rx.BaseObserver;

import java.util.List;

/**
 * @author: wuchao
 * @date: 2018/11/15 17:26
 * @desciption: 分类
 */
public class CategoryPresenter extends BasePresenter<CategoryView> {

    private CategoryModel mModel;

    public CategoryPresenter(CategoryModel model) {
        mModel = model;
    }

    public void getCategoryData() {
        mModel.getCategoryData().subscribe(
                new BaseObserver<List<Category>>(mPresentView) {
                    @Override
                    public void onNext(List<Category> categories) {
                        super.onNext(categories);
                        mPresentView.onCategoryResult(categories);
                    }
                }
        );
    }
}
