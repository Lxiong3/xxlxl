package com.newthread.framework.entity;


public class Customer {

    /**
     * name : Virgil B
     * street : 10 West 31st Street, #214
     * zip : 60616
     * phone : 312-567-5146
     * email : virgilb@example.com
     */
    private String cid;
    private String name;
    private String street;
    private String zip;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String email, String name, String street, String zip, String phone) {
        this.email = email;
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.phone = phone;
    }

    public Customer(String cid, String name, String street, String zip, String phone, String email) {
        this.cid = cid;
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
