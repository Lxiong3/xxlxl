package com.newthread.framework.model;

import java.util.List;


public class OrderModel {

    /**
     * fid : 123
     * order_detail : [{"fspid":"345","amount":1.5},{"fspid":"346","amount":8}]
     * delivery_note : Please leave with building attendant.
     */

    private String fid;
    private String delivery_note;
    private List<OrderDetailBean> order_detail;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getDelivery_note() {
        return delivery_note;
    }

    public void setDelivery_note(String delivery_note) {
        this.delivery_note = delivery_note;
    }

    public List<OrderDetailBean> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetailBean> order_detail) {
        this.order_detail = order_detail;
    }

    public static class OrderDetailBean {
        /**
         * fspid : 345
         * amount : 1.5
         */

        private String fspid;
        private double amount;

        public String getFspid() {
            return fspid;
        }

        public void setFspid(String fspid) {
            this.fspid = fspid;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
