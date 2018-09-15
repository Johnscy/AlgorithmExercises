package LeetCode;

import java.util.*;

/**
 * Given a string S, check if the letters can be rearranged so that
 * two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.
 * If not possible, return the empty string.
 *
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 *
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 *
 * Note:
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString_767 {
    //PriorityQueue + HashMap
    class Solution {
        public String reorganizeString(String S) {
            if (S == null || S.length() <= 1)
                return "";
            Map<Character,Integer> map = new HashMap<>();
            for(char c : S.toCharArray()) {
                int count = map.getOrDefault(c, 0) + 1;
                if (count > (S.length() + 1) / 2) return "";
                map.put(c,count);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1] - a[1]));
            for (char c: map.keySet())
                pq.add(new int[]{c,map.get(c)});
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()){
                int[] first = pq.poll();
                if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) { // 不和上一个字母相同
                    sb.append((char) first[0]);
                    if (--first[1] > 0)
                        pq.add(first);
                } else {
                    int[] second = pq.poll();
                    sb.append((char)second[0]);
                    if (--second[1] > 0)
                        pq.add(second);
                    pq.add(first);
                }
            }
            return sb.toString();
        }
    }

    //
    class Solution_BucketSort {
        public String reorganizeString(String S) {
            if (S == null || S.length() <= 1)
                return "";
            int[] counts = new int[26];
            int max = Integer.MIN_VALUE;int  maxIndex = 0;
            for (int i = 0; i < S.length(); i++) {
                int  index = S.charAt(i) - 'a';
                counts[index]++;
                max = Math.max(counts[index],max);  //获取数量最多的字母的数量
                maxIndex = max == counts[index] ? index : maxIndex; //获取此索引，即字母
            }
            if (S.length() - max < max - 1)
                return "";
            else{
                char[] sb = new char[S.length()];
                int k = 0;
                while (counts[maxIndex]-- > 0){
                    sb[k] = (char)(maxIndex + 'a');
                    k += 2;
                }
                for (int i = 0; i < 26; i++) {  //26个字母的数量遍历下
                    while (counts[i]-- > 0){
                        if (k >= S.length()) //!!!!
                            k = 1;
                        sb[k] = (char)(i + 'a');
                        k += 2;
                    }
                }
                return new String(sb);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String res =new ReorganizeString_767().new Solution_BucketSort().reorganizeString(input);
        System.out.println(res);
    }
}
