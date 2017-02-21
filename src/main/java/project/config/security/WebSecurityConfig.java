package project.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(value = "project.config.security")
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    protected MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    protected MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    protected MyLogOutHandler myLogOutHandler;

    @Autowired
    protected RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    protected AuthFailureHandler authFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .loginProcessingUrl("/login")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(authFailureHandler)
                .and()
                .logout()
                .permitAll()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .addLogoutHandler(myLogOutHandler)
                .and()
                .sessionManagement()
                .maximumSessions(1);

    }

    @Bean
    public SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler()
    {
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        System.out.println("auth");
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
