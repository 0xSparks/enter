package cool.sparks.security.controller;
import cool.sparks.security.service.impl.UserDetailsServiceImpl;
import cool.sparks.util.ServletUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;


/**
 * @author Sparks
 * @date 2022/8/19
 */
@RestController
public class LoginController {
    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @PermitAll
    @PostMapping("/login")
    public String login() {
        userDetailsService.loadUserByUsername("login");
        return "login";
    }
}
