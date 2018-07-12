package Target_To_Offer;
import java.util.ArrayList;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {
    public class Solution {
        public int[] multiply(int[] A) {
            if (A == null || A.length == 0)
                return null;
            int n = A.length;
            int[] B = new int[n];
            for (int i = 0,product = 1;i < n;product *= A[i],i++)
                B[i] = product;
            for (int i = n - 1, product = 1;i >= 0;product *= A[i],i--)
                B[i] *= product;
            return B;
        }
    }
}
