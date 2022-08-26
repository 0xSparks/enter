package cool.sparks.security.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Sparks
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_login_log")
public class LoginLogPo {
    /**
     * 访问
     */
    @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     *
     */
    private String loginLocation;

    private String browser;

    private String os;

    private String status;

    private String msg;

    private Date loginTime;
}
