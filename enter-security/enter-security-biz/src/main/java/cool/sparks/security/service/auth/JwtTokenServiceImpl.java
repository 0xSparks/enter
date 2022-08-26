package cool.sparks.security.service.auth;

import cn.hutool.core.util.IdUtil;

/**
 * @author Sparks
 * @date 2022/8/25
 */
public class JwtTokenServiceImpl implements JwtTokenService {
    @Override
    public String createToken(LoginUser loginUser) {
        loginUser.setToken(IdUtil.simpleUUID());
        return null;
    }
}
