package Target_To_Offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    //二分查找QAQ
    public class Solution {
        public int GetNumberOfK(int [] array , int k) {
            if (array == null || array.length == 0)
                return 0;
            int FirstK = BinarySearch(array,0,array.length,k);
            int LastK = BinarySearch(array,0,array.length,k + 1);
            return (FirstK == array.length || array[FirstK] != k) ? 0 : (LastK - FirstK);
        }
        //递归写法
        private int BinarySearch(int[] arr, int lo, int hi, int k){
            if (lo == hi)   return lo;
            int mid = (lo + hi) >> 1;
            if (arr[mid] >= k)           return BinarySearch(arr,lo,mid,k);
            else if (arr[mid] < k)       return BinarySearch(arr,mid + 1,hi,k);
            return 128;//随便return什么，因为递归会在lo == hi处结束XD
        }
        //非递归，循环写法
/*        private int BinarySearch(int[] arr, int lo, int hi, int k){
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (arr[mid] >= k) //!!!!!!!
                    hi = mid;
                else if (arr[mid] < k)
                    lo = mid + 1;
            }
            return lo;
        }*/
    }
}
