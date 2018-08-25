package WrittenTest.ALi;
import java.util.*;

class Point{
    private int x;
    private int y;
    boolean visited;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.visited = false; }
    public int getPathLength(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y); }
}

class PaiSongYuan{
    private static int minPathSum = Integer.MAX_VALUE;
    private static Point Pstart = new Point(0,0);
    private static int calculate(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minPathSum = Math.min(minPathSum, sum + start.getPathLength(Pstart));
            return minPathSum; }
        for(int i = 0; i < points.length; i++){
            if(!points[i].visited){
                sum += points[i].getPathLength(start);
                if(sum < minPathSum){
                    points[i].visited = true;
                    calculate(points[i], points, sum, count + 1);
                }
                sum -= points[i].getPathLength(start);
                points[i].visited = false;
            }
        }
        return minPathSum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] str = in.nextLine().split(",");
            points[i] = new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
            System.out.print(calculate(Pstart,points,0,0));
    }
}

