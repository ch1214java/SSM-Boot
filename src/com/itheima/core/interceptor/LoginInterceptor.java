package com.itheima.core.interceptor;

import com.itheima.core.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/9/29.
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求的URL
        String url = httpServletRequest.getRequestURI();
        //url:处了登录请求外，其他的URL都进行拦截控制
        if (url.indexOf("login/action") >=0){
            return true;
        }
        //获取session
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        //判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (user !=null){
            return true;
        }
        //不符合条件的给出提示信息，并转发到登录界面
        httpServletRequest.setAttribute("msg","您还没有登录，请先登录");
        httpServletRequest.getRequestDispatcher("WEB-INF/jsp/l   ogin.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
