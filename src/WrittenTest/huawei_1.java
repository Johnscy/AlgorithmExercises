package WrittenTest;
import java.util.*;

//大小写转换
public class huawei_1 {
    //class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String s = sc.nextLine();
                char[] chars = s.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    if (chars[i] >= 'a' && chars[i] <= 'z')
                        chars[i] -= 32;
                    else if (chars[i] >= 'A' && chars[i] <= 'Z')
                        chars[i] += 32;
                }
                System.out.println(new String(chars));
            }
        }
    //}
}
