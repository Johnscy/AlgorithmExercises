package WrittenTest.zz360;
import java.util.*;

//给一系列点坐标，求覆盖它们的正方形最小面积，边必须平行于坐标轴。
//估计数据大小有点问题。。。。
public class TheMinArea {
    //class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            long maxX = Long.MIN_VALUE;
            long minX = Long.MAX_VALUE;
            long maxY = Long.MIN_VALUE;
            long minY = Long.MAX_VALUE;
            long x = 0, y = 0;
            for (int i = 0; i < N; i++) {
                 x = in.nextLong();
                 y = in.nextLong();
                 maxX = Math.max(maxX,x);
                 minX = Math.min(minX,x);
                 maxY = Math.max(maxY,y);
                 minY = Math.min(minY,y);
            }
            long ans = Math.max((maxX - minX),(maxY - minY));
            System.out.println(ans * ans);
        }
    //}
}
