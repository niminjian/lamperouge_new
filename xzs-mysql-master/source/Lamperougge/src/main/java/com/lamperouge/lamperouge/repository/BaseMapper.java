package com.lamperouge.lamperouge.repository;

/**
 * @author nmj
 * @create 2022-01-10 23:51
 */
//泛型接口，通过类去实现这个泛型接口的时候指定泛型T的具体类型。
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
