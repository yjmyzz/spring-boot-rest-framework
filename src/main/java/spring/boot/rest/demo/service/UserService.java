package spring.boot.rest.demo.service;

import org.springframework.stereotype.Service;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.common.service.IService;
import spring.boot.rest.demo.domain.UserData;
import spring.boot.rest.demo.entity.User;

import java.util.List;

@Service
public interface UserService extends IService<User> {

    DataResult<List<UserData>> getAllUser();

    DataResult<UserData> get(int userId);

    DataResult<UserData> addUser(UserData user);

    DataResult<List<UserData>> addUsers(List<UserData> users);

    DataResult<UserData> updateUser(UserData user);

    DataResult<Integer> deleteUser(int userId);

}
