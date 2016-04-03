import java.util.LinkedList;
import java.util.Queue;


public class SpiralTraversal {

	
	private static void printSpiral(BSTNode root) {NOT WORKING>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// TODO Auto-generated method stub
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		printSpiral(bst.getRoot());
	}



}
