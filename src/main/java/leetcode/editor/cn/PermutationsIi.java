package leetcode.editor.cn;

import java.util.*;

public class PermutationsIi {

    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        List<List<Integer>> res = solution.permuteUnique(new int[]{1,2,1});
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.print("\n");
        }
    }

    //NO.47
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> listlist = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            boolean[] used = new boolean[n];

            List<Integer> dMax = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if(nums[i] != nums[i-1]){
                    dMax.add(i-1);
                    if(i == n-1){
                        dMax.add(i);
                    }
                }
            }
            dfs(listlist, list, nums, used, dMax, 0);
            return listlist;
        }

        private void dfs(List<List<Integer>> listlist, List<Integer> list, int[] nums, boolean[] used
                , List<Integer> dMax, int depth) {
            if (list.size() == nums.length) {
                listlist.add(new ArrayList<>(list));
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
//                if(i < nums.length - 1 && nums[i] == nums[i + 1] && !used[i]){
//                    continue;
//                }
//                if ((i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
//                    continue;
//                }
                Integer value = nums[i];
                list.add(value);
                used[i] = true;
                dfs(listlist, list, nums, used, dMax, depth + 1);
                used[i] = false;
                list.remove(value);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 557 👎 0

}