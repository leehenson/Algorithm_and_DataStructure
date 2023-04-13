package DataStructure;

import static DataStructure.LinkedList5.Node;

public class TEST4 {
	public static void main(String[] args) {
		LinkedList5 l1 = new LinkedList5();
		l1.append(9);
		l1.append(1);
		l1.append(4);
		l1.retrieve();
		
		LinkedList5 l2 = new LinkedList5();
		l2.append(6);
		l2.append(4);
		l2.append(3);
		l2.retrieve();
		
		Node n = sumLists(l1.get(1), l2.get(1), 0);
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	private static Node sumLists(Node l1, Node l2, int carry) {
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		Node result = new Node();
		int value = carry;
		
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		
		if(l1 != null || l2 != null) {
			Node next = sumLists(l1 == null ? null : l1.next,
								 l2 == null ? null : l2.next,
								 value >= 10 ? 1 : 0);
			result.next = next;
		}
		return result;
	}
}