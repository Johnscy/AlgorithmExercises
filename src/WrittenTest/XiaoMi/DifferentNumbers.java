package WrittenTest.XiaoMi;
import java.util.*;

public class DifferentNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> numList = new LinkedList<>();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("END"))
                break;
            list.add(input);
            String[] str = input.split("#");
            int n = Integer.valueOf(str[0]);
            char[] numstr = str[1].toCharArray();
            int num = 0;
            for (int i = numstr.length - 1, k = 1; i >= 0; i-- ,k *= n) {
                num += (numstr[i] - '0') * k;
            }
            numList.add(num);
            if (!map.containsKey(num))
                map.put(num,1);
            else
                map.put(num,map.get(num) + 1);
        }
        int index = -1;
        for (int num : numList) {
            index++;
            if (map.get(num) > 1) {
                list.add( index + 1, "$");
                list.remove(index);
            }
        }
        int count = list.size();
        if (count > 0)
            for (String s : list) {
                if (!s.equals("$"))
                    System.out.println(s);
                else
                    count--;
            }
        if (count == 0)
            System.out.println("None");
    }
}
