//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Class3$reverseList {
    // 1.多用一个头
    /*public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            head.next = result.next;
            result.next = head;
            head = temp;
        }
        return result.next;
    }*/

    // 2.
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
