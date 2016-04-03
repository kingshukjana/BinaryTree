

import java.util.HashMap;
import java.util.List;

public class TreeUtils2 {

	static void printAllPossiblePaths(BSTNode root) {
		HashMap<Integer, BSTNode> hm = new HashMap<Integer, BSTNode>();
		int currentLength = 0;
		printAllPossiblePaths(root, hm, currentLength);
	}

	private static void printAllPossiblePaths(BSTNode root,
			HashMap<Integer, BSTNode> hm, int currentLength) {
		if (root == null)
			return;
		hm.put(currentLength++, root);
		if (root.getLeft() == null && root.getRight() == null) {
			for (int i = 0; i < currentLength; i++) {
				System.out.print(" : " + hm.get(i).getData());
			}
			System.out.println();
		}
		if (root.getLeft() != null)
			printAllPossiblePaths(root.getLeft(), hm, currentLength);
		if (root.getRight() != null)
			printAllPossiblePaths(root.getRight(), hm, currentLength);
	}

	public static void printAllPossiblePaths_array(List<Integer> arr,
			int pathLength, BSTNode root) {
		if (root == null)
			return;
		arr.add(pathLength++, root.getData());
		if (root.getLeft() == null && root.getRight() == null)
			printPaths(arr, pathLength);
		if (root.getRight() != null)
			printAllPossiblePaths_array(arr, pathLength, root.getRight());
		if (root.getLeft() != null)
			printAllPossiblePaths_array(arr, pathLength, root.getLeft());

	}

	private static void printPaths(List<Integer> arr, int pathLength) {
		for (int i = 0; i < pathLength; i++) {
			System.out.print(" - " + arr.get(i));
		}
		System.out.println("");
	}

	public static int height(BSTNode r) {// what is the complexity????? / how to print the elements along the height??
		if (r == null)
			return 0;
		else
			return (1 + Math.max(height(r.getLeft()), height(r.getRight())));
	}

	public static int treeDiameter(BSTNode r) { // what is the complexity??  // how to print the diameter elements??
		if (r == null)
			return 0;
		int lHeight = height(r.getLeft());
		int rHeight = height(r.getRight());
		int lDiameter = treeDiameter(r.getLeft());
		int rDiameter = treeDiameter(r.getRight());
		return (Math.max((lHeight + rHeight + 1),
				Math.max(lDiameter, rDiameter)));
	}
	
	
	// count the total no of different Binary trees's that can be formed with a given
	// number of nodes  . This is equal to the catalan number
	public static int countTrees(int noOfNodes){
		int memo[] = new int[50];
		return countTreesMemoization(noOfNodes,memo);
		
	}

	private static int countTreesMemoization(int noOfNodes,int[] memo) { // what is the complexity??  /

		if (noOfNodes == 0 || noOfNodes == 1) {
			return 1;
		} else {
			int sum = 0, left = 0, right = 0;
			for (int k = 1; k <= noOfNodes; k++) { // loop runs total N times
				if(memo[k-1] == 0){
					memo[k-1] = countTreesMemoization(k-1, memo);
				}
				left = memo[k-1];
				if(memo[noOfNodes-k] == 0){
					memo[noOfNodes-k] = countTreesMemoization(noOfNodes-k, memo);
				}
				right = memo[noOfNodes-k];
				sum = sum + (left * right);		
			}
			return sum;
		}
	}

}
