package annotator;

import java.lang.reflect.Field;

/**
 * Created by simpletour_Jenkin on 2016/6/8.
 */
public class SunOfBeachUtils {
    public static void getUserInfo(Class<?> clazz){
        String userName = "wzj";
        String idNo = "ABCDEF";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(SunOfBeach.class)){

            }
        }
    }
}

