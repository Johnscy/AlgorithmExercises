package WrittenTest.PinDuoDuo;
import java.util.*;

// case 通过率95%
public class StitchingWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), L = in.nextInt();
        in.nextLine();
        char[][] chars = new char[N][L];
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = in.nextLine();
            String[] str = input[i].split("");
            for (int j = 0; j < L; j++)
                chars[i][j] = str[j].charAt(0);
        }
        char[] out = new char[L];
        for (int j = 0; j < L; j++) {
            char min = 'Z';
            for (int i = 0; i < N; i++) {
                if (chars[i][j] <= min)
                    min = chars[i][j];
            }
            out[j] = min;
        }
        String output = new String(out);
        for (int i = 0;i < N; ++i){
            if (output.equals(input[i])){
                System.out.print("-");
                return;
            }
        }
        System.out.print(output);
    }
}
