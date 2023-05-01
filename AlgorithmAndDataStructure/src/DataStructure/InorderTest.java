package DataStructure;

class Tree7 {
	class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	Node root;	// 루트 노드를 멤버 변수로 선언 
	int size;	// 사이즈를 멤버 변수로 선언 
	
	Tree7(int size) {	// 트리를 생성할 때, 사이즈로 이진 트리 생성 
		this.size = size;
		root = makeBST(0, size - 1);
		root.right.right.right.left = new Node(9); this.size++;
		root.right.right.right.right = new Node(9); this.size++;
		root.right.right.right.left.left = new Node(9); this.size++;
		root.right.right.right.left.right = new Node(9); this.size++;
		root.right.right.right.left.left.left = new Node(8); this.size++;
		root.right.right.right.left.left.right = new Node(9); this.size++;
	}
	
	Node makeBST(int start, int end) {	// 이진 트리를 구현하는 함수 
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
	
	boolean isValidateBST1() {
		int[] array = new int[size];	// 노드 갯수 만큼의 길이를 가지는 배열 생성 
		inorder(root, array);	// 시작 노드와 순서대로 가져온 데이터를 담을 배열의 주소를 넘기면서 inorder함수 호출 
		for(int i = 1; i < array.length; i++) {	// inorder 함수에서 저장한 배열을 돌면서 바로 왼쪽에 있는 데이터가 현재 데이터보다 크면 false 반환 
			if(array[i] < array[i - 1]) {
				return false;
			}
		}
		return true;	// 돌면서 잘못된 부분이 없으면 true를 반환 
	}
	
	int index = 0;	// 몇 번 배열까지 담았는지 기억하고 있을 정수 선언 
	void inorder(Node root, int[] array) {
		if(root != null) {	// 노드가 null이 아닐 때까지 반복 
			inorder(root.left, array);	// 순서에 입각해서 왼쪽 노드를 먼저 호출 
			array[index] = root.data;	// 나 자신을 배열에 출력 
			index++;	// 배열의 데이터 사이즈를 하나 증가 
			inorder(root.right, array);	// 노드의 오른쪽 서브 트리들을 재귀적으로 호출 
		}
	}
	
	Integer last_printed = null;	// 바로 이전 노드에 있었던 값을 저장하는 last_printed라는 변수를 정수 객체에 주소를 넘길 수 있도록 클래스 타입으로 선언 
	boolean isValidateBST2() {
		return isValidateBST2(root);	// 인자가 없이 호출되면 root 노드를 시작 노드로 재귀 호출을 시작 
	}
	
	boolean isValidateBST2(Node n) {	// 재귀 함수는 노드를 받고 boolean 타입으로 true나 false를 반환 
		if(n == null) return true;	// 노드의 마지막을 지나면 true를 반환 
		if(!isValidateBST2(n.left))	return false;	// 왼쪽 노드들을 돌면서 결과를 받아서 만약에 정렬되어있지 않은 값을 이미 만났으면 false를 반환 
		if(last_printed != null && n.data < last_printed) {	// 그렇지 않으면 바로 전에 저장된 값을 현재 노드의 값과 비교 
			return false;	// 만약 전의 값이 현재값보다 더 크면 순서가 틀렸기 때문에 false를 반환 
		}
		last_printed = n.data;	// 문제 없이 통과 되었으면 현재 데이터 값을 이전 값에 할당 
		if(!isValidateBST2(n.right)) return false;	// 오른쪽 노드들을 돌다가 문제가 되는 결과를 받으면 false를 반환 
		return true;	// 끝까지 false 조건에 안 걸리면 true를 반환 
	}
	
	boolean isValidateBST3() {
		return isValidateBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);	// 재귀 함수의 인자를 초기화하여 호출 
	}
	
	boolean isValidateBST3(Node n, int min, int max) {	// 노드와 최소, 최대값을 받는 재귀 함수 선언 
		if(n == null) {	// 노드가 null이면 재귀 호출을 종료 
			return true;
		}
		if(n.data < min || n.data > max) {	// 노드의 값이 최소, 최대값의 영역을 벗어나면 false를 반환 
			return false;
		}
		if(!isValidateBST3(n.left, min, n.data) || !isValidateBST3(n.right, n.data, max)) {	// 그렇지 않으면 왼쪽 오른쪽 노드들을 가지고 다시 함수를 호출, 왼쪽으로 이동할 때는 최대값을 현재값으로 대체, 오른쪽으로 이동할 때는 최소값을 현재값으로 대체하여 범위를 좁혀준다. 
			return false;	// 두 개의 결과중에 하나라도 false가 있으면 false를 반환 
		}
		return true;	// 모든 조건을 통과하면 true를 반환 
 	}
}

public class InorderTest {
	public static void main(String[] args) {
		Tree7 t = new Tree7(10);	// 트리 생성 
		System.out.println("Solution 1 - using inorder: " + t.isValidateBST1());	// 첫 번째 솔루션의 결과값 출력 
		System.out.println("Solution 2 - without array: " + t.isValidateBST2());	//  번째 솔루션의 결과값 출력 
		System.out.println("Solution 3 - min/max: " + t.isValidateBST3());	//  번째 솔루션의 결과값 출력 
	}
}