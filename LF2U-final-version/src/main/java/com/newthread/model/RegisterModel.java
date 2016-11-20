package com.newthread.model;


public class RegisterModel {

    /**
     * name : Virgil B
     * street : 1405 W Palatine Rd, Hoffman Estates
     * zip : 60192
     * phone : 847-963-8845
     * email : virgilb@example.com
     */

    private String name;
    private String street;
    private String zip;
    private String phone;
    private String email;

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

    @Override
    public String toString() {
        return "RegisterModel{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
