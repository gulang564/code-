package com.test.domain;

import java.io.Serializable;

public class Goods implements Serializable {
 private int id;
 private double price;
 private String title;
 private String detail;
 private String image;
 private int typeid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", image='" + image + '\'' +
                ", typeid=" + typeid +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }
}
