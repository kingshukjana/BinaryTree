import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintPathFromRootToNode {

	private static ArrayList<Integer> arr;

	public static void main(String[] args) {
		BST bst = new BST();
		System.out
				.println("java program to print the paths from root to a given node\n");
		// new approach , deviation from the all possible root to leaf paths
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
		arr = new ArrayList<Integer>();
		int value = 230;

		printPathFromRootToNode(bst.getRoot(), value);
		
		//System.out.println(arr.toString());
		Collections.reverse(arr);		
		System.out.println(arr.toString());
		}

	private static boolean printPathFromRootToNode(BSTNode node, int val) {

		if (node == null)
			return false;
		if (node.getData() == val
				|| printPathFromRootToNode(node.getLeft(), val)
				|| printPathFromRootToNode(node.getRight(), val)) {
			arr.add(node.getData());
			return true;
		} else {
			return false;
		}

	}

}
