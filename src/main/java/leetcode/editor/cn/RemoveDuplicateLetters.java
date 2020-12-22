package leetcode.editor.cn;

import java.util.*;

public class RemoveDuplicateLetters{

    public static void main(String[]args){
        Solution solution= new RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
    }
    
    //NO.316
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        /*
        * cbacdcbc
        * c 0,3,5,7
        * b 1,6
        * a 2
        * d 4
        *
        * ..a.d...
        */


        int[] lastIndex = new int[26];
        boolean[] has = new boolean[26];
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(i > lastIndex[chars[i] - 'a']){
                lastIndex[chars[i] - 'a'] = i;
            }
        }


        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            for(;;){
                if(stack.empty()){
                    stack.add(c);
                    has[index] = true;
                    break;
                }else{
                    if(has[index]){
                        break;
                    }
                    char previous = stack.peek();
                    int preIndex = previous - 'a';
                    if(previous == c){
                        break;
                    }
                    if(previous < c){
                        stack.add(c);
                        has[index] = true;
                        break;
                    }else{
                        if(lastIndex[preIndex] > i){
                            stack.pop();
                            has[preIndex] = false;
//                            stack.add(c);
//                            has[c-'a'] = true;
                        }else{
                            stack.add(c);
                            has[c-'a'] = true;
                            break;
                        }
                    }

                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char c:
             stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 300 👎 0

}