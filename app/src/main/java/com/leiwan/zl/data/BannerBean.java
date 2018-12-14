package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class BannerBean {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"alt":"成都","url":null,"pic":"http://oss.lewan6.ren/uploads/20181126/7ea2751c9e617c0035dd1f8a3a52f1eb.png","jump":1,"position":1,"pr_id":41,"route":"#"},{"alt":"成都","url":null,"pic":"http://oss.lewan6.ren/uploads/20181124/584fa766c9d848316d3c121eb84887c3.png","jump":1,"position":2,"pr_id":0,"route":"http://tool.chinaz.com/Tools/unixtime.aspx"},{"alt":"成都","url":"#","pic":"http://oss.lewan6.ren/uploads/20181124/ac2e6aaa6dbdae623ccb370677e586d0.png","jump":2,"position":0,"pr_id":0,"route":"#"},{"alt":"成都","url":"#","pic":"http://oss.lewan6.ren/uploads/20181129/fe90623bccec8480bb0a0603d5f1d89b.jpg","jump":2,"position":0,"pr_id":0,"route":"#"},{"alt":"成都","url":"#","pic":"http://oss.lewan6.ren/uploads/20181129/dc89541ad21070204f6b9af1f6cccb70.jpg","jump":2,"position":0,"pr_id":0,"route":"#"}]
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
         * pic : http://oss.lewan6.ren/uploads/20181126/7ea2751c9e617c0035dd1f8a3a52f1eb.png
         * jump : 1
         * position : 1
         * pr_id : 41
         * route : #
         */

        private String alt;
        private Object url;
        private String pic;
        private int jump;
        private int position;
        private int pr_id;
        private String route;

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

        public int getJump() {
            return jump;
        }

        public void setJump(int jump) {
            this.jump = jump;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getPr_id() {
            return pr_id;
        }

        public void setPr_id(int pr_id) {
            this.pr_id = pr_id;
        }

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            this.route = route;
        }
    }
}
