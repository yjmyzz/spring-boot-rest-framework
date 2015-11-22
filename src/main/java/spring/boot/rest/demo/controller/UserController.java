package spring.boot.rest.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.demo.domain.UserData;
import spring.boot.rest.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    private final static String USER = "user";

    @Autowired
    UserService userService;

    @RequestMapping(value = "ping")
    public DataResult<String> ping() {
        return userService.ping();
    }

    @RequestMapping(value = USER + "/{id}", method = RequestMethod.GET)
    public DataResult<UserData> get(@PathVariable int id) {
        return userService.get(id);
    }

    @RequestMapping(value = USER + "/all", method = RequestMethod.GET)
    public DataResult<List<UserData>> getAll() {
        return userService.getAllUser();
    }

    @RequestMapping(value = USER + "/add", method = RequestMethod.POST)
    public DataResult<UserData> add(@RequestBody UserData user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = USER + "/batchAdd", method = RequestMethod.POST)
    public DataResult<List<UserData>> batchAdd(@RequestBody List<UserData> users) {
        return userService.addUsers(users);
    }

    @RequestMapping(value = USER + "/update", method = RequestMethod.POST)
    public DataResult<UserData> update(@RequestBody UserData user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = USER + "/delete", method = RequestMethod.POST)
    public DataResult<Integer> delete(@RequestParam(value = "id", defaultValue = "0") int id) {
        return userService.deleteUser(id);
    }
}
