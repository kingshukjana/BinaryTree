
// java program to print all paths
//given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/

class PrintRootToLeafPath {
	BST bst;

	private static void printPaths(BSTNode node) {
		int path[] = new int[100];
		printPathsRecur(node, path, 0);
	}

	private static void printPathsRecur(BSTNode node, int[] path, int arrayIndexUpto) {

		if (node == null)
			return;
		path[arrayIndexUpto] = node.getData();// NOTE:this will come before print array
		//arrayIndexUpto++;
		if (node.getLeft() == null && node.getRight() == null) {
			printArray(path, arrayIndexUpto);
		}
		printPathsRecur(node.getLeft(), path, arrayIndexUpto+1);//imp:we need not send arrayIndexUpto+1
		printPathsRecur(node.getRight(), path, arrayIndexUpto+1);

	}

	/* Utility that prints out an array on a line */
	static void printArray(int ints[], int arrayIndexUpto) {
		int i;
		for (i = 0; i <= arrayIndexUpto; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// binary tree can be constructed from inorder and preorder
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
		printPaths(bst.getRoot());
	}

}