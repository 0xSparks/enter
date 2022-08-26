package cool.sparks.security.config;

import org.springframework.security.core.Authentication;

/**
 * @author Sparks
 * 自定义上下文
 */
public class CustomSecurityContextHolder {
    private static final ThreadLocal<Authentication> local = new ThreadLocal<>();

    /**
     * 存入
     */
    public static void setContext(Authentication context)
    {
        local.set(context);
    }

    /**
     * 获取
     */
    public static Authentication getContext()
    {
        return local.get();
    }

    /**
     * 清除
     */
    public static void clearContext()
    {
        local.remove();
    }
}
