package config;

import lombok.Data;

/**
 * @author Sparks
 * @date 2022/8/14
 */
@Data
public class OpenApiProperties {
    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 服务域名
     */
    private String termsOfServiceUrl;

    /**
     * 作者
     */
    private String author;

    /**
     * 作者主页
     */
    private String pageUrl;

    /**
     * 作者邮箱
     */
    private String email;

    /**
     * 版本
     */
    private String version;

    /**
     * 分组名
     */
    private String groupName;

    /**
     * 指定包扫描
     */
    private String basePackage;

    /**
     * 开启/关闭OpenApi
     */
    private Boolean enable;
}
