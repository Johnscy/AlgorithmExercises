package Algotithms_Fourth_Edition.Chapter1;

public class ex1_3_14 {
    private String[] a = new String[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    private void resize(int size) {
        String[] temp = new String[size];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void enqueue(String item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public String dequeue() {
        String item = a[0];
        for (int i = 0; i < N; i++) {
            a[i] = a[i + 1];
        }
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }
}
