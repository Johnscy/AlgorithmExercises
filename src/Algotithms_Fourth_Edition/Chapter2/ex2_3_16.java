package Algotithms_Fourth_Edition.Chapter2;

import java.util.Scanner;

public class ex2_3_16 {
        // postcondition: a[lo..hi] is best-case input for quicksorting that subarray
        private static void best(int[] a, int lo, int hi) {

            // precondition:  a[lo..hi] contains keys lo to hi, in order
            for (int i = lo; i <= hi; i++)
                assert a[i] == i;

            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            best(a, lo, mid-1);
            best(a, mid+1, hi);
            exch(a, lo, mid);
        }

        public static int[] best(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = i;
            best(a, 0, n-1);
            return a;
        }

        // exchange a[i] and a[j]
        private static void exch(int[] a, int i, int j) {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            int n = sc.nextInt();
            int[] a = best(n);
            for (int i = 0; i < n; i++)
                // StdOut.println(a[i]);
                System.out.print(alphabet.charAt(a[i]));
            System.out.println();
        }

}
