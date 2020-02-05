package com.king.filter;

import javax.servlet.*;
import java.io.IOException;

public class HelloWorldFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("触发 hello world 过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
