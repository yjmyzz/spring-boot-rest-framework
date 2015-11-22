package spring.boot.rest.common.consts;

/**
 * {type your description }
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
public class RestConst {

    public static class ErrorCode {

        public final static String UNKNOWN = "000";
        public final static String VALIDATE_FAIL = "001"; //参数校验失败
        public final static String EMPTY_PARAM = "002"; //参数为空
        public final static String DATABASE_ERROR = "003"; //数据库层面的错误


    }


    public static class HttpCode {
        public final static String Continue = "100";
        public final static String SwitchingProtocols = "101";
        public final static String Processing = "102";


        public final static String OK = "200";
        public final static String Created = "201";
        public final static String Accepted = "202";

    }
}
