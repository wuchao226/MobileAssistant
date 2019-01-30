package com.wuc.store.net.api;


import com.wuc.store.bean.AppDownloadInfo;
import com.wuc.store.bean.AppInfo;
import com.wuc.store.bean.AppInfoDetail;
import com.wuc.store.bean.BaseBean;
import com.wuc.store.bean.Category;
import com.wuc.store.bean.LoginBean;
import com.wuc.store.bean.PageBean;
import com.wuc.store.bean.RecommendBean;
import com.wuc.store.bean.SearchResult;
import com.wuc.store.bean.Subject;
import com.wuc.store.bean.SubjectDetail;
import com.wuc.store.bean.requestbean.LoginRequestBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author: wuchao
 * @date: 2018/10/29 10:30
 * @desciption: 相关接口
 */
public interface ApiService {

    @GET("featured2")
    Observable<BaseBean<PageBean<AppInfo>>> getApps(@Query("p") String jsonParam);

    /**
     * 推荐
     * @return
     */
    @GET("index")
    Observable<BaseBean<RecommendBean>> getRecommendData();

    /**
     * 获取排行榜
     * @param page
     * @return
     */
    @GET("toplist")
    Observable<BaseBean<PageBean<AppInfo>>> topList(@Query("page") int page);

    @GET("game")
    Observable<BaseBean<PageBean<AppInfo>>> games(@Query("page") int page);

    @POST("login")
    Observable<BaseBean<LoginBean>> login(@Body LoginRequestBean param);

    @GET("category")
    Observable<BaseBean<List<Category>>> getCategoryData();

    @GET("category/featured/{categoryid}")
    Observable<BaseBean<PageBean<AppInfo>>> getFeaturedAppDataByCategory
            (@Path("categoryid") int categoryId, @Query("page") int page);

    @GET("category/toplist/{categoryid}")
    Observable<BaseBean<PageBean<AppInfo>>> getTopListAppDataByCategory
            (@Path("categoryid") int categoryId, @Query("page") int page);

    @GET("category/newlist/{categoryid}")
    Observable<BaseBean<PageBean<AppInfo>>> getNewListAppDataByCategory
            (@Path("categoryid") int categoryId, @Query("page") int page);

    @GET("app/{id}")
    Observable<BaseBean<AppInfoDetail>> getAppDetailData(@Path("id") int id);

    @GET("download/{id}")
    Observable<BaseBean<AppDownloadInfo>> getAppDownloadInfoData(@Path("id") int id);

    @GET("apps/updateinfo")
    Observable<BaseBean<List<AppInfo>>> getAppUpdateInfoData
            (@Query("packageName") String packageName, @Query("versionCode") String versionCode);

    @GET("subject/hot")
    Observable<BaseBean<PageBean<Subject>>> getSubjectData(@Query("page") int page);

    @GET("subject/{id}")
    Observable<BaseBean<SubjectDetail>> getSubjectDetailData(@Path("id") int id);

    @GET("search/suggest")
    Observable<BaseBean<List<String>>> getSearchSuggestData(@Query("keyword") String keyword);

    @GET("search")
    Observable<BaseBean<SearchResult>> getSearchResultData(@Query("keyword") String keyword);
}
