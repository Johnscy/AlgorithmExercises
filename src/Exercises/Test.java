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

/*class Point{
    private int x;
    private int y;
    boolean visited;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.visited = false;
    }

    public int getPathLength(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}

class Main{
    private static int minPathSum = Integer.MAX_VALUE;
    private static Point Pstart = new Point(0,0);
    private static int calculate(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minPathSum = Math.min(minPathSum, sum + start.getPathLength(Pstart));
            return minPathSum;
        }
        for(int i = 0; i < points.length; i++){
            if(!points[i].visited){
                sum += points[i].getPathLength(start);
                if(sum < minPathSum){
                    points[i].visited = true;
                    calculate(points[i], points, sum, count + 1);
                }
                sum -= points[i].getPathLength(start);
                points[i].visited = false;
            }
        }
        return minPathSum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] str = in.nextLine().split(",");
            points[i] = new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
        System.out.print(calculate(Pstart,points,0,0));
    }
}*/

//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int[][] matrix = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            matrix[i][0] = in.nextInt();
//            matrix[i][1] = in.nextInt();
//        }
//        long maxX = matrix[0][0],minX = matrix[0][0],maxY = matrix[0][1],minY = matrix[0][1];
//        for (int i = 0; i < N; i++) {
//                if (matrix[i][0] > maxX)
//                    maxX = matrix[i][0];
//                else if (matrix[i][0] < minX)
//                    minX = matrix[i][0];
//                if (matrix[i][1]  > maxY)
//                    maxY = matrix[i][1];
//                else if (matrix[i][1] < minY)
//                    minY = matrix[i][1];
//        }
//        if (maxX == 0 && minX == 0)
//            System.out.print((maxY - minY) * (maxY - minY));
//        else if (maxY == 0 && minY == 0)
//            System.out.print((maxX - minX) * (maxX - minX));
//        else
//            System.out.print((maxX - minX) > (maxY - minY) ? (maxX - minX) * (maxX - minX) : (maxY - minY) * (maxY - minY));
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] a = new int[n];
//        for (int i = 1; i <= n; i++)
//            a[i] = in.nextInt();
//        int Q = in.nextInt();
//        int[] l = new int[Q];
//        int[] r = new int[Q];
//        for (int i = 0;i < Q;i++){
//            l[i] = in.nextInt();
//            r[i] = in.nextInt();
//        }
//        int dp[] = new int[n + 1];
//        dp[0] = 0;
//        for (int i = 1;i <= n;i++)
//             dp[i] = dp[i - 1] + a[i] > m ? m : dp[i - 1] + a[i];
//        for (int i = 0; i < Q; i++) {
//            System.out.println(dp[r[i]] - dp[l[i] - 1]);
//        }
//    }
//}



// class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int hp = in.nextInt();
//        in.nextLine();
//        int normal = in.nextInt();
//        in.nextLine();
//        int buffer = in.nextInt();
//        in.nextLine();
//        int numNormal = 0, numBuffer = 0;;
//        if(hp % normal == 0) {
//            numNormal = hp / normal;
//        }else {
//            numNormal = hp / normal + 1;
//        }
//        if(normal * 2 >= buffer) {
//            System.out.println(numNormal);
//            return ;
//        }
//        numBuffer = hp / buffer;
//        if(hp % buffer==0) {
//            System.out.println(numBuffer * 2);
//            return ;
//        }
//        if(hp - buffer * numBuffer > normal) {
//            numBuffer = numBuffer * 2 + 2;
//            System.out.println(numBuffer);
//            return ;
//        }
//        System.out.println(numBuffer * 2 + 1);
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt(), M = in.nextInt();
//        in.nextLine();
//        char[][] chars = new char[N][M];
//        char[][] out = new char[N][M];
//        for (int i = 0; i < N; i++) {
//            String[] str = in.nextLine().split("");
//            for (int j = 0; j < M; j++)
//                chars[i][j] = str[j].charAt(0);
//        }
//        for (int j = 0; j < M; j++) {
//            int count = 0;
//            for (int i = 0;i < N;i++){
//                if (chars[i][j] == '.')
//                    out[i][j] = '.';
//                else if (chars[i][j] == 'o') {
//                    out[i][j] = '.';
//                    count++;
//                }
//                else if (chars[i][j] == 'x'){
//                    out[i][j] = 'x';
//                    for (int k = i - 1; k >= 0 ; k--) {
//                        if (count <= 0)
//                            break;
//                        out[k][j] = 'o';
//                        count--;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(out[i][j]);
//            }
//            System.out.println();
//        }
//    }
//}

