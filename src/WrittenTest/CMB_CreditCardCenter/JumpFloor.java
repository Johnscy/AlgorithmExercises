package WrittenTest.CMB_CreditCardCenter;
import java.util.*;

public class JumpFloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 2) {
            System.out.print(n);
            return;
        }
        int fn = 0;
        int fib1 = 1, fib2 = 2;
        for (int i = 3;i <= n;i++){
            fn = fib1 + fib2;
            fib1 = fib2;
            fib2 = fn;
        }
        System.out.print(fn);
    }
}
