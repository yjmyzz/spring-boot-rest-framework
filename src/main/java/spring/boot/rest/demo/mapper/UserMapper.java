package spring.boot.rest.demo.mapper;


import spring.boot.rest.common.mapper.MyMapper;
import spring.boot.rest.demo.entity.User;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

    List<User> selectAll();
}