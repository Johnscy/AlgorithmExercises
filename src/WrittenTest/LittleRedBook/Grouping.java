package WrittenTest.LittleRedBook;
import java.util.*;

//未AC，90+%
public class Grouping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        int q = sc.nextInt();sc.nextLine();
        if(n <= 1 || q < 1){
            System.out.println(1);
            return;
        }
        boolean[][] matrix = new boolean[n + 1][n + 1];
        for (int i = 0; i < q; i++) {
            int child = sc.nextInt();
            int without = sc.nextInt();
            matrix[child][without] = true;
        }
        for (int i = 1; i <= n; i++)
            for (int j = i+1; j <= n ; j++)
                if(matrix[i][j] )
                    for (int k = j+1; k <= n; k++)
                        if(matrix[i][k] && matrix[j][k]){
                            System.out.println(0);
                            return;
                        }
        System.out.println(1);
    }
}