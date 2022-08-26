package cool.sparks.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

/**
 * @author Sparks
 * @date 2022/8/17
 */
@ConfigurationProperties(prefix = "enter.security")
@Validated
@Data
public class SecurityProperties {

    /**
     * 免登录的 URL 列表
     */
    private List<String> permitAllUrls = Collections.emptyList();
}
