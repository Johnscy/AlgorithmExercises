package Target_To_Offer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

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
    //next指针关联
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
            RandomListNode pHeadClone = pHead.next; //将两个链表分开
            while (cur.next!= null){
                RandomListNode node = cur.next;
                cur.next = node.next;
                cur = node;
            }
            return pHeadClone;
        }
    }

    //map关联
    public class Solution_map {
        public RandomListNode Clone(RandomListNode pHead) {
            HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
            RandomListNode cur = pHead;
            RandomListNode link = new RandomListNode(-1);
            while (cur != null){
                RandomListNode clone = new RandomListNode(cur.label);
                map.put(cur,clone); //将原链表结点和复制结点作为键值对存入map！
                cur = cur.next;
                link.next = clone;
                link = clone;
            }
            Set<Entry<RandomListNode,RandomListNode>> set = map.entrySet();
            Iterator<Entry<RandomListNode,RandomListNode>> iterator = set.iterator();
            while (iterator.hasNext()){
                Entry<RandomListNode,RandomListNode> next = iterator.next();
                next.getValue().random = map.get(next.getKey().random); //next.getKey().random为原链表中每个结点的random指针指向的结点。
            }//用get来取得map中对应这个结点的值，即复制的结点
            return map.get(pHead);
        }
    }

}
