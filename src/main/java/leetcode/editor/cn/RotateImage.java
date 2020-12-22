package leetcode.editor.cn;

public class RotateImage{

    public static void main(String[]args){
        Solution solution= new RotateImage().new Solution();
        int[][] a = new int[][]{
                {1,2,3}
                ,{4,5,6}
                ,{7,8,9}
        };
        solution.rotate(a);
        System.out.println("X");
    }
    
    //NO.48
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        // 3 x 3
        // 0,0 - > 0,2 -> 2,2 -> 2,0 ->0,0
        // 0,1 -> 1,2 -> 2,1 ->0,1
        // 4 x 4
        // 0,0 -> 0,3 -> 3,3 -> 3,0
        // 0,1 -> 1,2 -> 2,2 -> 1,0

        // n x n
        //(i,j) -> j,n-i-1
        int n = matrix.length;
        if(n < 2){
           return;
        }
        rotateL(matrix, 0);
    }

    //
        private void rotateL(int[][] matrix, int i){
            int j = i;

            int n = matrix.length;

            for(int i1 = i; i1 < n - 1 - i; i1 ++){
                int nextI = i;
                int nextJ = i1;
                int temp = matrix[nextI][nextJ];
                boolean first = true;
                while (!(nextJ == i1 && nextI == i) || first) {
                    if(first){
                        first = false;
                    }
                    int tmpI = nextJ;
                    int tmpJ = n-1-nextI;

                    int tempTemp = matrix[tmpI][tmpJ];
                    matrix[tmpI][tmpJ] = temp;
                    temp = tempTemp;

                    nextI = tmpI;
                    nextJ = tmpJ;
                }
            }


            if(n % 2 == 0){
                if(i < n/2){
                    rotateL(matrix, i + 1);
                }
            }else{
                if(i < n/2 - 1){
                    rotateL(matrix, i + 1);
                }
            }


        }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 702 👎 0

}