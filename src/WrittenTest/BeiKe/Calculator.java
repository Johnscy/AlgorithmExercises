package WrittenTest.BeiKe;
import java.util.Scanner;

/**
 * 计算器只能*2 和 -1，输入N要求变成M，求最少步骤。
 */
public class Calculator {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt(), M = in.nextInt();
            int count = 0;
            if (N >= M){
                count = N - M;
                System.out.print(count);
                return;
            }
            if (M % 2 != 0) {
                count++;
                M += 1;
            }
            while (M % 2 == 0) {
                M /= 2;
                count++;
            }
            while (M != N){
                if (M % 2 != 0) {
                    M += 1;
                    count++;
                }
                else {
                    M /= 2;
                    count++;
                }
            }
            System.out.print(count);
            return;
        }
}
