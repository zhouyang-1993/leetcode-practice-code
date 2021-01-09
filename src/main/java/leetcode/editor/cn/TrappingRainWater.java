package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater{

    public static void main(String[]args){
        Solution solution= new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    
    //NO.42
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {

        //int[] len is 3, first is begin index, second is end index, third is increase ot decreasing
        List<int[]> res = new ArrayList<>();

        int lastCreasing = 1;
        int beginIndex = 0;
        for (int i = 1; i < height.length; i++) {
            int currentCreasing;
            if(height[i-1] > height[i]){
                currentCreasing = -1;
            }else if(height[i-1] < height[i]){
                currentCreasing = 1;
            }else{
                currentCreasing = lastCreasing;
            }

            if(lastCreasing * currentCreasing < 0){
                int[] creasing = new int[]{beginIndex, i - 1, lastCreasing};
                res.add(creasing);
                beginIndex = i - 1;
                lastCreasing = currentCreasing;


            }
            if(i == height.length - 1){
                int[] creasing = new int[]{beginIndex, i, currentCreasing};
                res.add(creasing);
            }

        }

        int rainwater = 0;
        for (int i = 0; i < res.size() - 1; ) {
            int[] decreasingArr = res.get(i);
            int creasing = decreasingArr[2];

            if(creasing < 0){
                int beginDecreasing = decreasingArr[0];
                int endDecreasing = decreasingArr[1];
                int fDecreasing = height[beginDecreasing];

                int maxHigh = -1;
                int maxHighIndex = -1;
                int j = i + 1;
                for (; j < res.size(); j += 2) {
                    int[] increasingArr = res.get(j);
                    int endIncreasing = increasingArr[1];
                    int fIncreasing = height[endIncreasing];
                    if(fIncreasing > maxHigh){
                        maxHigh = fIncreasing;
                        maxHighIndex = j;
                    }
                    if(fIncreasing > fDecreasing){
                        break;
                    }
                }

                int[] increasingArr = res.get(maxHighIndex);
                int endIncreasing = increasingArr[1];
//                System.out.println("begin :" + beginDecreasing);
//                System.out.println("min :" + endDecreasing);
//                System.out.println("end :" + endIncreasing);
                int high = Math.min(height[beginDecreasing],height[endIncreasing]);
                int width = endIncreasing - beginDecreasing - 1;
                int sum = 0;
                for (int k = beginDecreasing + 1; k < endIncreasing; k++) {
                    sum += Math.min(height[k], high);
                }
//                System.out.println("sum :" + sum);

//                System.out.println("rainwater :" + (high*width - sum));
                rainwater += high*width - sum;

                i = maxHighIndex + 1;
            }else{
                i++;
            }

        }
        return rainwater;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1898 👎 0

}