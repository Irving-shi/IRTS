package com.irving.ir.service.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import com.irving.ir.bean.User;
import com.irving.ir.common.util.JwtUtils;
import com.irving.ir.mapper.UserMapper;
import com.irving.ir.model.UserModel;
import com.irving.ir.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * @author irving
 * @date 2021/6/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserMapper userMapper;

    @Value("${pwd.secret}")
    private String secretKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public String login(UserModel userModel) {

        String pwd = userModel.getPassword();

          User user =userMapper.login(userModel.getUsername());

          if (encrypt(pwd).equals(user.getPassword())){
              return jwtUtils.generateToken(user.getId());
          }
       return null;
    }

    @Override
    public User register(User user) {
        String encodePassword = encrypt(user.getPassword());
        user.setPassword(encodePassword);
        int result =userMapper.register(user);
        if(result ==1){
            return user;
        }
        return null;
    }

    private  String encrypt(String info) {
        byte[] key = new byte[0];
        try {
            key = new BASE64Decoder().decodeBuffer(secretKey);
        } catch (IOException e) {
          LOGGER.error("secretKey解码失败");
        }
        DES des = SecureUtil.des(key);
        String encrypt = des.encryptHex(info);
        return encrypt;
    }


}
