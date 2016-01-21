package spring.boot.rest.common.util;

import java.util.regex.Pattern;


public class StringUtil {

    public static boolean isMobile(String mobile) {
        String pMobile = "^(1(([34578][0-9])))\\d{8}$";
        return Pattern.matches(pMobile, mobile);
    }


}
