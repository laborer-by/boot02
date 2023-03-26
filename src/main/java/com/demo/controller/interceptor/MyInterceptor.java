package com.demo.controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor implements HandlerInterceptor {
    // 在原始方法执行之前执行，如果返回 false，后续拦截器会失效，且原始方法也不会执行。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle ...");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    // 在原始方法执行之后执行，如果任意拦截器的 preHandle 返回 false，则原始方法以及所有的 postHandle 都不执行。
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle ...");
    }

    // 在拦截完成之后最后执行，只要对应的拦截器的 preHandle 返回 true，就一定会执行。
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("afterCompletion ...");
    }
}
