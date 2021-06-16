package ir.irving.com.common.api;

/**
 * 封装错误码
 * @author irving
 * @date 2021/1/29
 */
public interface IErrorCode {
    long getCode();

    String getMessage();

    boolean getSuccess();

}
