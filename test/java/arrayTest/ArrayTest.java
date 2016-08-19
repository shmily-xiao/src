package arrayTest;

import com.sun.jdi.DoubleValue;

import java.util.Random;

/**
 * Created by simpletour_Jenkin on 2016/8/9.
 */
public class ArrayTest {




    public static void main(String[] args) {
//        Person[] persons = new Person[2];
//        Man man = new Man();
//        Women women = new Women();
//        persons[0] = man;
////        persons[1] = women;
//
//        for (int i = 0; i<persons.length ; i++){
//            System.out.println(persons[i]);
//        }
//
//        Integer days = 30;
//
//        System.out.println(days * 24 * 60 * 60 * 1000L);

        Double start = 0.8;
        Double end = 8.0;
        Double expect = 3.0;
        Double sum = 0.0;
        int length = 10000;
        for (int i = 0; i < length; i ++){
            java.text.DecimalFormat df  = new java.text.DecimalFormat("#0.00");
            Double dd = getMyExpectPrice(start,end,expect);
            String result = df.format(dd);
//            System.out.println(result);
            sum = sum + dd;
        }

        System.out.println("AVG : "+sum/length);

    }

    /**
     * 这个的方法只考虑正数的情况
     *
     * @param start  范围的开始段
     * @param end    范围的结束段
     * @param expect 期望的值
     * @return 可能为空
     */
    private static Double getMyExpectPrice(Double start, Double end, Double expect) {
        if (start == null || end == null || expect == null
                || start > expect || end < expect || end < start || start < 0) {
            return null;
        }

        // 概率的分配点
        // 小于 alpha的就取 expect - start 这一段
        // 大于 alpha的就取 end - expect
        double alpha = (expect - start) / (end - start);

        // [0,1)
        double randomPoint = Math.random();

        Random random = new Random();
        if (randomPoint > alpha) {
            return start + random.nextDouble() * (expect - start);
        } else {
            return expect + random.nextDouble() * (end - expect);
        }
    }
}



//class Man extends Person{
//    private void printString(){
//        System.out.println("man");
//    }
//}
//
//class Women extends Person{
//    private void printString(){
//        System.out.println("women");
//    }
//}



