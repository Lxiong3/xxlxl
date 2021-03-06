package com.newthread.mapper;

import com.newthread.domain.Catalog;

import java.util.List;

public interface CatalogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String gcpid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated
     */
    int insert(Catalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated
     */
    Catalog selectByPrimaryKey(String gcpid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated
     */
    List<Catalog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Catalog record);
}