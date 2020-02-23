package code;

import code.BinaryTree.Node;

public class BinaryTreeMain {
	public static void main(String[] args) {
		BinaryTree BT = new BinaryTree();
		BT.createBinaryTree(10);
		BT.createBinaryTree(11);
		BT.createBinaryTree(12);
		BT.createBinaryTree(13);
		BT.createBinaryTree(14);
		BT.createBinaryTree(15);
		BT.createBinaryTree(16);
		BT.createBinaryTree(17);
		
//		System.out.println("Recursive PreOrder");
//		BT.recursivePreOrder(BT.root);
//		System.out.println("\nRecursive Inorder");
//		BT.recursiveInorder(BT.root);
//		System.out.println("\nRecursive postorder");
//		BT.recursivePostOrder(BT.root);
//		System.out.println("\nPreorder");
//		BT.preorder(BT.root);
//		System.out.println("\nInorder");
//		BT.inorder(BT.root);
//		System.out.println("\nLevel order");
//		BT.levelorder(BT.root);
		
//		System.out.println(BT.findMaxValue());
//		System.out.println(BT.findValue(18));
//		System.out.println(BT.findElementRecursion(BT.root, 18));
//		System.out.println(BT.sizeOfTree(BT.root));
//		BT.levelorderInReverse();
		
//		BT.deleteTree(BT.root);
//		System.out.println(BT.root.data);
		
//		System.out.println(BT.heightOfTree(BT.root) -1);
//		System.out.println(BT.heightOfTreeNonRecursive(BT.root));
//		System.out.println(BT.numLeafNode(BT.root));
		
//		int[] arr = new int[] {10, 11, 12, 13, 14,};
//		Node root = BT.minimalTree(arr, 0, arr.length - 1, null);
//		BT.levelorder(root);
		
//		BT.listOfDepth(BT.root);
		
//		BT.root.left.left.left.left = new Node(20);
//		System.out.println(BT.checkBalanced(BT.root));
		
//		BT.sumOfPath(BT.root, 0, new int[20], 0); // 20 is max number of node in skwed
		
//		BT.createBinaryTree(1);
//		BT.createBinaryTree(3);
//		BT.createBinaryTree(-1);
//		BT.createBinaryTree(2);
//		BT.createBinaryTree(1);
//		BT.createBinaryTree(4);
//		BT.createBinaryTree(5);
//		System.out.println(BT.pathWithSum(BT.root, 5));
		
//		BT.commonAnchestor(BT.root, 14, 15);
		
		BinaryTree BT2 = new BinaryTree();
		
		BT2.createBinaryTree(11);
		BT2.createBinaryTree(13);
		BT2.createBinaryTree(14);
		BT2.createBinaryTree(17);
		
		System.out.println(BT2.isSubtree(BT.root, BT2.root));
	}

}
