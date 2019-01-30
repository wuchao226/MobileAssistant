package com.wuc.store.mvp.view;

import com.wuc.store.base.mvpbase.BaseView;
import com.wuc.store.bean.Category;

import java.util.List;

/**
 * @author: wuchao
 * @date: 2018/11/15 17:27
 * @desciption: 分类
 */
public interface CategoryView extends BaseView {
    /**
     * 分类回调
     * @param result
     */
    void onCategoryResult(List<Category> result);
}
