package com.team.house.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest1 = (HttpServletRequest) req;
        HttpServletResponse servletResponse1 = (HttpServletResponse) resp;
        String uri=servletRequest1.getRequestURI();
        String path=uri.substring(uri.lastIndexOf("/")+1);
        if (path.equals("login.jsp")||path.equals("login")||path.equals("regs.jsp")||path.equals("getStreetByDid")){
            chain.doFilter(req,resp);
        }else {
            HttpSession session=servletRequest1.getSession();
            Object loginInfo = session.getAttribute("user");
            if (loginInfo==null){
                servletResponse1.sendRedirect("login.jsp");
            }else {
                chain.doFilter(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }
}
