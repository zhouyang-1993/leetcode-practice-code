package leetcode.editor.cn;

public class WildcardMatching{

    public static void main(String[]args){
        Solution solution= new WildcardMatching().new Solution();
    }
    
    //NO.44
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isMatch(String s, String p) {
            boolean[][] f = new boolean[s.length()+1][p.length()+1];
            f[0][0] = true;

            // f(i,j) = true means s.substr(0,i) match p.substr(0,j)
            // then f(i+1,j + 1) =
            // if(s[i + 1] == p[j + 1]) then

            // from end to begin
            /**
             * case(p[?]){
             *   when *:
             *         p--,p-- only can be char.
             *         case all s[?] == p--, backtracking
             *   when ?:
             *          p-- = s--
             *   when c:
             *          p = s
             * }
             */
            char[] cs = s.toCharArray();
            char[] ps = p.toCharArray();
            for (int i = 1; i <= p.length(); i++) {
                if(ps[i - 1] == '*'){
                    f[0][i] = true;
                }else{
                    break;
                }
            }

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if(cs[i-1] == ps[j-1]){
                        f[i][j] = f[i-1][j-1];
                    }else if(ps[j-1] == '?'){
                        f[i][j] = f[i-1][j-1] ;
                    } else if(ps[j-1] == '*'){
                        f[i][j] = f[i][j-1] || f[i-1][j];
                    } else{
                        f[i][j] = false;
                    }
                }
            }
            return f[s.length()][p.length()];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法 
// 👍 580 👎 0

}