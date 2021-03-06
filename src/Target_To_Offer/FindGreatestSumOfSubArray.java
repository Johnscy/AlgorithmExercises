package Target_To_Offer;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    //动态规划DP
    public class Solution_1 {
        public int FindGreatestSumOfSubArray(int[] array) {
            if (array == null || array.length == 0)
                return 0;
            int res = Integer.MIN_VALUE;    //最大和的结果
            int sum = 0;    //过程中的累加值
            for (int element : array){
                sum = sum <= 0 ? element : element + sum;
                res = Math.max(sum,res);
            }
            return res;
        }
    }

    public class Solution_2 {
        public int FindGreatestSumOfSubArray(int[] array) {
            if (array == null || array.length == 0)
                return 0;
            int res = array[0];    //最大和的结果
            int sum = array[0];    //过程中的累加值
            for (int i = 1;i < array.length;i++){
                sum = Math.max(array[i],array[i] + sum);
                res = Math.max(sum,res);
            }
            return res;
        }
    }
}
