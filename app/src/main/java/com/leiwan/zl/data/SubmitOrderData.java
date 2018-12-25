package com.leiwan.zl.data;

/**
 * Created by Administrator on 2018/12/25.
 */

public class SubmitOrderData {

    /**
     * code : 200
     * message : 下单成功，请立即支付!
     * data : {"order_no":"LW18122510192803719295959","order_id":7603}
     */

    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * order_no : LW18122510192803719295959
         * order_id : 7603
         */

        private String order_no;
        private int order_id;

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }
    }
}
