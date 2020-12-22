package leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber{

    public static void main(String[]args){
        Solution solution= new LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{
                0,9,8,7,6,5,4,3,2,1
        }));
    }
    
    //NO.179
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        fastSort(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == 0 && isFirst){
                continue;
            }
            if(isFirst){
                isFirst = false;
            }
            stringBuilder.append(nums[i]);
        }

        return stringBuilder.toString().equals("") ? "0" : stringBuilder.toString();
    }

    //sort [i,j]
    private void fastSort(int[] nums, int i, int j){
//        System.out.println("sort " + i + " >> " + j);
//        for(int t = i; t <= j; t++){
//            System.out.print(nums[t] + ",");
//        }
//        System.out.print("\n");
        if(i >= j){
           return;
        }
        if(j - i == 1){
            if(isBigger(nums[i], nums[j])){
                swap(nums, i, j);
            }
            return;
        }
        int baseElement = nums[i];
        int leftPointer = i + 1;
        int rightPointer = j;
        for(;leftPointer < rightPointer;){

            for(; leftPointer < j + 1; leftPointer++){
                if(!isBigger(baseElement, nums[leftPointer])){
                    break;
                }
            }

            for(; i < rightPointer; rightPointer--){
                if(!isBigger(nums[rightPointer], baseElement)){
                    break;
                }
            }
            if(leftPointer < rightPointer){
                swap(nums, leftPointer ,rightPointer);
            }
        }
//        System.out.println(leftPointer + "," + rightPointer);
        if(rightPointer == i){
            // all bigger then base element
            // do nothing
            fastSort(nums, i + 1, j);
        }else if(leftPointer == j + 1){
            // all smaller then base element
            // do swap with j
            swap(nums, i ,j);
            fastSort(nums, i, j - 1);
        }else{
            // left pointer equals right pointer the smallest one of bigger then bade element
            swap(nums, i ,rightPointer);
            fastSort(nums, i, leftPointer - 2);
            fastSort(nums, leftPointer, j);
        }

    }


    private void swap(int[] nums, int i, int j){
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }


    private boolean isBigger(int a, int b){
        char[] as = (a + "" + b).toCharArray();
        char[] bs = (b + "" + a).toCharArray();
        for(int i = 0; i < as.length; i++){
            int ai = Integer.parseInt(as[i] + "");
            int bi = Integer.parseInt(bs[i] + "");
            if(ai > bi){
//                System.out.println(a + " > " + b);
                return true;
            }else if(bi > ai){
//                System.out.println(b + " > " + a);
                return false;
            }
        }
//        System.out.println(a + " > " + b);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 438 👎 0

}