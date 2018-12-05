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

public class WXAccessTokenEntity implements Serializable {

    /**
     * access_token : 16_C0W1L2P46h7A1SUmcthguHsXR9Fav-eoH4vELFUHIu-cgln1oMwSm2VcDKGmk5YWnyZ5wx_KVQcNOL-Si9P_Lw
     * expires_in : 7200
     * refresh_token : 16_V9aYdE_ndNo9vL6_5hKshpa14epHYASnSKr18blou3ZuORmeCdZWZxI9kK0qDl6zyfyqChPzoPX9IkLKQQOoAg
     * openid : okqnw0uIrHZK0mbDo1x6_vftQNXg
     * scope : snsapi_userinfo
     * unionid : oVKRq1OBobBU8Qt2dLTuxsI2jkP8
     */

    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
