package exercises;
import java.util.*;

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s = sc.nextLine();
//            char[] chars = s.toCharArray();
//            for(int i = 0; i < chars.length; i++){
//                if (chars[i] >= 'a' && chars[i] <= 'z')
//                    chars[i] -= 32;
//                else if (chars[i] >= 'A' && chars[i] <= 'Z')
//                    chars[i] += 32;
//            }
//            System.out.println(new String(chars));
//        }
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] value = sc.nextLine().split(",");
//        String[] weight = sc.nextLine().split(",");
//        int[] v = new int[value.length];
//        int[] w = new int[weight.length];
//        for (int i = 0;i < value.length;i++)
//            v[i] = Integer.valueOf(value[i]);
//        for (int i = 0; i < weight.length; i++)
//            w[i] = Integer.valueOf(weight[i]);
//        int bagSize = sc.nextInt();
//        int[][] dp = new int[6][bagSize + 1];
//        int temp1, temp2;
//        for (int i = 1; i <= 5; i++) {
//            dp[i][0] = 0;
//            for (int j = 1; j <= bagSize; j++) {
//                if (w[i - 1] > j)
//                    dp[i][j] = dp[i - 1][j];
//                else {
//                    temp1 = v[i - 1] + dp[i - 1][j - w[i - 1]];
//                    temp2 = dp[i - 1][j];
//                    dp[i][j] = (temp1 > temp2 ? temp1 : temp2);
//                }
//            }
//        }
//        System.out.println(dp[5][bagSize]);
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//            String[] typeDef = sc.nextLine().split(";");
//            String custom = sc.nextLine();
//            String[] custom_split = custom.split(" ");
//            if (custom_split[0].equals("*")) {
//                System.out.println("none");
//                return;
//            }
//        for (int i = 0; i < typeDef.length; i++) {
//            String[] eachDef = typeDef[i].split(" ");
//            //for (int j = 1; j < eachDef.length; j++) {
//            if (custom_split[0].equals(eachDef[eachDef.length - 1]))
//
//
//
//            }
//        }
//        System.out.println("none");
//        }
//    }

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        long[][] positive = new long[n + 1][k + 1]; //positive[i][k]:最后选择的人的序号是i，一共选了k个人。乘积是最大正数。
        long[][] negetive = new long[n + 1][k + 1]; //negetive[i][k]:最后选择的人的序号是i，一共选了k个人。乘积是最小负数。
        for (int i = 1; i <= n; i++) {
            positive[i][1] = a[i];
            negetive[i][1] = a[i];
        }
        long tempPositive = 0, tempNegetive = 0;
        for (int kk = 2; kk <= k; kk++) {
            for (int i = kk; i <= n; i++) {
                tempPositive = Integer.MIN_VALUE;
                tempNegetive = Integer.MAX_VALUE;
                for (int j = Math.max(kk - 1, i - d); j <= i - 1; j++) {
                    if (tempPositive < Math.max(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]))
                        tempPositive = Math.max(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]);
                    if (tempNegetive > Math.min(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]))
                        tempNegetive = Math.max(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]);
                }
                positive[i][kk] = tempPositive;
                negetive[i][kk] = tempNegetive;
            }
        }
        long res = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            if (res < positive[i][k])
                res = positive[i][k];
        }
        System.out.println(res);
        }
    }



