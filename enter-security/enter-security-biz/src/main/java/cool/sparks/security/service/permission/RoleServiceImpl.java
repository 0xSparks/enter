package cool.sparks.security.service.permission;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.sparks.security.dao.mysql.RoleMapper;
import cool.sparks.security.dao.po.RolePo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sparks
 * @date 2022/8/23
 */
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<RolePo> getRoleList() {
        return roleMapper.selectList(null);
    }

    @Override
    public List<RolePo> getRoleListByUserId(Long id) {
        return null;
    }
}
