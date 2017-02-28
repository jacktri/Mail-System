package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.controller.dto.UserDto;
import project.service.UserService;
import project.vo.UserVo;

@RestController
public class UserController
{
    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody final UserDto userDto)
    {
        userService.registerUser(convertToVo(userDto));
    }

    private UserVo convertToVo(UserDto userDto)
    {
        return new UserVo.Builder()
                .login(userDto.getUsername())
                .password(new BCryptPasswordEncoder().encode(userDto.getPassword()))
                .build();
    }
}
