package cool.sparks.util;


import lombok.Data;

/**
 * @author Sparks
 * @date 2022/8/16
 * 响应状态码&消息
 */
@Data
public class ResponseCodeAndMsg {
    
    private final Integer code;

    private final String msg;

    public ResponseCodeAndMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
