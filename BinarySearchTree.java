
import java.util.Queue;
/*
 *  Java Program to Implement Binary Search Tree
 */
/* Class BSTNode */
class BSTNode {
	BSTNode left, right;
	int data;
	/* Constructor */
	public BSTNode() {
		left = null;
		right = null;
		data = 0;
	}
	/* Constructor */
	public BSTNode(int n) {
		left = null;
		right = null;
		data = n;
	}
	/* Function to set left node */
	public void setLeft(BSTNode n) {
		left = n;
	}
	/* Function to set right node */
	public void setRight(BSTNode n) {
		right = n;
	}
	/* Function to get left node */
	public BSTNode getLeft() {
		return left;
	}
	/* Function to get right node */
	public BSTNode getRight() {
		return right;
	}
	/* Function to set data to node */
	public void setData(int d) {
		data = d;
	}
	/* Function to get data from node */
	public int getData() {
		return data;
	}
}
/* Class BST */
class BST {
	private BSTNode root;
	/* Constructor */
	public BST() {
		root = null;
	}
	public BSTNode getRoot() {
		return root;
	}
	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}
	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}
	/* Function to insert data recursively */
	private BSTNode insert(BSTNode node, int data) {
		if (node == null) {
			node = new BSTNode(data);
		} else {
			if (data <= node.getData()) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}
	/* Functions to delete data */
	public void delete(int k) {
		if (isEmpty()) {
			System.out.println("Tree Empty");
		} else if (search(k) == false) {
			System.out.println("Sorry " + k + " is not present");
		} else {
			root = delete(root, k);
			System.out.println(k + " deleted from the tree");
		}
	}
	private BSTNode delete(BSTNode root, int k) {
		BSTNode p, p2, n;
		if (root.getData() == k) {
			BSTNode lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null) {
				return null;
			} else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null) {
					p = p.getLeft();
				}
				p.setLeft(lt);
				return p2;
			}
		}
		if (k < root.getData()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		} else {
			n = delete(root.getRight(), k);
			root.setRight(n);
		}
		return root;
	}
	/* Functions to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}
	/* Function to count number of nodes recursively */
	private int countNodes(BSTNode r) {
		if (r == null) {
			return 0;
		} else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}
	/* Functions to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}
	/* Function to search for an element recursively */
	private boolean search(BSTNode r, int val) {
		boolean found = false;
		while (r != null && !found) {
			int rval = r.getData();
			if (val < rval) {
				r = r.getLeft();
			} else if (val > rval) {
				r = r.getRight();
			} else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}
	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}
	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}
	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}
	private void preorder(BSTNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}
	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}
	private void postorder(BSTNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
	public void breadthFirstNonRecursive() {
		Queue<BSTNode> queue = new java.util.LinkedList<BSTNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BSTNode node = queue.poll();
			System.out.print(node.data);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			System.out.println("");
		}// kingshuk: how to print it levelwise
	}
}
/* Class BinarySearchTree */
public class BinarySearchTree {
	public static void main(String[] args) {
		// binary tree can be constructed from inorder and preorder
		BST bst = new BST();
		System.out.println("Binary Search Tree Test\n");
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
		// bst.breadthFirstNonRecursive();
		// System.out.println("isTreeEqual:  "
		// + TreeUtils.isTreeEqual(bst.getRoot(), bst2.getRoot()));
		// System.out.println("LCA : "
		// + TreeUtils.lowestCommonAncestor(bst.getRoot(),
		// new BSTNode(130), new BSTNode(97)).data);
		//TreeUtils.printLevelOrder(bst.getRoot());
		System.out.println(TreeUtils2.countTrees(11));
	}
}
