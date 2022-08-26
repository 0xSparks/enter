package cool.sparks.security.service.permission;

import cn.hutool.core.util.ArrayUtil;

/**
 * @author Sparks
 *
 */
public class PermissionServiceImpl implements PermissionService {

    @Override
    public boolean hasAnyPermissions(Long userId, String... permissions) {

        if(ArrayUtil.isEmpty(permissions)){
            return true;
        }

        return false;
    }
}
