package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

public class Quick3way {
    private static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp > 0)         exch(a,i,gt--);
            else if(cmp < 0)    exch(a,lt++,i++);
            else                i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
    public static void sort(Comparable[] a){
        List<Comparable> list = new LinkedList<Comparable>();
        for (int k = 0;k < a.length ;k++){
            list.add(a[k]);
        }
        Collections.shuffle(list);             //利用List的shuffle方法打乱数组XD
        for (int k = 0;k < a.length ;k++){
            a[k] = list.get(k);
        }
        sort(a,0,a.length-1);
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