//class Main {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt(), b = in.nextInt();
//        List remainderList = new ArrayList();
//        int start;
//        int index = -1;
//        boolean flag = false;
//        while(true){
//            int remainder = a % b;
//            if(a < b || remainder < b){
//                flag = true;
//            }
//            if(flag){
//                index++;
//            }
//            if(remainder == 0){
//                System.out.print(index + " " + 0);
//                return;
//            }
//            if(flag){
//                start = remainderList.indexOf(remainder);
//                if(start >= 0)
//                    break;
//                else
//                    remainderList.add(remainder);
//            }
//            a = remainder * 10;
//        }
//        System.out.print(start + " " + (index - start));
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt(), L = in.nextInt();
//        in.nextLine();
//        char[][] chars = new char[N][L];
//        String[] input = new String[N];
//        for (int i = 0; i < N; i++) {
//            input[i] = in.nextLine();
//            String[] str = input[i].split("");
//            for (int j = 0; j < L; j++)
//                chars[i][j] = str[j].charAt(0);
//        }
//        char[] out = new char[L];
//        for (int j = 0; j < L; j++) {
//            char min = 'Z';
//            for (int i = 0; i < N; i++) {
//                if (chars[i][j] <= min)
//                    min = chars[i][j];
//            }
//            out[j] = min;
//        }
//        String output = new String(out);
//        for (int i = 0;i < N; ++i){
//            if (output.equals(input[i])){
//                System.out.print("-");
//                return;
//            }
//        }
//        System.out.print(output);
//    }
//}

/*
class Main {
    class TreeNode{
        int val;
        TreeNode pre = null;
        TreeNode(int v){
            val = v;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer,TreeNode> map = new HashMap<>();
        TreeNode root = new Main().new TreeNode(-1);
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt();
            in.nextInt();
            if (b == -1) {
                root.val = a;
                if (!map.containsKey(a))
                    map.put(a,root);
            }
            else {
                if (!map.containsKey(a))
                    map.put(a,new Main().new TreeNode(a));
                if (!map.containsKey(b))
                    map.put(b,new Main().new TreeNode(a));
            }
            if ()
        }
        for (Map.Entry<Integer,TreeNode> entry : map.entrySet()){
             if (entry.getKey() == root.val) {
                 TreeNode node = map.
                 node.pre = root;
             }
        }
    }

    private int findParent(int a, int b, TreeNode root){

    }
}*/

//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt(), M = in.nextInt();
//        int count = 0;
//        if (N >= M){
//            count = N - M;
//            System.out.print(count);
//            return;
//        }
//        if (M % 2 != 0) {
//            count++;
//            M += 1;
//        }
//        while (M % 2 == 0) {
//            M /= 2;
//            count++;
//        }
//        while (M != N){
//            if (M % 2 != 0) {
//                M += 1;
//                count++;
//            }
//            else {
//                M /= 2;
//                count++;
//            }
//        }
//        System.out.print(count);
//        return;
//    }
//}


//class Main{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
//        int count = 0;
//        for (;n != 0;count++)
//            n = n & (n-1);
//        System.out.print(count);
//    }
//}

