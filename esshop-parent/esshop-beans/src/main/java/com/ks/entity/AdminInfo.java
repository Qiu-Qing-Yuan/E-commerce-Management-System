package com.ks.entity;

import java.io.Serializable;
import java.util.Date;

public class AdminInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_info.id
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_info.admin_name
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private String adminName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_info.admin_pwd
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private String adminPwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_info.status
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_info.create_time
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_info.update_time
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table admin_info
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_info.id
     *
     * @return the value of admin_info.id
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_info.id
     *
     * @param id the value for admin_info.id
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_info.admin_name
     *
     * @return the value of admin_info.admin_name
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_info.admin_name
     *
     * @param adminName the value for admin_info.admin_name
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_info.admin_pwd
     *
     * @return the value of admin_info.admin_pwd
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public String getAdminPwd() {
        return adminPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_info.admin_pwd
     *
     * @param adminPwd the value for admin_info.admin_pwd
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_info.status
     *
     * @return the value of admin_info.status
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_info.status
     *
     * @param status the value for admin_info.status
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_info.create_time
     *
     * @return the value of admin_info.create_time
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_info.create_time
     *
     * @param createTime the value for admin_info.create_time
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_info.update_time
     *
     * @return the value of admin_info.update_time
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_info.update_time
     *
     * @param updateTime the value for admin_info.update_time
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}