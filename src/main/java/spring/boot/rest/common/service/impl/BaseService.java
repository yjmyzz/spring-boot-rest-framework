
package spring.boot.rest.common.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import spring.boot.rest.common.mapper.MyMapper;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.common.service.IService;

import java.util.List;


public abstract class BaseService<T> implements IService<T> {

    @Override
    public DataResult<String> ping() {
        return new DataResult<String>("running");
    }

    @Autowired
    protected MyMapper<T> mapper;


    public int insertUseGeneratedKeys(T entity) {
        return mapper.insertUseGeneratedKeys(entity);
    }


    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int insert(T entity) {
        return mapper.insert(entity);
    }

    public int insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKey(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateByPrimaryKeySelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

}
