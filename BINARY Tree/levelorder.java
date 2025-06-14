package BINARY Tree;

public class levelorder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue= new LinkedList<>();
  
        List<List<Integer>> ans = new ArrayList<>();
  
        if(root==null) return ans;
  
        queue.add(root);
  
        while(!queue.isEmpty()){
          int queuesize = queue.size();
          List<Integer>sublist= new ArrayList<>();
          for(int i =0;i<queuesize;i++){
              TreeNode temp=queue.poll();
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
            sublist.add(temp.val);
          }
          ans.add(sublist);
        }
  
        return ans;  
      }
}
