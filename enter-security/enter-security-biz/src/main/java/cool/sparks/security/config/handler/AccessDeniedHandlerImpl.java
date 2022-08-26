package cool.sparks.security.config.handler;

import cool.sparks.exception.GlobalHttpResponseCode;

import cool.sparks.util.ResponseResult;
import cool.sparks.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cool.sparks.exception.GlobalHttpResponseCode.NOT_ACCESSIBLE;

/**
 * @author Sparks
 *权限不足的处理 -- 已经登录但没有权限,返回{@link GlobalHttpResponseCode#NOT_ACCESSIBLE}
 *
 */
@Slf4j
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        log.error("权限不足的处理:{}",e.toString());
        ServletUtils.writeJSON(response, ResponseResult.error(NOT_ACCESSIBLE));
    }
}
