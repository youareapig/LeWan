package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class BannerBean {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"alt":"成都","url":null,"pic":"http://cs.lewan6.ren/uploads/20181126/7ea2751c9e617c0035dd1f8a3a52f1eb.png"},{"alt":"成都","url":null,"pic":"http://cs.lewan6.ren/uploads/20181124/584fa766c9d848316d3c121eb84887c3.png"},{"alt":"成都","url":"#","pic":"http://cs.lewan6.ren/uploads/20181124/ac2e6aaa6dbdae623ccb370677e586d0.png"},{"alt":"成都","url":"#","pic":"http://cs.lewan6.ren/uploads/20181129/fe90623bccec8480bb0a0603d5f1d89b.jpg"},{"alt":"成都","url":"#","pic":"http://cs.lewan6.ren/uploads/20181129/dc89541ad21070204f6b9af1f6cccb70.jpg"}]
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
         * alt : 成都
         * url : null
         * pic : http://cs.lewan6.ren/uploads/20181126/7ea2751c9e617c0035dd1f8a3a52f1eb.png
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
