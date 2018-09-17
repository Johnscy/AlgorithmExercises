package WrittenTest.LittleRedBook;
import java.util.*;

public class ReverseKGroupList {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().trim().split(" ");
        int n = strs.length;
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++)
            arrs[i] = Integer.parseInt(strs[i]);
        ListNode head = new ReverseKGroupList().new ListNode(arrs[0]);
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ReverseKGroupList().new ListNode(arrs[i]);
            temp = temp.next;
        }
        int k = sc.nextInt();
        sc.nextLine();
        head = reverseKGroup(head, k);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode i = head; i != null; n++, i = i.next) ;
        ListNode pHead = new ReverseKGroupList().new ListNode(0);
        pHead.next = head;
        ListNode pre = pHead;
        for (ListNode tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = pre.next;
                pre.next = tail.next;
                tail.next = next;
            }
            pre = tail;
            tail = tail.next;
        }
        return pHead.next;
    }

}