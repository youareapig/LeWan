package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/20.
 */

public class ConfirmPayData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"product":{"price_id":34,"product_id":38,"product_pic":null,"product_property":"光波房养生套餐","price_market":"561.00","price_sale":"19.90","price_settle":"0.01","price_commission":"14.00","product_totalnum":600,"product_buynum":39,"product_dynamicnum":null,"price_addtime":1544513933,"price_status":1,"product_name":"【高新区时尚汗蒸】19.9抢原价561扬子光波房汗蒸套餐（含扬子养生光波房+扬子养生光波桶+扬子养生仪各三次）周末节假日通用不加收","product_status":1,"product_del":0,"product_reviewstatus":2,"price_type":1,"product_returnall":0,"product_reservation":1,"product_isexpress":1,"product_timelimit":1,"product_numlimit":1,"product_numlimit_num":5,"product_starttime":1544518800,"product_endtime":1545580799,"product_startusetime":1544716800,"product_endusetime":1551283200,"merchant_id":17,"sold_out":0,"product_sku":561,"coupon":[],"concat":null,"mobile":null}}
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
         * product : {"price_id":34,"product_id":38,"product_pic":null,"product_property":"光波房养生套餐","price_market":"561.00","price_sale":"19.90","price_settle":"0.01","price_commission":"14.00","product_totalnum":600,"product_buynum":39,"product_dynamicnum":null,"price_addtime":1544513933,"price_status":1,"product_name":"【高新区时尚汗蒸】19.9抢原价561扬子光波房汗蒸套餐（含扬子养生光波房+扬子养生光波桶+扬子养生仪各三次）周末节假日通用不加收","product_status":1,"product_del":0,"product_reviewstatus":2,"price_type":1,"product_returnall":0,"product_reservation":1,"product_isexpress":1,"product_timelimit":1,"product_numlimit":1,"product_numlimit_num":5,"product_starttime":1544518800,"product_endtime":1545580799,"product_startusetime":1544716800,"product_endusetime":1551283200,"merchant_id":17,"sold_out":0,"product_sku":561,"coupon":[],"concat":null,"mobile":null}
         */

        private ProductBean product;

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public static class ProductBean {
            /**
             * price_id : 34
             * product_id : 38
             * product_pic : null
             * product_property : 光波房养生套餐
             * price_market : 561.00
             * price_sale : 19.90
             * price_settle : 0.01
             * price_commission : 14.00
             * product_totalnum : 600
             * product_buynum : 39
             * product_dynamicnum : null
             * price_addtime : 1544513933
             * price_status : 1
             * product_name : 【高新区时尚汗蒸】19.9抢原价561扬子光波房汗蒸套餐（含扬子养生光波房+扬子养生光波桶+扬子养生仪各三次）周末节假日通用不加收
             * product_status : 1
             * product_del : 0
             * product_reviewstatus : 2
             * price_type : 1
             * product_returnall : 0
             * product_reservation : 1
             * product_isexpress : 1
             * product_timelimit : 1
             * product_numlimit : 1
             * product_numlimit_num : 5
             * product_starttime : 1544518800
             * product_endtime : 1545580799
             * product_startusetime : 1544716800
             * product_endusetime : 1551283200
             * merchant_id : 17
             * sold_out : 0
             * product_sku : 561
             * coupon : []
             * concat : null
             * mobile : null
             */

            private int price_id;
            private int product_id;
            private Object product_pic;
            private String product_property;
            private String price_market;
            private String price_sale;
            private String price_settle;
            private String price_commission;
            private int product_totalnum;
            private int product_buynum;
            private Object product_dynamicnum;
            private int price_addtime;
            private int price_status;
            private String product_name;
            private int product_status;
            private int product_del;
            private int product_reviewstatus;
            private int price_type;
            private int product_returnall;
            private int product_reservation;
            private int product_isexpress;
            private int product_timelimit;
            private int product_numlimit;
            private int product_numlimit_num;
            private int product_starttime;
            private int product_endtime;
            private int product_startusetime;
            private int product_endusetime;
            private int merchant_id;
            private int sold_out;
            private int product_sku;
            private Object concat;
            private Object mobile;
            private List<?> coupon;

            public int getPrice_id() {
                return price_id;
            }

            public void setPrice_id(int price_id) {
                this.price_id = price_id;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public Object getProduct_pic() {
                return product_pic;
            }

            public void setProduct_pic(Object product_pic) {
                this.product_pic = product_pic;
            }

            public String getProduct_property() {
                return product_property;
            }

            public void setProduct_property(String product_property) {
                this.product_property = product_property;
            }

            public String getPrice_market() {
                return price_market;
            }

            public void setPrice_market(String price_market) {
                this.price_market = price_market;
            }

            public String getPrice_sale() {
                return price_sale;
            }

            public void setPrice_sale(String price_sale) {
                this.price_sale = price_sale;
            }

            public String getPrice_settle() {
                return price_settle;
            }

            public void setPrice_settle(String price_settle) {
                this.price_settle = price_settle;
            }

            public String getPrice_commission() {
                return price_commission;
            }

            public void setPrice_commission(String price_commission) {
                this.price_commission = price_commission;
            }

            public int getProduct_totalnum() {
                return product_totalnum;
            }

            public void setProduct_totalnum(int product_totalnum) {
                this.product_totalnum = product_totalnum;
            }

            public int getProduct_buynum() {
                return product_buynum;
            }

            public void setProduct_buynum(int product_buynum) {
                this.product_buynum = product_buynum;
            }

            public Object getProduct_dynamicnum() {
                return product_dynamicnum;
            }

            public void setProduct_dynamicnum(Object product_dynamicnum) {
                this.product_dynamicnum = product_dynamicnum;
            }

            public int getPrice_addtime() {
                return price_addtime;
            }

            public void setPrice_addtime(int price_addtime) {
                this.price_addtime = price_addtime;
            }

            public int getPrice_status() {
                return price_status;
            }

            public void setPrice_status(int price_status) {
                this.price_status = price_status;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public int getProduct_status() {
                return product_status;
            }

            public void setProduct_status(int product_status) {
                this.product_status = product_status;
            }

            public int getProduct_del() {
                return product_del;
            }

            public void setProduct_del(int product_del) {
                this.product_del = product_del;
            }

            public int getProduct_reviewstatus() {
                return product_reviewstatus;
            }

            public void setProduct_reviewstatus(int product_reviewstatus) {
                this.product_reviewstatus = product_reviewstatus;
            }

            public int getPrice_type() {
                return price_type;
            }

            public void setPrice_type(int price_type) {
                this.price_type = price_type;
            }

            public int getProduct_returnall() {
                return product_returnall;
            }

            public void setProduct_returnall(int product_returnall) {
                this.product_returnall = product_returnall;
            }

            public int getProduct_reservation() {
                return product_reservation;
            }

            public void setProduct_reservation(int product_reservation) {
                this.product_reservation = product_reservation;
            }

            public int getProduct_isexpress() {
                return product_isexpress;
            }

            public void setProduct_isexpress(int product_isexpress) {
                this.product_isexpress = product_isexpress;
            }

            public int getProduct_timelimit() {
                return product_timelimit;
            }

            public void setProduct_timelimit(int product_timelimit) {
                this.product_timelimit = product_timelimit;
            }

            public int getProduct_numlimit() {
                return product_numlimit;
            }

            public void setProduct_numlimit(int product_numlimit) {
                this.product_numlimit = product_numlimit;
            }

            public int getProduct_numlimit_num() {
                return product_numlimit_num;
            }

            public void setProduct_numlimit_num(int product_numlimit_num) {
                this.product_numlimit_num = product_numlimit_num;
            }

            public int getProduct_starttime() {
                return product_starttime;
            }

            public void setProduct_starttime(int product_starttime) {
                this.product_starttime = product_starttime;
            }

            public int getProduct_endtime() {
                return product_endtime;
            }

            public void setProduct_endtime(int product_endtime) {
                this.product_endtime = product_endtime;
            }

            public int getProduct_startusetime() {
                return product_startusetime;
            }

            public void setProduct_startusetime(int product_startusetime) {
                this.product_startusetime = product_startusetime;
            }

            public int getProduct_endusetime() {
                return product_endusetime;
            }

            public void setProduct_endusetime(int product_endusetime) {
                this.product_endusetime = product_endusetime;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public int getSold_out() {
                return sold_out;
            }

            public void setSold_out(int sold_out) {
                this.sold_out = sold_out;
            }

            public int getProduct_sku() {
                return product_sku;
            }

            public void setProduct_sku(int product_sku) {
                this.product_sku = product_sku;
            }

            public Object getConcat() {
                return concat;
            }

            public void setConcat(Object concat) {
                this.concat = concat;
            }

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public List<?> getCoupon() {
                return coupon;
            }

            public void setCoupon(List<?> coupon) {
                this.coupon = coupon;
            }
        }
    }
}
