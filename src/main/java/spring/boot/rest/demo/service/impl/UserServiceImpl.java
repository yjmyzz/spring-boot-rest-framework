package spring.boot.rest.demo.service.impl;

import org.springframework.stereotype.Service;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.common.service.impl.BaseService;
import spring.boot.rest.demo.converter.ModelConverter;
import spring.boot.rest.demo.domain.UserData;
import spring.boot.rest.demo.mapper.UserMapper;
import spring.boot.rest.demo.entity.User;
import spring.boot.rest.demo.service.UserService;

import java.util.List;

/**
 * {type your description }
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {


    @Override
    public DataResult<List<UserData>> getAllUser() {
        return new DataResult<List<UserData>>(ModelConverter.toUserDataList(((UserMapper) mapper).selectAll()));
    }

    @Override
    public DataResult<UserData> get(int userId) {
        return new DataResult<UserData>(ModelConverter.toUserData(selectByPrimaryKey(userId)));
    }

    @Override
    public DataResult<UserData> addUser(UserData user) {
        User model = ModelConverter.toUser(user);
        int i = insertUseGeneratedKeys(model);
        if (i > 0) {
            return get(model.getId());
        }
        return new DataResult<UserData>(i + "", "add user fail");
    }

    @Override
    public DataResult<UserData> updateUser(UserData user) {
        User model = ModelConverter.toUser(user);
        int i = updateByPrimaryKeySelective(model);
        if (i > 0) {
            return get(model.getId());
        }
        return new DataResult<UserData>(i + "", "update user fail");
    }

    @Override
    public DataResult<Integer> deleteUser(int userId) {
        int i = deleteByPrimaryKey(userId);
        if (i > 0) {
            return new DataResult<Integer>(i);
        }
        return new DataResult<Integer>(i + "", "delete user fail");
    }
}
