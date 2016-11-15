package com.newthread.framework.entity;

import java.util.Objects;


public class Products {
    /**
     * fspid : 345
     * name : Potatoes
     * note : These Russets are ideal for light and fluffy mashed potatoes.
     * start_date : 10-01
     * end_date :
     * price : 0.29
     * product_unit : lb
     * image :
     */
    private String gcpid;
    private String fspid;
    private String name;
    private String note;
    private String start_date;
    private String end_date;
    private double price;
    private String product_unit;
    private String image;

    public Products() {
    }

    public Products(String fspid, String name, String note, String start_date, String end_date, double price, String product_unit, String image) {
        this.fspid = fspid;
        this.name = name;
        this.note = note;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
        this.product_unit = product_unit;
        this.image = image;
    }

    public String getGcpid() {
        return gcpid;
    }

    public void setGcpid(String gcpid) {
        this.gcpid = gcpid;
    }

    public String getFspid() {
        return fspid;
    }

    public void setFspid(String fspid) {
        this.fspid = fspid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(String product_unit) {
        this.product_unit = product_unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        Products products = (Products) o;
        return Objects.equals(fspid, products.fspid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fspid);
    }

    @Override
    public String toString() {
        return "Products{" +
                "gcpid='" + gcpid + '\'' +
                ", fspid='" + fspid + '\'' +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", price=" + price +
                ", product_unit='" + product_unit + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
