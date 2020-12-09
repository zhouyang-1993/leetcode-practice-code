package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIii {

    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
    }

    //NO.220
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            Map<Integer, Integer> d = new HashMap<Integer, Integer>();
            int w = t + 1;
            for (int i = 0; i < n; i++) {
                int bucketIndex = getBucketIndex(nums[i], w);
                if (d.containsKey(bucketIndex)) {
                    return true;
                }
                if (d.containsKey(bucketIndex - 1) && Math.abs(d.get(bucketIndex - 1) - nums[i]) < w) {
                    return true;
                }
                if (d.containsKey(bucketIndex + 1) && Math.abs(d.get(bucketIndex + 1) - nums[i]) < w) {
                    return true;
                }
                d.put(bucketIndex, nums[i]);
                if (i >= k) {
                    d.remove(getBucketIndex(nums[i - k], w));
                }
            }
            return false;
        }

        private int getBucketIndex(int value, int w) {
            //正整数很好理解，但负数部分有点特殊。
            //例如 桶宽为2 ，[2,4)的index为1，[0,2)的index为0,以此类推（-2,0）的index为-1，（-4，-2】，【-3，-2】index为-2，但-2/2 = -1没错，-1/2=0就有问题了，在负数中
            //能够除以2 得到-1的范围为(-4，-2],由于我们是整数列(-4,-2]可以等价于[-3,-1) ,即 （value + 1）
            return value < 0 ? (value + 1) / w - 1 : value / w;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map 
// 👍 265 👎 0

}