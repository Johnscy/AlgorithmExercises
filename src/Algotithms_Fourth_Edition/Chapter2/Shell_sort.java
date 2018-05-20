package Algotithms_Fourth_Edition.Chapter2;

import java.util.*;

public class Shell_sort {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 0;
        while(h < N/3){h = 3*h + 1;}    //1,4,13,40,121,364,1093...... //   1/2(3^k - 1)
        while(h >= 1){
            for (int i = h;i < N;i++){
                for (int j =i ;j >= h && less(a[j],a[j-h]);j-=h)
                    exch(a,j,j-h);
            }
            h /= 3;
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
        String[] input = null;
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
