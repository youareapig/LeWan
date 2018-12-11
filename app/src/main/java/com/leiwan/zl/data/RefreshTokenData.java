package com.leiwan.zl.data;

/**
 * Created by Administrator on 2018/12/11.
 */

public class RefreshTokenData {

    /**
     * openid : okqnw0uIrHZK0mbDo1x6_vftQNXg
     * access_token : 16_do2kQhQqIsozqCt1upgnP-X_WebuxILo6001R3ou_IwOtnfSkRcY5PSg9_l0WB77_mB5fq1ndP9JS8hHNCYqxvE9RSn-FlBlIkH9ufI7FzI
     * expires_in : 7200
     * refresh_token : 16_4g6bakVerq3v6BH5liyid7eoCd_IR8f-_Z9JGBsnbMMKPAtsycmmksLwjf1R9L3d8hNhZ3lRI7-EJQWxuVndYy8Pu_ao-uDWDtBkYhF1ZfA
     * scope : snsapi_base,snsapi_userinfo,
     */

    private String openid;
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String scope;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
