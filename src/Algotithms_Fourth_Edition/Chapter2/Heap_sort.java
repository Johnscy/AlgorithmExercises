package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

public class Heap_sort {
    private static void sink(Comparable[] pq, int k, int n){
        while(2*k <= n){
            int j = 2*k;
            if (j < n && less(pq,j,j+1)) j++;
            if (!less(pq,k,j)) break;
            exch(pq,k,j);
            k = j;
        }
    }
    private static void exch(Comparable[] pq, int i, int j){
        Comparable t = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = t;
    }
    private static boolean less(Comparable[] pq,int i, int j){
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
    private static boolean isSorted(Comparable[] pq) {
        for (int i = 1; i < pq.length; i++) {
            if (less(pq,i+1, i)) return false;
        }
        return true;
    }
    private static void show(Comparable[] pq) {
        for (int i = 0; i < pq.length; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }

    public static void sort(Comparable[] a){
        int N =a.length;
        for(int k = N/2;k >= 1;k--)
            sink(a,k,N);
            while(N > 1){
                exch(a,1,N--);
                sink(a,1,N);
            }

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
