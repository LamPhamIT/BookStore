package com.shinn.filter;

import com.shinn.constant.SystemConstant;
import com.shinn.model.UserModel;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        StringBuffer buffer = request.getRequestURL();
        String url = buffer.toString();
        UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER);
        if (url.contains("/admin")) {
            user = (UserModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER);
            if (user != null) {
                if (user.getRole().getName().equals(SystemConstant.USER_ROLE)) {
                    response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
                } else if (user.getRole().getName().equals(SystemConstant.ADMIN_ROLE)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
            }
        } else if (url.contains("/tai-khoan")) {
            if(user == null) {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
            } else {filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
