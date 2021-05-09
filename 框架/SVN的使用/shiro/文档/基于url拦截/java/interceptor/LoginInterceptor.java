package com.sxt.interceptor;

import com.sxt.util.ResourcesUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Lenovo on 2019/5/6.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
       //获取用户请求的uri
        String uri = request.getRequestURI();
        //从util中获取权限列表
        List<String> anyone = ResourcesUtil.getValue("anyone");
        for(String mm:anyone){
            if(uri.indexOf(mm)>0){
                return true;
            }
        }
        //判断用户是否登陆
        if(request.getSession().getAttribute("user")==null){
            response.sendRedirect("/toLogin");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
