package leetcode.editor.cn;

import java.util.*;

public class FirstMissingPositive{

    public static void main(String[]args){
        Solution solution= new FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1}));
    }
    
    //NO.41
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1 && nums[0] == 1){
            return 2;
        }


        Map<Integer, Set<Integer>> map = new TreeMap<>();

        int n = nums.length;


        for (int num : nums) {
            if(num <= 0){
               continue;
            }

            int index = num/n;
            Set<Integer> set = map.getOrDefault(index, new TreeSet<>());
            set.add(num);
            map.put(index, set);
        }
        Set<Integer> set22 = new TreeSet<>();
        int i = 0;
        for(; i < map.size(); i++){
            Set<Integer> set = map.getOrDefault(i, new TreeSet<>());
            int size = n;
            if(i == 0){
                size--;
            }
            if(set.size() < size){
                //
                set22 = set;
                break;
            }
        }
        if(set22.size() == 0){
            return i*n == 0 ? 1 : i * n;
        }
        int j = i * n == 0 ? 1 : i * n;
        for (; j < (i+1) * n; j++) {
            if(!set22.contains(j)){
               break;
            }
        }
        return j == 0 ? 1 : j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 896 👎 0

}