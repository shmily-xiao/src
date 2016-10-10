package leetcode.addtwonumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/10/10.
 * 56ms
 *
 */
public class AddTwoNumbersTwo {
    public static void main(String[] args){

        AddTwoNumbersTwo addTwoNumbers = new AddTwoNumbersTwo();
        Long time1 = System.currentTimeMillis();
        addTwoNumbers.addTwoNumbers(addTwoNumbers.createL1(),addTwoNumbers.createL2());
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

    }

    public ListNode createL1(){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = l1;
        ListNode l3 = new ListNode(2);
        l3.next = l2;
        return l3;
    }

    public ListNode createL2(){
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(6);
        l2.next = l1;
        ListNode l3 = new ListNode(5);
        l3.next = l2;
        return l3;
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overTen = 0;
        List<Integer> result = new ArrayList<>();
        while (true){
            int num = l1.val + l2.val + overTen;

            result.add(this.getNumber(num));

            if (isOverTen(num)){
                overTen = 1;
            }else {
                overTen = 0;
            }
            l1 = l1.next;
            l2 = l2.next;

            if (l1 == null && l2 == null) {
                if (overTen==1){
                    result.add(1);
                }
                break;
            }
            if (l1 == null && l2 != null){
                result = addListNode(result,l2,overTen);
                break;
            }
            if (l1 !=null && l2 == null){
                result = addListNode(result,l1,overTen);
                break;
            }
        }

        ListNode resultListNode = null;

        for (int i=result.size()-1;i>=0;i--){
            if (resultListNode == null){
                resultListNode = new ListNode(result.get(i));
            }else {
                ListNode tempNode = new ListNode(result.get(i));
                tempNode.next = resultListNode;
                resultListNode = tempNode;
            }
        }

        return resultListNode;
    }

    private int getLength(ListNode listNode){
        int length = 0;
        while (listNode !=null){
            length = length+1;
            listNode = listNode.next;
        }
        return length;
    }

    private List<Integer> addListNode(List<Integer> list, ListNode addList, int overTen){

        while (addList != null) {
            int num = addList.val + overTen;
            if (isOverTen(num)){
                overTen = 1;
            }else {
                overTen = 0;
            }
            list.add(this.getNumber(num));
            addList = addList.next;
        }
        if (overTen==1){
            list.add(1);
        }
        return list;
    }

    private Boolean isOverTen(int num){
        return num >= 10;
    }

    private int getNumber(int num){
        return num%10;
    }





    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
