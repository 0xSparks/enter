package cool.sparks.security.service.permission;

/**
 * @author Sparks
 * @date 2022/8/25
 */
public interface AuthorizedManagerService {
    public boolean hasPermission(String permission);
}
