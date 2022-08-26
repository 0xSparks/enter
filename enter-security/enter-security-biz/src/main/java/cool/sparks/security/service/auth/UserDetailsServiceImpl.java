package cool.sparks.security.service.auth;

import cool.sparks.enums.SysStatus;
import cool.sparks.security.dao.po.UserPo;
import cool.sparks.security.service.permission.UserRoleService;
import cool.sparks.security.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static cool.sparks.security.util.AuthErrorCodes.*;
import static cool.sparks.util.ServiceExceptionUtil.exception;

/**
 * @author Sparks
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPo user = userService.getUserByUsername(username);
        if(user == null) {
            log.warn("{}",USERNAME_NOT_FOUND);
            throw exception(AUTH_LOGIN_INVALID_CREDENTIALS);
        }
        //如果账号被停用
        else if (SysStatus.USER_DISABLE.getCode().equals(user.getStatus())){
            log.warn("{}",USER_DISABLED);
            throw exception(USER_DISABLED);
        }
        //如果账号已被删除(提示账号密码错误)
        else if(SysStatus.USER_DELETED.getCode().equals(user.getDelFlag())){
            log.warn("{}",USER_DELETED);
            throw exception(AUTH_LOGIN_INVALID_CREDENTIALS);
        }

        log.info("{}已登录",username);

        return new LoginUser(user.getUserId(),user,userRoleService.getUserRoleByUserId(user.getUserId()));
    }
}
