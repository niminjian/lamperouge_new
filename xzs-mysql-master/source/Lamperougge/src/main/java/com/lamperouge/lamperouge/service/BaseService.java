package com.lamperouge.lamperouge.service;

/**
 * @author nmj
 * @create 2022-01-10 23:40
 */

/**
 * service接口，和mybatis generator配套使用
 *
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 根据Id删除数据，硬删除(直接将该记录从数据库中抹去)
     *
     * @param id id
     * @return int
     */
    int deleteById(Integer id);

    /**
     * 插入数据，完整数据插入
     *
     * @param record record
     * @return int
     */
    int insert(T record);

    /**
     * 插入不为null的数据
     *
     * @param record record
     * @return int
     */
    int insertByFilter(T record);

    /**
     * 根据Id查询数据
     *
     * @param id
     * @return
     */
    T selectById(Integer id);

    /**
     * 更新不为null的数据
     *
     * @param record record
     * @return int
     */
    int updateByIdFilter(T record);

    /**
     * 更新完整数据
     *
     * @param record record
     * @return int
     */
    int updateById(T record);
}
