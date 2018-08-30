package WrittenTest.PinDuoDuo;
import java.util.*;

public class FlipChessboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        in.nextLine();
        char[][] chars = new char[N][M];
        char[][] out = new char[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = in.nextLine().split("");
            for (int j = 0; j < M; j++)
                chars[i][j] = str[j].charAt(0);
        }
        for (int j = 0; j < M; j++) {
            int count = 0;
            for (int i = 0;i < N;i++){
                if (chars[i][j] == '.')
                    out[i][j] = '.';
                else if (chars[i][j] == 'o') {
                    out[i][j] = '.';
                    count++;
                }
                else if (chars[i][j] == 'x'){
                    out[i][j] = 'x';
                    for (int k = i - 1; k >= 0 ; k--) {
                        if (count <= 0)
                            break;
                        out[k][j] = 'o';
                        count--;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(out[i][j]);
            }
            System.out.println();
        }
    }
}
