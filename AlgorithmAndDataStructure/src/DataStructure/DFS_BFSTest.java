package DataStructure;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

class Graph {
	
	class Node { // Node
		int data;	// Node의 정수형 data
		LinkedList<Node> adjacent;	// 해당 노드의 인접한 Node
		boolean marked;	// 해당 노드에 방문했는지 확인하는 marking하는 flag
		
		Node(int data) {	// Node의 생성, data를 받고 marking flag는 false로 초기화하고 LinkedList를 준비 
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<>();
		}
	}
	
	Node[] nodes;	// 그래프안에 노드들을 저장할 배열 
	
	Graph(int size) {	// 간단하게 하기 위해 그래프의 노드 갯수는 고정 
		nodes = new Node[size];	// 노드의 갯수를 받아서 그 갯수만큼 배열을 생성 
		for(int i = 0; i < size; i++) {	// 편의를 위해 데이터와 배열방 번호를 동일하게 설정 
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {	// 두 노드의 관계를 저장하는 함수 
		Node n1 = nodes[i1];	// 데이터가 인덱스와 같기 떄문에 받은 숫자를 인덱스로 사용 
		Node n2 = nodes[i2];
		
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
		
		// 두 개의 노드의 인접한 노드들을 저장하는 LinkedList에 상대방이 있는지 확인하고 없으면 서로 추가 
	}
	
	void dfs() {	// dfs()를 그냥 호출하면 0번부터 시작 
		dfs(0);
	}
	
	void dfs(int index) {	// 시작 인덱스를 받아서 dfs 순회 결과를 출력하는 함수 
		Node root = nodes[index];	// 해당 인덱스의 노드 가져오기 
		Stack<Node> stack = new Stack<>();	// Stack 하나 생성 
		stack.push(root);	// 현재 노드를 Stack에 추가 
		root.marked = true;	// Stack에 들어갔었는지 표시 
		while(!stack.isEmpty()) {	// Stack에 데이터가 없을 때 까지 반복 
			Node r = stack.pop();	// Stack에서 데이터 하나 출력 
			for(Node n : r.adjacent) {	// 가져온 노드들의 인접한 노드들중 Stack에 추가된 적 없는 노드를 추가  
				if(n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void bfs() {	// bfs()를 그냥 호출하면 0번부터 시작 
		bfs(0);
	}
	
	void bfs(int index) { 
		Node root = nodes[index];	// bfs() 함수에서 인덱스로 받은 인자로 노드를 받아 옴 
		Queue<Node> queue = new Queue<>();// Queue를 하나 생성 
		queue.add(root);	// 데이터를 queue에 추가 
		root.marked = true;
		while(!queue.isEmpty()) {	// queue가 다 비어있을 때까지 반복 
			Node r = queue.remove();	// Queue에서 데이터 가져오기 
			for(Node n : r.adjacent) {	// Queue에서 꺼낸 노드의 추가된 적 없는 자식 노드들을 Queue에 추가 
				if(n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}
			visit(r);
		}
		
	}
	
	void dfsR(Node r) {	// 재귀 호출을 이용한 dfs, 재귀 호출을 할 때는 LinkedList가 노드의 주소를 가지고 있기 때문에 재귀 함수는 노드를 받는 형태 
		if(r == null) return;	// 받은 노드가 null이면 그냥 반환 
		r.marked = true;	// 호출이 되었었다고 노드에 마킹 
		visit(r);	// 인접한 노드를 호출하기 전에 데이터를 먼저 출력 
		for(Node n : r.adjacent) {	// 호출이 되지 않은 인접한 노드들을 호
			if(n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int index) {	// 시작 노드를 다양하게 테스트하기 위해서 배열의 인덱스를 받는 형태로도 선언 
		Node r = nodes[index];	// 인덱스를 받으면 노드를 찾
		dfsR(r);	// 해당 노드를 시작으로 재귀호출 
	}
	
	void dfsR() {	// 아무것도 호출하지 않았을 때는 0부터 시작 
		dfsR(0);
	}
	
	void visit(Node n) {	// 방문했을 때 출력하는 함수 
		System.out.print(n.data + " ");
	}
}

public class DFS_BFSTest {
	public static void main(String[] args) {
		Graph g = new Graph(9);	// 9개의 노드를 갖는 그래프 생성 
		g.addEdge(0, 1);	// 그래프의 관계 명시 
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		g.dfsR(3);
	}
}