package cool.sparks.user.config.openapi;
import config.OpenApiConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Sparks
 * @date 2022/8/15
 */
@Component
public class UserOpenApi extends OpenApiConfig {
    @Bean
    public Docket defaultApi(UserOpenApiProperties properties) {
        return super.defaultApi(properties);
    }
}
