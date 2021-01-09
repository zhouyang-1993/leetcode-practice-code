package leetcode.editor.cn;

import java.util.*;

public class CombinationSumIi {

    public static void main(String[] args) {

        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
    }

    //NO.40
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            for (int candidate : candidates) {
                map.put(candidate, map.getOrDefault(candidate, 0) + 1);
            }
            Arrays.sort(candidates);
            t(candidates, target, 0, new ArrayList<Integer>());
            return list;
        }

        private void t(int[] candidates, int target, int index, List<Integer> integerList) {
            if (index == candidates.length) {
                return;
            }
            int value = candidates[index];
//            if(integerList.contains(value)){
//                return;
//            }

            int count = map.get(value);

            int max = Math.min(target/value,count);
            for (int i = 0; i <= max; i++) {
                int target2 = target - i * value;
                if(i > 0){
                    integerList.add(value);
                }
                if (target2 == 0) {
                    list.add(new ArrayList<>(integerList));
                }
                if (target2 > 0) {
                    t(candidates, target2, index + count, integerList);
                }
            }

            for(int i = 0; i < max; i++){
                integerList.remove(integerList.size() - 1);
            }

        }



        List<int[]> freq = new ArrayList<int[]>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> sequence = new ArrayList<Integer>();

        public List<List<Integer>> combinationSum3(int[] candidates, int target) {
            Arrays.sort(candidates);
            for (int num : candidates) {
                int size = freq.size();
                if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                    freq.add(new int[]{num, 1});
                } else {
                    ++freq.get(size - 1)[1];
                }
            }
            dfs(0, target);
            return ans;
        }

        public void dfs(int pos, int rest) {
            if (rest == 0) {
                ans.add(new ArrayList<Integer>(sequence));
                return;
            }
            if (pos == freq.size() || rest < freq.get(pos)[0]) {
                return;
            }

            dfs(pos + 1, rest);

            int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
            for (int i = 1; i <= most; ++i) {
                sequence.add(freq.get(pos)[0]);
                dfs(pos + 1, rest - i * freq.get(pos)[0]);
            }
            for (int i = 1; i <= most; ++i) {
                sequence.remove(sequence.size() - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 460 👎 0

}