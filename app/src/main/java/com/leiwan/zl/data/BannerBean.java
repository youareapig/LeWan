package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class BannerBean {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"product_id":2,"product_pic":"http://cs.lewan6.ren/uploads/20181127/848514333a1e64d2409151a320d336a9.jpg","product_compic":["http://cs.lewan6.ren/uploads/20181127/0a819a834272edda0ab18e73eeb7e31a.jpg","http://cs.lewan6.ren/uploads/20181127/358f21ecf1080946b76793bb4b71dbea.jpg","http://cs.lewan6.ren/uploads/20181127/39d044c41e28e1907a013f1a76318fe0.jpg"],"product_name":"一把骨老火锅","temp_price":"0.01","temp_commission":[],"product_sold":33,"product_returnall":0,"product_timelimit":1,"product_numlimit":0,"product_starttime":1543420800,"product_endtime":1545840000,"sold_out":0,"share_desc":"清淡、浓汤、麻辣类型皆有","product_uptime":1543482456,"product_addtime":1543288848,"merchant_name":"测试商家1","region":"成都市","distance":"65.90","product_totalnum":100,"now_time":1543549735},{"product_id":9,"product_pic":"http://cs.lewan6.ren/uploads/20181129/9fae7dbc1cb549a30a89b48a3bc7a455.jpg","product_compic":["http://cs.lewan6.ren/uploads/20181129/5a1b23caff20948ce026d0c1504ec3f3.jpg","http://cs.lewan6.ren/uploads/20181129/f504000836cf50de74d7a90b77e24e49.jpg","http://cs.lewan6.ren/uploads/20181129/3fdf6b5c990641402c97a2d72672267b.jpg"],"product_name":"198元抢2018-2019成都亲子年票60+场馆","temp_price":"0.00","temp_commission":[],"product_sold":0,"product_returnall":0,"product_timelimit":1,"product_numlimit":0,"product_starttime":1543420800,"product_endtime":1546012800,"sold_out":0,"share_desc":"","product_uptime":1543495599,"product_addtime":1543469165,"merchant_name":"望江餐厅","region":"眉山市","distance":"11345.08","product_totalnum":0,"now_time":1543549735},{"product_id":5,"product_pic":"http://cs.lewan6.ren/uploads/20181128/fa713a8df273501ae79661a49f5f1d3d.jpg","product_compic":["http://cs.lewan6.ren/uploads/20181128/33f3f2facdea47ae80eff7ac82ca6af7.jpg","http://cs.lewan6.ren/uploads/20181128/4ef2e3a51272dde42a49d7b68b0a752c.jpg","http://cs.lewan6.ren/uploads/20181128/8f70a50f53fe1e5ab2886329fcf4bddb.jpg"],"product_name":"峨眉山温泉源头大酒店288元=2大2小抢住","temp_price":"444.00","temp_commission":[],"product_sold":44446,"product_returnall":0,"product_timelimit":0,"product_numlimit":0,"product_starttime":1540828800,"product_endtime":1544198400,"sold_out":0,"share_desc":"峨眉山温泉源头大酒店288元=2大2小抢住峨眉山温泉源头大酒店（含自助早餐、无限次泡温泉、菜品代金券等）","product_uptime":1543477753,"product_addtime":1543384759,"merchant_name":"望江餐厅","region":"眉山市","distance":"11345.08","product_totalnum":55555,"now_time":1543549735},{"product_id":4,"product_pic":"http://cs.lewan6.ren/uploads/20181128/d226a77baca9f216a07ae7522669a083.jpg","product_compic":["http://cs.lewan6.ren/uploads/1","http://cs.lewan6.ren/uploads/1","http://cs.lewan6.ren/uploads/1"],"product_name":"来之水果的邀请","temp_price":"5.10","temp_commission":[],"product_sold":26,"product_returnall":0,"product_timelimit":0,"product_numlimit":1,"product_starttime":null,"product_endtime":null,"sold_out":1,"share_desc":"来自进口新鲜水果,多个国家多个最新，最多的口味来诱惑你的眼球","product_uptime":1543408121,"product_addtime":1543367782,"merchant_name":"测试商家1","region":"成都市","distance":"65.90","product_totalnum":500,"now_time":1543549735},{"product_id":3,"product_pic":"http://cs.lewan6.ren/uploads/20181127/6afa89bae2325b16a70d11e51c0c0cab.jpg","product_compic":["http://cs.lewan6.ren/uploads/20181127/fbc4d12b9c16d6df64c081cba1b83b28.jpg","http://cs.lewan6.ren/uploads/20181127/f4e33f966b38937ef16325cc032f1204.jpg","http://cs.lewan6.ren/uploads/1"],"product_name":"水煮鱼","temp_price":"0.05","temp_commission":[],"product_sold":35,"product_returnall":0,"product_timelimit":0,"product_numlimit":0,"product_starttime":1543248000,"product_endtime":1545840000,"sold_out":1,"share_desc":"正宗川味水煮鱼","product_uptime":1543407819,"product_addtime":1543297734,"merchant_name":"望江餐厅","region":"眉山市","distance":"11345.08","product_totalnum":16,"now_time":1543549735}]
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
         * product_id : 2
         * product_pic : http://cs.lewan6.ren/uploads/20181127/848514333a1e64d2409151a320d336a9.jpg
         * product_compic : ["http://cs.lewan6.ren/uploads/20181127/0a819a834272edda0ab18e73eeb7e31a.jpg","http://cs.lewan6.ren/uploads/20181127/358f21ecf1080946b76793bb4b71dbea.jpg","http://cs.lewan6.ren/uploads/20181127/39d044c41e28e1907a013f1a76318fe0.jpg"]
         * product_name : 一把骨老火锅
         * temp_price : 0.01
         * temp_commission : []
         * product_sold : 33
         * product_returnall : 0
         * product_timelimit : 1
         * product_numlimit : 0
         * product_starttime : 1543420800
         * product_endtime : 1545840000
         * sold_out : 0
         * share_desc : 清淡、浓汤、麻辣类型皆有
         * product_uptime : 1543482456
         * product_addtime : 1543288848
         * merchant_name : 测试商家1
         * region : 成都市
         * distance : 65.90
         * product_totalnum : 100
         * now_time : 1543549735
         */

        private int product_id;
        private String product_pic;
        private String product_name;
        private String temp_price;
        private int product_sold;
        private int product_returnall;
        private int product_timelimit;
        private int product_numlimit;
        private int product_starttime;
        private int product_endtime;
        private int sold_out;
        private String share_desc;
        private int product_uptime;
        private int product_addtime;
        private String merchant_name;
        private String region;
        private String distance;
        private int product_totalnum;
        private int now_time;
        private List<String> product_compic;
        private List<?> temp_commission;

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

        public int getSold_out() {
            return sold_out;
        }

        public void setSold_out(int sold_out) {
            this.sold_out = sold_out;
        }

        public String getShare_desc() {
            return share_desc;
        }

        public void setShare_desc(String share_desc) {
            this.share_desc = share_desc;
        }

        public int getProduct_uptime() {
            return product_uptime;
        }

        public void setProduct_uptime(int product_uptime) {
            this.product_uptime = product_uptime;
        }

        public int getProduct_addtime() {
            return product_addtime;
        }

        public void setProduct_addtime(int product_addtime) {
            this.product_addtime = product_addtime;
        }

        public String getMerchant_name() {
            return merchant_name;
        }

        public void setMerchant_name(String merchant_name) {
            this.merchant_name = merchant_name;
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

        public int getProduct_totalnum() {
            return product_totalnum;
        }

        public void setProduct_totalnum(int product_totalnum) {
            this.product_totalnum = product_totalnum;
        }

        public int getNow_time() {
            return now_time;
        }

        public void setNow_time(int now_time) {
            this.now_time = now_time;
        }

        public List<String> getProduct_compic() {
            return product_compic;
        }

        public void setProduct_compic(List<String> product_compic) {
            this.product_compic = product_compic;
        }

        public List<?> getTemp_commission() {
            return temp_commission;
        }

        public void setTemp_commission(List<?> temp_commission) {
            this.temp_commission = temp_commission;
        }
    }
}
