package com.newthread.domain;

public class Orders {
    private String oid;
    private String status;
    private String frid ;
    private Integer productsTotal;
    private Double deliveryCharge;
    private Double orderTotal;
    private Integer plannedDeliveryDate;
    private Integer actualDeliveryDate;
    private Integer orderDate;
    private String orderedBy;
    private String deliveryAddress;
    private String orderDetail;
    private String note;
    public Orders() {
    }

    public Orders(String oid, String status, String frid, Integer productsTotal, Double deliveryCharge, Double orderTotal, Integer plannedDeliveryDate, Integer actualDeliveryDate, Integer orderDate, String orderedBy, String deliveryAddress, String orderDetail, String note) {
        this.oid = oid;
        this.status = status;
        this.frid = frid;
        this.productsTotal = productsTotal;
        this.deliveryCharge = deliveryCharge;
        this.orderTotal = orderTotal;
        this.plannedDeliveryDate = plannedDeliveryDate;
        this.actualDeliveryDate = actualDeliveryDate;
        this.orderDate = orderDate;
        this.orderedBy = orderedBy;
        this.deliveryAddress = deliveryAddress;
        this.orderDetail = orderDetail;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", status='" + status + '\'' +
                ", frid='" + frid + '\'' +
                ", productsTotal=" + productsTotal +
                ", deliveryCharge=" + deliveryCharge +
                ", orderTotal=" + orderTotal +
                ", plannedDeliveryDate=" + plannedDeliveryDate +
                ", actualDeliveryDate=" + actualDeliveryDate +
                ", orderDate=" + orderDate +
                ", orderedBy='" + orderedBy + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderDetail='" + orderDetail + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setFrid(String frid) {
        this.frid = frid;
    }


    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getPlannedDeliveryDate() {
        return plannedDeliveryDate;
    }

    public void setPlannedDeliveryDate(Integer plannedDeliveryDate) {
        this.plannedDeliveryDate = plannedDeliveryDate;
    }

    public Integer getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public void setActualDeliveryDate(Integer actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public Integer getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Integer orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy;
    }


    public void setNote(String note) {
        this.note = note;
    }
}