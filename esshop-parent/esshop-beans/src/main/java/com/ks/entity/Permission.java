package com.ks.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.id
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.aid
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private Integer aid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.fid
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private Integer fid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table permission
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.aid
     *
     * @return the value of permission.aid
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public Integer getAid() {
        return aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.aid
     *
     * @param aid the value for permission.aid
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.fid
     *
     * @return the value of permission.fid
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.fid
     *
     * @param fid the value for permission.fid
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }
}
