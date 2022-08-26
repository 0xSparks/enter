package cool.sparks.security.service.permission;

import cool.sparks.security.dao.po.RolePo;

import java.util.List;

public interface RoleService {

    /**
     * 获取角色列表
     */
    public List<RolePo> getRoleList();

    /**
     * 通过用户ID获取角色列表
     */
    public List<RolePo> getRoleListByUserId(Long userId);

}
