package cool.sparks.security.service.permission;

import cool.sparks.security.dao.po.UserPo;

import java.util.Set;

/**
 * @author Sparks
 * 权限验证
 */
public interface PermissionService {

    /**
     * 判断用户有否有权限
     * @param userId 用户ID
     * @param permissions 权限
     */
    public boolean hasAnyPermissions(Long userId, String... permissions);

}
