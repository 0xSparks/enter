package cool.sparks.security.config.openapi;

import config.OpenApiProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Sparks
 * @date 2022/8/22
 */
@ConfigurationProperties("enter.open-api")
public class EnterSecurityOpenApiProperties extends OpenApiProperties {
}
