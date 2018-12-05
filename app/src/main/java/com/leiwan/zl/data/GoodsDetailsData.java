package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/5.
 */

public class GoodsDetailsData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"details":{"product_id":5,"product_name":"288元=2大2小高级房/双床房（含无限次泡温泉、自助早餐、菜品代金券等），周末节假日可用，有效期至2019年6月","product_pic":"http://cs.lewan6.ren/uploads/20181129/b7f035df1774df780309c13250f6eea9.jpg","product_carousel":["http://cs.lewan6.ren/uploads/20181128/56dcefe17dadc6f3a2442af757b371fb.jpg","http://cs.lewan6.ren/uploads/20181128/838aa13b56f7be9cb20614086e2873cc.jpg","http://cs.lewan6.ren/uploads/20181128/9bacdc06e3726ed7c7cca40613a426d0.jpg","http://cs.lewan6.ren/uploads/20181128/73c6f76f9fe189d0871974bb714f8399.jpg","http://cs.lewan6.ren/uploads/20181130/04393e08dd86ab54fbea145e31a8abd5.jpg","http://cs.lewan6.ren/uploads/20181130/02d2899289159c95d2d86920805b0c59.jpg","http://cs.lewan6.ren/uploads/20181130/cfd132e4e5995a58040f441071a508ca.jpg","http://cs.lewan6.ren/uploads/20181130/712cea2e27902da4cfcf0617b1dfc42b.jpg","http://cs.lewan6.ren/uploads/20181130/e5c073a3c36523d496650ab6cf87b68e.jpg","http://cs.lewan6.ren/uploads/20181130/b2d1cb8012f94f31cd4ed9895a7ed1b0.jpg"],"product_poster":"http://cs.lewan6.ren/uploads/20181130/10fcdaa3ca5a5d5f555df20af4ce289f.jpg","product_tags":null,"product_returnall":0,"product_explosion":1,"product_reservation":1,"product_isexpress":1,"product_sold":17,"product_timelimit":0,"product_numlimit":1,"product_numlimit_num":50,"product_starttime":1543248000,"product_endtime":1544198400,"product_startusetime":1543852800,"product_endusetime":1561824000,"price_type":1,"reservationStr":"午餐|晚餐","product_info":"aa","product_useinfo":"bb","product_notice":"<p>\r\n\tcc\r\n<\/p>","product_description":"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\">\r\n\tdddddddddddddddddd\r\n<\/p>","sold_out":0,"share_desc":"288元=2大2小高级房/双床房（含自助早餐、无限次泡温泉、菜品代金券等），周末节假日可用，有效期至19年6月","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","merchant_address":"峨眉山五显岗车站，源头大酒店","merchant_lat":"29.584648","merchant_lng":"103.412537","numlimitcount":0,"now_time":1544000028},"price":[],"hotpush":[{"product_id":9,"product_pic":"http://cs.lewan6.ren/uploads/20181129/f71fbe9d3b67911b3e33559584936861.jpg","product_name":"爆品再爆！198元抢18-19年成都亲子年票，60+乐园和景区场馆通玩：浩海立方、天堂岛、339熊猫塔、国色天乡、水果侠、亚特兰蒂斯......","temp_price":"198.00","temp_commission":[],"sold_out":0,"merchant_name":"亲子年票","region":"成都市","distance":5076},{"product_id":10,"product_pic":"http://cs.lewan6.ren/uploads/20181129/7afc3a99257b958853890239b943f31e.jpg","product_name":"【高新区】19.9元抢506元套餐含10荤6素+68瓶青岛啤酒+100元代金券，周末节假日通用免预约，至19年6月有效","temp_price":"19.90","temp_commission":[],"sold_out":0,"merchant_name":"洪门里火锅","region":"成都市","distance":6888},{"product_id":8,"product_pic":"http://cs.lewan6.ren/uploads/20181129/5e3ffdb82e0c2e2443b02a9a492f32eb.jpg","product_name":"【锦江区】19.9元抢爱车巴汽车服务=3次标准洗车+1次发动机机舱清洗+20项安全检测+雨刮精，6个月有效期","temp_price":"19.90","temp_commission":[],"sold_out":0,"merchant_name":"爱车巴","region":"成都市","distance":3318},{"product_id":1,"product_pic":"http://cs.lewan6.ren/uploads/20181126/ae7dc26e47f3ac3e48423b93d6c77f2c.jpg","product_name":"专业汽车上门养护，给您的爱车保姆式服务，268元抢价值4878元汽车镀晶养护套餐，12养护项目，网上预订上门服务！","temp_price":"5.10","temp_commission":[],"sold_out":0,"merchant_name":"爱车巴","region":"成都市","distance":3318},{"product_id":6,"product_pic":"http://cs.lewan6.ren/uploads/20181128/5aa95c1fc91e6275236fc44e2490bfd3.jpg","product_name":"览虫书吧感恩回馈！素食四合院19.9元抢购原价192元2-3人下午茶和甜点套餐！","temp_price":"0.04","temp_commission":[],"sold_out":1,"merchant_name":"爱车巴","region":"成都市","distance":3318}]}
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
         * details : {"product_id":5,"product_name":"288元=2大2小高级房/双床房（含无限次泡温泉、自助早餐、菜品代金券等），周末节假日可用，有效期至2019年6月","product_pic":"http://cs.lewan6.ren/uploads/20181129/b7f035df1774df780309c13250f6eea9.jpg","product_carousel":["http://cs.lewan6.ren/uploads/20181128/56dcefe17dadc6f3a2442af757b371fb.jpg","http://cs.lewan6.ren/uploads/20181128/838aa13b56f7be9cb20614086e2873cc.jpg","http://cs.lewan6.ren/uploads/20181128/9bacdc06e3726ed7c7cca40613a426d0.jpg","http://cs.lewan6.ren/uploads/20181128/73c6f76f9fe189d0871974bb714f8399.jpg","http://cs.lewan6.ren/uploads/20181130/04393e08dd86ab54fbea145e31a8abd5.jpg","http://cs.lewan6.ren/uploads/20181130/02d2899289159c95d2d86920805b0c59.jpg","http://cs.lewan6.ren/uploads/20181130/cfd132e4e5995a58040f441071a508ca.jpg","http://cs.lewan6.ren/uploads/20181130/712cea2e27902da4cfcf0617b1dfc42b.jpg","http://cs.lewan6.ren/uploads/20181130/e5c073a3c36523d496650ab6cf87b68e.jpg","http://cs.lewan6.ren/uploads/20181130/b2d1cb8012f94f31cd4ed9895a7ed1b0.jpg"],"product_poster":"http://cs.lewan6.ren/uploads/20181130/10fcdaa3ca5a5d5f555df20af4ce289f.jpg","product_tags":null,"product_returnall":0,"product_explosion":1,"product_reservation":1,"product_isexpress":1,"product_sold":17,"product_timelimit":0,"product_numlimit":1,"product_numlimit_num":50,"product_starttime":1543248000,"product_endtime":1544198400,"product_startusetime":1543852800,"product_endusetime":1561824000,"price_type":1,"reservationStr":"午餐|晚餐","product_info":"aa","product_useinfo":"bb","product_notice":"<p>\r\n\tcc\r\n<\/p>","product_description":"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\">\r\n\tdddddddddddddddddd\r\n<\/p>","sold_out":0,"share_desc":"288元=2大2小高级房/双床房（含自助早餐、无限次泡温泉、菜品代金券等），周末节假日可用，有效期至19年6月","merchant_ssq":"四川省\t\t\t\t\t\t成都市\t\t\t\t\t\t锦江区\t\t\t\t\t\t","merchant_address":"峨眉山五显岗车站，源头大酒店","merchant_lat":"29.584648","merchant_lng":"103.412537","numlimitcount":0,"now_time":1544000028}
         * price : []
         * hotpush : [{"product_id":9,"product_pic":"http://cs.lewan6.ren/uploads/20181129/f71fbe9d3b67911b3e33559584936861.jpg","product_name":"爆品再爆！198元抢18-19年成都亲子年票，60+乐园和景区场馆通玩：浩海立方、天堂岛、339熊猫塔、国色天乡、水果侠、亚特兰蒂斯......","temp_price":"198.00","temp_commission":[],"sold_out":0,"merchant_name":"亲子年票","region":"成都市","distance":5076},{"product_id":10,"product_pic":"http://cs.lewan6.ren/uploads/20181129/7afc3a99257b958853890239b943f31e.jpg","product_name":"【高新区】19.9元抢506元套餐含10荤6素+68瓶青岛啤酒+100元代金券，周末节假日通用免预约，至19年6月有效","temp_price":"19.90","temp_commission":[],"sold_out":0,"merchant_name":"洪门里火锅","region":"成都市","distance":6888},{"product_id":8,"product_pic":"http://cs.lewan6.ren/uploads/20181129/5e3ffdb82e0c2e2443b02a9a492f32eb.jpg","product_name":"【锦江区】19.9元抢爱车巴汽车服务=3次标准洗车+1次发动机机舱清洗+20项安全检测+雨刮精，6个月有效期","temp_price":"19.90","temp_commission":[],"sold_out":0,"merchant_name":"爱车巴","region":"成都市","distance":3318},{"product_id":1,"product_pic":"http://cs.lewan6.ren/uploads/20181126/ae7dc26e47f3ac3e48423b93d6c77f2c.jpg","product_name":"专业汽车上门养护，给您的爱车保姆式服务，268元抢价值4878元汽车镀晶养护套餐，12养护项目，网上预订上门服务！","temp_price":"5.10","temp_commission":[],"sold_out":0,"merchant_name":"爱车巴","region":"成都市","distance":3318},{"product_id":6,"product_pic":"http://cs.lewan6.ren/uploads/20181128/5aa95c1fc91e6275236fc44e2490bfd3.jpg","product_name":"览虫书吧感恩回馈！素食四合院19.9元抢购原价192元2-3人下午茶和甜点套餐！","temp_price":"0.04","temp_commission":[],"sold_out":1,"merchant_name":"爱车巴","region":"成都市","distance":3318}]
         */

        private DetailsBean details;
        private List<?> price;
        private List<HotpushBean> hotpush;

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public List<?> getPrice() {
            return price;
        }

        public void setPrice(List<?> price) {
            this.price = price;
        }

        public List<HotpushBean> getHotpush() {
            return hotpush;
        }

        public void setHotpush(List<HotpushBean> hotpush) {
            this.hotpush = hotpush;
        }

        public static class DetailsBean {
            /**
             * product_id : 5
             * product_name : 288元=2大2小高级房/双床房（含无限次泡温泉、自助早餐、菜品代金券等），周末节假日可用，有效期至2019年6月
             * product_pic : http://cs.lewan6.ren/uploads/20181129/b7f035df1774df780309c13250f6eea9.jpg
             * product_carousel : ["http://cs.lewan6.ren/uploads/20181128/56dcefe17dadc6f3a2442af757b371fb.jpg","http://cs.lewan6.ren/uploads/20181128/838aa13b56f7be9cb20614086e2873cc.jpg","http://cs.lewan6.ren/uploads/20181128/9bacdc06e3726ed7c7cca40613a426d0.jpg","http://cs.lewan6.ren/uploads/20181128/73c6f76f9fe189d0871974bb714f8399.jpg","http://cs.lewan6.ren/uploads/20181130/04393e08dd86ab54fbea145e31a8abd5.jpg","http://cs.lewan6.ren/uploads/20181130/02d2899289159c95d2d86920805b0c59.jpg","http://cs.lewan6.ren/uploads/20181130/cfd132e4e5995a58040f441071a508ca.jpg","http://cs.lewan6.ren/uploads/20181130/712cea2e27902da4cfcf0617b1dfc42b.jpg","http://cs.lewan6.ren/uploads/20181130/e5c073a3c36523d496650ab6cf87b68e.jpg","http://cs.lewan6.ren/uploads/20181130/b2d1cb8012f94f31cd4ed9895a7ed1b0.jpg"]
             * product_poster : http://cs.lewan6.ren/uploads/20181130/10fcdaa3ca5a5d5f555df20af4ce289f.jpg
             * product_tags : null
             * product_returnall : 0
             * product_explosion : 1
             * product_reservation : 1
             * product_isexpress : 1
             * product_sold : 17
             * product_timelimit : 0
             * product_numlimit : 1
             * product_numlimit_num : 50
             * product_starttime : 1543248000
             * product_endtime : 1544198400
             * product_startusetime : 1543852800
             * product_endusetime : 1561824000
             * price_type : 1
             * reservationStr : 午餐|晚餐
             * product_info : aa
             * product_useinfo : bb
             * product_notice : <p>
             cc
             </p>
             * product_description : <p class="MsoNormal" align="center" style="text-align:center;">
             dddddddddddddddddd
             </p>
             * sold_out : 0
             * share_desc : 288元=2大2小高级房/双床房（含自助早餐、无限次泡温泉、菜品代金券等），周末节假日可用，有效期至19年6月
             * merchant_ssq : 四川省						成都市						锦江区
             * merchant_address : 峨眉山五显岗车站，源头大酒店
             * merchant_lat : 29.584648
             * merchant_lng : 103.412537
             * numlimitcount : 0
             * now_time : 1544000028
             */

            private int product_id;
            private String product_name;
            private String product_pic;
            private String product_poster;
            private Object product_tags;
            private int product_returnall;
            private int product_explosion;
            private int product_reservation;
            private int product_isexpress;
            private int product_sold;
            private int product_timelimit;
            private int product_numlimit;
            private int product_numlimit_num;
            private int product_starttime;
            private int product_endtime;
            private int product_startusetime;
            private int product_endusetime;
            private int price_type;
            private String reservationStr;
            private String product_info;
            private String product_useinfo;
            private String product_notice;
            private String product_description;
            private int sold_out;
            private String share_desc;
            private String merchant_ssq;
            private String merchant_address;
            private String merchant_lat;
            private String merchant_lng;
            private int numlimitcount;
            private int now_time;
            private List<String> product_carousel;

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

            public String getProduct_pic() {
                return product_pic;
            }

            public void setProduct_pic(String product_pic) {
                this.product_pic = product_pic;
            }

            public String getProduct_poster() {
                return product_poster;
            }

            public void setProduct_poster(String product_poster) {
                this.product_poster = product_poster;
            }

            public Object getProduct_tags() {
                return product_tags;
            }

            public void setProduct_tags(Object product_tags) {
                this.product_tags = product_tags;
            }

            public int getProduct_returnall() {
                return product_returnall;
            }

            public void setProduct_returnall(int product_returnall) {
                this.product_returnall = product_returnall;
            }

            public int getProduct_explosion() {
                return product_explosion;
            }

            public void setProduct_explosion(int product_explosion) {
                this.product_explosion = product_explosion;
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

            public int getProduct_sold() {
                return product_sold;
            }

            public void setProduct_sold(int product_sold) {
                this.product_sold = product_sold;
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

            public int getPrice_type() {
                return price_type;
            }

            public void setPrice_type(int price_type) {
                this.price_type = price_type;
            }

            public String getReservationStr() {
                return reservationStr;
            }

            public void setReservationStr(String reservationStr) {
                this.reservationStr = reservationStr;
            }

            public String getProduct_info() {
                return product_info;
            }

            public void setProduct_info(String product_info) {
                this.product_info = product_info;
            }

            public String getProduct_useinfo() {
                return product_useinfo;
            }

            public void setProduct_useinfo(String product_useinfo) {
                this.product_useinfo = product_useinfo;
            }

            public String getProduct_notice() {
                return product_notice;
            }

            public void setProduct_notice(String product_notice) {
                this.product_notice = product_notice;
            }

            public String getProduct_description() {
                return product_description;
            }

            public void setProduct_description(String product_description) {
                this.product_description = product_description;
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

            public String getMerchant_lat() {
                return merchant_lat;
            }

            public void setMerchant_lat(String merchant_lat) {
                this.merchant_lat = merchant_lat;
            }

            public String getMerchant_lng() {
                return merchant_lng;
            }

            public void setMerchant_lng(String merchant_lng) {
                this.merchant_lng = merchant_lng;
            }

            public int getNumlimitcount() {
                return numlimitcount;
            }

            public void setNumlimitcount(int numlimitcount) {
                this.numlimitcount = numlimitcount;
            }

            public int getNow_time() {
                return now_time;
            }

            public void setNow_time(int now_time) {
                this.now_time = now_time;
            }

            public List<String> getProduct_carousel() {
                return product_carousel;
            }

            public void setProduct_carousel(List<String> product_carousel) {
                this.product_carousel = product_carousel;
            }
        }

        public static class HotpushBean {
            /**
             * product_id : 9
             * product_pic : http://cs.lewan6.ren/uploads/20181129/f71fbe9d3b67911b3e33559584936861.jpg
             * product_name : 爆品再爆！198元抢18-19年成都亲子年票，60+乐园和景区场馆通玩：浩海立方、天堂岛、339熊猫塔、国色天乡、水果侠、亚特兰蒂斯......
             * temp_price : 198.00
             * temp_commission : []
             * sold_out : 0
             * merchant_name : 亲子年票
             * region : 成都市
             * distance : 5076
             */

            private int product_id;
            private String product_pic;
            private String product_name;
            private String temp_price;
            private int sold_out;
            private String merchant_name;
            private String region;
            private int distance;
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

            public int getSold_out() {
                return sold_out;
            }

            public void setSold_out(int sold_out) {
                this.sold_out = sold_out;
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

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public List<?> getTemp_commission() {
                return temp_commission;
            }

            public void setTemp_commission(List<?> temp_commission) {
                this.temp_commission = temp_commission;
            }
        }
    }
}
