package WrittenTest.BeiKe;
import java.util.Scanner;

public class Attack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long X = sc.nextInt();
            long A = sc.nextInt();
            long C = sc.nextInt();
            long Y = sc.nextInt();
            long B = sc.nextInt();
            long D = sc.nextInt();
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
            long t1 = X / B, t2 = Y / A;
            long time1 = D * t1, time2 = C * t2;
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
