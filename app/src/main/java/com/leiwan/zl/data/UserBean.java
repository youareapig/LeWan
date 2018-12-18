package com.leiwan.zl.data;

/**
 * Created by Administrator on 2018/12/18.
 */

public class UserBean {

    /**
     * code : 200
     * message : 获取成功
     * data : {"token":"3d98fbcb97684f238e3e09bbdc694605","recode":"VB7DBH","nickname":"少林功夫好、","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/wgXT18IR9icbX4ZhAHhjaRUoqdon4MgS5WVqDsAh3OQmZ6icnlceIvCvpWQynZvflYI0Cwn0QdDibYMGF9626zofw/132","level":2,"auth":1,"freesheet":1,"username":"超级会员"}
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
         * token : 3d98fbcb97684f238e3e09bbdc694605
         * recode : VB7DBH
         * nickname : 少林功夫好、
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/wgXT18IR9icbX4ZhAHhjaRUoqdon4MgS5WVqDsAh3OQmZ6icnlceIvCvpWQynZvflYI0Cwn0QdDibYMGF9626zofw/132
         * level : 2
         * auth : 1
         * freesheet : 1
         * username : 超级会员
         */

        private String token;
        private String recode;
        private String nickname;
        private String avatar;
        private int level;
        private int auth;
        private int freesheet;
        private String username;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRecode() {
            return recode;
        }

        public void setRecode(String recode) {
            this.recode = recode;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getAuth() {
            return auth;
        }

        public void setAuth(int auth) {
            this.auth = auth;
        }

        public int getFreesheet() {
            return freesheet;
        }

        public void setFreesheet(int freesheet) {
            this.freesheet = freesheet;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
