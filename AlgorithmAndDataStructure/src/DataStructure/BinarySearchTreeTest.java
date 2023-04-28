package DataStructure;

class Tree2 {	// Tree2 클래스 생성 
	class Node {	// Node 내부 클래스 생성 
		int data;	// 정수형 데이터 
		Node left;	// 왼쪽 노드를 저장할 변수 
		Node rigth;	// 오른쪽 노드를 저장할 변수 
		
		Node(int data) {	// 생성자에서 데이터를 받아서 노드에 저장 
			this.data = data;
		}
	}
	
	// Tree의 멤버 변수 
	Node root;	// Tree가 시작되는 root 노드 
	
	public void makeTree(int[] a) {	// 배열 정보를 받아서 Tree를 만드는 일을 시작해주는 메소드 선언 
		root = makeTreeR(a, 0, a.length - 1);	// 이 함수는 재귀 호출을 반복적으로 실행하기 앞서서 재귀호출에 필요한 데이터를 처음으로 던져주는 일을 한다. 그리고 재귀호출이 끝나면 가장 꼭대기에 있는 root노드의 주소를 받아서 멤버변에 저장  
	}
	
	public Node makeTreeR(int[] a, int start, int end) {	// 재귀 함수, 인자로는 배열 정와 시작 인덱스, 끝 인덱스를 받는다.
		if(start > end) return null;	// 이 함수를 반복적으로 호출하다가 시작점이 끝나는 점보다 커져버리면 그 땐 재귀호출을 마치고 null을 반환 
		// 끝나는 시점을 명확하게 해주는 것은 재귀호출에서 가장 중요한 부분이다. 그렇지 않으면 무한 루프를 돌게 된다. 
		int mid = (start + end) / 2;	// 받은 시작점과 끝지점으로 중간지점을 계산하고 
		Node node = new Node(a[mid]);	// 그 중간지점에 저장된 값으로 노드를 생성 
		node.left = makeTreeR(a, start, mid - 1);	// 재귀호출, 시작점부터 중간값 바로 앞에 있는 인덱스까지의 서브 트리를 현재 노드의 left에 저장 
		node.rigth = makeTreeR(a, mid + 1, end);	// 재귀호출, 중간값 바로 다음 인덱스부터 끝지점까지의 데이터로 만든 서브 트리는 현재 노드의 right 노드에 저장
		return node;	// node 반환 
	}
	
	public void searchBTree(Node n, int find) {	// 트리가 잘 만들어졌는지 이진 검색으로 확인하는 함, 검색을 할 시작 노드와 찾을 데이터를 함수의 인자로 받음 
		if(find < n.data) {	// 찾아야하는 값이 현재 노드의 데이터보다 작은 지를 비교하고 
			System.out.println("Data is smaller than " + n.data);	// 우선 진행경로를 확인하기 위해 데이터를 출력 
			searchBTree(n.left, find);	// 찾는 값이 더 작기 때문에 왼쪽 노드 주소와 찾는 값을 넘기고 재귀 호출 
		} else if (find > n.data) {	// 찾는 값이 받은 데이터보다 큰 지를 비교 
			System.out.println("Data is bigger than " + n.data);	// 로그 남김
			searchBTree(n.rigth, find);	// 찾는 값보다 더 크기 때문에 오른쪽 서브 트리에 root주소를 넘김 
		} else {	// 데이터가 크지도 작지도 않으면 같은 것이기 때문에 더 이상 재귀호출을 할 필요가 없기 때문에 찾았다고 로그를 남기고 함수를 종료 
			System.out.println("Data found!");
		}
	}
}

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		int[] a = new int[10];	// 길이가 10인 배열 생성 
		for(int i = 0; i < a.length; i++) {	// 배열에 숫자들을 대입 
			a[i] = i;
		}
		
		Tree2 t = new Tree2();	// Tree2 생성 
		t.makeTree(a);	// makeTree 함수를 호출하여 해당 배열로 트리를 만들고 멤버변수 root에 저장 
		t.searchBTree(t.root, 2);	// searchBTree로 결과 확인 
	}
}