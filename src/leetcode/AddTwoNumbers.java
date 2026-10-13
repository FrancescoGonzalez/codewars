package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    static ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(3))); //342
    static ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4))); //465


    static ListNode n9 = new ListNode(9); //9
    static ListNode n19 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

    static void main() {
        System.out.println(addTwoNumbers(n9, n19));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        boolean reminder = false;

        while (l1 != null || l2 != null) {
            int number = reminder ? 1 : 0;
            if (l1 == null) {
                number += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                number += l1.val;
                l1 = l1.next;
            } else {
                number += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (number >= 10) {
                number -= 10;
                reminder = true;
            } else {
                reminder = false;
            }

            list.add(number);
        }

        if (reminder) {
            list.add(1);
        }

        list = list.reversed();

        ListNode res = null;

        for (int i : list) {
            res = new ListNode(i, res);
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
