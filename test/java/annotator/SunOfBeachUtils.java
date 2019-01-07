package java.annotator;

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
            if (field.isAnnotationPresent(annotator.SunOfBeach.class)){

            }
        }
    }

    public static void main(String[] args){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s1 == s1.intern());
    }
}

