package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoFibonacciSequence().new Solution();

        System.out.println(solution.splitIntoFibonacci("11235813"));
    }

    //NO.842
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<Integer> splitIntoFibonacci(String S) {
            int n = S.length();
            if (n < 3) {
                return new ArrayList<>();
            }
            int maxN1 = n / 2;
            List<Integer> res = new ArrayList<>();

            for (int n1 = 1; n1 < maxN1 + 1; n1++) {
                res = new ArrayList<>();
                String n1Str = S.substring(n - n1);
                Long n1Value = Long.parseLong(n1Str);
                if (n1Value > Integer.MAX_VALUE) {
                    break;
                }
                if (isFb(S.substring(0, n - n1), n1Value.intValue(), n1, res)) {
                    res.add(n1Value.intValue());
                    break;
                }
            }
            return res;
        }

        /**
         * @param s
         * @param lastValue
         * @param n         length of lastValue
         */
        private boolean isFb(String s, int lastValue, int n, List<Integer> res) {
            //length of the second last value.
            int n2 = 1;
            //n2 is between 1 ~ min(n, s.length-1);
            int maxLength = Math.min(n, s.length() - 1);
            for (; n2 < maxLength + 1; n2++) {
                String n2Str = s.substring(s.length() - n2);
                Long n2Value = Long.parseLong(n2Str);
                if (n2Value > Integer.MAX_VALUE) {
                    break;
                }
                Integer n3Value = lastValue - n2Value.intValue();
                if (n3Value >= 0) {
                    Integer n3 = n3Value.toString().length();
                    if (n2 + n3 <= s.length()) {
                        String n3Str = s.substring(s.length() - n2 - n3, s.length() - n2);
                        if (n3Str.equals(n3Value.toString())) {
                            if (n3 + n2 == s.length()) {
                                res.add(n3Value);
                                res.add(n2Value.intValue());
                                return true;
                            } else {
                                if (isFb2(s.substring(0, s.length() - n2 - n3), n3Value, n2Value.intValue(), res)) {
                                    res.add(n3Value);
                                    res.add(n2Value.intValue());
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        public boolean isFb2(String s, int n2Value, int n3Value, List<Integer> res) {
            Integer n1Value = n3Value - n2Value;
            if (n1Value >= 0) {
                Integer n1 = n1Value.toString().length();
                if (n1 <= s.length()) {
                    String n1Str = s.substring(s.length() - n1);
                    if (n1Str.equals(n1Value.toString())) {
                        if (n1 == s.length()) {
                            res.add(n1Value);
                            return true;
                        } else {
                            if (isFb2(s.substring(0, s.length() - n1), n1Value, n2Value, res)) {
                                res.add(n1Value);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 170 👎 0

}