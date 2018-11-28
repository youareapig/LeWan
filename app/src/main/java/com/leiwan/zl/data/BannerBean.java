package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class BannerBean {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"alt":"啊飒飒","url":null,"pic":"20180801\\ae886eda5913ab145b6247c6ca77390d.jpg"},{"alt":"成都喜来登星际酒店","url":"#","pic":"20181027\\fa9c5393bf6505d19a7b88a2c8187fe4.png"},{"alt":"成都喜来登星际酒店","url":null,"pic":"20180801\\69ac105f94bc75b9daec8c880f03252f.jpg"},{"alt":"首页广告","url":null,"pic":"20180801\\ecafa99c12584a4ecc752d646190a36a.jpg"}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * alt : 啊飒飒
         * url : null
         * pic : 20180801\ae886eda5913ab145b6247c6ca77390d.jpg
         */

        private String alt;
        private Object url;
        private String pic;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
