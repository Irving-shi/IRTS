package com.irving.ir.service.impl;

import com.irving.ir.bean.Corpus;
import com.irving.ir.common.util.JwtUtils;
import com.irving.ir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author irving
 * @date 2021/6/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public String login(Corpus corpus) {
        return jwtUtils.generateToken(corpus.getId());
    }
}
