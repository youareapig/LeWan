package com.leiwan.zl.utils;

import android.content.Context;
import android.util.Log;

import com.leiwan.zl.App;
import com.leiwan.zl.newpeople.NewPeopleActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class Connector {

    //**************下面是xUtils3的请求使用，post方式***********************


    //下面四个根据自己接口文档实际情况替换值
    private static final String CODE_PARAMS = "code"; //返回码参数;
    private static final int SUCCESS = 0;//code返回成功；
    private static final int FAILURE = 1000;
    private static final int OTHER = 2000;
    private static String token, lat;

    public Connector() {
        token = SharedPreferencesUtil.getInstance(App.content).getSP("token");

        LogUtil.d("test", "token---" + token);

    }

    //首页列表(综合排序)
    public static void IndexList(Context context, String token, String lat, String cateid, String lng, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().indexUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("cateid", cateid);
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        xUtilsPostRequest(context, params, myCallback);
    }

    //首页列表(价格排序)sales  0取消 1降序 2升序
    public static void IndexList_sale(Context context, String token, String lat, String lng, String cateid, String price, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().indexUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("price", price);
        params.addBodyParameter("cateid", cateid);
        xUtilsPostRequest(context, params, myCallback);
    }

    //首页列表(销量排序)
    public static void IndexList_num(Context context, String token, String lat, String lng, String cateid, String num, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().indexUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("sales", num);
        params.addBodyParameter("cateid", cateid);
        xUtilsPostRequest(context, params, myCallback);
    }

    //首页列表(距离排序)
    public static void IndexList_away(Context context, String token, String lat, String lng, String cateid, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().indexUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("distance", "1");
        params.addBodyParameter("cateid", cateid);
        xUtilsPostRequest(context, params, myCallback);
    }

    //首页banner列表
    public static void indexBannerList(Context context, String lat, String lng, String cate, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().bannerUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("cate", cate);
        xUtilsPostRequest(context, params, myCallback);
    }

    //首页分类
    public static void indexFenlei(Context context, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().indexFenlei);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        xUtilsPostRequest(context, params, myCallback);
    }

    //分享圈列表
    public static void HotList(Context context, String token, String lat, String lng, String paging, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().indexUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("bursting", "1");
        xUtilsPostRequest(context, params, myCallback);
    }

    //新手教程文章分类
    public static void TabList(Context context, String lat, String lng, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().teachUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        xUtilsPostRequest(context, params, myCallback);
    }

    //新手教程文章列表
    public static void TeachList(Context context, String lat, String lng, String cate_id, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().teachListUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("cate_id", cate_id);
        xUtilsPostRequest(context, params, myCallback);
    }

    //新手教程文章列表
    public static void TeachDetails(Context context, String lat, String lng, String id, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().teachDetails);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("id", id);
        xUtilsPostRequest(context, params, myCallback);
    }
    //新手教程文章列表
    public static void GoodsDetails(Context context, String lat, String lng, String id, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().goodsDetailsUrl);
        params.addHeader("provincecode", "510000");
        params.addHeader("citycode", "510100");
        params.addHeader("sign", null);
        params.addHeader("product", "app");
        params.addHeader("platform", "android");
        params.addBodyParameter("token", token);
        params.addBodyParameter("type", "2");
        params.addBodyParameter("lat", lat);
        params.addBodyParameter("lng", lng);
        params.addBodyParameter("pr_id", id);
        xUtilsPostRequest(context, params, myCallback);
    }

    public static void getWXcode(Context context, String code, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().getWXcodeUrl);
        params.addBodyParameter("appid", App.APP_ID);
        params.addBodyParameter("secret", App.APP_SECRET);
        params.addBodyParameter("code", code);
        params.addBodyParameter("grant_type", "authorization_code");
        xUtilsGetRequest(context, params, myCallback);
    }
    public static void getWXUserInfo(Context context, String access_token,String openid, MyCallback myCallback) {
        RequestParams params = new RequestParams(NetInterface.getInstance().getWXUserInfo);
        params.addBodyParameter("access_token", access_token);
        params.addBodyParameter("openid", openid);
        xUtilsGetRequest(context, params, myCallback);
    }

    //调用的请求方式（封装的方法）
    private static void xUtilsPostRequest(final Context context, final RequestParams params, final MyCallback callback) {
        DialogUtils.getInstance(context).showDialog();
        x.http().post(params, new Callback.CacheCallback<String>() {

            private boolean hasError = false;
            private String result = null;

            @Override
            public void onSuccess(String result) {
                Log.d("zhenglei", "参数说明：" + String.valueOf(params));
                if (result != null) {
                    this.result = result;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                hasError = true;
                ToastUtil.showShortToast("服务器连接异常");
                Log.d("zhenglei", "服务器连接异常");
            }

            @Override
            public void onCancelled(CancelledException cex) {
//                ToastUtils.showToastShort(x.app(),"cancelled");
            }

            /**
             * 拿到的结果result在这里做相关操作
             */
            @Override
            public void onFinished() {
                DialogUtils.getInstance(context).dissmissDialog();
                callback.MyResult(result);
/*                Log.i("完成。。。33。。", result);
                if (!hasError&&result!=null){
                    JSONObject jsonObject=null;
                    try {
                        jsonObject=new JSONObject(result);
                        //错误的写法，optInt方法走完：非空会返回真正的code，如果为空会返回0；但是0在这里面可能会有表示意义（比如表示请求成功code=0）,所以建议使用getInt；
// int code=jsonObject.optInt("code");//这里是请求结果返回码的key（替换过自己的返回码参数）
                        int code=jsonObject.getInt(CODE_PARAMS);//这里是请求结果返回码的key（替换过自己的返回码参数）
                        if (code==SUCCESS){
                            callback.MyResult(result);
                        }else if (code==FAILURE){
//                            ToastUtils.showToastShort(x.app(),"失败");
                        }else if (code==OTHER){
//                            ToastUtils.showToastShort(x.app(),"其他");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
            }

            @Override
            public boolean onCache(String result) {
                this.result = result;
                return false;
            }
        });
    }
    //调用的请求方式（封装的方法get）
    private static void xUtilsGetRequest(final Context context, final RequestParams params, final MyCallback callback) {
        DialogUtils.getInstance(context).showDialog();
        x.http().get(params, new Callback.CacheCallback<String>() {

            private boolean hasError = false;
            private String result = null;

            @Override
            public void onSuccess(String result) {
                Log.d("zhenglei", "参数说明：" + String.valueOf(params));
                if (result != null) {
                    this.result = result;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                hasError = true;
                ToastUtil.showShortToast("服务器连接异常");
                Log.d("zhenglei", "服务器连接异常");
            }

            @Override
            public void onCancelled(CancelledException cex) {
//                ToastUtils.showToastShort(x.app(),"cancelled");
            }

            /**
             * 拿到的结果result在这里做相关操作
             */
            @Override
            public void onFinished() {
                DialogUtils.getInstance(context).dissmissDialog();
                callback.MyResult(result);
/*                Log.i("完成。。。33。。", result);
                if (!hasError&&result!=null){
                    JSONObject jsonObject=null;
                    try {
                        jsonObject=new JSONObject(result);
                        //错误的写法，optInt方法走完：非空会返回真正的code，如果为空会返回0；但是0在这里面可能会有表示意义（比如表示请求成功code=0）,所以建议使用getInt；
// int code=jsonObject.optInt("code");//这里是请求结果返回码的key（替换过自己的返回码参数）
                        int code=jsonObject.getInt(CODE_PARAMS);//这里是请求结果返回码的key（替换过自己的返回码参数）
                        if (code==SUCCESS){
                            callback.MyResult(result);
                        }else if (code==FAILURE){
//                            ToastUtils.showToastShort(x.app(),"失败");
                        }else if (code==OTHER){
//                            ToastUtils.showToastShort(x.app(),"其他");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
            }

            @Override
            public boolean onCache(String result) {
                this.result = result;
                return false;
            }
        });
    }


    public interface MyCallback {
        //result接受请求回来的数据
        void MyResult(String result);
    }


}
