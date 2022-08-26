package cool.sparks.util;


import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sparks
 * @date 2022/8/24
 */
public class ServletUtils {
    /**
     *返回 JSON String
     */
    @SuppressWarnings("deprecation") // 必须使用 APPLICATION_JSON_UTF8_VALUE，否则会乱码
    public static void writeJSON(HttpServletResponse response, Object object) {
        String jsonString = JsonUtils.toJsonString(object);
        ServletUtil.write(response, jsonString, MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    /**
     * 获取User-Agent
     */
    public static String getUserAgent(){
        HttpServletRequest request = getRequest();
        if(request == null){
            return null;
        }
        String userAgent = request.getHeader("User-Agent");
        return userAgent != null ? userAgent : "";
    }

    /**
     * 获取IP地址
     */
    public static String getClientIP() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return ServletUtil.getClientIP(request);
    }

    /**
     * 获取请求
     */
    public static HttpServletRequest getRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return null;
        }
        return ((ServletRequestAttributes)requestAttributes).getRequest();
    }
}
