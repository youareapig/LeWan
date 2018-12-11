package com.leiwan.zl.utils;

public class NetInterface {

    public static NetInterface INTERFACE = new NetInterface();

    public static NetInterface getInstance() {
        return NetInterface.INTERFACE;
    }

    public String indexUrl, bannerUrl, teachUrl, teachListUrl, teachDetails, indexFenlei, goodsDetailsUrl, quanyiUrl, myfriendUrl, orderUrl, darenServiceUrl, bankUrl, wechatUrl;
    public String getWXcodeUrl, getWXUserInfo, refreshtokenUrl;

    public NetInterface() {
        //拼接，公共部分
        String mainurl = "http://cs.lewan6.ren/";
        String getWXcodeUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        String getWXUserInfo = "https://api.weixin.qq.com/sns/userinfo";
        String refreshtokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

        this.indexUrl = mainurl + "api/Product/ProductList";
        this.bannerUrl = mainurl + "api/Banner/HomePageList";
        this.teachUrl = mainurl + "api/Content/getRookieTutorialCate";
        this.teachListUrl = mainurl + "Api/Content/getRookieTutorial";
        this.teachDetails = mainurl + "api/Content/getArticleContent";
        this.indexFenlei = mainurl + "api/Productcategory/CategoryList";
        this.goodsDetailsUrl = mainurl + "api/Product/ProductDetails";
        this.quanyiUrl = mainurl + "api/User/UserRefereeData";
        this.myfriendUrl = mainurl + "api/User/UserFriendsList";
        this.orderUrl = mainurl + "api/User/UserOrderList";
        this.darenServiceUrl = mainurl + "api/User/OrderDaren";
        this.bankUrl = mainurl + "api/Userbank/UserBankAll";
        this.wechatUrl = mainurl + "api/Wechat/WechatThirdParty";

        this.getWXcodeUrl = getWXcodeUrl;
        this.getWXUserInfo = getWXUserInfo;
        this.refreshtokenUrl = refreshtokenUrl;

    }
}