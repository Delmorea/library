package personal.delmore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.utils
 * @className: StringUtils
 * @author: Delmore
 * @description: TODO
 * @date: 2022/5/6 10:20
 * @version: 1.0
 */
public class StringUtils {
    /**
     * @param :
     * @return String
     * @author 86176
     * @description date转字符串
     * @date 2022/5/6 10:22
     */
    public static String getDateString(Date date){
        StringBuilder sb = new StringBuilder();
        sb.append(" yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat(sb.toString());
        String dateString = sdf.format(date);
        return dateString;
    }
}
