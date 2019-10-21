package CODE;

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
		
		System.out.println(BT.heightOfTree(BT.root) -1);
		System.out.println(BT.heightOfTreeNonRecursive(BT.root));
		System.out.println(BT.numLeafNode(BT.root));
	}

}
