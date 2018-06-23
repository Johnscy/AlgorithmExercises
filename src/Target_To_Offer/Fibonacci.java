package Target_To_Offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class Fibonacci {

    //非递归
    public class Solution1 {
        public int Fibonacci(int n) {
            if (n <= 1) return n;
            int[] fib = new int[n+1];
            for (int i = 2;i <= n;i++)
                fib[i] = fib[i-1]+fib[i-2];
            return fib[n];
        }
    }
    public class Solution2 {
        public int Fibonacci(int n) {
            if (n <= 1) return n;
            int fib1 = 0, fib2 = 1;
            int fib3 = 0;
            for (int i = 2;i <= n;i++){
                fib3 = fib1 + fib2;
                fib1 = fib2;
                fib2 = fib3;
            }
            return fib3;
        }
    }
    //最简
    public class Solution {
        public int Fibonacci(int n) {
            if (n <= 1) return n;
            int f = 0, g = 1;
            while (n-- > 0){
                g += f;
                f = g - f;
            }
            return f;
        }
    }
    //递归
    public class Solution3 {
        public int Fibonacci(int n) {
            if (n <= 1) return n;
            return Fibonacci(n-1) + Fibonacci(n - 2);
        }
    }
}
