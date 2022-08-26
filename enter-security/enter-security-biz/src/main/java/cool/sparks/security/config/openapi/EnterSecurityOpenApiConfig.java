package cool.sparks.security.config.openapi;

import config.OpenApiConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;

/**
 * @author Sparks
 * @date 2022/8/22
 */
@Configuration
@EnableConfigurationProperties(EnterSecurityOpenApiProperties.class)
public class EnterSercurityOpenApiConfig extends OpenApiConfig {
    private EnterSercurityOpenApi enterSercurityOpenApi;
    public Docket resultDocket(EnterSecurityOpenApiProperties properties){
        return enterSercurityOpenApi.defaultApi(properties);
    }
}
