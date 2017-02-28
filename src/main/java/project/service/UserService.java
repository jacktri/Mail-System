package project.service;

import project.vo.UserVo;

import java.util.List;

public interface UserService
{
    UserVo getUserByUsername(String username);

    void registerUser(UserVo userVo);

    List<String> getPermissions(String username);

    UserVo getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
