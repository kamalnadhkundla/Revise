package BINARY Tree.BST;
/*
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure
 */

 // the solution is not optimal just a basic solution to solve this prob
public class ReconstryBST {
    class Solution1 {
        public void recoverTree(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            // getInorder 
            inorder(list, root);
        Collections.sort(list); // orginal BST
            // checkMapping
            mapping(list,root,new int[1]);
        }
        public void mapping(List<Integer> list, TreeNode root, int[] temp){
            if(root==null) return;
            mapping(list,root.left,temp);
            if(root.val !=list.get(temp[0])){
                root.val=list.get(temp[0]);
                
            }
            temp[0]++;
            mapping(list,root.right,temp);
    
        }
        public void inorder(List<Integer> list , TreeNode root){
            if(root==null) return;
            inorder(list,root.left);
            list.add(root.val);
            inorder(list,root.right);
        }
    }
}
