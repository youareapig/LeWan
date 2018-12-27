package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/27.
 */

public class AddressData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"address_id":4399,"contact":"旺财","mobile":"158*****8899","ssq":"四川省成都市锦江区","address":"四川省成都市锦江区龙舟路"}]
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
         * address_id : 4399
         * contact : 旺财
         * mobile : 158*****8899
         * ssq : 四川省成都市锦江区
         * address : 四川省成都市锦江区龙舟路
         */

        private int address_id;
        private String contact;
        private String mobile;
        private String ssq;
        private String address;

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSsq() {
            return ssq;
        }

        public void setSsq(String ssq) {
            this.ssq = ssq;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
