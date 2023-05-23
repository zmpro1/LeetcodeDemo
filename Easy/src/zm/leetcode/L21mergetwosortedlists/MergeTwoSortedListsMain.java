package zm.leetcode.L21mergetwosortedlists;

//21. 合并两个有序链表  https://leetcode.cn/problems/merge-two-sorted-lists/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode last= this;
        StringBuilder sb = new StringBuilder();

        while (last != null) {
            sb.append(last.val).append("->");
            last = last.next;
        }

        return sb.toString();
    }
}

public class MergeTwoSortedListsMain {


    //迭代法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList =  new ListNode(-1);
        ListNode lastNode = newList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                lastNode.next = list1;
                list1 = list1.next;
            } else {
                lastNode.next  = list2;
                list2 = list2.next;
            }
            lastNode = lastNode.next;
        }

        if (list1 == null)
            lastNode.next = list2;
        if (list2== null)
            lastNode.next = list1;

        return newList;
    }

    //递归法
    public ListNode mergeTwoLists_official(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists_official(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_official(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode3.next = listNode5;
        listNode1.next = listNode3;

        listNode4.next = listNode6;
        listNode2.next = listNode4;
        System.out.println(listNode1);
        System.out.println(listNode2);
        System.out.println(new MergeTwoSortedListsMain().mergeTwoLists(listNode1, listNode2));
    }
}
