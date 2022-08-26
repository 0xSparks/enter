package dto;

import lombok.Data;

/**
 * @author Sparks
 */
@Data
public class UserRoleDto {
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 角色ID
     */
    private long roleId;
}
