package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/3.
 */

public class TeachListData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"id":1152,"cat_id":12,"title":"媒体信3我232322","pic":"http://cs.lewan6.ren/uploads/20180920/4549b4bdb911ad912f596875854c57ae.png"}]
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
         * id : 1152
         * cat_id : 12
         * title : 媒体信3我232322
         * pic : http://cs.lewan6.ren/uploads/20180920/4549b4bdb911ad912f596875854c57ae.png
         */

        private int id;
        private int cat_id;
        private String title;
        private String pic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