/*class LRUCache {
    class DLNode {
        int key;
        int value;
        DLNode prev; //指向前一个结点
        DLNode next; //指向后一个结点

        DLNode(int k, int v) {
            key = k;
            value = v;
        }

        DLNode() {
            this(0, 0);
        }
    }

    class DoubleLinkedList {
        DLNode head;   //dummy node，实际并不存在。
        int size;

        DoubleLinkedList() {
            head = new DLNode();
            head.next = head;
            head.prev = head;
            size = 0;
        }

        DLNode addLast(DLNode newNode) {
            DLNode last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
            size++;
            return newNode;
        }

        void remove(DLNode node) {
            DLNode prevNode = node.prev;
            DLNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    private int CAPACITY;
    private HashMap<Integer, DLNode> map;
    private DoubleLinkedList cache;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLNode oldNode = map.get(key);
        int value = oldNode.value;
        cache.remove(oldNode);
        DLNode newNode = cache.addLast(new DLNode(key, value));
        map.put(key, newNode);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLNode node = map.get(key);
            node.value = value;
            return;
            //cache.remove(node);
        } else if (cache.size == CAPACITY) {
            DLNode eliminated = cache.head.next;
            map.remove(eliminated.key);
            cache.remove(eliminated);
        }
        DLNode newNode = cache.addLast(new DLNode(key, value));
        map.put(key, newNode);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//in.nextLine();
        LRUCache lruCache = new LRUCache(n);
        while (in.hasNextLine()) {
            String[] str = in.nextLine().split(" ");
            if (str.length == 3)
                lruCache.put(Integer.valueOf(str[1]), Integer.valueOf(str[2]));
            else if (str.length == 2)
                System.out.println(lruCache.get(Integer.valueOf(str[1])));
        }
    }
}*/

/*    public class Main {

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

    }*/

/*class Main {
    //5 3 2
    //3 1 1 1 2
    //out: 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        int[] numAppearTimes = new int[100000];
        int res = 0;
        if (k >= n){
            for (int i = 1; i <= n; i++)
                numAppearTimes[a[i]]++;
            for (int i = 1; i <= n; i++) {
                if(numAppearTimes[a[i]] >= t) {
                    System.out.println(1);
                    return;
                }
            }
            System.out.println(0);
        }else {
            //int[] count = new int[n - k + 1 + 1];
            for (int j = 1; j <= k; j++)
                numAppearTimes[a[j]]++;
            for (int i = 1; i <= n - k; i++) {
                for (int j = i; j <= i + k - 1; j++) {
                    if (a[j] == a[j + 1] && j < i + k -1)
                        continue;
                    if (numAppearTimes[a[j]] >= t)
                        res++;//count[i]++;
                }
                numAppearTimes[a[i + k]]++;
                numAppearTimes[a[i]]--;
            }
            System.out.println(res);
        }
    }
}*/

/*class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();sc.nextLine();
        int[] a = new int[N + 1];
        for(int i = 1;i <= N;++i){
            a[i] = sc.nextInt();sc.nextLine();
        }
        int res = 0;


    }
}*/

//输入：
//1,1
//0,0,0,2,2,2,2,0
//输出：
//yes,0
//
//输入：
//2,2
//0,0,0,2,2,2,2,0
//输出：
//yes,0
//
//输入：
//3,0
//0,0,0,2,2,2,2,0
//输出：
//no,1
//
//输入：
//3,4
//0,0,0,2,2,2,2,0
//输出：
//no,2
//class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String[] s1 = sc.nextLine().split(",");
//        int x = Integer.valueOf(s1[0]), y = Integer.valueOf(s1[1]);
//        String[] s2 = sc.nextLine().split(",");
//        int n = s2.length / 2;
//        int[][] points = new int[n][2];
//        for (int i = 0; i < s2.length; i += 2) {
//            points[i/2][0] = Integer.valueOf(s2[i]);
//            points[i/2][1] = Integer.valueOf(s2[i + 1]);
//        }
//        int res = 0;
//        int yesOrNo = check(n,points,x,y);
//        if (yesOrNo == 1)
//            System.out.print("yes" + "," + res);
//        else {
//            System.out.print("no" + "," + res);
//        }
//
//    }
//
//    private static int check(int n,int[][] points,int x,int y){
//        int c = 1;
//        for (int i = 0 , j = n - 1; i < n; j = i++) {
//            if (((points[i][1] > y) != (points[j][1] > y)) &&
//                    (x < (points[j][0] - points[i][0]) * (y - points[i][1]) / (points[j][1] - points[i][1]) + points[i][0]))
//                    c = ~c;
//        }
//        return c;
//    }
//}

