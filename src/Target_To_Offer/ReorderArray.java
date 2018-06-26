package Target_To_Offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序。
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路：数出奇数的个数oddCnt。复制数组copy，遍历数组copy（array在变动），然后把偶数放在array[oddCnt]及后面的位置。
 */
public class ReorderArray {
    public class Solution {
        public void reOrderArray(int [] array) {
            int oddCnt = 0;
            for (int val : array)
                if (val % 2 == 1)
                    oddCnt++;
            int[] copy = array.clone();
            int i = 0, j = oddCnt;
            for (int val : copy){
                if (val % 2 == 1)
                    array[i++] = val;
                else
                    array[j++] = val;
            }
        }
    }
}
