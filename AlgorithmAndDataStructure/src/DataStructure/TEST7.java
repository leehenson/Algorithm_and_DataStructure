package DataStructure;

import static DataStructure.LinkedList5.Node;

import DataStructure.LinkedList5.Node;

public class TEST7 {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = n1.addNext(2);
		Node n3 = n2.addNext(3);
		Node n4 = n3.addNext(4);
		Node n5 = n4.addNext(5);
		Node n6 = n5.addNext(6);
		Node n7 = n6.addNext(7);
		Node n8 = n7.addNext(8);
		n8.addNext(n4);
		
		Node n = findLoop(n1);
		
		if(n != null) {
			System.out.println("Start of loop : " + n.data);
		} else {
			System.out.println("Loop not found");
		}
	}
	
	private static Node findLoop(Node head) {
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				break;
			}
		}
		
		if(fast == null || fast.next == null) {
			return  null;
		}
		
		slow = head;
		
		while(fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
}