//1
/*class Main{
    private static int maxLen, lo;     //最长回文子串的长度和起始索引
    public static int longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1)
            return 0;
        for (int i = 0;i+1 < len;i++){
            extendPalindrome(s,i,i);        //奇数长度
            extendPalindrome(s,i,i + 1); //偶数长度
        }
        return maxLen;
    }
    private static void extendPalindrome(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if (maxLen < j - i + 1){
            lo = i + 1;
            maxLen = j - i + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int res = longestPalindrome(input);
        System.out.print(res);
    }
}*/

//2
//class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();sc.nextLine();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            int k = sc.nextInt();
//            if (n == k)
//                System.out.println(0 + " " + 0);
//            else if(k == 0)
//                System.out.println(0 + " " + 0);
//            else if (n - k <= k - 1)
//                System.out.println(0 + " " + (n - k));
//            else
//                System.out.println(0 + " " + (k - 1));
//        }
//    }
//}

//3
//class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] input = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            input[i][0] = sc.nextInt();
//            input[i][1] = sc.nextInt();
//        }
//        int res = 0;
//        int[] voteTo = new int[m];
//        for (int i = 0; i < n; i++)
//            voteTo[input[i][0]]++;
//        int max = Integer.MIN_VALUE;
//        int maxIndex = 0;
//        for (int i = 0; i < m; i++) {
//            max = Math.max(voteTo[i], max);
//            maxIndex =
//        }
//        Arrays.sort(input,(s1,s2) -> (s1));
//        for (int i = 0; i < n; i++) {
//            if (input[i][0] != ma)
//            for (int j = 0; j < ; j++) {
//
//            }
//        }
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();sc.nextLine();
//        for (int i = 0; i < T; i++) {
//            String input = sc.nextLine();
//            StringBuffer sb = new StringBuffer(input);
//            String out = abbreviation(sb);
//            if (i < T - 1)
//                System.out.println(out);
//            else
//                System.out.print(out);
//        }
//    }
//
//    private static String abbreviation(StringBuffer s){
//        int n = s.length();
//        if (n <= 3)    return new String(s);
//        StringBuffer str = new StringBuffer(s);
//        int continuousLen = 1;
//        for (int i = n - 2, j = n - 1; i >= 0 && j >= 1; i--, j--) {
//            if (s.charAt(j) - s.charAt(i) == 1)
//                continuousLen++;
//            else if (continuousLen >= 4){
//                int k = i + continuousLen - 1;
//                continuousLen -= 3;
//                str.setCharAt(k--,'-');
//                while (continuousLen-- > 0) {
//                    str.deleteCharAt(k--);
//                }
//                continuousLen = 1;
//            }else
//                continuousLen = 1;
//            if ((i == 0) && (j == 1) && continuousLen >= 4){
//                int k = i + continuousLen - 2;
//                continuousLen -= 3;
//                str.setCharAt(k--,'-');
//                while (continuousLen-- > 0) {
//                    str.deleteCharAt(k--);
//                }
//            }
//        }
//        return new String(str);
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();sc.nextLine();
//        for (int i = 0; i < T; i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            String str = sc.next();
//            sc.nextLine();
//            int n = str.length();
//            int equalRight = 0;
//            for (int j = n - 1; j > 0; j--) {
//                int k = n - 1 - j;
//                if (str.charAt(j) >= 'A' && str.charAt(j) <= 'F')
//                    equalRight += (str.charAt(j) - 'A' + 10) * bit(y,k);
//                else
//                    equalRight += (str.charAt(j) - '0') * bit(y,k);
//                int equalLeft = 0;
//                for (int l = j - 1; l >= 0; l--) {
//                    int m = j - 1 - l;
//                    if (str.charAt(j) >= 'A' && str.charAt(j) <= 'F')
//                        equalLeft += (str.charAt(j) - 'A' + 10) * bit(y,m);
//                    else
//                        equalLeft += (str.charAt(j) - '0') * bit(y,m);
//                }
//                if (equalLeft == equalRight)
//                    System.out.print(equalLeft);
//            }
//        }
//    }
//    private static int bit(int base, int k){
//        int res = 1;
//        if ((k & 1) == 1)
//            res  *= base;   //累乘
//        base *= base;   //底数的平方
//        k >>= 1; //指数右移一位
//    }
//}

