package leetcode.editor.cn;

public class ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        Solution solution = new ScoreAfterFlippingMatrix().new Solution();
    }

    //NO.861
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * Mathematics law is the most important to solving algorithm problems.
         * The key to this problem is that the result is same whenever we change rows or columns.
         *
         * @param A
         * @return
         */
        public int matrixScore(int[][] A) {
            int len = A.length;
            int width = A[0].length;
            //transform rows first
            for (int i = 0; i < len; i++) {
                //we turn row i when row i is not begin with one.
                if (A[i][0] == 1) {
                    // turn row i
                    for (int j = 0; j < width; j++) {
                        A[i][j] = A[i][j] == 0 ? 1 : 0;
                    }
                }
            }
            //then transform columns.
            // while count of zero more than count of one then turn the column.
            for (int i = 0; i < width; i++) {
                //column i
                int countZero = 0;
                int countOne = 0;
                for (int j = 0; j < len; j++) {
                    if (A[j][i] == 0) {
                        countZero++;
                    } else {
                        countOne++;
                    }
                }
                if (countZero > countOne) {
                    // turn the column.
                    for (int j = 0; j < len; j++) {
                        A[j][i] = A[j][i] == 0 ? 1 : 0;
                    }
                }
            }

            //calculate sum of the matrix
            int sum = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < width; j++) {
                    if (A[i][j] == 1) {
                        sum += A[i][j] << (width - j - 1);
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 170 👎 0

}