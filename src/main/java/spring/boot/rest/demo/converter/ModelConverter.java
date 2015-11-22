package spring.boot.rest.demo.converter;

import org.springframework.beans.BeanUtils;
import spring.boot.rest.demo.domain.UserData;
import spring.boot.rest.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 将db层面的model与领域模型domain相互转换
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
public class ModelConverter {


    public static User toUser(UserData data) {
        if (data == null) {
            return null;
        }
        User model = new User();
        BeanUtils.copyProperties(data, model);
        return model;
    }

    public static UserData toUserData(User model) {
        if (model == null) {
            return null;
        }
        UserData data = new UserData();
        BeanUtils.copyProperties(model, data);
        return data;
    }

    public static List<UserData> toUserDataList(List<User> list) {
        if (list.isEmpty()) {
            return new ArrayList<UserData>(0);
        }
        List<UserData> dataList = new ArrayList<UserData>(list.size());
        for (User model : list) {
            dataList.add(toUserData(model));
        }
        return dataList;
    }
}
