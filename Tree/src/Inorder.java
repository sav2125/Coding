/**
 * Created by siddharthvarshney on 9/20/16.
 */
public class Inorder {
    TreeNode root;
    void inorder(TreeNode root)
    {
        TreeNode curr = root;
        if(curr == null)
            return;
        if(curr != null)
        {
            inorder(curr.left);
            System.out.print(curr.data + " ");
            inorder(curr.right);
        }
    }
    public static void main(String args[])
    {
        Inorder tree = new Inorder();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        tree.inorder(tree.root);
    }
}
