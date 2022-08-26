package cool.sparks.security.config.handler;

import cool.sparks.exception.GlobalHttpResponseCode;
import cool.sparks.util.ResponseResult;
import cool.sparks.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cool.sparks.exception.GlobalHttpResponseCode.UNAUTHORIZED;

/**
 * @author Sparks
 * 未认证的处理 -- 没有登录 返回{@link GlobalHttpResponseCode#UNAUTHORIZED}
 */
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        log.info("认证入口点:{}",e.toString());
        ServletUtils.writeJSON(response, ResponseResult.error(UNAUTHORIZED));
    }
}
