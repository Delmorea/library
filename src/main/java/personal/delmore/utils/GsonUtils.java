package personal.delmore.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Primitives;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.utils
 * @className: GsonUtils
 * @author: Delmore
 * @description: TODO
 * @date: 2022/4/17 15:53
 * @version: 1.0
 */
public class GsonUtils {
    /**
     * @param :
     * @return T
     * @author 86176
     * @description 将json转换为对象
     * @date 2022/4/18 10:26
     */
    public static <T> T getBean(String json, Class<T> classOfT) throws JsonSyntaxException {
        Object object = new Gson().fromJson((String) json, (Type) classOfT);
        return Primitives.wrap(classOfT).cast(object);
    }

    /**
     * @param :
     * @return String
     * @author 86176
     * @description 从json中获取指定键的value
     * @date 2022/4/17 15:53
     */
    public static String getParaFromJson(String json, String param) {
        JsonElement jsonElement = new JsonParser().parse(json);
        String value = jsonElement.getAsJsonObject().get(param).toString().replace("\"", "");
        return value;
    }

    /**
     * bean转json
     *
     * @param object
     * @return
     */
    public static String beanToJson(Object object) {
        String gString = null;
        gString = new Gson().toJson(object);
        return gString;
    }

    /**
     * @param :
     * @return String
     * @author 86176
     * @description list转json
     * @date 2022/4/28 10:01
     */
    public static String listToJson(List list) {
        String gString = null;
        gString = new Gson().toJson(list);
        return gString;
    }
}
