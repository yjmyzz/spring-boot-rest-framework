package spring.boot.rest.common.model;


/**
 * {type your description }
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
public class DataResult<T> {

    public DataResult() {
    }

    public DataResult(T data) {
        this.data = data;
        this.isSuccess = true;
    }

    public DataResult(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.isSuccess = false;
    }

    public DataResult(String errorCode, String errorDesc, long elapsedMilliseconds) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.isSuccess = false;
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    /**
     * 是否处理成功
     */
    private boolean isSuccess;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 错误代码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorDesc;

    /**
     * 处理耗时(毫秒)
     */
    private long elapsedMilliseconds;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public long getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public void setElapsedMilliseconds(long elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "isSuccess=" + isSuccess +
                ", data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", elapsedMilliseconds=" + elapsedMilliseconds +
                '}';
    }
}
