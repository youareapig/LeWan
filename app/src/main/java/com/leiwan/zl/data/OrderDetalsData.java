package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/25.
 */

public class OrderDetalsData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"order_id":7607,"order_no":"LW18122511243907622543985","fullname":"减肥减肥","mobile":"18140463430","isexpress":1,"reservation":2,"status":1,"addtime":1545708279,"product_id":58,"product_name":"【花水湾】5折后再5折！499元=2大2小抢2晚锦泰温泉酒店住宿+无限次温泉+每日早餐，耍雪山、泡温泉，巴适得板~","product_property":"酒店","merchant_name":"花水湾锦泰温泉大酒店","merchant_address":"花水湾温泉小镇","merchant_lng":"103.265941","merchant_lat":"30.567699","merchant_400tel":"18328512240","num":5,"price":"499.00","totalmoney":"2495.00","startusetime":1545753600,"endusetime":1561824000,"cash":"0.00","points":0,"commission":"0.00","coupon":"0.00","payamount":"2495.00","endtime":1,"code_count":0,"code":[],"payendtime":1545710079}
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
         * order_id : 7607
         * order_no : LW18122511243907622543985
         * fullname : 减肥减肥
         * mobile : 18140463430
         * isexpress : 1
         * reservation : 2
         * status : 1
         * addtime : 1545708279
         * product_id : 58
         * product_name : 【花水湾】5折后再5折！499元=2大2小抢2晚锦泰温泉酒店住宿+无限次温泉+每日早餐，耍雪山、泡温泉，巴适得板~
         * product_property : 酒店
         * merchant_name : 花水湾锦泰温泉大酒店
         * merchant_address : 花水湾温泉小镇
         * merchant_lng : 103.265941
         * merchant_lat : 30.567699
         * merchant_400tel : 18328512240
         * num : 5
         * price : 499.00
         * totalmoney : 2495.00
         * startusetime : 1545753600
         * endusetime : 1561824000
         * cash : 0.00
         * points : 0
         * commission : 0.00
         * coupon : 0.00
         * payamount : 2495.00
         * endtime : 1
         * code_count : 0
         * code : []
         * payendtime : 1545710079
         */

        private int order_id;
        private String order_no;
        private String fullname;
        private String mobile;
        private int isexpress;
        private int reservation;
        private int status;
        private int addtime;
        private int product_id;
        private String product_name;
        private String product_property;
        private String merchant_name;
        private String merchant_address;
        private String merchant_lng;
        private String merchant_lat;
        private String merchant_400tel;
        private int num;
        private String price;
        private String totalmoney;
        private int startusetime;
        private int endusetime;
        private String cash;
        private int points;
        private String commission;
        private String coupon;
        private String payamount;
        private int endtime;
        private int code_count;
        private int payendtime;
        private List<?> code;

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

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getIsexpress() {
            return isexpress;
        }

        public void setIsexpress(int isexpress) {
            this.isexpress = isexpress;
        }

        public int getReservation() {
            return reservation;
        }

        public void setReservation(int reservation) {
            this.reservation = reservation;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getAddtime() {
            return addtime;
        }

        public void setAddtime(int addtime) {
            this.addtime = addtime;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
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

        public String getMerchant_name() {
            return merchant_name;
        }

        public void setMerchant_name(String merchant_name) {
            this.merchant_name = merchant_name;
        }

        public String getMerchant_address() {
            return merchant_address;
        }

        public void setMerchant_address(String merchant_address) {
            this.merchant_address = merchant_address;
        }

        public String getMerchant_lng() {
            return merchant_lng;
        }

        public void setMerchant_lng(String merchant_lng) {
            this.merchant_lng = merchant_lng;
        }

        public String getMerchant_lat() {
            return merchant_lat;
        }

        public void setMerchant_lat(String merchant_lat) {
            this.merchant_lat = merchant_lat;
        }

        public String getMerchant_400tel() {
            return merchant_400tel;
        }

        public void setMerchant_400tel(String merchant_400tel) {
            this.merchant_400tel = merchant_400tel;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getTotalmoney() {
            return totalmoney;
        }

        public void setTotalmoney(String totalmoney) {
            this.totalmoney = totalmoney;
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

        public String getCash() {
            return cash;
        }

        public void setCash(String cash) {
            this.cash = cash;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getCoupon() {
            return coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }

        public String getPayamount() {
            return payamount;
        }

        public void setPayamount(String payamount) {
            this.payamount = payamount;
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

        public int getPayendtime() {
            return payendtime;
        }

        public void setPayendtime(int payendtime) {
            this.payendtime = payendtime;
        }

        public List<?> getCode() {
            return code;
        }

        public void setCode(List<?> code) {
            this.code = code;
        }
    }
}
