package config;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/**
 * @author Sparks
 * @date 2022/8/14
 */

public class OpenApiConfig {

    public Docket defaultApi(OpenApiProperties properties) {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(properties.getTitle()) //  可以用来自定义API的主标题
                .description(properties.getDescription()) // 可以用来描述整体的API
                .termsOfServiceUrl(properties.getTermsOfServiceUrl()) // 用于定义服务的域名
                .contact(new Contact(properties.getAuthor(), properties.getPageUrl(), properties.getPageUrl()))
                .version(properties.getVersion()) // 可以用来定义版本。
                .build();


        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo)
                .enable(properties.getEnable())   // 使用使用 swagger 开关。默认 true ，可省略。
                .groupName(properties.getGroupName())  //分组名称
                .select()
                //  .apis(RequestHandlerSelectors.any())    // 扫描所有所有路径
                //  .apis(RequestHandlerSelectors.none())   // 所有路径都不扫描
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage())) // 扫描指定包路径
                .paths(PathSelectors.any())     // 过滤器：对外暴露所有 uri
                //  .paths(PathSelectors.none())    // 过滤器：一个 uri 都不对外暴露
                //  .paths(PathSelectors.ant())     // 过滤器：对外暴露符合 ant 风格正则表达式的 uri
                //  .paths(PathSelectors.regex()    // 过滤器：对外暴露符合正则表达式的 uri
                .build();
    }
}
