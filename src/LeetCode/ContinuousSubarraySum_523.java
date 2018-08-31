package LeetCode;
import java.util.HashMap;

/**
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
 * that is, sums up to n*k where n is also an integer.
 */
public class ContinuousSubarraySum_523 {
    //求余，然后加上下一个元素继续求余，一直继续。如果之后出现的求余结果和以前某次一样，说明这中间一段的和为k的倍数。
    class Solution_HashMap {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums == null || k < 0)
                return false;
            if (k == 0){
                for (int i = 0;i < nums.length;i++){
                    if (nums[i] !=0 && nums[i + 1] != 0);
                    else
                        return true;
                }
                return false;
            }
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(){{put(0 , -1);}};; //!!!!往map里初始化0，-1
            int runningSum = 0;
            for (int i = 0;i < nums.length;i++){
                runningSum += nums[i];
                if (k != 0) runningSum %= k;
                Integer prev = map.get(runningSum);
                if (prev != null)
                    if (i - prev > 1)   //至少两个元素，相隔要大于1
                        return true;
                else
                    map.put(runningSum,i);
            }
            return false;
        }
    }

    //DP，用新数组存前i个值的和，然后两个相减，得出一段区间的和，看能不能被k整除。
    class Solution_DP {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums == null || k < 0)
                return false;
//            if (k == 0){
//                for (int i = 0;i < nums.length;i++){
//                    if (nums[i] !=0 && nums[i + 1] != 0);
//                    else
//                        return true;
//                }
//                return false;
//            }
            int[] sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 1;i < sums.length;i++)
                sums[i] = sums[i - 1] + nums[i - 1];
            for (int i = 2;i < sums.length;i++)
                for (int j = i - 2;j >= 0;j--){ //sums[i] - sums[j]之间包含的元素大于等于2个
                    if (k == 0 && (sums[i] - sums[j] == k))
                        return true;
                    if (k!= 0 && (sums[i] - sums[j]) % k == 0)
                        return true;
                }
            return false;
        }
    }
}
