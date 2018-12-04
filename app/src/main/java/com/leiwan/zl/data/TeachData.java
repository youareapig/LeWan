package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/3.
 */

public class TeachData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"id":10,"cat_name":"新手教程"},{"id":12,"cat_name":"推广大课堂"},{"id":31,"cat_name":"分享得佣金"}]
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
         * id : 10
         * cat_name : 新手教程
         */

        private int id;
        private String cat_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }
    }
}
