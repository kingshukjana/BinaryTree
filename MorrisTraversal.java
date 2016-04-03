
public class MorrisTraversal {
	
	static void morrisInorder(BSTNode node) {
        BSTNode current, pre;
         
        if (node == null) {
            return;
        }
         
        current = node;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
 
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
 
                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } 
 
                 /* Revert the changes made in if part to restore the original 
                 tree i.e., fix the right child of predecssor */ else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */
                 
            } /* End of if condition current->left == NULL*/
             
        } /* End of while */
         
    }

	public static void main(String[] args) {
		BST bst = new BST();
		System.out.println("Binary Search Tree \njava program to print all paths");
		bst.insert(110);
		bst.insert(190);
		bst.insert(130);
		bst.insert(250);
		bst.insert(270);
		bst.insert(230);
		bst.insert(50);
		bst.insert(97);
		bst.insert(80);
		bst.insert(30);
		morrisInorder(bst.getRoot());
	}

}
