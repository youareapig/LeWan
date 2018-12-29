package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/29.
 */

public class FenDianData {

    /**
     * code : 200
     * message : 查询成功
     * data : [{"merchant_id":78,"merchant_name":"浅草日料"}]
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
         * merchant_id : 78
         * merchant_name : 浅草日料
         */

        private int merchant_id;
        private String merchant_name;

        public int getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(int merchant_id) {
            this.merchant_id = merchant_id;
        }

        public String getMerchant_name() {
            return merchant_name;
        }

        public void setMerchant_name(String merchant_name) {
            this.merchant_name = merchant_name;
        }
    }
}
