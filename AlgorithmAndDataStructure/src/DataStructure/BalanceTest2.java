package DataStructure;

import DataStructure.Tree3.Node;

class Tree5 {	// Tree 클래스 생성 
	class Node {	// Node 내부 클래스 생성 
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	Node root;	// root를 저장할 노드 
	
	Tree5(int size) {	// Tree4 생성자를 통해 이진트리 생성 
		root = makeBST(0, size - 1);
//		root.right.right.right.right = new Node(10);
	}
	
	Node makeBST(int start, int end) {	// 이진 트리를 구현하는 함수 
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
	
	boolean isBalanced(Node root) {	// boolean 타입의 데이터를 반환하는 함수 선언 함수의 인자로는 노드의 주소를 받는다. 
		if(root == null) return true;	// 마지막 노드를 지났으면 더 이상 진행하지 않고, true를 반환 
		int heightDiff = getHeight(root.left) - getHeight(root.right);	// 양 쪽 서브트리의 길이를 받아서 그 차이를 저장 
		if(Math.abs(heightDiff) > 1) {	// 그 차이가 1이상 차이가 나면 
			return false;	// false를 반환 
		} else {	// 그렇지 않으면 
			return isBalanced(root.left) && isBalanced(root.right);	// 왼쪽과 오른쪽이 모두 밸런스가 맞는지 and 연산자로 둘 다 맞는 경우에만 true로 반환 
		}
	}
	
	int getHeight(Node root) {	// 노드를 던지면 해당 노드를 루트로 이하 서브 트리의 가장 긴 줄기의 레벨이 몇인지 알아오는 함수 
		if(root == null) return -1;	// 돌다가 트리의 마지막 노드를 지나면 -1를 반환해서 레벨 카운팅 번호에서 하나를 빼줌 
		return Math.max(getHeight(root.right), getHeight(root.right)) + 1;	// 그렇지 않으면 왼쪽 오른쪽 자식 노드들을 반복적으로 호출하면서 둘 중 더 긴 줄기를 선택하고 거기다가 1를 더해서 반환, 반환할 때마다 1를 더하면 함수가 벗겨질 때마다 레벨이 하나씩 증가하면서 세어나간다.  
	}
	
	int checkHeight(Node root) {	// 길이를 재는 함수 선언 
		if(root == null) return -1;	// 재귀 호출이 끝나는 시점은 마지막 노드를 지나면 레벨에서 하나 뺀다. 
		int leftHeight = checkHeight(root.left);	// 왼쪽 노드를 돌면서 서브트리의 길이를 잰다. 
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;	// 	받은 결과값이 정수값중 가장 작으면 false를 반환 
		int rightHeight = checkHeight(root.right);	// 오른쪽 노드를 돌면서 서브트리의 길이를 잰다. 
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;	// 	받은 결과값이 정수값중 가장 작으면 false를 반환 
		int heightDiff = leftHeight - rightHeight;	// false가 아닌 경우에는 해당 결과값이 서브트리의 길이가 되기 때문에 양쪽 서브트리의 가장 긴 줄기끼리 비교하여 
		if(Math.abs(heightDiff) > 1) {	// 그 차이가 1이 넘으면
			return Integer.MIN_VALUE;	// false를 반
		} else {	// 아니면 두 개의 길이중 큰 값에 1를 더해서 반환 
			return Math.max(leftHeight, rightHeight) + 1;	// 여기서 1를 더해서 반환하면 재귀 호출을 맨 끝에서 한 커풀 벗겨질 때마다 1씩 증가해서 길이로 사용 가능 
		}
	}
	
	boolean isBalanced2(Node root) {	// 재귀 함수를 호출해줄 함수 선언 
		return checkHeight(root) != Integer.MIN_VALUE;	// checkHeight 결과값이 정수의 가장 작은 값이 아니면 	true를 반환 
	}
}

public class BalanceTest2 {
	public static void main(String[] args) {
		Tree5 t = new Tree5(10);	// 10개의 노드를 가지는 이진 트리 생성 
		System.out.println(t.isBalanced2(t.root));	// isBalanced 함수 호출하여 출력 
	}
}