package Target_To_Offer;
import java.util.*;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1.
 */
public class FirstNotRepeatingChar {
    //用hashmap存储字符和出现次数。考虑到要统计的字符范围有限，因此可以使用整型数组代替hashmap。
    public class Solution_HashMap {
        public int FirstNotRepeatingChar(String str) {
            if (str == null || str.length() == 0)
                return -1;
            int[] cnts = new int[256];
            for (int i = 0;i < str.length();i++)
                cnts[str.charAt(i)]++;
            for (int i = 0;i < str.length();i++)
                if (cnts[str.charAt(i)] == 1)
                    return i;
            return -1;
        }
    }

    //考虑到只需要找到只出现一次的字符，那么我们只需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
    public class Solution_BitSet {
        public int FirstNotRepeatingChar(String str) {
            if (str == null || str.length() == 0)
                return -1;
            BitSet character = new BitSet(256);
            BitSet count = new BitSet(256);
            for (char c : str.toCharArray())
                if (!character.get(c) && !count.get(c)) //对第一次出现的字符，把记录字符的位置1，对应的计数位还是为0
                    character.set(c);
                else if (character.get(c) && !count.get(c)) //对已经出现过一次的字符，再出现相同的，把计数位置1。。。多次出现的，不动，计数位一直为1就行
                    count.set(c);
            for (int i = 0;i < str.length();i++){   //需要输出索引，所以用for遍历
                char c = str.charAt(i);
                if (character.get(c) && !count.get(c))
                    return i;
            }
            return -1;

        }
    }

    //队列。。和另外一题很像：字符流中第一个不重复的字符
    public class Solution_Queue {
        public int FirstNotRepeatingChar(String str) {
            if (str == null || str.length() == 0)
                return -1;
            Queue<Character> queue = new LinkedList<>();
            int[] cnts = new int[256];
            for (char c : str.toCharArray()){
                cnts[c]++;
                queue.offer(c);
                while (!queue.isEmpty() && cnts[queue.peek()] > 1)
                    queue.poll();
            }
            for (int i = 0;i < str.length();i++){
                if (!queue.isEmpty() && queue.peek() == str.charAt(i))
                    return i;
            }
            return -1;
        }
    }
}
