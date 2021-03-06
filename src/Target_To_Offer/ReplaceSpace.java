package Target_To_Offer;

/**
 * 将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            int oldLen = str.length();
            for (int i = 0; i < oldLen; i++) {
                if (str.charAt(i) == ' ')
                    str.append("  ");   //加俩空格在末尾，扩展长度至替换后的情况。
            }

            int P1 = oldLen - 1;
            int P2 = str.length() - 1;
            while (P1 > 0 && P2 > P1) {
                char c = str.charAt(P1--);
                if (c == ' ') {
                    str.setCharAt(P2--, '0');
                    str.setCharAt(P2--, '2');
                    str.setCharAt(P2--, '%');
                } else {
                    str.setCharAt(P2--, c);
                }
            }
            return str.toString();
        }
    }
}
