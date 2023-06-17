package LinkedList;

import node.Node;

public class LinkedList {

	private Node head;
	private int length;

	public LinkedList() {
		super();
		this.head = null;
		this.length=0;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	public void insertAtFirst(Node newNode) {
		
			newNode.setNext(head);
			head=newNode;
			length++;	
	}
	
	
	public void insertAtLast(Node newNode) {
		if(head==null) {
			head=newNode;
			length++;
		}
		else {
			Node p = head;
			while(p.getNext()!=null) {
				p=p.getNext();
			}
			p.setNext(newNode);
			length++;
		}
	}
	
	
	public void insertAtPosition(int position,Node newNode) {
		if(position<=1) {
			insertAtFirst(newNode);
		}
		else if(position>=length) {
			insertAtLast(newNode);
		}
		else {
			Node temp = head;
			for(int i=1;i<position-1;i++) {
				temp=temp.getNext();
			}
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			length++;
		}
		
	}
	
	public Node removeNodeFromFront() {
		Node node=head;
		if(node!=null) {
			head=node.getNext();
			node.setNext(null);
			length--;
		}
		return node;	
	}
	
	public Node removeFromLast() {
		Node node=head;
		Node node1=head;
		if(node!=null) {
			while(node.getNext().getNext()!=null) {
				node=node.getNext();
				node1=node.getNext();
			}
			node.setNext(null);
			length--;
			
		}
		return node1;
	}
	
	
	
	public Node removeFromPosition(int position) {
		Node node=head;
		Node node1=head;
		
		if(position<=1) {
			return removeNodeFromFront();
		}
		else if(position>=length) {
			return removeFromLast();
		}
		else {
			
		}
	}
	
	
	public void display() {
		if(head==null) {
			System.out.println("Linked list is empty");
		}
		else {
			Node n = head;
			while(n!=null) {
				System.out.print(n.getData()+" ");
				n=n.getNext();
			}
		}
		
	}
}
