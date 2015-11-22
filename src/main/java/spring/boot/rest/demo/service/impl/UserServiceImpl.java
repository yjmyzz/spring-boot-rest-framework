package spring.boot.rest.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.rest.common.consts.RestConst;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.common.service.impl.BaseService;
import spring.boot.rest.demo.converter.ModelConverter;
import spring.boot.rest.demo.domain.UserData;
import spring.boot.rest.demo.entity.User;
import spring.boot.rest.demo.mapper.UserMapper;
import spring.boot.rest.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * {type your description }
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
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
        if (user == null) {
            return new DataResult<UserData>(RestConst.ErrorCode.EMPTY_PARAM, "param is empty");
        }
        User model = ModelConverter.toUser(user);
        int i = insertUseGeneratedKeys(model);
        if (i > 0) {
            return get(model.getId());
        }
        return new DataResult<UserData>(i + "", "add user fail");
    }

    @Override
    public DataResult<List<UserData>> addUsers(List<UserData> users) {
        if (users.isEmpty()) {
            return new DataResult<List<UserData>>(RestConst.ErrorCode.EMPTY_PARAM, "param is empty");
        }
        List<UserData> returnList = new ArrayList<UserData>(users.size());
        for (UserData data : users) {
            User model = ModelConverter.toUser(data);
            int i = insertUseGeneratedKeys(model);
            if (i > 0) {
                returnList.add(ModelConverter.toUserData(selectByPrimaryKey(model.getId())));
            }
        }
        return new DataResult<List<UserData>>(returnList);
    }

    @Override
    public DataResult<UserData> updateUser(UserData user) {
        if (user == null) {
            return new DataResult<UserData>(RestConst.ErrorCode.EMPTY_PARAM, "param is empty");
        }
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
