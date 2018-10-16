package WrittenTest.BeiKe;
import java.util.Scanner;

public class Attack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int X = sc.nextInt();
            int A = sc.nextInt();
            int C = sc.nextInt();
            int Y = sc.nextInt();
            int B = sc.nextInt();
            int D = sc.nextInt();
            if (X <= B && Y <= A){
                System.out.println("TIE");
                continue;
            }else if (X <= B && Y > A){
                System.out.println("XIAOCHUN");
                continue;
            }else if (X > B && Y <= A){
                System.out.println("XIAOZHI");
                continue;
            }
            int t1 = X / B, t2 = Y / A;
            int time1 = D * t1, time2 = C * t2;
            if (X % B == 0) time1 -= D;
            if (Y % A == 0) time2 -= C;
            if (time1 == time2)
                System.out.println("TIE");
            else  if (time1 > time2)
                System.out.println("XIAOZHI");
            else
                System.out.println("XIAOCHUN");
        }
    }
}
