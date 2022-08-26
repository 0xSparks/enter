package cool.sparks.security.service;

import cool.sparks.security.dao.po.UserPo;

import java.util.Set;

/**
 * @author Sparks
 * 权限验证
 */
public interface PermissionService {

    /**
     * 获取菜单权限
     */
    public Set<String> getPermissions(UserPo user);

}
