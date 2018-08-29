package WrittenTest.zz360;
import java.util.*;

public class WatchFlowers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1;i <= n;i++) {
            dp[i][in.nextInt()]++;
            for (int j = 1; j <= m; j++)
                dp[i][j] += dp[i - 1][j];
        }
        int Q = in.nextInt();
        while (Q-- > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                if (dp[r][i] - dp[l - 1][i] > 0)
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
