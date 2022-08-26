package cool.sparks.security.service;

import cool.sparks.exception.ServiceException;
import cool.sparks.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

import static cool.sparks.exception.GlobalHttpResponseCode.*;
import static cool.sparks.security.util.AuthErrorCodes.AUTH_LOGIN_INVALID_CREDENTIALS;


/**
 * @author Sparks
 * @date 2022/8/16
 */
@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ServiceExceptionHandler {

    public ResponseResult<?> defaultExceptionHandler(HttpServletRequest request, Throwable e){
        if(e instanceof ServiceException)
        {
            return serviceExceptionHandler((ServiceException) e);
        }

        else if (e instanceof MethodArgumentNotValidException)
        {
            return methodArgumentNotValidExceptionHandler((MethodArgumentNotValidException) e);
        }

        else if (e instanceof MethodArgumentTypeMismatchException)
        {
            return methodArgumentTypeMismatchExceptionHandler((MethodArgumentTypeMismatchException) e);
        }

        else if (e instanceof BadCredentialsException){
            return badCredentialsExceptionHandler((BadCredentialsException) e);
        }
        return ResponseResult.error(INTERNAL_SERVER_ERROR);
    }


    /**
     * 处理业务异常
     */
    @ExceptionHandler(value = ServiceException.class)
    public ResponseResult<?> serviceExceptionHandler(ServiceException e) {
        log.warn("[serviceExceptionHandler]", e);
        return ResponseResult.error(e.getCode(),e.getMsg());
    }


    /**
     * 异常的兜底处理--系统异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseResult<?> orElseExceptionHandler(Throwable e){
        log.warn("[orElseExceptionHandler]", e);
        return ResponseResult.error(INTERNAL_SERVER_ERROR.getCode(),INTERNAL_SERVER_ERROR.getMsg());
    }

    /**
     * 字段校验不通过异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException  e){
        log.warn("[MethodArgumentNotValidException]",e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        return ResponseResult.error(ERROR_PARAMETERS.getCode(),fieldError.getDefaultMessage());
    }

    /**
     * 字段类型不符合异常处理(需要传递Inter但传的是String)
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseResult<?> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e){
        log.warn("[MethodArgumentTypeMismatchException]",e);
        return ResponseResult.error(ERROR_PARAMETERS.getCode(),e.getMessage());
    }

    /**
     * 权限不足异常处理
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseResult<?> accessDeniedExceptionHandler (AccessDeniedException e){
        log.warn("[AccessDeniedException]",e);
        return ResponseResult.error(NOT_ACCESSIBLE);
    }

    /**
     * 认证失败的处理
     */
    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseResult<?> badCredentialsExceptionHandler(BadCredentialsException e){
        return ResponseResult.error(AUTH_LOGIN_INVALID_CREDENTIALS);
    }
}
