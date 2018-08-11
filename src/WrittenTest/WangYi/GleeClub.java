package WrittenTest.WangYi;
import java.util.*;

/**
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
 * 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 * 输出描述:
 * 输出一行表示最大的乘积。
 */
public class GleeClub {
    //class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();
            long[][] positive = new long[n + 1][k + 1]; //positive[i][k]:最后选择的人的序号是i，一共选了k个人。乘积是最大正数。
            long[][] negetive = new long[n + 1][k + 1]; //negetive[i][k]:最后选择的人的序号是i，一共选了k个人。乘积是最小负数。
            for (int i = 1; i <= n; i++) {
                positive[i][1] = a[i];
                negetive[i][1] = a[i];
            }
            long tempPositive, tempNegetive;
            for (int kk = 2; kk <= k; kk++) {
                for (int i = kk; i <= n; i++) {
                    tempPositive = Long.MIN_VALUE;
                    tempNegetive = Long.MAX_VALUE;
                    for (int j = Math.max(kk - 1, i - d); j <= i - 1; j++) {
                        if (tempPositive < Math.max(positive[j][kk - 1] * a[i], negetive[j][kk - 1] * a[i]))
                            tempPositive = Math.max(positive[j][kk - 1] * a[i], negetive[j][kk - 1] * a[i]);
                        if (tempNegetive > Math.min(positive[j][kk - 1] * a[i], negetive[j][kk - 1] * a[i]))
                            tempNegetive = Math.min(positive[j][kk - 1] * a[i], negetive[j][kk - 1] * a[i]);
                    }
                    positive[i][kk] = tempPositive;
                    negetive[i][kk] = tempNegetive;
                }
            }
            long res = Long.MIN_VALUE;
            for (int i = k; i <= n; i++) {
                if (res < positive[i][k])
                    res = positive[i][k];
            }
            System.out.println(res);
        }
    //}
}
