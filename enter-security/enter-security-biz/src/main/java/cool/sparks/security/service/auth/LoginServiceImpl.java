package cool.sparks.security.service.auth;

import cool.sparks.security.config.CustomSecurityContextHolder;
import cool.sparks.util.ResponseResult;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Sparks
 * @date 2022/8/25
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    private AuthenticationManager authenticationManager;


    @Override
    public ResponseResult<?> login(String username, String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        //调用UserDetailsServiceImpl
        Authentication authentication = authenticationManager.authenticate(token);

        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        return ResponseResult.success(loginUser);
    }
}
