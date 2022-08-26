package cool.sparks.security.controller.login.fo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author Sparks
 * @date 2022/8/24
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginFo {
    @NotEmpty(message = "账号不能为空")
    @Length(min = 6, max = 16, message = "账号长度 6-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
