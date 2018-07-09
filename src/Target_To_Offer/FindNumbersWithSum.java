package Target_To_Offer;
import java.util.*;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
    //双指针法
    //找到的第一组（相差最大的）就是乘积最小的。可以这样证明：考虑x+y=C（C是常数），x*y的大小。
    // 不妨设y>=x，y-x=d>=0，即y=x+d, 2x+d=C, x=(C-d)/2, x*y=x(x+d)=(C-d)(C+d)/4=(C^2-d^2)/4，也就是x*y是一个关于变量d的二次函数，对称轴是y轴，开口向下。
    // d是>=0的，d越大, x*y也就越小。
    public class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
            ArrayList<Integer> res = new ArrayList<>();
            if (array.length == 0 || array == null || sum <= array[0])
                return res;
            int start = 0, end = array.length - 1;
            while (start < end){
                int S = array[start] + array[end];
                if (S == sum){      //找到的第一组就是乘积最小的！！！
                    res.add(array[start]);
                    res.add(array[end]);
                    break;
                }
                else if (S < sum)
                    start++;
                else
                    end--;
            }
            return res;
        }
    }


    //用HashMap存放元素和下标，然后开始遍历数组找到和为sum的两个元素，从左到右找到的第一对和为sum的就是最小的一对。
    public class Solution_HashMap {
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            HashMap<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> result = new ArrayList<>();
            int len = array.length;
            for (int i = 0; i < len; i++)
                map.put(array[i], i);
            for (int i = 0; i < len; i++) {
                int sub = sum - array[i];
                if (map.containsKey(sub)) {
                    result.add(array[i]);
                    result.add(sub);
                    break;
                }
            }
            return result;
        }
    }
}
