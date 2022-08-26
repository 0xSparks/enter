package cool.sparks.exception;

import cool.sparks.util.ResponseCodeAndMsg;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Sparks
 * @date 2022/8/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException{
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException() {
    }

    public ServiceException(ResponseCodeAndMsg error) {
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public ServiceException(Integer code, String msg) {

    }

    public Integer getCode() {
        return code;
    }

    public ServiceException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ServiceException setMsg(String msg) {
        this.msg = msg;
        return this;
    }

}
