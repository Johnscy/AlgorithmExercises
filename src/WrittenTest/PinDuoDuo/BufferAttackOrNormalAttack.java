package WrittenTest.PinDuoDuo;
import java.util.*;

public class BufferAttackOrNormalAttack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hp = in.nextInt();
        in.nextLine();
        int normal = in.nextInt();
        in.nextLine();
        int buffer = in.nextInt();
        in.nextLine();
        int numNormal = 0, numBuffer = 0;
        if(hp % normal == 0) {
            numNormal = hp / normal;
        }else {
            numNormal = hp / normal + 1;
        }
        if(normal * 2 >= buffer) {
            System.out.println(numNormal);
            return;
        }
        numBuffer = hp / buffer;
        if(hp % buffer == 0) {
            System.out.println(numBuffer * 2);
            return;
        }
        if(hp - buffer * numBuffer > normal) {
            numBuffer = numBuffer * 2 + 2;
            System.out.println(numBuffer);
            return;
        }
        System.out.println(numBuffer * 2 + 1);
    }
}
