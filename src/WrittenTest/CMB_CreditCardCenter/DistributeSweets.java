package WrittenTest.CMB_CreditCardCenter;
import java.util.*;

public class DistributeSweets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        for (String s: s1)
            pq1.add(Integer.valueOf(s));
        for (String s: s2)
            pq2.add(Integer.valueOf(s));
        int res = 0;
        while(!pq2.isEmpty()){
            if (pq1.isEmpty())
                break;
            if (pq2.peek() >= pq1.peek()){
                res++;
                pq1.poll();
                pq2.poll();
            }else {
                pq2.poll();
            }
        }
        System.out.print(res);
    }
}
