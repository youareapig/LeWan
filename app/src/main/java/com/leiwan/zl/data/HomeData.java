package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/16.
 */

public class HomeData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"product_id":6,"product_pic":"http://cs.lewan6.ren/uploads/20181128/5aa95c1fc91e6275236fc44e2490bfd3.jpg","product_compic":["http://cs.lewan6.ren/uploads/20181128/7b736fcafe1a44b3188dadcd8c9040b1.jpg","http://cs.lewan6.ren/uploads/20181128/cce683f5dee2d23d326f13f9f113986a.jpg","http://cs.lewan6.ren/uploads/20181128/ebdbb042c9cb8bcea46909b8822618bb.jpg"],"product_name":"览虫书吧感恩回馈！素食四合院19.9元抢购原价192元2-3人下午茶和甜点套餐！","temp_price":"99.00","temp_commission":[],"product_sold":0,"product_returnall":0,"product_timelimit":1,"product_numlimit":1,"product_starttime":1543507200,"product_endtime":1544544000,"sold_out":0,"share_desc":"1折19.9元抢成都zui具文艺范\u201c览虫书吧\u201d下午茶/甜点经典套餐； 心灵栖息地，轻松览世界，致敬读书人！集书籍、咖啡、甜品、经典茶饮、素食、会议、雅集等服务","product_uptime":1543388229,"product_addtime":1543387612,"merchant_name":"测试商家1","region":"成都市","product_totalnum":1000,"now_time":1543393294},{"product_id":2,"product_pic":"http://cs.lewan6.ren/uploads/20181127/848514333a1e64d2409151a320d336a9.jpg","product_compic":["http://cs.lewan6.ren/uploads/20181127/0a819a834272edda0ab18e73eeb7e31a.jpg","http://cs.lewan6.ren/uploads/20181127/358f21ecf1080946b76793bb4b71dbea.jpg","http://cs.lewan6.ren/uploads/20181127/39d044c41e28e1907a013f1a76318fe0.jpg"],"product_name":"一把骨老火锅","temp_price":"0.20","temp_commission":[],"product_sold":0,"product_returnall":0,"product_timelimit":1,"product_numlimit":0,"product_starttime":1543248000,"product_endtime":1545840000,"sold_out":0,"share_desc":"清淡、浓汤、麻辣类型皆有","product_uptime":1543375347,"product_addtime":1543288848,"merchant_name":"测试商家1","region":"成都市","product_totalnum":100,"now_time":1543393294}]
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
         * product_id : 6
         * product_pic : http://cs.lewan6.ren/uploads/20181128/5aa95c1fc91e6275236fc44e2490bfd3.jpg
         * product_compic : ["http://cs.lewan6.ren/uploads/20181128/7b736fcafe1a44b3188dadcd8c9040b1.jpg","http://cs.lewan6.ren/uploads/20181128/cce683f5dee2d23d326f13f9f113986a.jpg","http://cs.lewan6.ren/uploads/20181128/ebdbb042c9cb8bcea46909b8822618bb.jpg"]
         * product_name : 览虫书吧感恩回馈！素食四合院19.9元抢购原价192元2-3人下午茶和甜点套餐！
         * temp_price : 99.00
         * temp_commission : []
         * product_sold : 0
         * product_returnall : 0
         * product_timelimit : 1
         * product_numlimit : 1
         * product_starttime : 1543507200
         * product_endtime : 1544544000
         * sold_out : 0
         * share_desc : 1折19.9元抢成都zui具文艺范“览虫书吧”下午茶/甜点经典套餐； 心灵栖息地，轻松览世界，致敬读书人！集书籍、咖啡、甜品、经典茶饮、素食、会议、雅集等服务
         * product_uptime : 1543388229
         * product_addtime : 1543387612
         * merchant_name : 测试商家1
         * region : 成都市
         * product_totalnum : 1000
         * now_time : 1543393294
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
