package cool.sparks.security.dao.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Sparks
 * @date 2022/8/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class UserRolePo implements Serializable {
    private long userId;
    private long roleId;
}
