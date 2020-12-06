package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView{

    public static void main(String[]args){
        Solution solution= new BinaryTreeRightSideView().new Solution();
    }
    
    //NO.199
//leetcode submit region begin(Prohibit modification and deletion)

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if(null == root){
            return rightView;
        }
        breadthFirst(root, rightView);
        return rightView;

    }

    private void depthFitst(TreeNode node, int depth, List<Integer> rightView){
        if(depth > rightView.size()){
            rightView.add(node.val);
        }
        if(node.right != null){
            depthFitst(node.right, depth + 1, rightView);
        }
        if(node.left != null){
            depthFitst(node.left, depth + 1, rightView);
        }
    }

    private void breadthFirst(TreeNode node, List<Integer> rightView){
        Queue<TreeNode> nodeQueue= new LinkedList<>();
        nodeQueue.offer(node);
        for(; nodeQueue.size() > 0;){
            int size = nodeQueue.size();
            for(int i = 0; i < size; i++){
                TreeNode tn = nodeQueue.poll();
                if(null != tn.left){
                    nodeQueue.offer(tn.left);
                }
                if(null != tn.right){
                    nodeQueue.offer(tn.right);
                }
                if(i == size-1){
                    rightView.add(tn.val);
                }
            }

        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 370 👎 0

}