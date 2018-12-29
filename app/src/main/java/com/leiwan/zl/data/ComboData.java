package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/29.
 */

public class ComboData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"id":6211,"reservationday_id":2743,"property":"11:00-14:00","addprice":"0.00","totalnum":10,"usenum":0,"product_name":"【紫荆片区】99元抢原价408元的浅草日料2-3人套餐（含；精品刺身、珍味双拼、浅草牛蒡手卷、盐烤秋刀鱼.........）周末节假日/午晚餐通用不加价，独具匠心！","product_property":"日料","lastnumber":10},{"id":6212,"reservationday_id":2743,"property":"17:00-23:00","addprice":"0.00","totalnum":3,"usenum":0,"product_name":"【紫荆片区】99元抢原价408元的浅草日料2-3人套餐（含；精品刺身、珍味双拼、浅草牛蒡手卷、盐烤秋刀鱼.........）周末节假日/午晚餐通用不加价，独具匠心！","product_property":"日料","lastnumber":3}]
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
         * id : 6211
         * reservationday_id : 2743
         * property : 11:00-14:00
         * addprice : 0.00
         * totalnum : 10
         * usenum : 0
         * product_name : 【紫荆片区】99元抢原价408元的浅草日料2-3人套餐（含；精品刺身、珍味双拼、浅草牛蒡手卷、盐烤秋刀鱼.........）周末节假日/午晚餐通用不加价，独具匠心！
         * product_property : 日料
         * lastnumber : 10
         */

        private int id;
        private int reservationday_id;
        private String property;
        private String addprice;
        private int totalnum;
        private int usenum;
        private String product_name;
        private String product_property;
        private int lastnumber;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getReservationday_id() {
            return reservationday_id;
        }

        public void setReservationday_id(int reservationday_id) {
            this.reservationday_id = reservationday_id;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getAddprice() {
            return addprice;
        }

        public void setAddprice(String addprice) {
            this.addprice = addprice;
        }

        public int getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(int totalnum) {
            this.totalnum = totalnum;
        }

        public int getUsenum() {
            return usenum;
        }

        public void setUsenum(int usenum) {
            this.usenum = usenum;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getProduct_property() {
            return product_property;
        }

        public void setProduct_property(String product_property) {
            this.product_property = product_property;
        }

        public int getLastnumber() {
            return lastnumber;
        }

        public void setLastnumber(int lastnumber) {
            this.lastnumber = lastnumber;
        }
    }
}