/*class Main {
    private static int M;
    private static int P = 0;
    private static int[][] hahaha= {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M = in.nextInt(); in.nextLine();
        int[][] matrix = new int[M][M];
        boolean[][] hasPassedBy = new boolean[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++)
                matrix[i][j] = in.nextInt();
            in.nextLine();
        }
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++)
                if (!hasPassedBy[i][j] && matrix[i][j] == 1) {
                    DFS(matrix, hasPassedBy, i, j);
                    P++;
                }
        System.out.print(P);
    }
    private static void DFS(int[][] matrix,boolean[][] hasPassedBy,int i, int j){
        if (i >= M || i < 0 || j >= M || j < 0)
            return;
        else if (matrix[i][j] == 0 || hasPassedBy[i][j])
            return;
        else {
            hasPassedBy[i][j] = true;
        }
        for (int k = 0; k < hahaha.length;k++){
            DFS(matrix,hasPassedBy,i + hahaha[k][0],j + hahaha[k][1]);
        }
    }
}*/


//1
//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        char[] c = input.toCharArray();
//        int num1 = 0, num2 = 0;
//        int count = 0;
//        for (int i = 0; i <= 2; i++) {
//            num1 += c[i] - '0';
//            num2 += c[i + 3] - '0';
//        }
//        int which = num2 - num1;
//        PriorityQueue<Character> pq = new PriorityQueue<>();
//        for (int i = 0; i <= 2; i++) {
//            if (which < 0)
//                pq.add(c[i + 3]);
//            else
//                pq.add(c[i]);
//        }
//        which = Math.abs(which);
//        if (which == 0){
//            System.out.print(count);
//            return;
//        }else if (which <= '9' - pq.peek()){
//            count++;
//            System.out.print(count);
//            return;
//        }else {
//            while (which > 0) {
//                    which -= Math.abs('9' - pq.poll());
//                count++;
//            }
//            System.out.print(count);
//        }
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in
//
//        );
//        String str = scan.nextLine();
//        int[] pre = new int[3];
//        int[] back = new int[3];
//        for(int i=0;i<3;i++) {
//            pre[i] = (int)(str.charAt(i)-'0');
//            back[i] = (int)(str.charAt(i+3)-'0');
//        }
//        boolean flag = false;//代表前面大于后面
//        int sum1 = 0;
//        for(int i = 0;i<3;i++) {
//            sum1 = sum1+pre[i]-back[i];
//        }
//        if(sum1==0) {
//            System.out.println(0);
//            return ;
//        }
//        if(sum1<0) {
//            flag = true;
//            sum1 = - sum1;
//        }
//        boolean[] pp = new boolean[3];
//        boolean[] ff = new boolean[3];
//        int num = 0;
//        if(flag==false) {
//            for(int i =0;i<3;i++) {
//                int temp = pre[i];
//                pre[i] = back[i];
//                back[i] = temp;
//            }
//        }
//        while(sum1!=0) {//后面大于前面，前面+，后面减
//            int max1 = 0;
//            int index1 = 0;
//            for(int i =0;i<3;i++) {
//                if(!pp[i]&&max1<(9-pre[i])) {
//                    max1 = 9-pre[i];
//                    index1 = i;
//                }
//            }
//            int max2 = 0;
//            int index2 = 0;
//            for(int i =0;i<3;i++) {
//                if(!ff[i]&&max2<back[i]) {
//                    max2 = back[i];
//                    index2 = i;
//                }
//            }
//            if(max1>max2) {
//                if(sum1<=max1) {
//                    num++;
//                    break;
//                }else {
//                    sum1 -= max1;
//                    num++;
//                }
//                pp[index1] = true;
//            }else {
//                if(sum1<=max2) {
//                    num++;
//                    break;
//                }else {
//                    num++;
//                    sum1 -= max2;
//                }
//                ff[index2] = true;
//            }
//        }
//        System.out.println(num);
//    }
//}

