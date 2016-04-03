
import java.util.LinkedList;
import java.util.Queue;
class TreeUtils {
	static boolean isTreeEqual(BSTNode root1, BSTNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 != null && root2 != null) {
			return root1.getData() == root2.getData()
					&& isTreeEqual(root1.getLeft(), root2.getLeft())
					&& isTreeEqual(root1.getRight(), root2.getRight());
		} else {
			return false;
		}
	}
	public static BSTNode lowestCommonAncestor(BSTNode root, BSTNode a,
			BSTNode b) {
		// important:
		// http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
		// to fond LCA in any tree, may not be a binary search tree
		if (root == null || a == null || b == null) {
			return null;
		}
		if (Math.max(a.data, b.data) < root.data) {
			// both nodes are on the left
			return lowestCommonAncestor(root.left, a, b);
		} else if (Math.min(a.data, b.data) > root.data) {
			// both nodes are on the right
			return lowestCommonAncestor(root.right, a, b);
		} else {
			// the nodes are on separate branches
			return root;
		}
	}
	static void printLevelOrder(BSTNode root) {
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		queue.offer(root);
		queue.offer(null);
		while (queue.size() > 1) {
			BSTNode front = queue.poll();
			if (front == null) {
				System.out.println();
				queue.offer(null);
			} else {
				System.out.print(front.getData() + " ");
				BSTNode left = front.getLeft();
				BSTNode right = front.getRight();
				if (left != null) {
					queue.offer(left);
				}
				if (right != null) {
					queue.offer(right);
				}
			}
		}
	}
	// LCA for any binary tree
	// public static Node lowestCommonAncestor(Node root, Node a, Node b) {
	// if (root == null) {
	// return null;
	// }
	//
	// if (root.equals(a) || root.equals(b)) {
	// // if at least one matched, no need to continue
	// // this is the LCA for this root
	// return root;
	// }
	//
	// Node l = lowestCommonAncestor(root.left, a, b);
	// Node r = lowestCommonAncestor(root.right, a, b);
	//
	// if (l != null && r != null) {
	// return root; // nodes are each on a seaparate branch
	// }
	//
	// // either one node is on one branch,
	// // or none was found in any of the branches
	// return l != null ? l : r;
	// }
	
	
	public boolean isValidBST(BSTNode root) {
	     return isValidBST(root, Integer.MIN_VALUE,
	          Integer.MAX_VALUE);
	}
	private boolean isValidBST(BSTNode node, int MIN, int MAX) {
	     if(node == null)
	         return true;
	     if(node.getData() > MIN 
	         && node.getData() < MAX
	         && isValidBST(node.left, MIN, node.getData())
	         && isValidBST(node.right, node.getData(), MAX))
	         return true;
	     else 
	         return false;
	}
	
	// Print path from root node to a given node
	//public static void 
	
	
	
	
	
	
}