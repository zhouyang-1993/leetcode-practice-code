package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver{

    public static void main(String[]args){
        Solution solution= new SudokuSolver().new Solution();
    }
    
    //NO.37
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean over = false;

        // Define some array store the elements which can be chosen.
        boolean[][] rowElements = new boolean[9][10];
        boolean[][] columnElements = new boolean[9][10];
        boolean[][][] nineElements = new boolean[3][3][10];

        // Store the point of space element.
        List<int[]> spaceList = new ArrayList<>();

        public void solveSudoku2(char[][] board) {
            if(board.length != 9 || board[0].length != 9){
                return;
            }

            // Traversal the board.
            for(int i=0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(board[i][j] == '.'){
                        spaceList.add(new int[]{i, j});
                    }else{
                        int num = board[i][j] - '0';
                        rowElements[i][num] = true;
                        columnElements[j][num] = true;
                        nineElements[i/3][j/3][num] = true;
                    }
                }
            }

            // recursion start
            dist(board, 0);

        }

        public void dist(char[][] board, int index){
            if(index == spaceList.size()){
                over = true;
                return;
            }
            int[] space = spaceList.get(index);
            int i = space[0];
            int j = space[1];

            // Traversal from 1 to 9 , try every one that haven't appear.
            for(int v = 1; v < 10 && !over; v++){
                if(!rowElements[i][v] && !columnElements[j][v] && !nineElements[i / 3][j / 3][v]){
                    board[i][j] = (char) ('0' + v);
                    rowElements[i][v] = columnElements[j][v] = nineElements[i/3][j/3][v] = true;
                    dist(board, index + 1);
                    rowElements[i][v] = columnElements[j][v] = nineElements[i/3][j/3][v] = false;
                }
            }
        }

        /*
         solution 2.0
         Use bit operation replace the array.
         */
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[][] nine = new int[3][3];

        public void solveSudoku(char[][] board){
            if(board.length != 9 || board[0].length != 9){
                return;
            }

            // Traversal the board.
            for(int i=0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(board[i][j] == '.'){
                        spaceList.add(new int[]{i, j});
                    }else{
                        int num = board[i][j] - '1';
                        rows[i] = rows[i] | (1 << num);
                        columns[j] = columns[j] | (1 << num);
                        nine[i/3][j/3] = nine[i/3][j/3] | (1 << num);
                    }
                }
            }

            // recursion start
            dist2(board, 0);
        }

        private void dist2(char[][] board, int index){
            if(index == spaceList.size()){
                over = true;
                return;
            }

            int[] space = spaceList.get(index);
            int i = space[0];
            int j = space[1];

            int mask = ~(rows[i] | columns[j] | nine[i/3][j/3]) & 0x1ff;
            for(int v = 0; v < 9 && ! over; v++){
                int d = (1<<v);
                if ((mask & d ) == d) {
                    rows[i] |= d;
                    columns[j] |= d;
                    nine[i/3][j/3] |= d;

                    board[i][j] = (char) ('1' + v);
                    dist2(board,index + 1);

                    int x = ~d;
                    rows[i] &= x;
                    columns[j] &= x;
                    nine[i/3][j/3] &= x;

                }
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)


//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 715 👎 0

}