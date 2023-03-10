package com.ks.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.entity.FunctionMenu;

public interface FunctionMenuMapper extends BaseMapper<FunctionMenu> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function_menu
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function_menu
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int insert(FunctionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function_menu
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int insertSelective(FunctionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function_menu
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    FunctionMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function_menu
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int updateByPrimaryKeySelective(FunctionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function_menu
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int updateByPrimaryKey(FunctionMenu record);
}
