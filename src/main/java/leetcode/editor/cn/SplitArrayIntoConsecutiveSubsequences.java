package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences{

    public static void main(String[]args){
        Solution solution= new SplitArrayIntoConsecutiveSubsequences().new Solution();
        System.out.println(solution.isPossible(new int[]{3,4,4,5,6,7,8,9,10,11}));
    }
    
    //NO.659
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return false;
        }
        Map<Integer,Integer> elementCountMap = new HashMap<>();
        for(int i = 0; i < n; i ++){
            elementCountMap.put(nums[i],elementCountMap.getOrDefault(nums[i],0) + 1);
        }
        Map<Integer,Integer> maxIndexMap = new HashMap<>();
        for(int i = 0; i < n; i ++){
            // first wo should determine if there still some nums[i] left.
            if(elementCountMap.get(nums[i])  == 0){
                continue;
            }
            //If there is a sequence that ending with nums[i] - 1,then ok
            if(maxIndexMap.getOrDefault(nums[i] - 1, 0) > 0){
                // there are sequence which end with (nums[i] - 1)
                // extend this sequence to nums[i].
                int currentCount = maxIndexMap.getOrDefault(nums[i],0);
                // extend means the number of sequence that end with nums[i] add one;
                maxIndexMap.put(nums[i], currentCount+1);
                // and then the number of sequence that end with nums[i] minus 1;
                int originCount = maxIndexMap.get(nums[i] - 1);
                maxIndexMap.put(nums[i] - 1, originCount - 1);
                // and then the residual number of nums[i] need to minus 1;
                elementCountMap.put(nums[i], elementCountMap.get(nums[i]) - 1);
            }else{
                // no sequence ending with nums[i] - 1 means that nums[i] is zhe first element of a sequence.
                // so we need at last three element to put to the same sequence.
                // determine if nums[i] + 1 and nums[i] + 2 is exist.
                if(elementCountMap.getOrDefault(nums[i] + 1, 0) > 0
                        && elementCountMap.getOrDefault(nums[i] + 2, 0) > 0){
                    //nums[i]
                    elementCountMap.put(nums[i], elementCountMap.get(nums[i]) - 1);
                    //nums[i + 1]
                    elementCountMap.put(nums[i] + 1, elementCountMap.get(nums[i] + 1) - 1);
                    //nums[i]
                    maxIndexMap.put(nums[i] + 2, maxIndexMap.getOrDefault(nums[i] + 2, 0) + 1);
                    elementCountMap.put(nums[i] + 2, elementCountMap.get(nums[i] + 2) - 1);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 233 👎 0

}