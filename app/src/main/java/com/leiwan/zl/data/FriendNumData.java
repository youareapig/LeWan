package com.leiwan.zl.data;

/**
 * Created by Administrator on 2018/12/18.
 */

public class FriendNumData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"customer":0,"newcustomer":0,"directly":0,"newdirectly":0,"whole":0,"newwhole":0}
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
         * customer : 0
         * newcustomer : 0
         * directly : 0
         * newdirectly : 0
         * whole : 0
         * newwhole : 0
         */

        private int customer;
        private int newcustomer;
        private int directly;
        private int newdirectly;
        private int whole;
        private int newwhole;

        public int getCustomer() {
            return customer;
        }

        public void setCustomer(int customer) {
            this.customer = customer;
        }

        public int getNewcustomer() {
            return newcustomer;
        }

        public void setNewcustomer(int newcustomer) {
            this.newcustomer = newcustomer;
        }

        public int getDirectly() {
            return directly;
        }

        public void setDirectly(int directly) {
            this.directly = directly;
        }

        public int getNewdirectly() {
            return newdirectly;
        }

        public void setNewdirectly(int newdirectly) {
            this.newdirectly = newdirectly;
        }

        public int getWhole() {
            return whole;
        }

        public void setWhole(int whole) {
            this.whole = whole;
        }

        public int getNewwhole() {
            return newwhole;
        }

        public void setNewwhole(int newwhole) {
            this.newwhole = newwhole;
        }
    }
}
