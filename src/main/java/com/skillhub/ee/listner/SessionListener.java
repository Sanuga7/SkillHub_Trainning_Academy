package com.skillhub.ee.listner;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();
        Integer activeUserCount = (Integer) context.getAttribute("activeUsers");

        if(activeUserCount == null){
            activeUserCount = 0;
        }

        activeUserCount++;
        context.setAttribute("activeUsers", activeUserCount);

        System.out.println("Active User Count Updated, Active Count: " + activeUserCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();
        Integer activeUserCount = (Integer) context.getAttribute("activeUsers");

        if(activeUserCount != null && activeUserCount > 0){
            activeUserCount--;
        }

        context.setAttribute("activeUsers", activeUserCount);
        System.out.println("Active User Count Updated, Active Count: " + activeUserCount);

    }
}
