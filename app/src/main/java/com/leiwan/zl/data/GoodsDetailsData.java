package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/5.
 */

public class GoodsDetailsData {



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


        private DetailsBean details;
        private List<PriceBean> price;
        private List<HotpushBean> hotpush;

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public List<PriceBean> getPrice() {
            return price;
        }

        public void setPrice(List<PriceBean> price) {
            this.price = price;
        }

        public List<HotpushBean> getHotpush() {
            return hotpush;
        }

        public void setHotpush(List<HotpushBean> hotpush) {
            this.hotpush = hotpush;
        }

        public static class DetailsBean {


            private int product_id;
            private String product_name;
            private String product_pic;
            private String product_poster;
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
            private List<ProductTagsBean> product_tags;

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

            public List<ProductTagsBean> getProduct_tags() {
                return product_tags;
            }

            public void setProduct_tags(List<ProductTagsBean> product_tags) {
                this.product_tags = product_tags;
            }

            public static class ProductTagsBean {
                /**
                 * tag_name : 美食
                 */

                private String tag_name;

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }
            }
        }

        public static class PriceBean {
            /**
             * price_id : 6
             * product_property : 下午茶
             * price_market : 192.00
             * price_sale : 19.90
             * price_commission : {"zigou":"15.00","fenxiang":"0"}
             * product_totalnum : 721
             * product_buynum : 721
             * product_dynamicnum : null
             */

            private int price_id;
            private String product_property;
            private String price_market;
            private String price_sale;
            private PriceCommissionBean price_commission;
            private int product_totalnum;
            private int product_buynum;
            private Object product_dynamicnum;

            public int getPrice_id() {
                return price_id;
            }

            public void setPrice_id(int price_id) {
                this.price_id = price_id;
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

            public PriceCommissionBean getPrice_commission() {
                return price_commission;
            }

            public void setPrice_commission(PriceCommissionBean price_commission) {
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

            public static class PriceCommissionBean {
                /**
                 * zigou : 15.00
                 * fenxiang : 0
                 */

                private String zigou;
                private String fenxiang;

                public String getZigou() {
                    return zigou;
                }

                public void setZigou(String zigou) {
                    this.zigou = zigou;
                }

                public String getFenxiang() {
                    return fenxiang;
                }

                public void setFenxiang(String fenxiang) {
                    this.fenxiang = fenxiang;
                }
            }
        }

        public static class HotpushBean {
            /**
             * product_id : 1
             * product_pic : http://oss.lewan6.ren/uploads/20181126/ae7dc26e47f3ac3e48423b93d6c77f2c.jpg
             * product_name : 268元抢价值4878元汽车镀晶养护套餐，12养护项目，网上预订上门服务，给您的爱车保姆式服务
             * temp_price : 5.10
             * temp_commission : {"zigou":"5.00","fenxiang":"0"}
             * sold_out : 0
             * merchant_name : 爱车巴
             * region : 成都市
             * distance : 4
             */

            private int product_id;
            private String product_pic;
            private String product_name;
            private String temp_price;
            private TempCommissionBean temp_commission;
            private int sold_out;
            private String merchant_name;
            private String region;
            private int distance;

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

            public TempCommissionBean getTemp_commission() {
                return temp_commission;
            }

            public void setTemp_commission(TempCommissionBean temp_commission) {
                this.temp_commission = temp_commission;
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

            public static class TempCommissionBean {
                /**
                 * zigou : 5.00
                 * fenxiang : 0
                 */

                private String zigou;
                private String fenxiang;

                public String getZigou() {
                    return zigou;
                }

                public void setZigou(String zigou) {
                    this.zigou = zigou;
                }

                public String getFenxiang() {
                    return fenxiang;
                }

                public void setFenxiang(String fenxiang) {
                    this.fenxiang = fenxiang;
                }
            }
        }
    }
}
