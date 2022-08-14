package cool.sparks.user.config.openapi;

import config.OpenApiProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Sparks
 * @date 2022/8/15
 */
@ConfigurationProperties("enter.open-api")
public class UserOpenApiProperties extends OpenApiProperties {
}
