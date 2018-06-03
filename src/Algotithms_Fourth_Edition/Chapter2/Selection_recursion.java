package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;
/**
 * 找到一组数中第k小的元素，用递归。
 */
public class Selection_recursion {
    public static Comparable select(Comparable[] a, int k){
        List<Comparable> list = new LinkedList<Comparable>();
        for (int x = 0;x < a.length ;x++){
            list.add(a[x]);
        }
        Collections.shuffle(list);             //利用List的shuffle方法打乱数组XD
        for (int x = 0;x < a.length ;x++){
            a[x] = list.get(x);
        }
        int lo = 0,hi = a.length - 1;
        return select(a,lo,hi,k);
    }

    private static Comparable select(Comparable[] a, int lo, int hi, int k){
        if(lo >= hi) return null;
        int j = partition(a,lo,hi);
        if(j == k)  return a[k-1];
        else if(j > k) select(a,lo,j-1,k);
        else if(j < k) select(a,j+1,hi,k);
        return a[k-1];//数组从0开始计数，第k小要减1
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo,j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)) if(i == hi) break;
            while(less(v,a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        public static void main(String[] args){
            String[] input;
            int k;
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一组数字/字母，并用空格隔开：");
            input = sc.nextLine().split("\\s");
            System.out.println("请输入一个数字，表示选择输入数组中第k小的元素");
            k = sc.nextInt();
            if (input[0].matches("\\d+([.]\\d+)?")) {         //判断输入是整数或者小数（当然均为正的了XD），然后转为Double型比较
                Double[] inputNums = new Double[input.length];
                for (int x = 0; x < input.length; x++) {
                    inputNums[x] = Double.parseDouble(input[x]);
                }
                System.out.println(select(inputNums,k));
            } else {                                                 //否则，输入的字母。。。直接比字符串大小吧
                System.out.println(select(input,k));
            }
        }

}
