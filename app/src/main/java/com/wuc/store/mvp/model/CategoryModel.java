package com.wuc.store.mvp.model;

import com.wuc.store.bean.Category;
import com.wuc.store.net.RetrofitFactory;
import com.wuc.store.net.api.ApiService;
import com.wuc.store.net.rx.RxTransformResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author: wuchao
 * @date: 2018/11/15 17:30
 * @desciption: 分类
 */
public class CategoryModel {

    public Observable<List<Category>> getCategoryData() {
        return RetrofitFactory.getInstance().create(ApiService.class)
                .getCategoryData().compose(RxTransformResponse.<List<Category>>compatResult());
    }
}
