package WrittenTest.IQIYI;
import java.util.*;

public class Rank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();sc.nextLine();
        int[] Ai = new int[N + 1];
        for (int i = 1; i <= N; i++)
            Ai[i] = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            String[] str = sc.nextLine().split(" ");
            if (str[0].equals("A"))
                Ai[Integer.valueOf(str[1])]++;
            else if (str[0].equals("B"))
                Ai[Integer.valueOf(str[1])]--;
        }
        int k = Ai[P];
        Arrays.sort(Ai);
        int index = 1;
        for (int i = N; i >= 1; i--) {
            if (Ai[i] != k)
                index++;
            else
                break;
        }
        System.out.println(index);
    }
}