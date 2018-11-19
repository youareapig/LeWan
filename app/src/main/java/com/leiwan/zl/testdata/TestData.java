package com.leiwan.zl.testdata;

/**
 * Created by Administrator on 2018/11/15.
 */

public class TestData {
    private String imgUrl;
    private String title;
    private String price;
    private String num;

    public TestData(String imgUrl, String title, String price, String num) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.price = price;
        this.num = num;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
