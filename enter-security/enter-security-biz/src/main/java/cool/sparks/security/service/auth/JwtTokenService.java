package cool.sparks.security.service.auth;

public interface JwtTokenService {

    public String createToken(LoginUser loginUser);

}
