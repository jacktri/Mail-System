package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.service.UserService;
import project.vo.UserDetailsVo;
import project.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{
    @Autowired
    protected UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        UserVo userVo = userService.getUserByUsername(username);
        if (userVo == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        return new UserDetailsVo.Builder().userVo(userVo).authorities(grantedAuthorities).build();
    }
}
