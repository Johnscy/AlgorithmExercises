package Target_To_Offer;

import java.util.HashMap;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {
    //要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
    // 牛客网讨论区这一题的首票答案使用 nums[i] + length 来将元素标记，这么做会有加法溢出问题。

    //这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上！！！！！！！
    public class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[],int length,int [] duplication) {
            if (numbers == null || length <= 0)
                return false;
            for (int i = 0;i < length;i++){ //检查数组元素是否合法：每个元素都∈[0,length - 1]
                if (numbers[i] < 0 || numbers[i] > length - 1)
                    return false;
            }
            for (int i = 0;i < length;i++){     //这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上
                while (numbers[i] != i){        //当numbers[i]的值不是i的话，进入循环
                    if (numbers[i] == numbers[numbers[i]]){ //在上面的条件下，当序号为i和number[i]的元素相等时，说明出现了相同元素
                        duplication[0] = numbers[i];
                        return true;
                    }
                    swap(numbers,i,numbers[i]); //交换序号为i和numbers[i]的元素
                }
            }
            return false;
        }
        private void swap(int[] nums, int i, int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    //常规的HashMap
    public class Solution_HashMap {
        public boolean duplicate(int numbers[],int length,int [] duplication) {
            if (numbers == null || length <= 0)
                return false;
            for (int i = 0;i < length;i++){ //检查数组元素是否合法：每个元素都∈[0,length - 1]
                if (numbers[i] < 0 || numbers[i] > length - 1)
                    return false;
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int num : numbers){
                if (map.containsKey(num)){
                    int cnt = map.get(num);
                    map.put(num,++cnt);
                }else
                    map.put(num,1);
            }
            for (int num : numbers){
                if (map.get(num) > 1){
                    duplication[0] = num;
                    return true;
                }
            }
            return false;
        }
    }

//2-bitmap 位图,可以处理大数据量的重复、排序等
    public class Solution_2BitMap {
        public boolean duplicate1(int numbers[], int length, int[] duplication) {
        //一个Int是4字节 4*8=32位,用2位表示一个数有无重复 00表示没有出现 01 表示出现一次 10表示出现两次
            int arrSize=(int)Math.ceil((double)length/16);//确定我们需要开辟多少的int空间，16=32(int的位数)/2(2位表示)
            int arr[] = new int[arrSize];
            for(int i=0;i<length;i++){
                int x=numbers[i];
                int m=x>>4;//x/16; m表示确定到arr数组中的第几个
                int n=x&15;//x%16; n表示确定到int中的第几位
                //(arr[m]&(0x3<<(2*n)))>>(2*n) 0x3:二进制表示11,把11左移2*n位;arr[m]&(0x3<<(2*n)):获取两位的值,右移将值取出来
                int cnt=(arr[m]&(0x3<<(2*n)))>>(2*n);
                //如果值小于2,表示要么对应的次数 要么有一次，要么没有
                if(cnt < 2){
                    cnt++;
                    //清空对应的值,同时保证其他位上的数字不变(所以要用~)
                     arr[m]&=~((0x3<<(2*n)));
                    //赋值相加
                    arr[m]|=cnt<<(2*n);
                }
             }
             //判断重复
            for(int i=0;i<length;i++){
                int m=numbers[i]>>4;
                int n=numbers[i]&15;
                if((arr[m]&(0x3<<(2*n)))>>(2*n)==2){
                    duplication[0]=numbers[i];
                    return true;
                }
            }
            return false;
        }
    }

}
