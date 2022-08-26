package cool.sparks.util;
import cool.sparks.exception.ServiceException;

/**
 * @author Sparks
 * @date 2022/8/16
 */
public class ServiceExceptionUtil {

    public static ServiceException exception(ResponseCodeAndMsg error) {
        return new ServiceException(error);
    }
}
