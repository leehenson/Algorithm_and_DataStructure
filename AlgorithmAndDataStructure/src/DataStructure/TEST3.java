package DataStructure;

class LinkedList5 {
    Node header;

    static class Node {
        int data;
        Node next = null;
        
        Node() {}
        
        Node(int d) {
        	data = d;
        }
        
        public Node get(int d) {
        	Node n = this;
        	for(int i = 0; i < d; i++) {
        		n = n.next;
        	}
        	return n;
        }
        
        public Node addNext(int d) {
        	Node n = new Node(d);
        	this.next = n;
        	return n;
        }
        
        public Node addNext(Node n) {
        	this.next = n;
        	return n;
        }
    }

    LinkedList5() {
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

public class TEST3 {
	public static void main(String[] args) {
		LinkedList5 ll = new LinkedList5();
		ll.append(7);
		ll.append(2);
		ll.append(8);
		ll.append(5);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		LinkedList5.Node n = Partition2(ll.get(1), 5);
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	private static LinkedList5.Node Partition2(LinkedList5.Node n, int x) {
		LinkedList5.Node head = n;
		LinkedList5.Node tail = n;
		
		while(n != null) {
			LinkedList5.Node next = n.next;
			if(n.data < x) {
				n.next = head;
				head = n;
			} else {
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next = null;
		
		return head;
	}
}