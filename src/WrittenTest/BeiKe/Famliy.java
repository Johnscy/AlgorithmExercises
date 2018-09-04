package WrittenTest.BeiKe;
import java.util.HashMap;
import java.util.Scanner;

public class Famliy {
    private static int findParent(HashMap<Integer,Integer> map, int num1, int num2){
        int temp = num1;
        while (map.get(temp) != -1){
            if (map.get(temp) == num2)
                return 2;
            temp = map.get(temp);
        }
        temp = num2;
        while (map.get(temp) != -1){
            if (map.get(temp) == num1)
                return 1;
            temp = map.get(temp);
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();in.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt();
            in.nextLine();
            map.put(a, b);
        }
        int m = in.nextInt();in.nextLine();
        int[][] pair = new int[m][2];
        for (int i = 0; i < m; i++) {
            pair[i][0] = in.nextInt();
            pair[i][1] = in.nextInt();
            //in.nextLine();
        }
        for (int i = 0; i < m; i++)
            System.out.println(findParent(map, pair[i][0], pair[i][1]));
    }
}
