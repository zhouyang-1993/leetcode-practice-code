package leetcode.editor.cn;

import java.util.Stack;

public class MonotoneIncreasingDigits{

    public static void main(String[]args){
        Solution solution= new MonotoneIncreasingDigits().new Solution();
        System.out.println(solution.monotoneIncreasingDigits(677440));
    }
    
    //NO.738
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits2(int N) {
        if(N < 10){
           return N;
        }
        int n = N;
        int mLast = 9;
        Stack<Integer> integerStack = new Stack<>();
        int zero = 0;
        for(; n > 0;){
            int m = n % 10;
            n = n / 10;
            if(zero > 0){
                m = m - 1;
                zero = 0;
            }

            if(m == 0){
                if(n == 0){
                    break;
                }
                zero = 1;
                integerStack.add(9);
                mLast = 9;
                continue;
            }

            if(m <= mLast){
                integerStack.add(m);
                mLast = m;
            }else{
                integerStack.pop();
                integerStack.add(9);
                integerStack.add(m-1);
                mLast = m - 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        Integer end = null;
        while(!integerStack.isEmpty()){
            if(end != null){
                stringBuilder.append("9");
                integerStack.pop();
                continue;
            }
            int v = integerStack.pop();
            if(v == 9){
                end = 9;
            }
            stringBuilder.append(v);
        }

        return Integer.parseInt(stringBuilder.toString());

    }

        public int monotoneIncreasingDigits(int N) {
            char[] strN = Integer.toString(N).toCharArray();
            int i = 1;
            while (i < strN.length && strN[i - 1] <= strN[i]) {
                i += 1;
            }
            if (i < strN.length) {
                while (i > 0 && strN[i - 1] > strN[i]) {
                    strN[i - 1] -= 1;
                    i -= 1;
                }
                for (i += 1; i < strN.length; ++i) {
                    strN[i] = '9';
                }
            }
            return Integer.parseInt(new String(strN));
        }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 147 👎 0

}