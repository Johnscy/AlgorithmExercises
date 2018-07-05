package Target_To_Offer;
import java.util.*;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class GetLeastNumbers {
    //快速选择
    //复杂度：O(N) + O(1)
    //只有当允许修改数组元素时才可以使用
    //快速排序的partition()方法，会返回一个整数j使得a[l..j-1]小于等于a[j]，且a[j+1..h]大于等于a[j]，此时a[j]就是数组的第j大元素。
    // 可以利用这个特性找出数组的第K个元素，这种找第K个元素的算法称为快速选择算法。
    public class Solution_QuickSelect {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> res = new ArrayList<>();
            if (k > input.length || k <= 0 || input.length ==0)
                return res;
            findKthSmallest(input,k-1);
            for (int i = 0;i < k;i++)
                res.add(input[i]);
            return res;
        }
        private void findKthSmallest(int[] arr, int k){
            int l = 0, h = arr.length - 1;
            while (l < h){
                int j = partition(arr,l,h);
                if (j == k) break;
                if (j > k)  h = j - 1;
                else        l = j + 1;
            }

        }
        private int partition(int[] arr, int low, int high){
            int i = low, j = high + 1;
            int cmp = arr[low];
            while (true){
                while (i < high && arr[++i] < cmp);
                while (j >low && arr[--j] > cmp);
                if (i >= j) break;
                swap(arr,i,j);
            }
            swap(arr,low,j);
            return j;
        }
        private void swap(int[] arr, int i, int j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    //优先队列。
    // 建一个大小为 K 的最小堆，用大顶堆来实现
    //复杂度：O(NlogK) + O(K)
    //特别适合处理海量数据
    //应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
    //维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
    public class Solution_Heap {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            if (k > input.length || k <= 0 || input.length ==0)
                return new ArrayList<Integer>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));//!!!!!!!
            for (int element : input){
                maxHeap.add(element);
                if (maxHeap.size() > k)
                    maxHeap.poll();
            }
            return new ArrayList<>(maxHeap);
        }
    }
}
