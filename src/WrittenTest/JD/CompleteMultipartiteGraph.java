package WrittenTest.JD;
import java.util.*;

public class CompleteMultipartiteGraph {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            ArrayList<HashSet<Integer>> map = new ArrayList<>();
            for(int i = 0;i < N;i++)
                map.add(new HashSet<>());
            for(int i = 0;i < M;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map.get(x - 1).add(y - 1);
                map.get(y - 1).add(x - 1);
            }
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
            int flag=0;
            for(int i = 0;i < N;i++){
                for(int j = 0;j < tmp.size();j++){
                    ArrayList<Integer> list = tmp.get(j);
                    flag=0;
                    int stateNode = list.get(0);
                    if(map.get(i).contains(stateNode)){
                        flag=1;
                    }else flag = -1;
                    for(int k = 0;k < list.size();k++){
                        if((flag == 1 && !map.get(i).contains(list.get(k)))||(flag == -1 && map.get(i).contains(list.get(k)))){
                            flag = -2;
                            break;
                        }
                    }
                    if(flag == -2)break;
                    if(flag == -1){
                        if(helper(map,tmp,i,j)){
                            list.add(i);
                        }
                        else
                            flag = -2;
                        break;
                    }
                }
                if(flag == 0 || flag == 1){
                    ArrayList<Integer> newList=new ArrayList<>();
                    newList.add(i);
                    tmp.add(newList);
                }
            }
            if(flag == -2)System.out.println("No");
            else System.out.println("Yes");
        }
    }
    static boolean helper(ArrayList<HashSet<Integer>> map, ArrayList<ArrayList<Integer>> tmp,int m,int n){
        for(int i = 0;i < tmp.size();i++){
            if(i == n)continue;
            ArrayList<Integer> list = tmp.get(i);
            for(int j = 0;j < list.size();j++){
                if(!map.get(m).contains(list.get(j)))
                    return false;
            }
        }
        return true;
    }
}

