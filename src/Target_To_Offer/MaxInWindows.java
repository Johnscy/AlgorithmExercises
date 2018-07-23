package Target_To_Offer;
import java.util.*;
/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口。
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    //双向队列LinkedList
    public class Solution {
        public ArrayList<Integer> maxInWindows(int [] num, int size) {
            ArrayList<Integer> res = new ArrayList<>();
            int len = num.length;
            if (num == null || len == 0 || size > len || size < 1)
                return res;
            //int numOfWindows = len - size + 1;
            LinkedList<Integer> queue = new LinkedList<>(); //保存下标
            for (int i = 0; i < len; i++) {
                if (!queue.isEmpty()){
                    if (i >= queue.peek() + size)    // 如果队列头元素不在滑动窗口中了，就删除头元素
                        queue.pop();
                    while (!queue.isEmpty() && num[i] >= num[queue.getLast()])// 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                        queue.removeLast();
                }
                queue.offer(i);
                if (i + 1 >= size)
                    res.add(num[queue.peek()]);
            }
            return res;
        }
    }

    //用优先队列维护大顶堆
    public class Solution_MaxHeap {
        public ArrayList<Integer> maxInWindows(int [] num, int size) {
            ArrayList<Integer> res = new ArrayList<>();
            int len = num.length;
            if (num == null || len == 0 || size > len || size < 1)
                return res;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> (o2 - o1));//大顶堆
            for (int i = 0; i < size; i++)
                maxHeap.add(num[i]);
            res.add(maxHeap.peek());    //第一个窗口的最大值
            for (int i = 1, j = i + size - 1;j < len;i++,j++){  //i为窗口起始索引，j为结束索引
                maxHeap.remove(num[i - 1]); //去掉前一个窗口的头，向后滑动
                maxHeap.add(num[j]);
                res.add(maxHeap.peek());
            }
            return res;
        }
    }
}
