package com.newthread.domain;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.fspid
     *
     * @mbggenerated
     */
    private String fspid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.note
     *
     * @mbggenerated
     */
    private String note;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.start_date
     *
     * @mbggenerated
     */
    private Integer startDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.end_date
     *
     * @mbggenerated
     */
    private Integer endDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.price
     *
     * @mbggenerated
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_unit
     *
     * @mbggenerated
     */
    private String productUnit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.image
     *
     * @mbggenerated
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.gcpid
     *
     * @mbggenerated
     */
    private String gcpid;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */
    public Product() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.fspid
     *
     * @return the value of product.fspid
     *
     * @mbggenerated
     */
    public String getFspid() {
        return fspid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.fspid
     *
     * @param fspid the value for product.fspid
     *
     * @mbggenerated
     */
    public void setFspid(String fspid) {
        this.fspid = fspid == null ? null : fspid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.name
     *
     * @return the value of product.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.name
     *
     * @param name the value for product.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.note
     *
     * @return the value of product.note
     *
     * @mbggenerated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.note
     *
     * @param note the value for product.note
     *
     * @mbggenerated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.start_date
     *
     * @return the value of product.start_date
     *
     * @mbggenerated
     */
    public Integer getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.start_date
     *
     * @param startDate the value for product.start_date
     *
     * @mbggenerated
     */
    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.end_date
     *
     * @return the value of product.end_date
     *
     * @mbggenerated
     */
    public Integer getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.end_date
     *
     * @param endDate the value for product.end_date
     *
     * @mbggenerated
     */
    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.price
     *
     * @return the value of product.price
     *
     * @mbggenerated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.price
     *
     * @param price the value for product.price
     *
     * @mbggenerated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_unit
     *
     * @return the value of product.product_unit
     *
     * @mbggenerated
     */
    public String getProductUnit() {
        return productUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_unit
     *
     * @param productUnit the value for product.product_unit
     *
     * @mbggenerated
     */
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.image
     *
     * @return the value of product.image
     *
     * @mbggenerated
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.image
     *
     * @param image the value for product.image
     *
     * @mbggenerated
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.gcpid
     *
     * @return the value of product.gcpid
     *
     * @mbggenerated
     */
    public String getGcpid() {
        return gcpid;
    }

    public Product(String fspid, String name, String note, Integer startDate, Integer endDate, Double price, String productUnit, String image, String gcpid) {
        this.fspid = fspid;
        this.name = name;
        this.note = note;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.productUnit = productUnit;
        this.image = image;
        this.gcpid = gcpid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.gcpid
     *
     * @param gcpid the value for product.gcpid
     *
     * @mbggenerated
     */

    public void setGcpid(String gcpid) {
        this.gcpid = gcpid == null ? null : gcpid.trim();
    }
}