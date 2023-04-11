package DataStructure;

class LinkedList3 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList3() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
    
    void delete(int d) {
        Node n = header;
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }
    
    void retrieve() {
        Node n = header.next;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
    
    public Node get(int i) {
        Node n = header;
        for(int j=0;j<i;j++){
            n = n.next;
        }
        return n;
    }
}

public class TEST {
	public static void main(String[] args) {
		LinkedList3 ll = new LinkedList3();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		deleteNode(ll.get(3));
		ll.retrieve();
	}
	
	static boolean deleteNode(LinkedList3.Node n) {
		if(n == null || n.next == null) {
			return false;
		} 
		LinkedList3.Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}