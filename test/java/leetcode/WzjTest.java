package java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class WzjTest {

    public int start;

    public int end;


    public WzjTest(int start, int end){
        this.end = end;
        this.start = start;
    }

    public static void main(String[] args) {

        List<WzjTest> wzjTests  = new ArrayList<>();

        WzjTest test0 = new WzjTest(1, 3);
        WzjTest test1 = new WzjTest(2, 3);
        WzjTest test2 = new WzjTest(4, 7);
        WzjTest test3 = new WzjTest(5, 6);
        WzjTest test4 = new WzjTest(5, 10);
        wzjTests.add(test0);
        wzjTests.add(test1);
        wzjTests.add(test2);
        wzjTests.add(test3);
        wzjTests.add(test4);

        //wzjTests.stream().reduce((v1,v2) -> {
        //    System.out.println(v1.start);
        //    System.out.println(v1.end);
        //    System.out.println(v2.start);
        //    System.out.println(v2.end);
        //    if (v1.start>v2.start){
        //        return v1;
        //    }
        //    return v2;
        //});

        //wzjTests.stream().filter(distinctByTime(item -> item)).forEach(item -> {
        //    System.out.println(item.start + "--" +item.end);
        //});

        List<WzjTest> result = new ArrayList<>();

        wzjTests.stream().forEach(next -> {
            if (result.isEmpty()){
                result.add(next);
            }else {
                WzjTest pre = result.get(result.size() - 1);
                if (pre.end < next.start){
                    result.add(next);

                }else if (next.end - next.start > pre.end - pre.start) {
                    result.remove(pre);
                    result.add(next);
                }
            }
        });

        result.forEach(item -> {
            System.out.println(item.start + "--" +item.end);
        });

    }



    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
    }

    public static <T> Predicate<T> distinctByTime(Function<? super T, Object> keyExtractor) {
        Map<String, WzjTest> seen = new ConcurrentHashMap<>();

        return object -> {
            WzjTest object1 = (WzjTest)object;
            if (seen.isEmpty()){
                seen.put("key", object1);
                return true;
            }else {
                WzjTest key = seen.get("key");
                if (object1.start > key.end || object1.end < key.start) {
                    seen.put("key", object1);
                    return true;
                }
                else if(object1.end - object1.start > key.end - key.start){
                    seen.put("key", object1);
                    return true;
                }
                return false;

            }
        };
    }





}
