package cool.sparks.security.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.sparks.security.dao.po.UserRolePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRolePo> {
}
