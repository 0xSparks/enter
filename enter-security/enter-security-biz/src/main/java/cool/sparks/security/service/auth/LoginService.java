package cool.sparks.security.service.auth;

import cool.sparks.util.ResponseResult;

public interface LoginService {

    public ResponseResult<?> login(String username, String password);
}
