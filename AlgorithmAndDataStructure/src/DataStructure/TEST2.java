package DataStructure;

class LinkedList4 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList4() {
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

public class TEST2 {
	public static void main(String[] args) {
		LinkedList4 ll = new LinkedList4();
		ll.append(7);
		ll.append(2);
		ll.append(8);
		ll.append(5);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		LinkedList4.Node n = Partition(ll.get(1), 5);
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	private static LinkedList4.Node Partition(LinkedList4.Node n, int x) {
		LinkedList4.Node s1 = null;
		LinkedList4.Node e1 = null;
		LinkedList4.Node s2 = null;
		LinkedList4.Node e2 = null;
		
		while(n != null) {
			LinkedList4.Node next = n.next;
			n.next = null;
			if(n.data < x) {
				if(s1 == null) {
					s1 = n;
					e1 = s1;
				} else {
					e1.next = n;
					e1 = n;
				}
			} else {
				if(s2 == null) {
					s2 = n;
					e2 = s2;
				} else {
					e2.next = n;
					e2 = n;
				}
			}
			n = next;
		}
		if(s1 == null) {
			return s2;
		}
		e1.next = s2;
		return s1;
	}
}