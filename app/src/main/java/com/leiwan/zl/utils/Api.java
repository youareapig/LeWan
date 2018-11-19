package com.leiwan.zl.utils;

import com.leiwan.zl.data.HomeData;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018/11/15.
 */

public interface Api {
    @FormUrlEncoded
    @POST("api/Product/ProductList")
    Observable<HomeData> getData(@HeaderMap Map<String,Object> headers,
                                 @Field("token") String token,
                                 @Field("type") int type

    );
}
