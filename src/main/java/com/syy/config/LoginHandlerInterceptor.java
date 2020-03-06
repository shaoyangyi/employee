package com.syy.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
//    返回true就放行，返回false就不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        登录成功之后，应该有用户的session
        Object loginUser= request.getSession().getAttribute("loginUser");

        if (loginUser==null){
            request.setAttribute("msg","没有权限，请先登录");
//            没有登录，转发回首页
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