//2
//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int P = sc.nextInt();sc.nextLine();
//        int[] Ai = new int[N + 1];
//        for (int i = 1; i <= N; i++)
//            Ai[i] = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < M; i++) {
//            String[] str = sc.nextLine().split(" ");
//            if (str[0].equals("A"))
//                Ai[Integer.valueOf(str[1])]++;
//            else if (str[0].equals("B"))
//                Ai[Integer.valueOf(str[1])]--;
//        }
//        int k = Ai[P];
//        Arrays.sort(Ai);
//        int index = 1;
//        for (int i = N; i >= 1; i--) {
//            if (Ai[i] != k)
//                index++;
//            else
//                break;
//        }
//        System.out.print(index);
//    }
//}


//class ListNode {
//    int val;
//    ListNode next;
//    public ListNode(int val) {
//        this.val = val;
//    }
//}
//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] strs = sc.nextLine().trim().split(" ");
//        int n = strs.length;
//        int[] arrs = new int[n];
//        for(int i = 0;i < n;i++)
//            arrs[i] = Integer.parseInt(strs[i]);
//        ListNode head = new ListNode(arrs[0]);
//        ListNode temp = head;
//        for(int i =1;i<n;i++) {
//            temp.next = new ListNode(arrs[i]);
//            temp = temp.next;
//        }
//        int k = sc.nextInt();
//        sc.nextLine();
//        head = reverseKGroup(head, k);
//        while(head!=null) {
//            System.out.print(head.val+" ");
//            head = head.next;
//        }
//    }
//    public static  ListNode reverseKGroup(ListNode head, int k) {
//        int n = 0;
//        for (ListNode i = head; i != null; n++, i = i.next);
//        ListNode pHead = new ListNode(0);
//        pHead.next = head;
//        ListNode pre = pHead;
//        for (ListNode tail = head; n >= k; n -= k) {
//            for (int i = 1; i < k; i++) {
//                ListNode next = tail.next.next;
//                tail.next.next = pre.next;
//                pre.next = tail.next;
//                tail.next = next;
//            }
//            pre = tail;
//            tail = tail.next;
//        }
//        return pHead.next;
//    }
//
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int res = 0;
//        if (n <= 0) {
//            System.out.println(res);
//            return;
//        }
//        int[] dp = new int[n + 1];
//        for (int i = 5; i <= n; i++) {
//            int temp = 0;
//            int k = i;
//            while (k != 0) {
//                k /= 5;
//                temp += k;
//                dp[i] = dp[k / 5] + temp;
//            }
//        }
//        for (int i = 1; i <= n; i++) {
//            res += dp[i];
//        }
//        System.out.println(res);
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();sc.nextLine();
//        int q = sc.nextInt();sc.nextLine();
//        if(n <= 1 || q < 1){
//            System.out.println(1);
//            return;
//        }
//        boolean[][] matrix = new boolean[n + 1][n + 1];
//        for (int i = 0; i < q; i++) {
//            int child = sc.nextInt();
//            int without = sc.nextInt();
//            matrix[child][without] = true;
//        }
//        for (int i = 1; i <= n; i++)
//            for (int j = i+1; j <= n ; j++)
//                if(matrix[i][j] )
//                    for (int k = j+1; k <= n; k++)
//                        if(matrix[i][k] && matrix[j][k]){
//                            System.out.println(0);
//                            return;
//                        }
//        System.out.println(1);
//    }
//}





