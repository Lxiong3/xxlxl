package com.newthread.domain;

/**
 * Author:黄平财
 * Date:2016/11/19
 * Mail:11867939@qq.com
 */
public class DeliversTo {

    private String delivery_to_id;
    private String uid;
    private String zip;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeliversTo() {
    }


    public void setDelivery_to_id(String delivery_to_id) {
        this.delivery_to_id = delivery_to_id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
