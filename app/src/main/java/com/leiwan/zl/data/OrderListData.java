package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/25.
 */

public class OrderListData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"order_id":7604,"order_no":"LW18122510215206281243780","order_totalfee":"0.10","order_status":1,"shopname":"畅享汽车","region":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","product_name":"【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用","num":1,"startusetime":1545408000,"endusetime":1559232000},{"order_id":7603,"order_no":"LW18122510192803719295959","order_totalfee":"0.10","order_status":1,"shopname":"畅享汽车","region":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","product_name":"【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用","num":1,"startusetime":1545408000,"endusetime":1559232000}]
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
         * order_id : 7604
         * order_no : LW18122510215206281243780
         * order_totalfee : 0.10
         * order_status : 1
         * shopname : 畅享汽车
         * region : 四川省						成都市						锦江区
         * product_name : 【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用
         * num : 1
         * startusetime : 1545408000
         * endusetime : 1559232000
         */

        private int order_id;
        private String order_no;
        private String order_totalfee;
        private int order_status;
        private String shopname;
        private String region;
        private String product_name;
        private int num;
        private int startusetime;
        private int endusetime;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getOrder_totalfee() {
            return order_totalfee;
        }

        public void setOrder_totalfee(String order_totalfee) {
            this.order_totalfee = order_totalfee;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getStartusetime() {
            return startusetime;
        }

        public void setStartusetime(int startusetime) {
            this.startusetime = startusetime;
        }

        public int getEndusetime() {
            return endusetime;
        }

        public void setEndusetime(int endusetime) {
            this.endusetime = endusetime;
        }
    }
}
