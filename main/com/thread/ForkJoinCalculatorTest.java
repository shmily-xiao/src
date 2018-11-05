package com.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by simpletour_Jenkin on 2016/11/14.
 *
 * 使用分支/合并 框架，运用分治法的思想
 */
public class ForkJoinCalculatorTest extends RecursiveTask<Integer>{
    private static final long serialVersionUID = 7333472779649130114L;

    private static final int THRESHOLD = 10;

    private int start;

    private int end;

    public ForkJoinCalculatorTest(){}

    public ForkJoinCalculatorTest(int start, int end) {
        this.end = end;
        this.start = start;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if ((end-start) < THRESHOLD){ //当问题分解到可求解程度时直接计算结果
            for (int i=start;i<=end;i++){
                sum +=i;
            }
        }else{
            int middle = (start + end) >>> 1;
            // 将任务一分为二
            ForkJoinCalculatorTest left = new ForkJoinCalculatorTest(start,middle);
            ForkJoinCalculatorTest right = new ForkJoinCalculatorTest(middle,end);
            left.fork();
            right.fork();
            // 注意:由于此处是递归式的任务分解，也就意味着接下来会二叉树状的分解

            sum = left.join() + right.join();

        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> result = forkJoinPool.submit(new ForkJoinCalculatorTest(1,10000));
        System.out.println(result.get());
    }

}