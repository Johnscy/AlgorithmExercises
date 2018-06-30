package Target_To_Offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路：在每个结点后面插入复制结点，然后给复制结点的随机指针赋值，最后把两个链表分开。
 */
public class Clone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null)  return null;
            RandomListNode cur = pHead;
            while (cur != null){    //在原链表的每个结点后面插入复制结点
                RandomListNode node = new RandomListNode(cur.label);
                node.next = cur.next;
                cur.next = node;
                cur = node.next;
            }

            cur = pHead;
            while (cur != null){    //给每个复制结点的random指针赋值
                RandomListNode node = cur.next;
                if (cur.random != null)
                    node.random = cur.random.next;
                cur = node.next;
            }

            cur = pHead;
            RandomListNode pHeadClone = pHead.next; //重新链接复制结点
            while (cur.next!= null){
                RandomListNode node = cur.next;
                cur.next = node.next;
                cur = node;
            }
            return pHeadClone;
        }
    }
}
