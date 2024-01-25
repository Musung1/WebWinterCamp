package com.example.myboard.service.userService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class SessionService {
    public static final String Session_Cookie_Name = "mySessionId";
    private Map<String,Object> sessionStore = new HashMap<>();

    public void createSession(Object value, HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId,value);

        Cookie cookie = new Cookie(Session_Cookie_Name,sessionId);
        response.addCookie(cookie);

    }

    public Object getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(Session_Cookie_Name,request);
        if(sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }
    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(Session_Cookie_Name,request);
        if(sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    private Cookie findCookie(String sessionCookieName, HttpServletRequest request) {
        if(request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter((cookie -> cookie.getName().equals(sessionCookieName)))
                .findAny()
                .orElse(null);
    }

}
