package com.irving.ir.componet;

import com.alibaba.fastjson.JSON;
import com.irving.ir.common.annotation.Login;
import com.irving.ir.common.api.ResultCode;
import com.irving.ir.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义token处理逻辑
 * @author irving
 * @date 2021/6/19
 */

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {


   private JwtUtils jwtUtils;


    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationInterceptor.class);


    public static final String USER_KEY = "userId";

    public AuthorizationInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;

        if (handler instanceof HandlerMethod){

            annotation=((HandlerMethod)handler).getMethodAnnotation(Login.class);
        }else {
            return  true;
        }

        if (annotation==null){
            return true;
        }
        //获取用户凭证

        String token = request.getHeader("token");
        if (null == token) {
            token = request.getParameter("token");
        }
        if (null == token) {
            LOGGER.error("找不到token");
            setResponse(request, response, ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),new Object());
            return false;
        }
//        JwtUtils jwtUtils =new JwtUtils();
//        jwtUtils.setExpire(604800);
//        jwtUtils.setHeader("token");
//        jwtUtils.setSecret("f4e2e52034348f86b67cde581c0f9eb5[www.renren.io]");


        Claims claims =jwtUtils.getClaimByToken(token);
        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
            LOGGER.error("token已经过期");
            setResponse(request, response, ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),new Object());
            return false;
        }
        request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));
        LOGGER.info("入参：{}",request.getParameterMap());

        return true;
    }

    public void setResponse(HttpServletRequest request,
                            HttpServletResponse response, Long code,String message,Object data) {

        response.setContentType("application/json;charset=UTF-8");
        try (Writer writer = response.getWriter()) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("code", code);
            resultMap.put("msg", message);
            resultMap.put("success", false);
            resultMap.put("data",data);

            JSON.writeJSONString(writer, resultMap);
            writer.flush();
        } catch (IOException e) {
            LOGGER.error("response 设置操作异常：" + e);
        }
    }
}
