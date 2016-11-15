package com.newthread.framework.entity;

import java.util.Objects;


public class Report implements Comparable<Report> {
    private String frid;
    private String name;
    private String orders;

    public Report() {
    }

    public Report(String frid, String name, String orders) {
        this.frid = frid;
        this.name = name;
        this.orders = orders;
    }

    public String getFrid() {
        return frid;
    }

    public void setFrid(String frid) {
        this.frid = frid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;
        Report report = (Report) o;
        return Objects.equals(frid, report.frid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frid);
    }

    @Override
    public int compareTo(Report o) {

        int x = 0;

        try {
            x = Integer.parseInt(o.frid) - Integer.parseInt(frid);
        } catch (Exception e) {

        }

        return x;
    }
}
