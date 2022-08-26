package cool.sparks.security.service.user;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.sparks.security.dao.mysql.UserMapper;
import cool.sparks.security.dao.po.UserPo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author Sparks
 * @date 2022/8/21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

    @Resource
    private UserMapper UserMapper;

    /**
     * 根据ID查用户{@link UserService#getUserById(Long)}
     */
    @Override
    public UserPo getUserById(Long id) {
        return UserMapper.selectById(id);
    }

    /**
     * 根据用户名查用户{@link UserService#getUserByUsername(String)}
     */
    public UserPo getUserByUsername(String username) {
        QueryWrapper<UserPo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        return UserMapper.selectOne(wrapper);
    }
}
