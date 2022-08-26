package cool.sparks.security.service.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cool.sparks.security.dao.po.UserPo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Sparks
 * @date 2022/8/21
 */
public class LoginUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户的角色ID
     */
    private Long roleId;

    /**
     * 用户信息
     */
    private UserPo UserPo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token ){
        this.token = token;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public UserPo getUserPo() {
        return UserPo;
    }

    public void setUserPo(UserPo UserPo) {
        this.UserPo = UserPo;
    }

    public LoginUser()
    {
    }

    public LoginUser(UserPo user, Long roleId)
    {
        this.UserPo = user;
        this.roleId = roleId;
    }

    public LoginUser(Long userId, UserPo user, Long roleId)
    {
        this.userId = userId;
        this.UserPo = user;
        this.roleId = roleId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return UserPo.getPassword();
    }

    @Override
    public String getUsername() { return UserPo.getUserName();}

    /**
     * 账户是否未过期,过期无法验证
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
