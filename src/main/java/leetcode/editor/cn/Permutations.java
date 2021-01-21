package leetcode.editor.cn;

import java.util.*;

public class Permutations{

    public static void main(String[]args){
        Solution solution= new Permutations().new Solution();
        List<List<Integer>> res = solution.permute(new int[]{1,2,3});

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.print("\n");
        }
    }
    
    //NO.46
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        int len;
        public List<List<Integer>> permute(int[] nums) {
            len = nums.length;
            List<Integer> residual = new ArrayList<Integer>();
            for (int num : nums) {
                residual.add(num);
            }
            add(new ArrayList<>(), residual);
            return res;
        }

        public void add(List<Integer> list,List<Integer> residual){
            if(list.size() == len){
                res.add(new ArrayList<>(list));
                return;
            }
            int len = residual.size();
            for (int i = 0; i < len; i++) {
                Integer value = residual.get(i);
                if(null == value){
                    continue;
                }
                list.add(value);
                residual.set(i, null);
                add(list,residual);
                residual.set(i, value);
                list.remove(value);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1069 👎 0

}