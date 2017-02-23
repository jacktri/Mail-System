package project.service;

import project.vo.UserVo;

import java.util.List;

public interface UserService
{
    UserVo getUserByUsername(String username);

    List<String> getPermissions(String username);

    UserVo getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
