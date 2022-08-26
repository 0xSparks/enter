package cool.sparks.security.service.permission;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.sparks.security.dao.mysql.UserRoleMapper;
import cool.sparks.security.dao.po.UserRolePo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Sparks
 * @date 2022/8/25
 */
@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;
    /**
     * 根据用户ID查询角色ID
     */
    @Override
    public Long getUserRoleByUserId(Long userId) {
        QueryWrapper<UserRolePo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        UserRolePo userRole = userRoleMapper.selectOne(wrapper);
        System.out.println("查询到的角色ID:"+userRole.getRoleId());
        return userRole.getRoleId();
    }
}
