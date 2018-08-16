package Exercises;
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

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n + 1];
//        for (int i = 1; i <= n; i++)
//            a[i] = sc.nextInt();
//        int k = sc.nextInt();
//        int d = sc.nextInt();
//        long[][] positive = new long[n + 1][k + 1]; //positive[i][k]:最后选择的人的序号是i，一共选了k个人。乘积是最大正数。
//        long[][] negetive = new long[n + 1][k + 1]; //negetive[i][k]:最后选择的人的序号是i，一共选了k个人。乘积是最小负数。
//        for (int i = 1; i <= n; i++) {
//            positive[i][1] = a[i];
//            negetive[i][1] = a[i];
//        }
//        long tempPositive = 0, tempNegetive = 0;
//        for (int kk = 2; kk <= k; kk++) {
//            for (int i = kk; i <= n; i++) {
//                tempPositive = Integer.MIN_VALUE;
//                tempNegetive = Integer.MAX_VALUE;
//                for (int j = Math.max(kk - 1, i - d); j <= i - 1; j++) {
//                    if (tempPositive < Math.max(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]))
//                        tempPositive = Math.max(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]);
//                    if (tempNegetive > Math.min(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]))
//                        tempNegetive = Math.max(positive[j][k - 1] * a[i], negetive[j][k - 1] * a[i]);
//                }
//                positive[i][kk] = tempPositive;
//                negetive[i][kk] = tempNegetive;
//            }
//        }
//        long res = Integer.MIN_VALUE;
//        for (int i = k; i <= n; i++) {
//            if (res < positive[i][k])
//                res = positive[i][k];
//        }
//        System.out.println(res);
//        }
//    }

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++)
//            a[i] = sc.nextInt();
//        sc.nextLine();
//        int m = sc.nextInt();
//        sc.nextLine();
//        int[] q = new int[m];
//        for (int i = 0; i < m; i++)
//            q[i] = sc.nextInt();
//        int[] res = new int[n];
//        res[0] = a[0];
//        for (int i = 1;i < n;i++)
//            res[i] = a[i] + res[i - 1];
//        for (int i = 0; i < m; i++) {
//            int j = 0, k = n - 1;
//            while (j < k){
//                int mid = (j + k) /2;
//                if (q[i] > res[mid])
//                    j = mid + 1;
//                else if (q[i] < res[mid])
//                    k = mid;
//                else
//                    k = mid;
//            }
//            System.out.println(k + 1);
//        }
//    }
//}


//class Main {
//    public static void main(String[] args) {
//        Scanner in =  new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        in.nextLine();
//        int[] a = new int[n];
//        int[] flags = new int[n];
//        for(int i = 0;i<n;i++) {
//            a[i] = in.nextInt();
//        }
//        in.nextLine();
//        for(int i =0;i<n;i++) {
//            flags[i] = in.nextInt();
//        }
//        in.nextLine();
//        int sum = 0;
//        for(int i =0;i<n;i++) {
//            if(flags[i]==1) {
//                sum += a[i];
//            }
//        }
//        int max = 0;
//
//        for(int i =0;i<n-k;i++) {
//            int tempsum = 0;
//            for(int j = 0;j<k;j++) {
//                if(flags[j+i]==0) {
//                    tempsum += a[j+i];
//                }
//            }
//            if(tempsum>max) {
//                max =tempsum;
//            }
//        }
//        System.out.println(sum+max);
//    }
//}

//class Main {
//    public static TreeSet<String> treeSet = new TreeSet<>();
//    private static void pailie(String s, String temp){
//        if(s.length()==0){
//            treeSet.add(temp);
//            return;
//        }
//        for(int i=0;i < s.length();i++){
//            String news = s.substring(0, i)+ s.substring(i + 1,s.length());
//            pailie(news, temp + s.charAt(i));
//        }
//    }
//private static void FullPermutation(char[] chars,int k, TreeSet<String> res){
//    if (k == chars.length - 1){
//        String over = String.valueOf(chars);
//        //if (!res.contains(over))    //去重方法一，如果已经包含了，则不加入
//        res.add(over);
//    } else{
//        for (int i = k;i < chars.length;i++){
//            if (i == k || chars[k] != chars[i]) { //去重方法二，如果相同，则不交换
//                swap(chars, i, k);
//                FullPermutation(chars, k + 1, res);
//                swap(chars, i, k);
//            }
//        }
//    }
//}
//    private static void swap(char[] cs, int i, int j) {
//        char temp = cs[i];
//        cs[i] = cs[j];
//        cs[j] = temp;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int k = in.nextInt();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0;i < n;i++)
//            sb.append("a");
//        for (int i = 0;i < m;i++)
//            sb.append("z");
//        FullPermutation(sb.toString().toCharArray(),0,treeSet);
//        if (k > treeSet.size())
//            System.out.print(-1);
//        else {
//            int i = 1;
//            for (String s : treeSet)
//                if (i != k)
//                    i++;
//                else {
//                    System.out.print(s);
//                    break;
//                }
//        }
//    }
//}

/*class Main {
    private static int M;
    private static int N;
    private static int maxQNow = 0;
    private static int P = 0;
    private static int Q = 0;
    private static int[][] hahaha= {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        M = Integer.valueOf(s[0]);
        N = Integer.valueOf(s[1]);
        int[][] matrix = new int[M][N];
        boolean[][] hasPassedBy = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] str = in.nextLine().split(",");
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.valueOf(str[j]);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!hasPassedBy[i][j] && matrix[i][j] == 1) {
                    DFS(matrix, hasPassedBy, i, j);
                    P++;
                    Q = maxQNow > Q ? maxQNow : Q;
                    maxQNow = 0;
                }
            }
        }
        System.out.print(P + " " + Q);
    }
    private static void DFS(int[][] matrix,boolean[][] hasPassedBy,int i, int j){
        if (i >= M ||i < 0 || j >= N || j < 0 || matrix[i][j] == 0 || hasPassedBy[i][j])
            return;
        else {
            maxQNow++;
            hasPassedBy[i][j] = true;
        }
        for (int k = 0; k < hahaha.length;k++){
            DFS(matrix,hasPassedBy,i + hahaha[k][0],j + hahaha[k][1]);
        }
    }
}*/

/*class hahaha {
    public static int maxSum(int[] prices){
        if (prices.length == 1) return prices[0];
        return Math.max(buy(prices, 0, prices.length - 2), buy(prices, 1, prices.length - 1));
    }
    private static int buy(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            if (num[j] > i)
                include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] prices = new int[size];
        for (int i = 0; i < size; i++) {
            prices[i] = sc.nextInt();
        }
        System.out.print(maxSum(prices));
    }

}*/







