package cool.sparks.exception;

import cool.sparks.util.ResponseCodeAndMsg;

public interface GlobalHttpResponseCode {

    ResponseCodeAndMsg SUCCESS = new ResponseCodeAndMsg(200, "OK");
    /**
     * 表示客户端请求的语法错误，服务器无法理解，例如 url 含有非法字符、json 格式有问题。
     */
    ResponseCodeAndMsg ERROR_PARAMETERS = new ResponseCodeAndMsg(400, "请求参数有误");
    /**
     * 请求要求身份验证。对于需要登录的网页，服务器可能返回此响应。
     */
    ResponseCodeAndMsg UNAUTHORIZED = new ResponseCodeAndMsg(401, "未登录");
    /**
     * 表示服务器理解请求客户端的请求，但是拒绝请求。
     */
    ResponseCodeAndMsg NOT_ACCESSIBLE = new ResponseCodeAndMsg(403, "禁止访问");
    /**
     * 服务器无法根据客户端的请求找到资源(网页)。
     */
    ResponseCodeAndMsg NOT_FOUND = new ResponseCodeAndMsg(404, "请求未找到");
    /**
     * 服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理。
     */
    ResponseCodeAndMsg INTERNAL_SERVER_ERROR = new ResponseCodeAndMsg(500, "系统异常");
    /**
     * 服务器目前无法使用(由于超载或停机维护)。通常，这只是暂时状态。
     */
    ResponseCodeAndMsg SERVICE_UNAVAILABLE = new ResponseCodeAndMsg(503, "服务不可用");


}
