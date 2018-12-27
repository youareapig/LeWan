package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/27.
 */

public class NoAppointmentData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"order_id":7626,"ordernumber":"LW18122709372904309359025","express":1,"product_name":"【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用","startusetime":1545408000,"endusetime":1559232000,"endtime":1,"code_count":1,"code":[{"consume_code":"5376019724431","status":1}]},{"order_id":7626,"ordernumber":"LW18122709372904309359025","express":1,"product_name":"【动物园站】39.9元抢购590元淘乐纯K欢唱套餐(4瓶纯生+1份果盘+1份小吃+1份爆米花)不限包间，下午档/黄金档任选嗨唱","startusetime":1545321600,"endusetime":1550592000,"endtime":1,"code_count":1,"code":[{"consume_code":"5376019724431","status":1}]}]
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
         * order_id : 7626
         * ordernumber : LW18122709372904309359025
         * express : 1
         * product_name : 【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用
         * startusetime : 1545408000
         * endusetime : 1559232000
         * endtime : 1
         * code_count : 1
         * code : [{"consume_code":"5376019724431","status":1}]
         */

        private int order_id;
        private String ordernumber;
        private int express;
        private String product_name;
        private int startusetime;
        private int endusetime;
        private int endtime;
        private int code_count;
        private List<CodeBean> code;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrdernumber() {
            return ordernumber;
        }

        public void setOrdernumber(String ordernumber) {
            this.ordernumber = ordernumber;
        }

        public int getExpress() {
            return express;
        }

        public void setExpress(int express) {
            this.express = express;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
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

        public int getEndtime() {
            return endtime;
        }

        public void setEndtime(int endtime) {
            this.endtime = endtime;
        }

        public int getCode_count() {
            return code_count;
        }

        public void setCode_count(int code_count) {
            this.code_count = code_count;
        }

        public List<CodeBean> getCode() {
            return code;
        }

        public void setCode(List<CodeBean> code) {
            this.code = code;
        }

        public static class CodeBean {
            /**
             * consume_code : 5376019724431
             * status : 1
             */

            private String consume_code;
            private int status;

            public String getConsume_code() {
                return consume_code;
            }

            public void setConsume_code(String consume_code) {
                this.consume_code = consume_code;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
