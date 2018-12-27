package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/25.
 */

public class OrderDetalsData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"order_id":7629,"express_firm":null,"express_no":null,"order_no":"LW18122709404300512279447","fullname":"旺财","mobile":"13778877888","isexpress":1,"reservation":1,"status":5,"addtime":1545874843,"product_id":54,"product_name":"【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用","product_property":"汽车养护","num":1,"price":"0.01","totalmoney":"0.01","startusetime":1545408000,"endusetime":1559232000,"cash":"0.00","points":0,"commission":"0.00","coupon":"0.00","payamount":"0.01","endtime":1,"code_count":1,"payendtime":1545876643,"shop":[{"merchant_name":"畅享汽车A分店","merchant_400tel":"028-84542003","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","merchant_address":"二环路东5段132号","merchant_lng":"104.102654","merchant_lat":"30.628565"},{"merchant_name":"龙泉鼎力店","merchant_400tel":"028-64731929","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t龙泉驿区\t\t\t\t\t\t","merchant_address":"北泉路818号","merchant_lng":"104.251774","merchant_lat":"30.57638"},{"merchant_name":"犀浦君印店","merchant_400tel":"028-87839502","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t郫都区\t\t\t\t\t\t","merchant_address":"犀浦兴业北街258号","merchant_lng":"103.988827","merchant_lat":"30.763269"},{"merchant_name":"龙泉建材路店","merchant_400tel":"028-88493957","merchant_ssq":"四川省\t\t\t\t\t\t成都市龙泉驿区","merchant_address":"建材路219号","merchant_lng":"104.286252","merchant_lat":"30.576032"},{"merchant_name":"温江春江店","merchant_400tel":"028-82791018","merchant_ssq":"四川省\t\t\t\t\t\t成都市温江区","merchant_address":"春江南路158号","merchant_lng":"103.847013","merchant_lat":"30.720418"},{"merchant_name":"郫都君悦星空店","merchant_400tel":"028-67242428","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t郫都区\t\t\t\t\t\t","merchant_address":"顺文路1号","merchant_lng":"103.889422","merchant_lat":"30.801077"},{"merchant_name":"锦华万达店","merchant_400tel":"15328047181","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","merchant_address":"二环路东5段132","merchant_lng":"104.102708","merchant_lat":"30.628534"}],"code":[{"consume_code":"4776109735385","consume_status":2,"consume_type":1}]}
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
         * order_id : 7629
         * express_firm : null
         * express_no : null
         * order_no : LW18122709404300512279447
         * fullname : 旺财
         * mobile : 13778877888
         * isexpress : 1
         * reservation : 1
         * status : 5
         * addtime : 1545874843
         * product_id : 54
         * product_name : 【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用
         * product_property : 汽车养护
         * num : 1
         * price : 0.01
         * totalmoney : 0.01
         * startusetime : 1545408000
         * endusetime : 1559232000
         * cash : 0.00
         * points : 0
         * commission : 0.00
         * coupon : 0.00
         * payamount : 0.01
         * endtime : 1
         * code_count : 1
         * payendtime : 1545876643
         * shop : [{"merchant_name":"畅享汽车A分店","merchant_400tel":"028-84542003","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","merchant_address":"二环路东5段132号","merchant_lng":"104.102654","merchant_lat":"30.628565"},{"merchant_name":"龙泉鼎力店","merchant_400tel":"028-64731929","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t龙泉驿区\t\t\t\t\t\t","merchant_address":"北泉路818号","merchant_lng":"104.251774","merchant_lat":"30.57638"},{"merchant_name":"犀浦君印店","merchant_400tel":"028-87839502","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t郫都区\t\t\t\t\t\t","merchant_address":"犀浦兴业北街258号","merchant_lng":"103.988827","merchant_lat":"30.763269"},{"merchant_name":"龙泉建材路店","merchant_400tel":"028-88493957","merchant_ssq":"四川省\t\t\t\t\t\t成都市龙泉驿区","merchant_address":"建材路219号","merchant_lng":"104.286252","merchant_lat":"30.576032"},{"merchant_name":"温江春江店","merchant_400tel":"028-82791018","merchant_ssq":"四川省\t\t\t\t\t\t成都市温江区","merchant_address":"春江南路158号","merchant_lng":"103.847013","merchant_lat":"30.720418"},{"merchant_name":"郫都君悦星空店","merchant_400tel":"028-67242428","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t郫都区\t\t\t\t\t\t","merchant_address":"顺文路1号","merchant_lng":"103.889422","merchant_lat":"30.801077"},{"merchant_name":"锦华万达店","merchant_400tel":"15328047181","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","merchant_address":"二环路东5段132","merchant_lng":"104.102708","merchant_lat":"30.628534"}]
         * code : [{"consume_code":"4776109735385","consume_status":2,"consume_type":1}]
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
        private List<CodeBean> code;

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

        public List<CodeBean> getCode() {
            return code;
        }

        public void setCode(List<CodeBean> code) {
            this.code = code;
        }

        public static class ShopBean {
            /**
             * merchant_name : 畅享汽车A分店
             * merchant_400tel : 028-84542003
             * merchant_ssq : 四川省						成都市						锦江区
             * merchant_address : 二环路东5段132号
             * merchant_lng : 104.102654
             * merchant_lat : 30.628565
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

        public static class CodeBean {
            /**
             * consume_code : 4776109735385
             * consume_status : 2
             * consume_type : 1
             */

            private String consume_code;
            private int consume_status;
            private int consume_type;

            public String getConsume_code() {
                return consume_code;
            }

            public void setConsume_code(String consume_code) {
                this.consume_code = consume_code;
            }

            public int getConsume_status() {
                return consume_status;
            }

            public void setConsume_status(int consume_status) {
                this.consume_status = consume_status;
            }

            public int getConsume_type() {
                return consume_type;
            }

            public void setConsume_type(int consume_type) {
                this.consume_type = consume_type;
            }
        }
    }
}
