package cool.sparks.security.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.sparks.security.dao.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPo> {
}
