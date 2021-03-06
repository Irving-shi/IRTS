package com.irving.ir.controller.pub;

import com.irving.ir.bean.Corpus;
import com.irving.ir.bean.User;
import com.irving.ir.common.api.CommonResult;
import com.irving.ir.common.util.JwtUtils;
import com.irving.ir.model.UserModel;
import com.irving.ir.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author irving
 * @date 2021/6/19
 */

@Controller
@Api(tags = "UserController", description = "后台用户管理")
@RequestMapping("/admin")
public class UserController {

  @Autowired
  private UserService userService;



    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UserModel userModel){
        String token=userService.login(userModel);
        if (null==token){
            return CommonResult.failed("登录失败");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        return CommonResult.success(tokenMap,"获取token成功");
    }

    @ApiOperation(value = "注册用户")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<User>  register(@RequestBody User user){
       User registerUser=  userService.register(user);
        if(null==registerUser){
            return  CommonResult.failed("注册失败");
        }
        return CommonResult.success(registerUser,"注册成功");

    }

}
