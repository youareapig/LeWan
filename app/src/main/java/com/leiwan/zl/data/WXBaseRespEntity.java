package com.leiwan.zl.data;

import java.io.Serializable;

/**
 * description ：
 * project name：CCloud
 * author : Vincent
 * creation date: 2017/6/10 11:20
 *
 * @version 1.0
 */

public class WXBaseRespEntity implements Serializable {

    /**
     * code : 001BRv1w1812Ng0NtIZv1yt61w1BRv1q
     * country : CN
     * errCode : 0
     * lang : zh_CN
     * state : lewan_wechat_login
     * type : 1
     * url : wxfca63c8cf5fd3162://oauth?code=001BRv1w1812Ng0NtIZv1yt61w1BRv1q&state=lewan_wechat_login
     */

    private String code;
    private String country;
    private int errCode;
    private String lang;
    private String state;
    private int type;
    private String url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
