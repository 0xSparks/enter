package cool.sparks.user.config.openapi;
import config.OpenApiConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;



/**
* @author Sparks
* @date 2022/8/14
*/
@Configuration
@EnableConfigurationProperties(UserOpenApiProperties.class)
// 开启/关闭OpenApi open-api.enable=true/false
public class UserOpenApiConfig extends OpenApiConfig{

    private UserOpenApi userOpenApi;
    public Docket resultDocket(UserOpenApiProperties properties){
        return userOpenApi.defaultApi(properties);
    }
}
