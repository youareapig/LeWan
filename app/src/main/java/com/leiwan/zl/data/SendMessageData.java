package com.leiwan.zl.data;

import java.util.List;

/**
 * Created by Administrator on 2018/12/17.
 */

public class SendMessageData {

    /**
     * code : 200
     * message : 短信已发送
     * data : []
     */

    private int code;
    private String message;
    private List<?> data;

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

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
