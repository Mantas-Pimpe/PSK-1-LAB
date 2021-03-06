package org.uni.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import org.uni.mybatis.model.Dealership;

@Mapper
public interface DealershipMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEALERSHIP
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEALERSHIP
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    int insert(Dealership record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEALERSHIP
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    Dealership selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEALERSHIP
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    List<Dealership> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEALERSHIP
     *
     * @mbg.generated Mon Apr 05 18:35:58 EEST 2021
     */
    int updateByPrimaryKey(Dealership record);
}