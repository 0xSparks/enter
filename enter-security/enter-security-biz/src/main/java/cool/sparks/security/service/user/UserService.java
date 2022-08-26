package cool.sparks.security.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.sparks.security.dao.po.UserPo;

public interface UserService extends IService<UserPo> {
    /**
     * 根据ID查用户
     */
    public UserPo getUserById(Long id);


    /**
     * 根据用户名查用户
     */
    public UserPo getUserByUsername(String username);

}
