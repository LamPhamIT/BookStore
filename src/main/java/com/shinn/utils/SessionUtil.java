package com.shinn.utils;

import jakarta.servlet.http.HttpServletRequest;

public class SessionUtil {
    private static SessionUtil session = null;
    private SessionUtil(){

    }
    public static SessionUtil getInstance() {
        if(session == null) {
            session = new SessionUtil();
        }
        return session;
    }
    public void putValue(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }
    public Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }
    public void removeValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
}
