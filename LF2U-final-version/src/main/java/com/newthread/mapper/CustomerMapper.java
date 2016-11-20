package com.newthread.mapper;

import com.newthread.domain.Customer;
import java.util.List;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    Customer selectByPrimaryKey(String cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    List<Customer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Customer record);
}