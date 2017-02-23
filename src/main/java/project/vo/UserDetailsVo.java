package project.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.common.vo.visitor.ValueObject;
import project.common.vo.utils.ValueObjectBuilder;

import java.util.Collection;
import java.util.List;

public class UserDetailsVo implements UserDetails, ValueObject
{
    private UserVo userVo;
    private List<GrantedAuthority> authorities;

    public UserDetailsVo(UserVo userVo, List<GrantedAuthority> authorities){
        this.userVo = userVo;
        this.authorities = authorities;
    }

    public UserDetailsVo(Builder builder){
        this.userVo = builder.userVo;
        this.authorities = builder.authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return userVo.getPassword();
    }

    @Override
    public String getUsername()
    {
        return userVo.getLogin();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    public static final class Builder implements ValueObjectBuilder<Builder>
    {
        private UserVo userVo;
        private List<GrantedAuthority> authorities;

        public Builder userVo(UserVo userVo){
            this.userVo = userVo;
            return this;
        }
        public Builder authorities(List<GrantedAuthority> authorities){
            this.authorities = authorities;
            return this;
        }
        public UserDetailsVo build(){
            return new UserDetailsVo(this);
        }
    }
}
