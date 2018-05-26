package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

public class ex2_3_22 {
    private static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int p= lo, i = lo+1, j = hi, q=hi;
        Comparable v = a[lo];
        while (i <= j){
            int cmp_front = v.compareTo(a[i]);
            int cmp_back =  v.compareTo(a[j]);

            if(cmp_front > 0)         exch(a,j--,i);
            else if(cmp_front < 0)    i++;
            else                      exch(a,p++,i++);

            if(cmp_back > 0)          j--;
            else if(cmp_back < 0)     exch(a,j,i++);
            else                      exch(a,q--,j--);
        }
        i = j + 1;
        for (int k = lo; k < p; k++)
            exch(a, k, j--);
        for (int k = hi; k > q; k--)
            exch(a, k, i++);

        sort(a,lo,j-1);
        sort(a,i+1,hi);
    }

    public static void sort(Comparable[] a){
        List<Comparable> list = new LinkedList<Comparable>();
        for (int k = 0;k < a.length;k++){
            list.add(a[k]);
        }
        Collections.shuffle(list);             //利用List的shuffle方法打乱数组XD
        for (int k = 0;k < a.length;k++){
            a[k] = list.get(k);
        }
        sort(a,0,a.length-1);
    }

    private static boolean eq(Comparable v, Comparable w){
        return v.compareTo(w) == 0;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args){
        String[] input;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一组数字/字母，并用空格隔开：");
//      while(sc.hasNext())
        input = sc.nextLine().split("\\s");
        if (input[0].matches("\\d+([.]\\d+)?")) {         //判断输入是整数或者小数（当然均为正的了XD），然后转为Double型比较
            Double[] inputNums = new Double[input.length];
            for (int k = 0; k < input.length; k++) {
                inputNums[k] = Double.parseDouble(input[k]);
            }
            sort(inputNums);
            System.out.print(isSorted(inputNums));
            System.out.println();
            show(inputNums);
        } else {                                                 //否则，输入的字母。。。直接比字符串大小吧
            sort(input);
            System.out.print(isSorted(input));
            System.out.println();
            show(input);
        }
    }
}
