package pack0;

public class BST {
	private int nodeCount = 0; 
	
	 class Node{
		String data; 
		Node left, right; 
		
		public Node(String word) {
			data = word; 
			left = right = null; 
		}
	}

	public Node insert(Node root, int input) {
		
		nodeCount++; 
		return root; 
	}
	
	
}
