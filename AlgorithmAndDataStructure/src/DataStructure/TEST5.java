package DataStructure;

import static DataStructure.LinkedList5.Node;

class Storage {
	int carry = 0;
	Node result = null;
}

public class TEST5 {
	public static void main(String[] args) {
		LinkedList5 l1 = new LinkedList5();
		l1.append(9);
		l1.append(1);
		l1.retrieve();
		
		LinkedList5 l2 = new LinkedList5();
		l2.append(1);
		l2.append(1);
		l2.retrieve();
		
		Node n = sumLists(l1.get(1), l2.get(1));
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	private static Node sumLists(Node l1, Node l2) {
		int len1 = getListLength(l1);
		int len2 = getListLength(l2);
		
		if(len1 < len2) {
			l1 = LPadList(l1, len2 - len1);
		} else {
			l2 = LPadList(l2, len1 - len2);
		}
		
		Storage storage = addLists(l1, l2);
		if(storage.carry != 0) {
			storage.result = insertBefore(storage.result, storage.carry);
		}
		return storage.result;
	}
	
	private static Storage addLists(Node l1, Node l2) {
		if(l1 == null && l2 == null) {
			Storage storage = new Storage();
			return storage;
		}
 		Storage storage = addLists(l1.next, l2.next);
 		int value = storage.carry + l1.data + l2.data;
 		int data = value % 10;
 		storage.result = insertBefore(storage.result, data);
 		storage.carry = value / 10;
 		return storage;
	}
	
	private static int getListLength(Node l) {
		int total = 0;
		while(l != null) {
			total++;
			l = l.next;
		}
		return total;
	}
	
	private static Node insertBefore(Node node, int data) {
		Node before = new Node(data);
		if(node != null) {
			before.next = node;
		}
		return before;
	}
	
	private static Node LPadList(Node l, int length) {
		Node head = l;
		for(int i = 0; i < length; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
}