package com.lamperouge.lamperouge.service.impl;

import com.lamperouge.lamperouge.repository.BaseMapper;
import com.lamperouge.lamperouge.service.BaseService;

/**
 * @author nmj
 * @create 2022-01-10 23:36
 */
//注意这个实现类也是一个抽象类，它在实现BaseService接口时就不会强制实现里面的方法，因为抽象类中允许有抽象方法的存在
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    //不写下面的构造器时，这个变量会报错没有被初始化
    private final BaseMapper<T> baseMapper;

    public BaseServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int deleteById(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertByFilter(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectById(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByIdFilter(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }
}
