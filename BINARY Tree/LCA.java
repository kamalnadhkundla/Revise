package BINARY Tree;


/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */

 // one way is to generate the paths for both the nodes and getting a common guy from it

public class LCA {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ArrayList<TreeNode> descp = new ArrayList<>();
            ArrayList<TreeNode> descq= new ArrayList<>();
    
            getdesc(descp,root,p);
            getdesc(descq,root,q);
            // find common guy in both the array
            List<TreeNode> commonElements = descp.stream()
                                        .filter(descq::contains)
                                        .collect(Collectors.toList());
     return commonElements.get(commonElements.size()-1);
    
            
        }
        public boolean getdesc(ArrayList<TreeNode> list, TreeNode root, TreeNode target){
            if(root==null) return false;
            list.add(root);
            if(root==target) return true;
            if(getdesc(list,root.left,target) || getdesc(list,root.right,target)) return true;
            list.remove(list.size()-1);
            return false;
        }
    }
    class Solution2{
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null) return null;
            if(root==p || root==q) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right= lowestCommonAncestor(root.right,p,q);

            if(left== null && right==null) return null;
            else if(left==null && right!=null) return right;
          else  if(left!=null && right==null) return left;
            else return root;
        }
    }
}
