package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

public class ex2_2_15<T extends Comparable> {
    public  void sort(T[] a, Object[] result) {
        int N = a.length;
        Queue<Queue> aux = new LinkedList<Queue>();
        for (int i = 0; i < N; i++) {
            Queue<T> queue = new LinkedList<T>();
            queue.offer(a[i]);
            aux.offer(queue);
        }
        while (aux.size() > 1) {
            merge(aux, aux.poll(), aux.poll());
        }
        int result_length = aux.peek().size();      //最后只剩一个队列的大小，其中的元素已经有序。
        for(int i = 0;i < result_length;i++){       //因为“擦除”，所以用个Object[] 数组来接收最后的结果。
            result[i] = aux.peek().poll();
        }
    }
    public  void merge( Queue aux, Queue<T> first, Queue<T> second) {
        //将有序的Queue first与Queue second归并，最后插入Queue aux尾部
        Queue<T> temp = new LinkedList<T>();
        while (!first.isEmpty() || !second.isEmpty()) {
            if (first.peek() == null)                   temp.offer(second.poll());
            else if (second.peek() == null)             temp.offer(first.poll());
            else if (less(first.peek(), second.peek())) temp.offer(first.poll());
            else                                        temp.offer(second.poll());
        }
        aux.offer(temp);
    }

    private  boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private  void show(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private  boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一组数字/字母，并用空格隔开：");
//      while(sc.hasNext())
        input = sc.nextLine().split("\\s");
        Object[] result = new Object[input.length];
        if (input[0].matches("\\d+([.]\\d+)?")) {         //判断输入是整数或者小数（当然均为正的了XD），然后转为Double型比较
            Double[] inputNums = new Double[input.length];
            for (int k = 0; k < input.length; k++) {
                inputNums[k] = Double.parseDouble(input[k]);
            }
            ex2_2_15<Double> ex2_2_15_1 = new ex2_2_15<Double>();
            ex2_2_15_1.sort(inputNums,result);
            for (int k = 0; k < result.length; k++) {
                inputNums[k] = (Double)result[k];
            }
            System.out.print(ex2_2_15_1.isSorted(inputNums));
            System.out.println();
            ex2_2_15_1.show(inputNums);
        } else {                                                 //否则，输入的字母。。。直接比字符串大小吧
            ex2_2_15<String> ex2_2_15_2 = new ex2_2_15<String>();
            ex2_2_15_2.sort(input,result);
            for (int k = 0; k < result.length; k++) {
                input[k] = (String) result[k];
            }
            System.out.print(ex2_2_15_2.isSorted(input));
            System.out.println();
            ex2_2_15_2.show(input);
        }
    }
}
