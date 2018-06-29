package Target_To_Offer;
import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public class Solution {
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int r1= 0, r2 = matrix.length - 1;      //行
            int c1 = 0, c2 = matrix[0].length - 1;  //列
            while (c1 <= c2 && r1 <= r2){
                for (int i = c1;i<= c2;i++)
                    arrayList.add(matrix[r1][i]);
                for (int i = r1 + 1;i <= r2;i++)
                    arrayList.add(matrix[i][c2]);
                if (r1 != r2)   //r1 != r2，添加的r2行的元素才不会是已经添加过的
                    for (int i = c2 - 1;i >= c1;i--)
                        arrayList.add(matrix[r2][i]);
                if (c1 != c2)   //c1 != c2，添加的c1列的元素才不会是已经添加过的
                    for (int i = r2 - 1;i >= r1 + 1;i--)
                        arrayList.add(matrix[i][c1]);
                r1++;r2--;c1++;c2--;
            }
            return arrayList;
        }
    }
}
