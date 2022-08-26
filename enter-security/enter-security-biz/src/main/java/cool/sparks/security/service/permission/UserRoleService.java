package cool.sparks.security.service.permission;


public interface UserRoleService {

    /**
     * 根据用户ID查询角色ID
     */
    Long getUserRoleByUserId(Long userId);

}
