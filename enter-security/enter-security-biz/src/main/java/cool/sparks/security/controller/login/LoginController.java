package cool.sparks.security.controller.login;
import cool.sparks.security.service.auth.LoginService;
import cool.sparks.util.ResponseResult;
import dto.UserRoleDto;
import cool.sparks.security.controller.login.fo.LoginFo;
import cool.sparks.security.service.auth.UserDetailsServiceImpl;
import cool.sparks.security.service.permission.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;


/**
 * @author Sparks
 * @date 2022/8/19
 */
@Slf4j
@RestController
public class LoginController {
    @Resource
    private UserDetailsServiceImpl userDetailsService;
    @Resource
    private LoginService loginService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @PermitAll
    @PostMapping("/login")
    @PreAuthorize("@pr.hasPermission(null)")
    public ResponseResult<?> login(@RequestBody @Valid LoginFo fo) {
//        userDetailsService.loadUserByUsername("login");
        String encode = passwordEncoder.encode("123");
        System.out.println("加密的密码"+encode);
        ResponseResult<?> login = loginService.login(fo.getUsername(), fo.getPassword());
        log.info("登录账号:{}",fo);
        return login;
    }
}
