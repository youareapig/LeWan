package com.leiwan.zl.utils;

public class NetInterface {

    public static NetInterface INTERFACE = new NetInterface();

    public static NetInterface getInstance() {
        return NetInterface.INTERFACE;
    }

    public String indexUrl, bannerUrl;

    public NetInterface() {
        //拼接，公共部分
        String mainurl = "http://cs.lewan6.ren/";

        this.indexUrl = mainurl + "api/Product/ProductList";
        this.bannerUrl = mainurl + "api/Banner/HomePageList";
    }
}