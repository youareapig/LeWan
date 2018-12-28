package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/28.
 */

public class CalenderData {

    /**
     * code : 200
     * message : 查询成功
     * data : [{"reservationday_id":1107,"calendar":1546012800,"week":"周六","preday":2,"totalnum":"4000","usenum":"0","day":"12月29日","status":1,"lastnumber":4000},{"reservationday_id":1108,"calendar":1546099200,"week":"周日","preday":2,"totalnum":"4000","usenum":"0","day":"12月30日","status":1,"lastnumber":4000},{"reservationday_id":1109,"calendar":1546185600,"week":"周一","preday":2,"totalnum":"4000","usenum":"0","day":"12月31日","status":1,"lastnumber":4000}]
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
         * reservationday_id : 1107
         * calendar : 1546012800
         * week : 周六
         * preday : 2
         * totalnum : 4000
         * usenum : 0
         * day : 12月29日
         * status : 1
         * lastnumber : 4000
         */

        private int reservationday_id;
        private int calendar;
        private String week;
        private int preday;
        private String totalnum;
        private String usenum;
        private String day;
        private int status;
        private int lastnumber;

        public int getReservationday_id() {
            return reservationday_id;
        }

        public void setReservationday_id(int reservationday_id) {
            this.reservationday_id = reservationday_id;
        }

        public int getCalendar() {
            return calendar;
        }

        public void setCalendar(int calendar) {
            this.calendar = calendar;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public int getPreday() {
            return preday;
        }

        public void setPreday(int preday) {
            this.preday = preday;
        }

        public String getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(String totalnum) {
            this.totalnum = totalnum;
        }

        public String getUsenum() {
            return usenum;
        }

        public void setUsenum(String usenum) {
            this.usenum = usenum;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getLastnumber() {
            return lastnumber;
        }

        public void setLastnumber(int lastnumber) {
            this.lastnumber = lastnumber;
        }
    }
}
