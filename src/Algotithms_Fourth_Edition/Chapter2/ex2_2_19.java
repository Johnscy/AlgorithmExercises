package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

public class ex2_2_19 {
        private static Comparable[] aux;
        private static int merge(Comparable[] a, int lo, int mid, int hi, int inversions) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                } else if (j > hi) {
                    a[k] = aux[i++];
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    inversions += j - k - 1;     //最后还是两两比较大小，如果逆序，
                } else {
                    a[k] = aux[i++];
                }
            }
            return inversions;
        }

        public static int count(Comparable[] a) {
            aux = new Comparable[a.length];
            return count(a, 0, a.length - 1, 0);
        }

        private static int count(Comparable[] a, int lo, int hi, int inversions) {
            if (hi <= lo) {
                return inversions;
            }
            int mid = lo + (hi - lo) / 2;
            inversions = count(a, lo, mid, inversions);
            inversions = count(a, mid + 1, hi, inversions);
            return merge(a, lo, mid, hi, inversions);
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] a = sc.nextLine().split(" ");
            System.out.println(count(a));
        }
}
