package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/16.
 */

public class HomeData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"product_id":3,"product_pic":"http://lwlm.com/uploads/20180923/0157fb2d27c9e3b36c67b8cbbdd44626.jpg","product_compic":["http://lwlm.com/uploads/20180923/0157fb2d27c9e3b36c67b8cbbdd44626.jpg","http://lwlm.com/uploads/20180923/0157fb2d27c9e3b36c67b8cbbdd44626.jpg"],"product_name":"蓉城江北老灶春熙店100元代金券！可以叠用三张！周末节假日通用！限量秒杀1","temp_price":"80.00","temp_commission":0,"product_sold":3,"product_returnall":0,"product_timelimit":0,"product_numlimit":0,"product_starttime":1539014400,"product_endtime":1540396800,"region":"四川省成都市锦江区","distance":"0.20"}]
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
         * product_id : 3
         * product_pic : http://lwlm.com/uploads/20180923/0157fb2d27c9e3b36c67b8cbbdd44626.jpg
         * product_compic : ["http://lwlm.com/uploads/20180923/0157fb2d27c9e3b36c67b8cbbdd44626.jpg","http://lwlm.com/uploads/20180923/0157fb2d27c9e3b36c67b8cbbdd44626.jpg"]
         * product_name : 蓉城江北老灶春熙店100元代金券！可以叠用三张！周末节假日通用！限量秒杀1
         * temp_price : 80.00
         * temp_commission : 0
         * product_sold : 3
         * product_returnall : 0
         * product_timelimit : 0
         * product_numlimit : 0
         * product_starttime : 1539014400
         * product_endtime : 1540396800
         * region : 四川省成都市锦江区
         * distance : 0.20
         */

        private int product_id;
        private String product_pic;
        private String product_name;
        private String temp_price;
        private int temp_commission;
        private int product_sold;
        private int product_returnall;
        private int product_timelimit;
        private int product_numlimit;
        private int product_starttime;
        private int product_endtime;
        private String region;
        private String distance;
        private List<String> product_compic;

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getProduct_pic() {
            return product_pic;
        }

        public void setProduct_pic(String product_pic) {
            this.product_pic = product_pic;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getTemp_price() {
            return temp_price;
        }

        public void setTemp_price(String temp_price) {
            this.temp_price = temp_price;
        }

        public int getTemp_commission() {
            return temp_commission;
        }

        public void setTemp_commission(int temp_commission) {
            this.temp_commission = temp_commission;
        }

        public int getProduct_sold() {
            return product_sold;
        }

        public void setProduct_sold(int product_sold) {
            this.product_sold = product_sold;
        }

        public int getProduct_returnall() {
            return product_returnall;
        }

        public void setProduct_returnall(int product_returnall) {
            this.product_returnall = product_returnall;
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

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public List<String> getProduct_compic() {
            return product_compic;
        }

        public void setProduct_compic(List<String> product_compic) {
            this.product_compic = product_compic;
        }
    }
}
