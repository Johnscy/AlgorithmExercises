package WrittenTest.JD;
import java.util.*;

public class Comparison {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        int[][] input = new int[n][3];
        for (int i = 0; i < n; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            input[i][2] = sc.nextInt();
            sc.nextLine();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (input[j][0] > input[j][0] && input[j][1] > input[i][1] && input[j][2] > input[i][2]){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}



