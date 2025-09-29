package september_learn.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
         }
     }
    public static void main(String[] args) {
        PathSum mdbt = new PathSum();
//        TreeNode left = mdbt.new TreeNode(4, left2, right2);
        TreeNode left1 = mdbt.new TreeNode(13);
        TreeNode right1 = mdbt.new TreeNode(4);
        TreeNode right = mdbt.new TreeNode(8, left1, right1);
        TreeNode left3 = mdbt.new TreeNode(7);
        TreeNode right3 = mdbt.new TreeNode(2);
        TreeNode left2 = mdbt.new TreeNode(11, left3,right3);
        TreeNode right2 = mdbt.new TreeNode(4);
        TreeNode left = mdbt.new TreeNode(4, left1, null);
        TreeNode root = mdbt.new TreeNode(5, right1,right);

//        TreeNode right = mdbt.new TreeNode(3);
//        TreeNode root = mdbt.new TreeNode(1, null,right);
        TreeNode head = root;
        List<Integer> visited = new ArrayList<>();
        printTreeNode(head, visited);
        System.out.println(visited);
        visited = new ArrayList<>();
        TreeNode head1 = root;
        System.out.println("Max Depth ? ");
//        int max = maxDepth(head1);
       boolean isPathExist =  pathSum(head1, 22);
        System.out.println(isPathExist);
//        System.out.println(max);
        int target =22;
       target =  maxTargetSum(head,target);
        if(target == 0)
        System.out.println("target Matches");
        else System.out.println("target not exist");

        TreeNode head2 = root;
        int depth = maxDepth(head2);
        System.out.println("Max Depth ? " + depth);

        head2 = root;
       int isBalanceBinaryTree = balanceBinaryTree(head2);
        System.out.println("Is Balance binary tree ? " +( isBalanceBinaryTree != -1));

    }

    private static void printTreeNode(TreeNode head, List<Integer> visited) {
       if(head == null){
           System.out.println(!visited.isEmpty() ? visited.remove(visited.size()-1) : "" );
           return;
       }
       visited.add(head.val);
       printTreeNode(head.left,visited);
       printTreeNode(head.right,visited);
    }

    private static int maxDepth(TreeNode head){
        if(head == null) return 0;
           int left = maxDepth(head.left);
           int right = maxDepth(head.right);
           return Math.max(left, right) + 1;
        }

    private static int maxTargetSum(TreeNode head, int target){
        if(head == null) return -1;
        if(head.left == null && head.right == null) return (target == head.val ? 0 : -1);
            int t = target - head.val;
            int left = maxTargetSum(head.left, t);
            int right = maxTargetSum(head.right, t);
            return Math.max(left, right);
    }

    private static boolean pathSum(TreeNode head, int target){
        if(head == null) return false;
        if(head.left == null && head.right == null) return target == head.val;
        int t = target - head.val;
        return pathSum(head.left, t) || pathSum(head.right, t);
    }

    private static int balanceBinaryTree(TreeNode head){
       if(head == null) return 0;
       int l = balanceBinaryTree(head.left);
       if(l == -1) return -1;
       int r = balanceBinaryTree(head.right);
       if(r == -1) return -1;
       if(Math.abs(l-r ) > 1) return -1;
      return Math.max(l,r) + 1;
    }
}
