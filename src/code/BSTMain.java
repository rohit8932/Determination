package code;

public class BSTMain {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.root = bst.createBST(bst.root,10);
		bst.root = bst.createBST(bst.root,9);
		bst.root = bst.createBST(bst.root,12);
		
		bst.inorder(bst.root);
		
		System.out.print(bst.searchInBST(bst.root, 12).data);
	}

}
