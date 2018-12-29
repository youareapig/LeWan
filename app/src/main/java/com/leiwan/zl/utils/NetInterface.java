package com.leiwan.zl.utils;

public class NetInterface {

    public static NetInterface INTERFACE = new NetInterface();

    public static NetInterface getInstance() {
        return NetInterface.INTERFACE;
    }

    public String indexUrl, bannerUrl, teachUrl, teachListUrl,
            teachDetails, indexFenlei, goodsDetailsUrl,
            quanyiUrl, myfriendUrl, orderUrl, darenServiceUrl,
            bankUrl, wechatUrl, supervipUrl, sendmessageUrl, userInfoUrl, friendsnumUrl,
            mymoneyUrl,submitorderUrl,confirmpayUrl,yuyuelistUrl,orderdetailsUrl,
            isappointmentUrl,noappointmentUrl,addaddressUrl,addresslistUrl,appointmentdetailsUrl,
            appointmentcalendarUrl,getcaseUrl,fendianUrl,canlanderUrl;
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
        this.supervipUrl = mainurl + "api/User/UserRegister";
        this.sendmessageUrl = mainurl + "Api/Sys/sendSms";
        this.userInfoUrl = mainurl + "api/User/UserPersonal";
        this.friendsnumUrl = mainurl + "api/User/UserFriends";
        this.mymoneyUrl = mainurl + "api/User/UserWallet";
        this.submitorderUrl=mainurl+"Api/Mall/submitOrder";
        this.confirmpayUrl=mainurl+"Api/Mall/confirmPay";
        this.yuyuelistUrl=mainurl+"api/Yuyue/ConsumeBookedProduct";
        this.orderdetailsUrl=mainurl+"api/User/UserOrderInfo";
        this.isappointmentUrl=mainurl+"api/Yuyue/ConsumeBookedAll";
        this.noappointmentUrl=mainurl+"api/Yuyue/ConsumeBespokeAll";
        this.addaddressUrl=mainurl+"api/UserAddress/UserAppendAddress";
        this.addresslistUrl=mainurl+"api/UserAddress/UserAddressList";
        this.appointmentdetailsUrl=mainurl+"api/Yuyue/ConsumeBookedProductDet";
        this.appointmentcalendarUrl=mainurl+"Api/Yuyue/ConsumeBookedProductCalendar";
        this.getcaseUrl=mainurl+"Api/Yuyue/getCase";
        this.fendianUrl=mainurl+"api/Yuyue/getFenDian";
        this.canlanderUrl=mainurl+"Api/Yuyue/calandar";

        this.getWXcodeUrl = getWXcodeUrl;
        this.getWXUserInfo = getWXUserInfo;
        this.refreshtokenUrl = refreshtokenUrl;

    }
}