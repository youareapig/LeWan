package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/24.
 */

public class YuYueData {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"product_id":54,"product_name":"【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用"},{"product_id":53,"product_name":"重大通知：300抢购1000元美年大健康体检套餐，周末节假日、11个分店通用，为您的健康保驾护航。"},{"product_id":51,"product_name":"仪式感爆炸！八大主题馆任你选~19.9抢购原价1088元辣妈萌娃私人定制，更有到店好礼等你！"},{"product_id":56,"product_name":"仪式感爆炸！八大主题馆任你选~19.9抢购原价1088元辣妈萌娃私人定制，更有到店好礼等你！"},{"product_id":48,"product_name":"【高新区时尚汗蒸】19.9抢原价561扬子光波房汗蒸套餐（含扬子养生光波房+扬子养生光波桶+扬子养生仪各三次）周末节假日通用不加收"},{"product_id":23,"product_name":"【玉林/驷马桥】19.9抢购原价656一大一小洁牙套餐，超声波保健洁牙+全口硒粒子抛光+儿童全口涂氟（一小）......周末节假日通用，有效期至6月底"},{"product_id":37,"product_name":"【金沙/龙泉】59.9抢原价894元SPA/美甲套餐(SPA开背+精品美甲+面部深层补水)，周末/节假日通用"},{"product_id":38,"product_name":"【高新区时尚汗蒸】19.9抢原价561扬子光波房汗蒸套餐（含扬子养生光波房+扬子养生光波桶+扬子养生仪各三次）周末节假日通用不加收"},{"product_id":62,"product_name":"【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用"},{"product_id":5,"product_name":"限量加推！288元=2大2小高级房/双床房（含无限次泡温泉、自助早餐、菜品代金券等），周末节假日可用，有效期至2019年6月"}]
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
         * product_id : 54
         * product_name : 【六店】9.9元抢899元畅享汽车服务，洗车+内室除味+安全检测+各代金券+添加雨刮精等，5个月超长使用期，周末节假日通用
         */

        private int product_id;
        private String product_name;

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
    }
}
