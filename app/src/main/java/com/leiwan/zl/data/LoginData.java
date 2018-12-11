package com.leiwan.zl.data;

/**
 * Created by Administrator on 2018/12/11.
 */

public class LoginData {

    /**
     * code : 200
     * message : 登录成功
     * data : {"token":"199af8536df550d946aa448af6feca6f","nickname":"Albatross","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKWb6FvQhficETJFU8tiaJ3msEvQRhUlXVicMuQKQ4AoIeicHVGW4diaOpXHf94TOMQwlRGagunEUJofSA/132","level":2}
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
         * token : 199af8536df550d946aa448af6feca6f
         * nickname : Albatross
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKWb6FvQhficETJFU8tiaJ3msEvQRhUlXVicMuQKQ4AoIeicHVGW4diaOpXHf94TOMQwlRGagunEUJofSA/132
         * level : 2
         */

        private String token;
        private String nickname;
        private String avatar;
        private int level;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
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
    }
}
