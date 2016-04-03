import java.util.Stack;


public class TraversalWithoutRecursion {

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
		inorder(bst.getRoot());
	}

	private static void inorder(BSTNode node) {
		// TODO Auto-generated method stub
	        if (node == null) {
	            return;
	        }
	        
	        //keep the nodes in the path that are waiting to be visited
	        Stack<BSTNode> stack = new Stack<BSTNode>();
	         
	        //first node to be visited will be the left one
	        while (node != null) {
	            stack.push(node);
	            node = node.left;
	        }
	         
	        // traverse the tree
	        while (stack.size() > 0) {// NOTE:  we dont loop for while(node!=null)
	           
	            // visit the top node
	            node = stack.pop();
	            System.out.print(node.data + " ");
	            if (node.right != null) {
	                node = node.right;
	                 
	                // the next node to be visited is the leftmost
	                while (node != null) {
	                    stack.push(node);
	                    node = node.left;
	                }
	            }
	        }
	    
	}

}
