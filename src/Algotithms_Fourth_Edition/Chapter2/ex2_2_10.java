package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

public class ex2_2_10 {
    //  private static Comparable[] aux;        //辅助数组
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }
    public static void merge(Comparable[] a, Comparable[] aux,int lo, int mid, int hi){
        //将有序的a[lo,mid]与a[mid+1,hi]借助辅助数组aux归并到a[lo,hi]
        int i = lo,j = hi;//mid+1;
        for(int k = lo; k <= mid;k++)
            aux[k] = a[k];
        for(int k = mid+1; k <= hi;k++)
            aux[k] = a[hi-k+mid+1];
        for (int k = lo;k <= hi;k++){
            //if(i > mid)                     a[k] = aux[j--];
            //else if(j < mid+1)              a[k] = aux[i++];
            if(less(aux[i],aux[j]))         a[k] = aux[i++];
            else                            a[k] = aux[j--];
        }
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a,int i,int j){
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
    private static boolean isSorted(Comparable[] a){
        for (int i = 1;i < a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String[] input;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一组数字/字母，并用空格隔开：");
//      while(sc.hasNext())
        input = sc.nextLine().split("\\s");
        if(input[0].matches("\\d+([.]\\d+)?")) {         //判断输入是整数或者小数（当然均为正的了XD），然后转为Double型比较
            Double[] inputNums = new Double[input.length];
            for(int k = 0;k < input.length;k++) {
                inputNums[k] = Double.parseDouble(input[k]);
            }
            sort(inputNums);
            System.out.print(isSorted(inputNums));
            System.out.println();
            show(inputNums);
        } else{                                                 //否则，输入的字母。。。直接比字符串大小吧
            sort(input);
            System.out.print(isSorted(input));
            System.out.println();
            show(input);
        }

    }

}
