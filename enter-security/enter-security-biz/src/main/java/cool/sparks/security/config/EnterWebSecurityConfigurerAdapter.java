package cool.sparks.security.config;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cool.sparks.security.config.handler.AuthenticationEntryPointImpl;
import cool.sparks.security.config.handler.AuthenticationFailureHandlerImpl;
import cool.sparks.security.service.auth.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import java.util.Map;
import java.util.Set;

/**
 * @author Sparks
 * @date 2022/8/15
 */
@Slf4j
@EnableWebSecurity  // 启用 spring-security 功能。
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class EnterWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Resource
    private SecurityProperties securityProperties;

    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 自定义UserDetailsService {@link UserDetailsServiceImpl}
     */
    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 未认证的处理 {@link AuthenticationEntryPointImpl}
     */
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 退出登录的处理
     */
    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;

    /**
     * 认证失败的处理 {@link AuthenticationFailureHandlerImpl}
     */
    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 上下文
     */
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 解决无法注入bean
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * 自定义UserDetailsService {@link UserDetailsServiceImpl}
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


    protected void configure(HttpSecurity http) throws Exception {
        http
                //开启跨域
                .cors().and()
                // CSRF 禁用，因为不使用 Session
                .csrf().disable()
                //配置（在影响sessionFilter）,要求 sessionFilter 不要从 HttpSession 中存取数据
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .headers().frameOptions().disable().and()
                //添加自定义security handler
                .exceptionHandling()
                //未认证的处理
                .authenticationEntryPoint(authenticationEntryPoint);

        Multimap<HttpMethod, String> permitAllUrls = getPermitAllUrlsFromAnnotations();
        http    //配置请求地址的权限
                .authorizeRequests()
                //放行在application.yml中的配置 enter.security.permit-all-urls
                .antMatchers(securityProperties.getPermitAllUrls().toArray(new String[0])).permitAll()
                //放行带有@PermitAll注解的方法的url
                .antMatchers(HttpMethod.GET,permitAllUrls.get(HttpMethod.GET).toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.POST,permitAllUrls.get(HttpMethod.POST).toArray(new String[0])).permitAll()
                //兜底规则，必须认证
                .anyRequest().authenticated();
        http    //退出登录
                .logout().logoutUrl("logout").logoutSuccessHandler(logoutSuccessHandler);

    }

    /**
     * 获得带有@PermitAll注解的方法
     * @return Multimap
     */
    private Multimap<HttpMethod, String> getPermitAllUrlsFromAnnotations() {
        Multimap<HttpMethod, String> result = HashMultimap.create();
        // 获得接口对应的 HandlerMethod 集合
        RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping)
                applicationContext.getBean("requestMappingHandlerMapping");
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        //获取带有@PermitAll注解的方法
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            HandlerMethod handlerMethod = entry.getValue();

            //如果没有@PermitAll注解 跳过
            if(!handlerMethod.hasMethodAnnotation(PermitAll.class)){
                continue;
            }

            if(entry.getKey().getMethodsCondition() == null){
                continue;
            }

            //获取带有@PermitAll方法的url集合
            Set<String> urls = entry.getKey().getPatternsCondition().getPatterns();
            //存入Multimap
            entry.getKey().getMethodsCondition().getMethods().forEach(requestMethod -> {
                switch (requestMethod){
                    case GET:
                        result.putAll(HttpMethod.GET,urls);
                        break;
                    case POST:
                        result.putAll(HttpMethod.POST,urls);
                        break;
                }
            });

        }
        log.info("所以人可以访问的地址:{}", result);
        return result;
    }


}
