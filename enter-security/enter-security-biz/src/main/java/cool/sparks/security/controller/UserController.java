package cool.sparks.security.controller;
import cool.sparks.security.config.SecurityProperties;
import cool.sparks.security.dao.po.UserPo;
import cool.sparks.security.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import java.util.Arrays;

/**
 * @author Sparks
 */
@Slf4j
@RestController
@RefreshScope
public class UserController {
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private SecurityProperties securityProperties;

    @Resource
    private UserService userService;

    @Value("${enter.open-api.title}")
    private String title;

    @GetMapping("/users")
    public String getUserName() {
        String password = passwordEncoder.encode("123");
        System.out.println("securityProperties是:"+ Arrays.toString(securityProperties.getPermitAllUrls().toArray(new String[0])));
        return "admin";
    }
    @PermitAll
    @GetMapping("/pass")
    public String getPassword() {

        log.debug("username的值是:{}",title);

        return title;
    }
}
