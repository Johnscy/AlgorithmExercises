package Algotithms_Fourth_Edition.Chapter1;
import java.util.*;

public class ex1_3_37 {
    public static int JosephusWithQueue(int N,int M,int K){
        if(N <= 0 || M <= 0 || K <= 0)
            return -1;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0;i< N;i++)
            queue.offer(i);
        while(queue.size() > 1){
            int outPerson = (K + M - 2)%N;
            for(int i= 0;i<outPerson;i++) {
                int temp = queue.poll();
                queue.offer(temp);
            }
            System.out.print(queue.poll());
        }
        System.out.print(queue.peek());
        System.out.println();
        return queue.peek();
    }
    public static int JosephusWithQueue(int N,int M){
        return JosephusWithQueue(N,M,1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        JosephusWithQueue(sc.nextInt(),sc.nextInt(),sc.nextInt());
    }
}
