package com.generics;

/**
 * Created by simpletour_java on 2015/7/1.
 */
public class generics2 {
    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }
    public static void main( String args[] )
    {
        System.out.printf( "Max of %d, %d and %d is %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "Maxm of %.1f,%.1f and %.1f is %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "Max of %s, %s and %s is %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );


        System.out.println(System.getProperties().toString());

    }
}
