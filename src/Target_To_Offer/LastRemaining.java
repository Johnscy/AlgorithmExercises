package Target_To_Offer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....
 * 这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class LastRemaining {
    //用队列
    public class Solution_Queue {
        public int LastRemaining_Solution(int n, int m) {
            if (n <= 0 || m < 0)
                return -1;
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0;i< n;i++)
                queue.offer(i);
            while (queue.size() > 1){
                int out = (m - 1) % n;
                for (int i = 0;i < out;i++){
                    int temp = queue.poll();
                    queue.offer(temp);
                }
                queue.poll();
                n--;
            }
            return queue.peek();
        }
    }

    //递归，推公式
    //约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。因为是圆圈，所以最后需要对 n 取余。
    public class Solution_Recursion {
        public int LastRemaining_Solution(int n, int m) {
            if (n <= 0 || m < 0)    //特殊输入的处理
                return -1;
            if (n == 1)     //返回条件
                return 0;
            return (LastRemaining_Solution(n - 1, m) + m) % n;
        }
    }
}