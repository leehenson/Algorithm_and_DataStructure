package DataStructure;

class Tree8 {	// 트리 생성  
	class Node {	// 노드 생성 
		int data;
		Node left;
		Node right;
		Node parent;	// 부모 노드 저장할 변수 
		
		Node(int data) {
			this.data = data;
		}
	}
	
	Node root;	// 루트 노드 저장 
	
	Tree8(int size) {	// 트리를 생성하면 이진 검색 트리 생성 
		root = makeBST(0, size - 1, null);
	}
	
	Node makeBST(int start, int end, Node parent) {	// 이진 검새 트리 생성하는 함수 
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1, node);
		node.right = makeBST(mid + 1, end, node);
		node.parent = parent;
		return node;
	}
	
	void findNext(Node node) {	// 다음 노드를 찾는 함수 
		if(node.right == null) {	// 오른쪽 노드가 없는 경우 
			System.out.println(findAbove(node.parent, node).data + " is " + node.data + "'s next");	// 위에서 찾기, 재귀 함수를 호출할 때, 부모 노드와 함께 현재 노드도 인자로 넘김 그래야 내가 어느 쪽 자식이였는지를 확인 가능 
		} else {	// 오른쪽 자식이 있으면 아래에서 찾기 
			System.out.println(findBelow(node.right).data + " is " + node.data + "'s next");
		}
	}
	
	Node findAbove(Node root, Node child) {	// 위에서 찾는 함수 
		if(root == null) return null;	// null Exception  처리 
		if(root.left == child) return root;	// 부모의 왼쪽 노드가 자신과 같으면 그 부모가 바로 다음 노드이기 때문에 부모 노드를 반환 
		return findAbove(root.parent, root);	// 그렇지 않으면 또 부모의 부모를 가지고 해당 함수를 다시 호출, 이 때 부모의 노드도 같이 보내서 부모가 조부모의 어느 쪽 자식이였는지를 비교 
	}
	
	Node findBelow(Node root) {
		if(root.left == null) return root;	// 돌다가 재귀 호출을 멈추는 순간은 왼쪽의 더 이상 자식이 없을 때, 해당 노드가 다음 노드가 된다. 
		return findBelow(root.left);	// 왼쪽 자식 노드를 계속 넘겨주면서 반복적으로 실행해서 맨 마지막 왼쪽 노드를 찾기 
	}
}

public class InorderTest2 {
	public static void main(String[] args) {
		Tree8 t = new Tree8(10);	// 트리 생성 
		t.findNext(t.root.left.right.right);
		t.findNext(t.root.left);
		t.findNext(t.root);
		t.findNext(t.root.left.left);
		t.findNext(t.root.right.left.right);
	}
}