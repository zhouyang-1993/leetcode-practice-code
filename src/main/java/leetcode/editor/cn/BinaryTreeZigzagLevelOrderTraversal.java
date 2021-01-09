package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal{

    public static void main(String[]args){
        Solution solution= new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    
    //NO.103
//leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }

            List<TreeNode> queue = new ArrayList<>();
            queue.add(root);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(root.val);
            res.add(first);
            boolean left = false;

            while(!queue.isEmpty()){
                List<TreeNode> newNodeList = new ArrayList<>();
                for(int i = 0; i < queue.size(); i++){
                    TreeNode treeNode = queue.get(i);
                    if(treeNode.left != null){
                        newNodeList.add(treeNode.left);
                    }
                    if(treeNode.right != null){
                        newNodeList.add(treeNode.right);
                    }
                }
                List<Integer> data = new ArrayList<>();
                if(!newNodeList.isEmpty()){
                    if(left){
                        for (int i = 0; i < newNodeList.size(); i++) {
                            data.add(newNodeList.get(i).val);
                        }
                    }else{
                        for (int i = newNodeList.size()-1; i >= 0; i--) {
                            data.add(newNodeList.get(i).val);
                        }
                    }
                    res.add(data);
                }


                left = !left;

                queue = newNodeList;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 355 👎 0

}