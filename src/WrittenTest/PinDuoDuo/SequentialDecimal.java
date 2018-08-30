package WrittenTest.PinDuoDuo;
import java.util.*;

public class SequentialDecimal {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        List remainderList = new ArrayList();
        int start;
        int index = -1;
        boolean flag = false;
        while(true){
            int remainder = a % b;
            if(a < b || remainder < b){
                flag = true;
            }
            if(flag){
                index++;
            }
            if(remainder == 0){
                System.out.print(index + " " + 0);
                return;
            }
            if(flag){
                start = remainderList.indexOf(remainder);
                if(start >= 0)
                    break;
                else
                    remainderList.add(remainder);
            }
            a = remainder * 10;
        }
        System.out.print(start + " " + (index - start));
    }
}
