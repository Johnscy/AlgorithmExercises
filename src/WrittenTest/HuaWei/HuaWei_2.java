package WrittenTest.HuaWei;
import java.util.*;

//0 - 1背包问题，DP
public class HuaWei_2 {
    //class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] value = sc.nextLine().split(",");
            String[] weight = sc.nextLine().split(",");
            int[] v = new int[value.length];
            int[] w = new int[weight.length];
            for (int i = 0;i < value.length;i++)
                v[i] = Integer.valueOf(value[i]);
            for (int i = 0; i < weight.length; i++)
                w[i] = Integer.valueOf(weight[i]);
            int bagSize = sc.nextInt();
            int[][] dp = new int[6][bagSize + 1];
            int temp1, temp2;
            for (int i = 1; i <= 5; i++) {
                dp[i][0] = 0;
                for (int j = 1; j <= bagSize; j++) {
                    if (w[i - 1] > j)
                        dp[i][j] = dp[i - 1][j];
                    else {
                        temp1 = v[i - 1] + dp[i - 1][j - w[i - 1]];
                        temp2 = dp[i - 1][j];
                        dp[i][j] = (temp1 > temp2 ? temp1 : temp2);
                    }
                }
            }
            System.out.println(dp[5][bagSize]);
        }
    //}
}
