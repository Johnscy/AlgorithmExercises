package WrittenTest;
import java.util.*;

//并不对= =
class RealName{
    String name;
    int numOfPrint = 0;

    public RealName(String str,int num){
        name = str;
        numOfPrint = num;
    }
}
//处理字符串的问题，，，corner很多
public class huawei_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String typedefLine = sc.nextLine();
        String outName = sc.nextLine();
        HashMap<String,RealName> map = new HashMap<>();
        map.put("int",new RealName("int",0));
        map.put("float",new RealName("float",0));
        map.put("char",new RealName("char",0));
        map.put("long",new RealName("long",0));
        map.put("double",new RealName("double",0));
        map.put("bool",new RealName("bool",0));

        String[] split = typedefLine.split(";");
        for (int i = 0; i < split.length; i++) {
            String temp[] = split[i].split(" ");
            int index =temp.length -2;
            int j = temp[index].length()-1;
            while(j>=0 && temp[index].charAt(j)=='*') j--;
            if(j<0){
                System.out.println("none");
                return;
            }
            RealName rn = new RealName(temp[index].substring(0,j+1),temp[index].length() -j-1);
            if(!map.containsKey(rn.name)){
                System.out.println("none");
                return;
            }
            rn.name = map.get(rn.name).name;
            rn.numOfPrint += map.get(rn.name).numOfPrint;
            map.put(temp[index+1],rn);
        }

        if(map.containsKey(outName)){
            System.out.print(map.get(outName).name);
            int num = map.get(outName).numOfPrint;
            if(num>0){
                System.out.print(" ");
            }
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println();
            return;
        }
        System.out.println("none");

    }

}
