package Target_To_Offer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {
    //Queue
    public class Solution {
        private int[] count = new int[256];     //最多有256种
        private Queue<Character> queue = new LinkedList<>();
        //Insert one char from stringstream
        public void Insert(char ch) {
                count[ch]++;
                if (count[ch] == 1)
                    queue.add(ch);
                while (!queue.isEmpty() && count[queue.peek()] >= 2)
                    queue.poll();
        }
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce() {
            return queue.isEmpty() ? '#' : queue.peek();
        }
    }
}
