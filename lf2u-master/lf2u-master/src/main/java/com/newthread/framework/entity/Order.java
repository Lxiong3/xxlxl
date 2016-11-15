package com.newthread.framework.entity;

import java.util.List;


public class Order {

    private String oid;
    private double products_total;
    private double delivery_charge;
    private double order_total;
    private String status;
    private String order_date;
    private String planned_delivery_date;
    private String actual_delivery_date;
    private OrderedByBean ordered_by;
    private String delivery_address;
    private String note;
    private List<OrderDetailBean> order_detail;
    private String fid;

    public Order(String oid, double products_total, double delivery_charge,
                 double order_total, String status, String order_date, String planned_delivery_date,
                 String actual_delivery_date, OrderedByBean ordered_by, String delivery_address,
                 String note, List<OrderDetailBean> order_detail) {
        this.oid = oid;
        this.products_total = products_total;
        this.delivery_charge = delivery_charge;
        this.order_total = order_total;
        this.status = status;
        this.order_date = order_date;
        this.planned_delivery_date = planned_delivery_date;
        this.actual_delivery_date = actual_delivery_date;
        this.ordered_by = ordered_by;
        this.delivery_address = delivery_address;
        this.note = note;
        this.order_detail = order_detail;
    }

    public Order() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public double getProducts_total() {
        return products_total;
    }

    public void setProducts_total(double products_total) {
        this.products_total = products_total;
    }

    public double getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(double delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getFid() {
        return fid;
    }

    public double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getPlanned_delivery_date() {
        return planned_delivery_date;
    }

    public void setPlanned_delivery_date(String planned_delivery_date) {
        this.planned_delivery_date = planned_delivery_date;
    }

    public String getActual_delivery_date() {
        return actual_delivery_date;
    }

    public void setActual_delivery_date(String actual_delivery_date) {
        this.actual_delivery_date = actual_delivery_date;
    }

    public OrderedByBean getOrdered_by() {
        return ordered_by;
    }

    public void setOrdered_by(OrderedByBean ordered_by) {
        this.ordered_by = ordered_by;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<OrderDetailBean> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetailBean> order_detail) {
        this.order_detail = order_detail;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public static class OrderedByBean {

        private String name;
        private String email;
        private String phone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class OrderDetailBean {

        private int fspid;
        private String name;
        private String order_size;
        private String price;
        private double line_item_total;

        public OrderDetailBean() {
        }

        public OrderDetailBean(int fspid, String name, String order_size, String price, double line_item_total) {
            this.fspid = fspid;
            this.name = name;
            this.order_size = order_size;
            this.price = price;
            this.line_item_total = line_item_total;
        }

        public int getFspid() {
            return fspid;
        }

        public void setFspid(int fspid) {
            this.fspid = fspid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrder_size() {
            return order_size;
        }

        public void setOrder_size(String order_size) {
            this.order_size = order_size;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public double getLine_item_total() {
            return line_item_total;
        }

        public void setLine_item_total(double line_item_total) {
            this.line_item_total = line_item_total;
        }
    }
}
