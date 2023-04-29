package DataStructure;

import java.util.LinkedList;
import java.util.ArrayList;

class Tree3 {	// Tree 클래스 생성 
	class Node {	// 이진 트리 노드 생성 
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	Node root;	// 루트를 저장 
	
	Tree3(int size) {	// 생성과 동시에 이진트리를 생성 
		root = makeBST(0, size - 1);
	}
	
	Node makeBST(int start, int end) {	// 이진 트리를 구현하는 함수 
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
	
	ArrayList<LinkedList<Node>> BSTtoList() {	// 재귀 호출을 할 때, 레벨을 함수의 인자로 받아 LinkedList에 추가하는 함수  
		ArrayList<LinkedList<Node>> lists = new ArrayList<>();	// 재귀함수를 호출하기 전에 함수를 호출할 초기값들을 던져줄 함수를 구현, 결과값으로 넘겨줄 배열방을 만들어서 그 안에 LinkedList들을 담아서 반환
		BSTtoList(root, lists, 0); // 재귀 함수에 시작할 때 만들었던 이진 트리의 시작 노드와 결과를 담을 배열방 주소, 그리고 현재 레벨 0이라고 알려주는 함수를 호출 
		return lists;	// 재귀호출을 통해 획득한 결과를 반환 
	}
	
	void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {	// 재귀 함수 정의 
		if(root == null) return;	// 호출 받은 노드가 null이면 그냥 나가기 , 재귀 호출에서는 어디서 멈출지를 명시하는 것은 매우 중요하다. 
		LinkedList<Node> list = null;	// 해당 노드를 담을 리스트 선언 
		if(lists.size() == level) {	// 새로운 레벨에 노드를 처음 호출할 때 해당 레벨의 리스트가 배열방에 존재하지 않기 때문에 
			list = new LinkedList<Node>();	// 새로운 리스트를 하나 만들어서 배열에 추가 
			lists.add(list);
		} else {	// 배열에 해당 레벨의 리스트가 존재하면 
			list = lists.get(level);	// 그곳에 노드를 추가해야 되기 떄문에 레벨 번호로 기존에 있는 리스트의 시작 주소를 획득해 온다. 
		}
		list.add(root);	// 해당 리스트에 노드를 추가 
		BSTtoList(root.left, lists, level + 1);
		BSTtoList(root.right, lists, level + 1);	// 자식 노드들로 level + 1하여 재귀 호출 
	}
	
	ArrayList<LinkedList<Node>> BSTtoList2() {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();	// 결과값을 담을 배열을 선언 
		LinkedList<Node> current = new LinkedList<>();	// 현재 레벨의 노드를 담을 LinkedList 선언 
		if(root != null) {	// 초기값으로 루트 노드를 먼저 담음 
			current.add(root);
		}
		
		while(current.size() > 0) {	// current 리스트에 현재 레벨의 노드들을 담기 위해 현재 레벨에 노드가 있는 동안에는 계속 반복 
			result.add(current);	// while문 이전에 실행한 결과를 올라와서 배열방에 담고 또 새로운 레벨을 시작하는데 처음 시작할 때는 루트 노드를 current에 담았기 때문에 첫 번째 레벨에는 루트만 하나 담기게 된다. 
			LinkedList<Node> parent = current;	// 현재 레벨을 부모 레벨로 변경 
			current = new LinkedList<Node>();	// 현재 레벨은 새로 시작 
			for(Node parents : parent) {
				if(parents.left != null) current.add(parents.left);
				if(parents.right != null) current.add(parents.right);	// 왼쪽이나 오른쪽에 자식이 있으면 현재 레벨에 모두 추가 
			}
		}
		return result;	// 더 이상 현재 레벨에 담을 자식 노드가 하나도 남아있지 않으면 결과 리스트를 담은 배열을 반환 
	}
	
	void printList(ArrayList<LinkedList<Node>> arr) {	// 결과를 출력하는 함수 
		for(LinkedList<Node> list : arr) {	// 	배열을 돌면서 리스트를 가져오기 
			for(Node node : list) {	// 리스트 안에서 노드를 가져오기 
				System.out.print(node.data + " ");	// 노드의 데이터 출력 
			}
			System.out.println();	// 리스트가 하나 끝날 때마다 새로운 라인에 출력 
		}
	}
}

public class BinaryTreeTest {
	public static void main(String[] args) {
		Tree3 t = new Tree3(10);
		t.printList(t.BSTtoList());
	}
}