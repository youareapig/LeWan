package com.leiwan.zl.utils;

public class NetInterface {

    public static NetInterface INTERFACE = new NetInterface();

    public static NetInterface getInstance() {
        return NetInterface.INTERFACE;
    }

    public String indexUrl, bannerUrl, teachUrl, teachListUrl, teachDetails, indexFenlei;

    public NetInterface() {
        //拼接，公共部分
        String mainurl = "http://cs.lewan6.ren/";

        this.indexUrl = mainurl + "api/Product/ProductList";
        this.bannerUrl = mainurl + "api/Banner/HomePageList";
        this.teachUrl = mainurl + "api/Content/getRookieTutorialCate";
        this.teachListUrl = mainurl + "Api/Content/getRookieTutorial";
        this.teachDetails = mainurl + "api/Content/getArticleContent";
        this.indexFenlei = mainurl + "api/Productcategory/CategoryList";
    }
}