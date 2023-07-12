package com.shinn.controller.web;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.scope.FacebookPermissions;
import com.restfb.scope.ScopeBuilder;
import com.restfb.types.User;
import jakarta.security.jacc.WebUserDataPermission;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet({"/chia-se"})
public class Share extends HttpServlet {
    // App id // 2255222071336502
    // App secret : bf423a9f37ebcb01f3f250ed75892f64

    private static final String APP_ID = "2255222071336502";
    private static final String APP_SECRET = "bf423a9f37ebcb01f3f250ed75892f64";
    private static final String SCOPE = "publish_actions";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("Blog_ID"); // id baif viet cua toi
        String href = "http://localhost:8080/BookStore_war_exploded/tin-tuc?blogId=" + id;
//        String encodedHref1 = URLEncoder.encode(href, "UTF-8");//.replace("+", "%20");
//        String encodedHref2 = URLEncoder.encode(href, "UTF-8");//.replace("+", "%20");
        String shareUrl = "https://www.facebook.com/dialog/share?" +
                "app_id=" + APP_ID +
                "&display=popup" +
                "&href="  + href +
                "&redirect_uri=" + href;
        resp.sendRedirect(shareUrl);
    }
//
//
//    private String getAuthorizationUrl() {
//        ScopeBuilder scopeBuilder = new ScopeBuilder();
//        scopeBuilder.addPermission(FacebookPermissions.CATALOG_MANAGEMENT);
//    }
//
//    private String getAccessToken(String code, String redirectUrl) {
//        FacebookClient.AccessToken accessToken =  new DefaultFacebookClient(Version.LATEST)
//                .obtainUserAccessToken(APP_ID, APP_SECRET, redirectUrl, code);
//        return accessToken.getAccessToken();
//    }
//
//
//    private User getUserInfo(String accessToken) {
//        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.LATEST);
//        User user   = facebookClient.fetchObject("me", User.class);
//        return user;
//    }

}
