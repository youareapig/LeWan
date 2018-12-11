package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/10.
 */

public class FriendData {

    /**
     * code : 200
     * message : 获取成功
     * data : {"count":18,"list":[{"user_id":63,"nickname":"Louie","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/4zkNmXDZibfrCmUnjXhSUZicrRYtcvR5ibeHKByAMlNbyGYtznU2lzNqS6F19XIu5OiaPYt93jhFnjibK1AK90E7Mzw/132","level":"超级会员","order_count":0},{"user_id":81,"nickname":"说起来，不好说","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/ouxRref3HVVEjQbCiahNz1ohqbxRuef8ibyr9UFRczkuQVBXEnUjWQTEGWWSZzckpejgjCiawxSN6fEo50WNfNVfA/132","level":"超级会员","order_count":0},{"user_id":99,"nickname":"寒","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/QTUZOiaZlbLNsvicCNXXNRuYSabreFoxGPoGxNZLzjOQVvMAM1jw2XpCxng1CySP53rictZGys31bcd6BibH56JlicQ/132","level":"超级会员","order_count":0},{"user_id":104,"nickname":"念去去","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/X9vHGxGbHWlyvib1aVkQ2Cmkylw6gZUWibOm1MgrZ3hBe6JtC0iaCSO5t839nzX6veFJvX0bWjgGROiaKjqGZk0Uibw/132","level":"超级会员","order_count":0},{"user_id":105,"nickname":"我竟无言以对！","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/5ibXJdICbNdTBQczb2xTiap0yRhbIS4ebUoHxcbg0vh61zLfYhhRUudrFsXWyWGS6bKXPvGPcXuKPlqeqMV3l9QQ/132","level":"超级会员","order_count":0},{"user_id":119,"nickname":"U","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELASGVJud32l2RXoPCPYdjesL6OfjUF2do2VE8ia1SjBJnO8uW6icwHnsiaFJYGaf7eWuVibF7CkxE0Xg/132","level":"超级会员","order_count":0},{"user_id":122,"nickname":"方天","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/nfhQ5ibcibez5DbXhiaK50Pv3ReahicwNE0dibARW962ib3XicIcR9iaoevb85txBklQPHQ1BNwE23SN5G2OEMayRqcQ5A/132","level":"超级会员","order_count":0},{"user_id":225,"nickname":"扎心不，老铁","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/ArOtUJfIKf6AC8mlboiaiapXqXLweZUZVqZmZvkXqK9GkUZrMgabJcyNiaLKJAZwFCbNgaf9WoGp0m0WOZibThhs3g/132","level":"超级会员","order_count":0},{"user_id":281,"nickname":"右","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/iabjTH4RdkJSB2mTht6eCrkzG3NmM3sOaia4Rs6iaibJ1VvOYXEANO4JnCiasOpYh1iapCl9YwY8sXKRiaZqdk0Qpbm0w/132","level":"超级会员","order_count":0},{"user_id":671,"nickname":"钟欣","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/InKXymxdA8jnSXVYXk38daYrhYkxIO3ibiad7AiboG6giceBbTaYwY8eNibYGQh2fKQmUMFkeCR4MuWMngGbWMMaIEg/132","level":"超级会员","order_count":0}]}
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
         * count : 18
         * list : [{"user_id":63,"nickname":"Louie","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/4zkNmXDZibfrCmUnjXhSUZicrRYtcvR5ibeHKByAMlNbyGYtznU2lzNqS6F19XIu5OiaPYt93jhFnjibK1AK90E7Mzw/132","level":"超级会员","order_count":0},{"user_id":81,"nickname":"说起来，不好说","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/ouxRref3HVVEjQbCiahNz1ohqbxRuef8ibyr9UFRczkuQVBXEnUjWQTEGWWSZzckpejgjCiawxSN6fEo50WNfNVfA/132","level":"超级会员","order_count":0},{"user_id":99,"nickname":"寒","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/QTUZOiaZlbLNsvicCNXXNRuYSabreFoxGPoGxNZLzjOQVvMAM1jw2XpCxng1CySP53rictZGys31bcd6BibH56JlicQ/132","level":"超级会员","order_count":0},{"user_id":104,"nickname":"念去去","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/X9vHGxGbHWlyvib1aVkQ2Cmkylw6gZUWibOm1MgrZ3hBe6JtC0iaCSO5t839nzX6veFJvX0bWjgGROiaKjqGZk0Uibw/132","level":"超级会员","order_count":0},{"user_id":105,"nickname":"我竟无言以对！","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/5ibXJdICbNdTBQczb2xTiap0yRhbIS4ebUoHxcbg0vh61zLfYhhRUudrFsXWyWGS6bKXPvGPcXuKPlqeqMV3l9QQ/132","level":"超级会员","order_count":0},{"user_id":119,"nickname":"U","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELASGVJud32l2RXoPCPYdjesL6OfjUF2do2VE8ia1SjBJnO8uW6icwHnsiaFJYGaf7eWuVibF7CkxE0Xg/132","level":"超级会员","order_count":0},{"user_id":122,"nickname":"方天","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/nfhQ5ibcibez5DbXhiaK50Pv3ReahicwNE0dibARW962ib3XicIcR9iaoevb85txBklQPHQ1BNwE23SN5G2OEMayRqcQ5A/132","level":"超级会员","order_count":0},{"user_id":225,"nickname":"扎心不，老铁","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/ArOtUJfIKf6AC8mlboiaiapXqXLweZUZVqZmZvkXqK9GkUZrMgabJcyNiaLKJAZwFCbNgaf9WoGp0m0WOZibThhs3g/132","level":"超级会员","order_count":0},{"user_id":281,"nickname":"右","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/iabjTH4RdkJSB2mTht6eCrkzG3NmM3sOaia4Rs6iaibJ1VvOYXEANO4JnCiasOpYh1iapCl9YwY8sXKRiaZqdk0Qpbm0w/132","level":"超级会员","order_count":0},{"user_id":671,"nickname":"钟欣","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/InKXymxdA8jnSXVYXk38daYrhYkxIO3ibiad7AiboG6giceBbTaYwY8eNibYGQh2fKQmUMFkeCR4MuWMngGbWMMaIEg/132","level":"超级会员","order_count":0}]
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * user_id : 63
             * nickname : Louie
             * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/4zkNmXDZibfrCmUnjXhSUZicrRYtcvR5ibeHKByAMlNbyGYtznU2lzNqS6F19XIu5OiaPYt93jhFnjibK1AK90E7Mzw/132
             * level : 超级会员
             * order_count : 0
             */

            private int user_id;
            private String nickname;
            private String avatar;
            private String level;
            private int order_count;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
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

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public int getOrder_count() {
                return order_count;
            }

            public void setOrder_count(int order_count) {
                this.order_count = order_count;
            }
        }
    }
}
