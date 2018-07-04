package Target_To_Offer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    //骚操作 Boyer-Moore Majority Vote Algorithm
    //思路：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
    // 如果存在这个数，遇到它一次+1，遇到其他-1，则最后一定会大于0；
    // 但是最后大于0，对应的那个数不一定出现次数超过数组长度一半，所以要验证。
    public class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length <= 0)
                return 0;
            int majority = 0;   //记录数字
            int cnt = 0;        //遇到相同数字+1，不同-1
            for (int i = 0;i < array.length;i++){
                if (cnt == 0){
                    majority = array[i];
                    cnt++;
                }else
                    cnt = (array[i] == majority) ? cnt + 1 : cnt - 1;
            }
            int times = 0;  //检查出现次数是否大于数组长度的一半
            for (int val : array)
                if (val == majority)
                    times++;
            return times * 2 > array.length ? majority : 0;
        }
    }

    //Hashmap存放数字和出现次数
    public class Solution_Hashmap {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length <= 0)
                return 0;
            HashMap<Integer,Integer> map = new HashMap<>(); //键记录数字，值记录出现次数
            for (int i = 0;i < array.length;i++)
                if (map.containsKey(array[i])) {
                    int count = map.get(array[i]);
                    map.put(array[i],++count);
                }
                else
                    map.put(array[i],1);
            for (Map.Entry<Integer,Integer> entry : map.entrySet())
                if (entry.getValue() * 2 > array.length)
                    return entry.getKey();
            return 0;
        }
    }

    //用到快排中的思想。通过快排找中位数，如果等于中位数的个数>len/2，则找到了
    public class Solution_sort {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length <= 0)
                return 0;
            int len =array.length;
            int middle = partition(array,0,len - 1);
            while (middle != len/2){
                if (middle < len/2)
                    middle = partition(array,middle + 1,len - 1);
                else if (middle > len/2)
                    middle = partition(array,0,middle - 1);
            }
            //此时已找到中位数的位置middle
            int times = 0;  //检查出现次数是否大于数组长度的一半
            for (int val : array)
                if (val == array[middle])
                    times++;
            return times * 2 > array.length ? array[middle] : 0;

        }
        private int partition(int[] arr, int start, int end){
            if (arr == null || arr.length == 0) return 0;
            int flag = arr[start];
            while (start < end){
                while (start < end && arr[end] >= flag)
                    end--;
                arr[start] = arr[end];
                while (start < end && arr[start] <= flag)
                    start++;
                arr[end] = arr[start];
            }
            arr[start] = flag;  //把用来切分的元素放回中间
            return start;
        }
    }

    //先排序再。。。不推荐（数组大了不好处理）
    public class Solution_QAQ {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length <= 0)
                return 0;
            Arrays.sort(array);
            int count = 0;
            for (int i = 0;i < array.length;i++)
                if (array[i] == array[array.length/2])
                    ++count;
            return (count * 2 > array.length) ? array[array.length/2] : 0;
        }
    }

}
