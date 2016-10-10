package leetcode;

import java.util.List;

/**
 * Created by simpletour_Jenkin on 2016/10/10.
 */
public class AddTwoNumbers {

    public static void main(String[] args){

        AddTwoNumbers addTwoNUmbers = new AddTwoNumbers();
        Long time1 = System.currentTimeMillis();
        addTwoNUmbers.addTwoNumbers(addTwoNUmbers.createL1(),addTwoNUmbers.createL2());
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

    }

    public ListNode createL1(){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = l1;
//        ListNode l3 = new ListNode(2);
//        l3.next = l2;
        return l1;
    }

    public ListNode createL2(){
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(7);
        l2.next = l1;
        ListNode l3 = new ListNode(5);
        l3.next = l2;
        return l1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l4 = null;
        int overTen = 0;
        int length = 0;
        while (true){
            int num = l1.val + l2.val + overTen;
            if (l3 == null) {
               l3 = new ListNode(this.getNumber(num));
            }else {
                l4 = new ListNode(this.getNumber(num));
                l4.next = l3;
                l3 = l4;
            }
            if (isOverTen(num)){
                overTen = 1;
            }else {
                overTen = 0;
            }
            l1 = l1.next;
            l2 = l2.next;

            if (l1 == null && l2 == null) {
                if (overTen==1){
                    ListNode oneNode = new ListNode(1);
                    oneNode.next = l3;
                    l3 = oneNode;
                }
                break;
            }
            if (l1 == null && l2 != null){
                l3 = addListNode(l3,l2,overTen);
                break;
            }
            if (l1 !=null && l2 == null){
                l3 = addListNode(l3,l1,overTen);
                break;
            }
        }


        length = this.getLength(l3);

        ListNode resultListNode = null;
        int[] nums = new int[length];

        for(int i=0;i<length;i++){
            nums[i] = l3.val;
            l3 = l3.next;
        }

        for (int i=0;i<length;i++){
            if (resultListNode == null){
                resultListNode = new ListNode(nums[i]);
            }else {
                ListNode tempNode = new ListNode(nums[i]);
                tempNode.next = resultListNode;
                resultListNode = tempNode;
            }
        }

        return resultListNode;
    }

    /**
     *
     * 主要的链表 oldList 和 addList 的 合并。
     * addList 合并到oldList上，且是前向合并
     *
     * @param oldList 需要返回的字段
     * @param addList 需要添加的字段
     * @param overTen 判断是否加1
     * @return
     */
    private ListNode addListNode(ListNode oldList, ListNode addList, int overTen){

        while (addList != null) {
            int num = addList.val + overTen;
            if (isOverTen(num)){
                overTen = 1;
            }else {
                overTen = 0;
            }
            ListNode temp = new ListNode(this.getNumber(num));
            temp.next = oldList;
            oldList = temp;
            addList = addList.next;
        }
        if (overTen==1){
            ListNode oneNode = new ListNode(1);
            oneNode.next = oldList;
            oldList = oneNode;
        }
        return oldList;
    }

    private int getLength(ListNode listNode){
        int length = 0;
        while (listNode != null) {

            length = length + 1;
            listNode = listNode.next;
        }

        return length;

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
