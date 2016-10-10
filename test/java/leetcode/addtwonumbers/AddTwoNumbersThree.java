//package leetcode.addtwonumbers;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by simpletour_Jenkin on 2016/10/10.
// */
//public class AddTwoNumbersThree {
//
//    public static void main(String[] args){
//
//        AddTwoNumbersThree addTwoNumbers = new AddTwoNumbersThree();
//        Long time1 = System.currentTimeMillis();
//        addTwoNumbers.addTwoNumbers(addTwoNumbers.createL1(),addTwoNumbers.createL2());
//        Long time2 = System.currentTimeMillis();
//        System.out.println(time2 - time1);
//
//    }
//
//    public ListNode createL1(){
//        ListNode l1 = new ListNode(3);
//        ListNode l2 = new ListNode(4);
//        l2.next = l1;
//        ListNode l3 = new ListNode(2);
//        l3.next = l2;
//        return l3;
//    }
//
//    public ListNode createL2(){
//        ListNode l1 = new ListNode(4);
//        ListNode l2 = new ListNode(6);
//        l2.next = l1;
//        ListNode l3 = new ListNode(5);
//        l3.next = l2;
//        return l3;
//    }
//
//
//
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int overTen = 0;
//        int len1 = getLength(l1);
//        int len2 = getLength(l2);
//        int length =  len1>len2 ? len1:len2;
//        length = length + 3;
//        int[] nums = new int[length];
//        int jj = 0;
//        while (true){
//            int num = l1.val + l2.val + overTen;
//
//            nums[jj] = this.getNumber(num);
//
//            if (isOverTen(num)){
//                overTen = 1;
//            }else {
//                overTen = 0;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//
//            if (l1 == null && l2 == null) {
//                if (overTen==1){
//                    nums[jj] = 1;
//                }
//                break;
//            }
//            if (l1 == null && l2 != null){
//
//                nums = addListNode(nums,l2,overTen,jj);
//                break;
//            }
//            if (l1 !=null && l2 == null){
//                nums = addListNode(nums,l1,overTen,jj);
//                break;
//            }
//            jj = jj + 1;
//        }
//
//        ListNode resultListNode = null;
//
//        for (int i=nums.length-1;i>=0;i--){
//            if (resultListNode == null){
//                resultListNode = new ListNode(result.get(i));
//            }else {
//                ListNode tempNode = new ListNode(result.get(i));
//                tempNode.next = resultListNode;
//                resultListNode = tempNode;
//            }
//        }
//
//        return resultListNode;
//    }
//
//    private int getLength(ListNode listNode){
//        int length = 0;
//        while (listNode !=null){
//            length = length+1;
//            listNode = listNode.next;
//        }
//        return length;
//    }
//
//    private int[] addListNode(int[] nums, ListNode addList, int overTen, int jj){
//
//        while (addList != null) {
//            int num = addList.val + overTen;
//            if (isOverTen(num)){
//                overTen = 1;
//            }else {
//                overTen = 0;
//            }
//            nums[jj] = this.getNumber(num);
//            jj = jj + 1;
//            addList = addList.next;
//        }
//        if (overTen==1){
//            nums[jj] = 1;
//        }
//        return nums;
//    }
//
//    private Boolean isOverTen(int num){
//        return num >= 10;
//    }
//
//    private int getNumber(int num){
//        return num%10;
//    }
//
//
//
//
//
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
//}
