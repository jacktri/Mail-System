package project.config.security;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyLogOutHandler implements LogoutHandler
{
    private UserCache userCache;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        System.out.println("logging out");
    }
}
