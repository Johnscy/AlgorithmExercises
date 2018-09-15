package WrittenTest.IQIYI;
import java.util.*;

public class MinReplaceTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] c = input.toCharArray();
        int num1 = 0, num2 = 0;
        int count = 0;
        for (int i = 0; i <= 2; i++) {
            num1 += c[i] - '0';
            num2 += c[i + 3] - '0';
        }
        int gap = num2 - num1;
        PriorityQueue<Character> pq1 = new PriorityQueue<>();//和小的
        PriorityQueue<Character> pq2 = new PriorityQueue<>((o1,o2)->(o2 - o1));//和大的
        for (int i = 0; i <= 2; i++) {
            if (gap < 0) {
                pq1.add(c[i + 3]);
                pq2.add(c[i]);
            } else {
                pq1.add(c[i]);
                pq2.add(c[i + 3]);
            }
        }
        gap = Math.abs(gap);
        if (gap == 0){
            System.out.print(count);
            return;
        }else if (gap <= '9' - pq1.peek() || gap <= pq2.poll() - '0'){
            count++;
            System.out.print(count);
            return;
        }
        while (gap > 0) {
            int add = '9' - pq1.poll();
            int minus = pq2.poll();
            gap -= Math.max(add,minus);
            count++;
        }
        System.out.println(count);
    }
}