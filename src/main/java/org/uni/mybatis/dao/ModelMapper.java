package org.uni.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import org.uni.mybatis.model.Model;
@Mapper
public interface ModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    int insert(Model record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    Model selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    List<Model> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    int updateByPrimaryKey(Model record);
}