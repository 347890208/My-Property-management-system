package com.rainy.property.config.security;

import com.alibaba.fastjson.JSON;
import com.rainy.property.domain.AjaxResponseBody;
import com.rainy.property.util.JwtTokenUtil;
import com.rainy.property.util.UrlUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version v1.0
 * @ProjectName: My-Property-management-system
 * @ClassName: AjaxAuthenticationSuccessHandler
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/3/16 11:41
 */
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        AjaxResponseBody responseBody = new AjaxResponseBody();
        System.out.println("登录成功");

        responseBody.setCode(20000);
        responseBody.setMsg("Login Success!");

        SelfUserDetails userDetails = (SelfUserDetails) authentication.getPrincipal();

        String Token = JwtTokenUtil.generateToken(userDetails.getUsername(), 100, "_secret");
        //可以拿到username,就在这往redis存token
        System.out.println(userDetails.getUsername());
        responseBody.setToken(Token);

        UrlUtil urlUtil = new UrlUtil(20000,responseBody);
        httpServletResponse.getWriter().write(JSON.toJSONString(urlUtil));
    }
}

