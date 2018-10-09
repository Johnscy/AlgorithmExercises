package WrittenTest.ByteDance;
import java.util.Scanner;

/**
 * 给定一个包含1-9数字的字符串（长度4-12），字符串的每个位置都可以加一个“+”或者“-”。
 * 要求最后形成合法的算是，并计算出和为0的组合数量。
 */
public class TargetSum {
    private static int num = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();scan.nextLine();
        String[] strs = new String[n];
        int[] nums = new int[n];
        for(int i = 0;i < n;i++) {
            strs[i] = scan.nextLine();
        }
        for(int i = 0;i < n;i++) {
            num = 0;
            dfs(strs[i],0);
            nums[i] = num;
        }
        for(int i = 0;i < n;i++) {
            System.out.println(nums[i]);
        }
    }
    private static void dfs(String string, int sum) {
        // TODO Auto-generated method stub
        if(string == null || string.length() == 0) {
            if(sum == 0) {
                num++;
            }
            return;
        }
        for(int i = 0;i < string.length();i++) {
            String str = string.substring(0, i+1);
            int n = Integer.parseInt(str);
            sum += n;
            dfs(string.substring(i+1),sum);
            sum -= 2*n;
            dfs(string.substring(i+1),sum);
            sum += n;
        }
    }

}