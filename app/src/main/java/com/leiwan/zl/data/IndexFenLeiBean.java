package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */

public class IndexFenLeiBean {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"cate_id":1,"cate_name":"新人","cate_icon":"http://cs.lewan6.ren/uploads/20181126/48aef7dff4a5e0c278b59966596fbc35.png"},{"cate_id":2,"cate_name":"美食","cate_icon":"http://cs.lewan6.ren/uploads/20181126/ec17ef8982d6b1a9290bfb747b5b5ef2.png"},{"cate_id":3,"cate_name":"酒店","cate_icon":"http://cs.lewan6.ren/uploads/20181126/6d6b7f445149d7ec6d88a837601bb661.png"},{"cate_id":4,"cate_name":"礼品","cate_icon":"http://cs.lewan6.ren/uploads/20181126/670cfdb095d13d5b2bb30678d9fd6053.png"},{"cate_id":5,"cate_name":"亲子","cate_icon":"http://cs.lewan6.ren/uploads/20181126/ec5305976db97623177a210e262aefac.png"},{"cate_id":6,"cate_name":"乐园","cate_icon":"http://cs.lewan6.ren/uploads/20181126/7bdd1d6e4f97857a257778ca3c8417af.png"},{"cate_id":7,"cate_name":"景区","cate_icon":"http://cs.lewan6.ren/uploads/20181126/9b95a25ef0733e8cc6a97b8f82ee92a4.png"},{"cate_id":8,"cate_name":"出行","cate_icon":"http://cs.lewan6.ren/uploads/20181126/8292251e8d2742f56faf1e28c13642e9.png"}]
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
         * cate_id : 1
         * cate_name : 新人
         * cate_icon : http://cs.lewan6.ren/uploads/20181126/48aef7dff4a5e0c278b59966596fbc35.png
         */

        private int cate_id;
        private String cate_name;
        private String cate_icon;

        public int getCate_id() {
            return cate_id;
        }

        public void setCate_id(int cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getCate_icon() {
            return cate_icon;
        }

        public void setCate_icon(String cate_icon) {
            this.cate_icon = cate_icon;
        }
    }
}
