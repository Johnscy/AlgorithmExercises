package Target_To_Offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class InversePairs {
    //用归并排序。。里面交换逆序对，对其进行计数。
    public class Solution {
        private long count = 0; //计数君
        private int[] copy;     //辅助数组
        public int InversePairs(int [] array) {
            copy = new int[array.length];
            sort(array,0,array.length - 1);
            return (int)(count % 1000000007);
        }

        private void sort(int[] arr, int lo, int hi){
            if (lo >= hi)   return;
            int mid = (hi - lo) / 2 + lo;
            sort(arr,lo,mid);
            sort(arr,mid + 1,hi);
            merge(arr,lo,mid,hi);
        }
        private void merge(int[] arr, int lo, int mid, int hi){ //将有序的arr[lo,mid]与arr[mid+1,hi]归并到arr[lo,hi]
            int i = lo, j = mid + 1;
            for (int k = lo;k <= hi;k++)
                copy[k] = arr[k];
            for (int k = lo;k <= hi;k++){
                if (i > mid)        arr[k] = copy[j++];
                else if(j > hi)     arr[k] = copy[i++];
                else if(copy[i] < copy[j])  arr[k] = copy[i++];
                else                {
                    arr[k] = copy[j++];
                    this.count += mid - i + 1;  // copy[i] >= copy[j]，说明 copy[i...mid] 都大于 copy[j]
                }
            }
        }
    }
}
