package exercises;
import java.util.*;
public class LCS{
    public static void main(String args[]){
        Scanner sc  =   new Scanner(System.in);
        char[] str1 =   sc.next("\\w+").toCharArray();
        char[] str2 =   sc.next("\\w+").toCharArray();
        int dp[][]  =   new int[str1.length][str2.length];
        int maxLen  =   0;
        int end     =   0;
        for(int i = 0;i < str1.length;i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j])
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = 0;
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    end = i;
                }
            }
        }
        System.out.print("result = ");
        if(maxLen == 0)
            System.out.print("null");
        else
            for(int k = end - maxLen + 1;k <= end;k++){
                System.out.print(str1[k]);
            }
        System.out.println();
    }
}