package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.entity.UserEntity;
import project.repository.UserRepository;
import project.service.UserService;
import project.vo.UserVo;
import project.vo.visitor.entity.UserEntityVoVisitor;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    protected UserRepository userRepository;

    @Override
    public UserVo getUserByUsername(String username)
    {
        List<UserEntity> entities = userRepository.findByUsername(username);
        UserVo userVo = convertEntityToVo(entities.get(0));
        if (userVo.getLogin().equals(username))
            {
            return userVo;
            }
        return null;
    }

    private List<UserVo> convertEntitiesToVos(final List<UserEntity> entities)
    {
        final List<UserVo> userVos = new ArrayList<>(entities.size());
        entities.forEach(entity -> userVos.add(convertEntityToVo(entity)));
        return userVos;
    }

    private UserVo convertEntityToVo(final UserEntity entity)
    {
        return entity.accept(new UserEntityVoVisitor(
                new UserVo.Builder()))
                .getBuilder()
                .build();
    }

    @Override
    public List<String> getPermissions(String username)
    {
        return null;
    }

    @Override
    public UserVo getCurrentUser()
    {
        return null;
    }

    @Override
    public Boolean isCurrentUserLoggedIn()
    {
        return true;
    }
}
