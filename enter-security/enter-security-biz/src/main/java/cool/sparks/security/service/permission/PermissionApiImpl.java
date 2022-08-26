package cool.sparks.security.service.permission;

import javax.annotation.Resource;

/**
 * @author Sparks
 * @date 2022/8/24
 */
public class PermissionApiImpl implements PermissionApi{
    @Resource
    private PermissionService permissionService;

    @Override
    public boolean hasAnyPermissions(Long userId, String... permissions) {
        return false;
    }
}
