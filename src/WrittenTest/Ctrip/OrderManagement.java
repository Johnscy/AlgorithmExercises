package WrittenTest.Ctrip;
import java.util.*;

public class OrderManagement {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int find = sc.nextInt();
            int[] nums = new int[N];
            int[] startD = new int[N];
            int[] endD = new int[N];
            ArrayList<Integer> re = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
                startD[i] = sc.nextInt();
                endD[i] = sc.nextInt();
                if( find>=startD[i] && find<= endD[i]){
                    re.add(nums[i]);
                }
            }
            if(re.size() == 0){
                System.out.println("null");
                return;
            }
            Collections.sort(re);
            for (Integer i:re) {
                System.out.println(i);
            }
        }

}

