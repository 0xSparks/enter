package cool.sparks.util;

import cool.sparks.exception.GlobalHttpResponseCode;
import lombok.Data;

import java.io.Serializable;
@Data
public class ResponseResult<T> implements Serializable {
    /**
     * 响应码
     */
    private int code;
    /**
     * 错误消息
     */
    private String msg;
    /**
     * 需要返回的数据
     */
    private T data;

    public ResponseResult() {
    }

    public static <T> ResponseResult<T> error(Integer code, String msg) {
        ResponseResult<T> result = new ResponseResult<>();
        result.code = code;
        result.msg = msg;
        return result;
    }

    /**
     * 请求错误
     * @param errorCode 错误码
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> error(ResponseCodeAndMsg errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    /**
     * 返回成功
     * @param data 返回数据
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.code = GlobalHttpResponseCode.SUCCESS.getCode();
        result.data = data;
        result.msg = "";
        return result;
    }

}

