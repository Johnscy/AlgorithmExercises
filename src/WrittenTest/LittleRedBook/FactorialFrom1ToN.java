package WrittenTest.LittleRedBook;
import java.util.*;

public class FactorialFrom1ToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        if (n <= 0) {
            System.out.println(res);
            return;
        }
        int[] dp = new int[n + 1];
        for (int i = 5; i <= n; i++) {
            int temp = 0;
            int k = i;
            while (k != 0) {
                k /= 5;
                temp += k;
                dp[i] = dp[k / 5] + temp;
            }
        }
        for (int i = 1; i <= n; i++) {
            res += dp[i];
        }
        System.out.println(res);
    }
}

/*public class FactorialFrom1ToN_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n==0) {
            System.out.println(1);
            return ;
        }
        int[] dp5 = new int[n+1];
        for(int i=1;i<=n;i++) {
            int count=0;
            int k = i;
            while(k%5==0) {
                k = k/5;
                count++;
            }
            dp5[i] = dp5[i-1]+count;
        }
        int count5 = 0;
        for(int i =1;i<=n;i++) {
            count5 +=dp5[i];
        }
        System.out.println(count5);
    }
}*/
