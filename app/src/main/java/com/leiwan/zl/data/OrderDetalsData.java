package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/25.
 */

public class OrderDetalsData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"order_id":7621,"express_firm":null,"express_no":null,"order_no":"LW18122614040801926199797","fullname":"减肥减肥","mobile":"15896359806","isexpress":1,"reservation":1,"status":1,"addtime":1545804248,"product_id":53,"product_name":"重大通知：300抢购1000元美年大健康体检套餐，周末节假日、11个分店通用，为您的健康保驾护航。","product_property":"基础+女性升级包二","num":1,"price":"648.00","totalmoney":"648.00","startusetime":1545062400,"endusetime":1576598400,"cash":"0.00","points":0,"commission":"0.00","coupon":"0.00","payamount":"648.00","endtime":1,"code_count":0,"payendtime":1545806048,"shop":[{"merchant_name":"美年大健康","merchant_400tel":"18302889646","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t武侯区\t\t\t\t\t\t","merchant_address":"成都市武侯区浆洗街27号","merchant_lng":"104.086405","merchant_lat":"30.661092"},{"merchant_name":"金牛分店","merchant_400tel":"18302889646","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t金牛区\t\t\t\t\t\t","merchant_address":"成都市金牛区金沙路15号1-2层","merchant_lng":"104.049323","merchant_lat":"30.692545"},{"merchant_name":"星辉分店","merchant_400tel":"18302889601","merchant_ssq":"四川省\t\t\t\t\t\t成都市金牛区","merchant_address":"成都市金牛区星辉西路12号1-2层","merchant_lng":"104.080991","merchant_lat":"30.684565"},{"merchant_name":"天府新谷分院","merchant_400tel":"18302889602","merchant_ssq":"四川省\t\t\t\t\t\t成都市高新南区","merchant_address":"成都市高新区府城大道西段399号天府新谷1栋1-2层","merchant_lng":"104.061764","merchant_lat":"30.594101"},{"merchant_name":"天府三街分院","merchant_400tel":"18302889603","merchant_ssq":"四川省\t\t\t\t\t\t成都市高新南区","merchant_address":"成都市高新区天府大道中段天府三街福年广场3层","merchant_lng":"104.071521","merchant_lat":"30.553275"},{"merchant_name":"凯儿分院","merchant_400tel":"18302889604","merchant_ssq":"四川省\t\t\t\t\t\t成都市武侯区","merchant_address":"成都市武侯区二环路南四段51号莱蒙都会5层","merchant_lng":"104.040133","merchant_lat":"30.63784"},{"merchant_name":"维康分院","merchant_400tel":"18302889605","merchant_ssq":"四川省\t\t\t\t\t\t成都市锦江区","merchant_address":"成都市锦江区静居寺路20号2 楼","merchant_lng":"104.117119","merchant_lat":"30.62769"},{"merchant_name":"双流分院","merchant_400tel":"18302889606","merchant_ssq":"四川省\t\t\t\t\t\t成都市双流区","merchant_address":"成都市双流区东升街道宜城大街三段九号附501附601","merchant_lng":"103.93613","merchant_lat":"30.583767"},{"merchant_name":"慈铭高新","merchant_400tel":"18302889607","merchant_ssq":"四川省\t\t\t\t\t\t成都市高新南区","merchant_address":"成都市高新区天府二街99号","merchant_lng":"104.072924","merchant_lat":"30.556765"},{"merchant_name":"慈铭金沙分院","merchant_400tel":"18302889608","merchant_ssq":"四川省\t\t\t\t\t\t成都市青羊区","merchant_address":"成都青羊区金沙遗址路5号","merchant_lng":"104.015772","merchant_lat":"30.685678"},{"merchant_name":"新都分院","merchant_400tel":"18302889609","merchant_ssq":"四川省\t\t\t\t\t\t成都市新都区","merchant_address":"成都市新都区新都大道479号友盛上都二楼","merchant_lng":"104.197909","merchant_lat":"30.824664"}],"code":[]}
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
         * order_id : 7621
         * express_firm : null
         * express_no : null
         * order_no : LW18122614040801926199797
         * fullname : 减肥减肥
         * mobile : 15896359806
         * isexpress : 1
         * reservation : 1
         * status : 1
         * addtime : 1545804248
         * product_id : 53
         * product_name : 重大通知：300抢购1000元美年大健康体检套餐，周末节假日、11个分店通用，为您的健康保驾护航。
         * product_property : 基础+女性升级包二
         * num : 1
         * price : 648.00
         * totalmoney : 648.00
         * startusetime : 1545062400
         * endusetime : 1576598400
         * cash : 0.00
         * points : 0
         * commission : 0.00
         * coupon : 0.00
         * payamount : 648.00
         * endtime : 1
         * code_count : 0
         * payendtime : 1545806048
         * shop : [{"merchant_name":"美年大健康","merchant_400tel":"18302889646","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t武侯区\t\t\t\t\t\t","merchant_address":"成都市武侯区浆洗街27号","merchant_lng":"104.086405","merchant_lat":"30.661092"},{"merchant_name":"金牛分店","merchant_400tel":"18302889646","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t金牛区\t\t\t\t\t\t","merchant_address":"成都市金牛区金沙路15号1-2层","merchant_lng":"104.049323","merchant_lat":"30.692545"},{"merchant_name":"星辉分店","merchant_400tel":"18302889601","merchant_ssq":"四川省\t\t\t\t\t\t成都市金牛区","merchant_address":"成都市金牛区星辉西路12号1-2层","merchant_lng":"104.080991","merchant_lat":"30.684565"},{"merchant_name":"天府新谷分院","merchant_400tel":"18302889602","merchant_ssq":"四川省\t\t\t\t\t\t成都市高新南区","merchant_address":"成都市高新区府城大道西段399号天府新谷1栋1-2层","merchant_lng":"104.061764","merchant_lat":"30.594101"},{"merchant_name":"天府三街分院","merchant_400tel":"18302889603","merchant_ssq":"四川省\t\t\t\t\t\t成都市高新南区","merchant_address":"成都市高新区天府大道中段天府三街福年广场3层","merchant_lng":"104.071521","merchant_lat":"30.553275"},{"merchant_name":"凯儿分院","merchant_400tel":"18302889604","merchant_ssq":"四川省\t\t\t\t\t\t成都市武侯区","merchant_address":"成都市武侯区二环路南四段51号莱蒙都会5层","merchant_lng":"104.040133","merchant_lat":"30.63784"},{"merchant_name":"维康分院","merchant_400tel":"18302889605","merchant_ssq":"四川省\t\t\t\t\t\t成都市锦江区","merchant_address":"成都市锦江区静居寺路20号2 楼","merchant_lng":"104.117119","merchant_lat":"30.62769"},{"merchant_name":"双流分院","merchant_400tel":"18302889606","merchant_ssq":"四川省\t\t\t\t\t\t成都市双流区","merchant_address":"成都市双流区东升街道宜城大街三段九号附501附601","merchant_lng":"103.93613","merchant_lat":"30.583767"},{"merchant_name":"慈铭高新","merchant_400tel":"18302889607","merchant_ssq":"四川省\t\t\t\t\t\t成都市高新南区","merchant_address":"成都市高新区天府二街99号","merchant_lng":"104.072924","merchant_lat":"30.556765"},{"merchant_name":"慈铭金沙分院","merchant_400tel":"18302889608","merchant_ssq":"四川省\t\t\t\t\t\t成都市青羊区","merchant_address":"成都青羊区金沙遗址路5号","merchant_lng":"104.015772","merchant_lat":"30.685678"},{"merchant_name":"新都分院","merchant_400tel":"18302889609","merchant_ssq":"四川省\t\t\t\t\t\t成都市新都区","merchant_address":"成都市新都区新都大道479号友盛上都二楼","merchant_lng":"104.197909","merchant_lat":"30.824664"}]
         * code : []
         */

        private int order_id;
        private Object express_firm;
        private Object express_no;
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
        private List<ShopBean> shop;
        private List<?> code;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public Object getExpress_firm() {
            return express_firm;
        }

        public void setExpress_firm(Object express_firm) {
            this.express_firm = express_firm;
        }

        public Object getExpress_no() {
            return express_no;
        }

        public void setExpress_no(Object express_no) {
            this.express_no = express_no;
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

        public List<ShopBean> getShop() {
            return shop;
        }

        public void setShop(List<ShopBean> shop) {
            this.shop = shop;
        }

        public List<?> getCode() {
            return code;
        }

        public void setCode(List<?> code) {
            this.code = code;
        }

        public static class ShopBean {
            /**
             * merchant_name : 美年大健康
             * merchant_400tel : 18302889646
             * merchant_ssq : 四川省						成都市						武侯区
             * merchant_address : 成都市武侯区浆洗街27号
             * merchant_lng : 104.086405
             * merchant_lat : 30.661092
             */

            private String merchant_name;
            private String merchant_400tel;
            private String merchant_ssq;
            private String merchant_address;
            private String merchant_lng;
            private String merchant_lat;

            public String getMerchant_name() {
                return merchant_name;
            }

            public void setMerchant_name(String merchant_name) {
                this.merchant_name = merchant_name;
            }

            public String getMerchant_400tel() {
                return merchant_400tel;
            }

            public void setMerchant_400tel(String merchant_400tel) {
                this.merchant_400tel = merchant_400tel;
            }

            public String getMerchant_ssq() {
                return merchant_ssq;
            }

            public void setMerchant_ssq(String merchant_ssq) {
                this.merchant_ssq = merchant_ssq;
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
        }
    }
}
