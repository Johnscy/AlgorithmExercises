package Target_To_Offer;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    //题目应该有一个隐含条件，就是不能用额外的空间。
    //Java 的题目输入参数为 String 类型，需要先创建一个字符数组使得空间复杂度为 O(N)，但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。
    // 任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
    //正确的解法应该是和书上一样，先旋转每个单词，再旋转整个字符串。
    //要考虑到" aasd hu ks afh "这种情况，即开始或结束为空格，并且几个空格连续的情况！！！！
    public class Solution {
        public String ReverseSentence(String str) {
            if (str == null || str.trim().equals(""))
                return str;
            char[] chars = str.toCharArray();
            int n = str.length();
            int i = 0, j = 0;
            boolean isFirst = true;
            while (j <= n){
                while (chars[j] == ' ' && isFirst) {
                    j++;
                }
                isFirst = false;
                if (j == n || chars[j] == ' '){
                    reverse(chars,i,j - 1);
                    i = j + 1;
                    j++;
                }

            }
            reverse(chars,0,n - 1);
            return new String(chars);
        }

        private void reverse(char[] c, int i ,int j){
            while (i < j){
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
                i++;j--;
            }
        }
    }

    //用了split
    public class Solution_String {
        public String ReverseSentence(String str) {
            if (str == null || str.trim().equals(""))// trim掉多余空格
                return str;
            String[] words = str.split(" ");// 以空格切分出各个单词
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < words.length; i++)
                buffer.append(reverse(words[i].toCharArray(), 0, words[i].length() - 1)).append(" ");
            if (buffer.length() > 0)
                buffer.deleteCharAt(buffer.length() - 1);// 删除最后一个空格
            return reverse(buffer.toString().toCharArray(), 0, buffer.length() - 1);
        }
        private String reverse(char[] c, int i, int j) {
            while (i < j) {
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
                i++;
                j--;
            }
            return new String(c);
        }
    }

    //似乎有缺陷：" a "这种情况无法还原
    public class Solution_ {
        public String ReverseSentence(String str) {
            if(str == null || str.trim().equals(""))
                return str;
            String[] a = str.split(" ");
            StringBuffer o = new StringBuffer();
            int i;
            for (i = a.length; i >0;i--){
                o.append(a[i-1]);
                if(i > 1)
                    o.append(" ");
            }
             return o.toString();
        }
    }
}
