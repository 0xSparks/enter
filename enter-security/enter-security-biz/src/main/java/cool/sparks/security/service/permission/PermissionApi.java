package cool.sparks.security.service.permission;

/**
 * 权限Api
 */
public interface PermissionApi {
    /**
     * 判断用户有否有权限
     * @param userId 用户ID
     * @param permissions 权限
     */
    boolean hasAnyPermissions(Long userId, String... permissions);
}
