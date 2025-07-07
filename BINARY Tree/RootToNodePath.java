package BINARY Tree;

/*
 * In this problem we will be given the node we have to trace down the path in the tree, question stated that
 * there will be the node that equals to the target return the path.
 */
public class RootToNodePath {
    
    public ArrayList<TreeNode> findpath(TreeNode root, TreeNode target){
        ArrayList<TreeNode> list = new ArrayList<>();
        if(root==null) return list;
        check(root,list);
    }
    public boolean check(TreeNode root,ArrayList<Integer>list, TreeNode target){

        if(root==null) return false;

        list.add(root);
        if(root==target) return true;

        if(check(root.left,list,target) || check(root.right,list,target)) return true;
        
        list.remove(list.size()-1);
        return false;

    }
}
