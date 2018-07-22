package Target_To_Offer;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {
    public class Solution {
        private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->(o2 - o1));//大顶堆，存储左半边元素
        private PriorityQueue<Integer> right = new PriorityQueue<>();               //小顶堆，存储右半边元素，并且右半边元素都大于左半边。
        private int N = 0;  //元素个数
        public void Insert(Integer num) {
            if (N % 2 == 0){
                left.add(num);
                right.add(left.poll());
            }else{
                right.add(num);
                left.add(right.poll());
            }
            N++;
        }
        public Double GetMedian() {
            if (N % 2 == 0)
                return (left.peek() + right.peek()) / 2.0;
            else
                return right.peek() / 1.0;
        }
    }
}
