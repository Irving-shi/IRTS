package com.irving.ir.service;

import com.irving.ir.bean.User;
import com.irving.ir.model.UserModel;

/**
 * @author irving
 * @date 2021/6/19
 */
public interface UserService {
    String login(UserModel userModel);

    User register(User user);
}
