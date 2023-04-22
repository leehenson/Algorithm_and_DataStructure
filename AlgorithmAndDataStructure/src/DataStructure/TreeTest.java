package DataStructure;

class Node2 {
	int data;
	Node2 left;
	Node2 right;
}

class Tree {
	public Node2 root;
	
	public void setRoot(Node2 node) {
		this.root = node;
	}
	
	public Node2 getRoot() {
		return root;
	}
	
	public Node2 makeNode(Node2 left, int data, Node2 right) {
		Node2 node = new Node2();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	public void inorder(Node2 node) {
		if(node != null) { 
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
	
	public void preorder(Node2 node) {
		if(node != null) {
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder(Node2 node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
}

public class TreeTest {
	public static void main(String[] args) {
		Tree t = new Tree();
		Node2 n4 = t.makeNode(null, 4, null);
		Node2 n5 = t.makeNode(null, 5, null);
		Node2 n2 = t.makeNode(n4, 2, n5);
		Node2 n3 = t.makeNode(null, 3, null);
		Node2 n1 = t.makeNode(n2, 1, n3);
		t.setRoot(n1);
		t.inorder(t.getRoot());
		System.out.println();
		t.preorder(t.getRoot());
		System.out.println();
		t.postorder(t.getRoot());	
	}
}