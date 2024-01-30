package com.example.myboard.service.userService;

import com.example.myboard.domain.TbUser;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.Arrays;


class SessionServiceTest {
    SessionService sessionService = new SessionService();
    @Test
    public void sessionTest() {
        TbUser tbUser = TbUser.of("musung","123");
        HttpSession session;
        HttpSession requestSession;
        //1. 로그인 요청
        MockHttpServletRequest request = new MockHttpServletRequest();
        //2. 세션 생성
        session = request.getSession(true);
        session.setAttribute("loginSession",tbUser);

        // session response
        MockHttpServletResponse response = new MockHttpServletResponse();
        System.out.println(session.getId());


        //3. checkSession
        MockHttpServletRequest request2 = new MockHttpServletRequest();
        request2.setCookies(new Cookie("jsessionid",session.getId()));
        Arrays.stream(request2.getCookies()).forEach((cookie -> System.out.println(cookie.getValue())));
        requestSession = request2.getSession(false);
        Assertions.assertThat(requestSession).isNotNull();
        requestSession.getAttributeNames().asIterator().forEachRemaining(System.out::println);
        //4. 로그인 확인
        TbUser tbUser1 = (TbUser) requestSession.getAttribute("loginSession");
        //Assertions.assertThat(tbUser1).isEqualTo(tbUser);

        // 세션 생성





    }

}