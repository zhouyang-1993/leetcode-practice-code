package leetcode.editor.cn;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class RepeatedDnaSequences{

    public static void main(String[]args){
        Solution solution= new RepeatedDnaSequences().new Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
//        System.out.println('A' + 1);
    }

    
    //NO.187
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // FIXME 位运算，典型
        public List<String> findRepeatedDnaSequences(String s) {
            int L = 10, n = s.length();
            if (n <= L) return new ArrayList();

            // rolling hash parameters: base a
            int a = 4, aL = (int)Math.pow(a, L);

            // convert string to array of integers
            Map<Character, Integer> toInt = new
                    HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
            int[] nums = new int[n];
            for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

            int bitmask = 0;
            Set<Integer> seen = new HashSet();
            Set<String> output = new HashSet();
            // iterate over all sequences of length L
            for (int start = 0; start < n - L + 1; ++start) {
                // compute bitmask of the current sequence in O(1) time
                if (start != 0) {
                    // left shift to free the last 2 bit
                    bitmask <<= 2;
                    // add a new 2-bits number in the last two bits
                    bitmask |= nums[start + L - 1];
                    // unset first two bits: 2L-bit and (2L + 1)-bit
                    bitmask &= ~(3 << 2 * L);
                }
                // compute hash of the first sequence in O(L) time
                else {
                    for(int i = 0; i < L; ++i) {
                        bitmask <<= 2;
                        bitmask |= nums[i];
                    }
                }
                // update output and hashset of seen sequences
                if (seen.contains(bitmask)) output.add(s.substring(start, start + L));
                seen.add(bitmask);
            }
            return new ArrayList<String>(output);
        }
}
//leetcode submit region end(Prohibit modification and deletion)


//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 
// 👍 128 👎 0

}