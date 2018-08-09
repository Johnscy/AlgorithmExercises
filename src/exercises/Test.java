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
        int max = 1;
        long[][] positive = new long[n + 1][k + 1];
        long[][] negetive = new long[n + 1][k + 1];
        for (int i = 1; i < ; i++) {

        }

        System.out.println(max);
        }
    }
}


