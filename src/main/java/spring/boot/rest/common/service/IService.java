package spring.boot.rest.common.service;

import spring.boot.rest.common.model.DataResult;

import java.util.List;


public interface IService<T> {


    DataResult<String> ping();

    T selectByPrimaryKey(Object key);

    int insert(T entity);

    int insertSelective(T entity);

    /**
     * mysql专用
     *
     * @param entity
     * @return
     */
    int insertUseGeneratedKeys(T entity);

    int deleteByPrimaryKey(Object key);

    int updateByPrimaryKey(T entity);

    int updateByPrimaryKeySelective(T entity);

    List<T> selectByExample(Object example);
}
