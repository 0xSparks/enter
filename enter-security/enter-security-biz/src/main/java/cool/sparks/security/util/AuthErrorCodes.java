package cool.sparks.security.util;

import cool.sparks.util.ResponseCodeAndMsg;

public interface AuthErrorCodes {

    ResponseCodeAndMsg AUTH_LOGIN_INVALID_CREDENTIALS = new ResponseCodeAndMsg(40003,"登录失败,账号或密码错误");
    ResponseCodeAndMsg USER_DISABLED = new ResponseCodeAndMsg(40004,"账号已被停用");
    ResponseCodeAndMsg USER_DELETED = new ResponseCodeAndMsg(40005,"账号已被删除");
    ResponseCodeAndMsg USERNAME_NOT_FOUND = new ResponseCodeAndMsg(40005,"用户名未找到");
}
