package cool.sparks.security.config;

import cool.sparks.security.config.handler.AccessDeniedHandlerImpl;
import cool.sparks.security.config.handler.AuthenticationEntryPointImpl;
import cool.sparks.security.config.handler.AuthenticationFailureHandlerImpl;
import cool.sparks.security.config.handler.LogoutSuccessHandlerImpl;
import cool.sparks.security.service.auth.UserDetailsServiceImpl;
import cool.sparks.security.service.permission.AuthorizedManagerService;
import cool.sparks.security.service.permission.AuthorizedManagerServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;

/**
 * @author Sparks
 * @date 2022/8/17
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SecurityProperties.class)
public class EnterWebSecurityAutoConfigurer {
    /**
     * 自定义security application.yml配置
     */
    @Resource
    private SecurityProperties securityProperties;

    /**
     * 自定义UserDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    /**
     * 使用BCryptPasswordEncoder加密密码
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 未认证的处理
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new AuthenticationEntryPointImpl();
    }

    /**
     * 权限不足的处理
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandlerImpl();
    }

    /**
     * 退出登录的处理
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new LogoutSuccessHandlerImpl();
    }

    /**
     * 认证失败的处理
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler(){
        return new AuthenticationFailureHandlerImpl();
    }

    /**
     * 授权管理
     */
    @Bean("pr")
    public AuthorizedManagerService getAuthorizedManagerService(){
        return new AuthorizedManagerServiceImpl();
    }
}
