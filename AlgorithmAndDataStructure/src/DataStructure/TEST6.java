package DataStructure;

import static DataStructure.LinkedList5.Node;

import DataStructure.LinkedList5.Node;

public class TEST6 {
	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = n1.addNext(7);
		Node n3 = n2.addNext(9);
		Node n4 = n3.addNext(10);
		Node n5 = n4.addNext(7);
		Node n6 = n5.addNext(6);
		
		Node m1 = new Node(6);
		Node m2 = m1.addNext(8);
		Node m3 = m2.addNext(n4);
		
		Node n = getIntersection(n1, n2);
		
		if(n != null) {
			System.out.println("Intersection : " + n.data);
		} else {
			System.out.println("Not found");
		}
	}
	
	private static Node getIntersection(Node l1, Node l2) {
		int len1 = getListLength(l1);
		int len2 = getListLength(l2);
		
		if(len1 > len2) {
			l1 = l1.get(len1 - len2);
		} else if(len1 < len2) {
			l2 = l2.get(len2 - len1);
		}
		
		while(l1 != null && l2 != null) {
			if(l1 == l2) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return null;
	}
	
	private static int getListLength(Node l) {
		int total = 0;
		while(l != null) {
			total++;
			l = l.next;
		}
		return total;
	}
}