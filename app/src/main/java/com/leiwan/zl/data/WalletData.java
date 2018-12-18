package com.leiwan.zl.data;

/**
 * Created by Administrator on 2018/12/18.
 */

public class WalletData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"reward":{"putforward":0,"pending":0,"grandtotal":0,"sumup":0},"income":{"today":"0.00","yesterday":"0.00","thismonth":"0.00","lastmonth":"0.00"}}
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
         * reward : {"putforward":0,"pending":0,"grandtotal":0,"sumup":0}
         * income : {"today":"0.00","yesterday":"0.00","thismonth":"0.00","lastmonth":"0.00"}
         */

        private RewardBean reward;
        private IncomeBean income;

        public RewardBean getReward() {
            return reward;
        }

        public void setReward(RewardBean reward) {
            this.reward = reward;
        }

        public IncomeBean getIncome() {
            return income;
        }

        public void setIncome(IncomeBean income) {
            this.income = income;
        }

        public static class RewardBean {
            /**
             * putforward : 0
             * pending : 0
             * grandtotal : 0
             * sumup : 0
             */

            private int putforward;
            private int pending;
            private int grandtotal;
            private int sumup;

            public int getPutforward() {
                return putforward;
            }

            public void setPutforward(int putforward) {
                this.putforward = putforward;
            }

            public int getPending() {
                return pending;
            }

            public void setPending(int pending) {
                this.pending = pending;
            }

            public int getGrandtotal() {
                return grandtotal;
            }

            public void setGrandtotal(int grandtotal) {
                this.grandtotal = grandtotal;
            }

            public int getSumup() {
                return sumup;
            }

            public void setSumup(int sumup) {
                this.sumup = sumup;
            }
        }

        public static class IncomeBean {
            /**
             * today : 0.00
             * yesterday : 0.00
             * thismonth : 0.00
             * lastmonth : 0.00
             */

            private String today;
            private String yesterday;
            private String thismonth;
            private String lastmonth;

            public String getToday() {
                return today;
            }

            public void setToday(String today) {
                this.today = today;
            }

            public String getYesterday() {
                return yesterday;
            }

            public void setYesterday(String yesterday) {
                this.yesterday = yesterday;
            }

            public String getThismonth() {
                return thismonth;
            }

            public void setThismonth(String thismonth) {
                this.thismonth = thismonth;
            }

            public String getLastmonth() {
                return lastmonth;
            }

            public void setLastmonth(String lastmonth) {
                this.lastmonth = lastmonth;
            }
        }
    }
}
