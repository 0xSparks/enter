package cool.sparks.security.config.handler;

import cool.sparks.util.ResponseResult;
import cool.sparks.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cool.sparks.security.util.AuthErrorCodes.AUTH_LOGIN_INVALID_CREDENTIALS;

/**
 * @author Sparks
 * 认证失败的处理
 */
@Slf4j
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        log.error("认证失败的处理:{}", AUTH_LOGIN_INVALID_CREDENTIALS);
        ServletUtils.writeJSON(response, ResponseResult.error(AUTH_LOGIN_INVALID_CREDENTIALS));
    }
}
