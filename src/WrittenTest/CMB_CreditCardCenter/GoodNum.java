package WrittenTest.CMB_CreditCardCenter;
import java.util.*;

public class GoodNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i))
                res++;
        }
        System.out.println(res);
    }
    private static boolean isGoodNumber(int k){
        String num = k+"";
        char[] c = num.toCharArray();
        for (int i = 0; i < num.length(); i++) {
            if (c[i] == '3' || c[i] == '4' || c[i] == '7')
                return false;
            else if (c[i] == '2')
                c[i] = '5';
            else if (c[i] == '5')
                c[i] = '2';
            else if (c[i] == '6')
                c[i] = '9';
            else if (c[i] == '9')
                c[i] = '6';
        }
        if (new String(c).equals(num))
            return false;
        else
            return true;
    }
}
