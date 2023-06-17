package tester;

import LinkedList.LinkedList;
import node.Node;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		
		linkedList.insertAtFirst(new Node(5));
		linkedList.insertAtFirst(new Node(6));
		linkedList.insertAtFirst(new Node(7));
		linkedList.insertAtFirst(new Node(8));
		linkedList.insertAtFirst(new Node(9));
		linkedList.insertAtLast(new Node(4));
		linkedList.insertAtLast(new Node(3));
		linkedList.insertAtLast(new Node(2));
		linkedList.insertAtPosition(8, new Node(5));
		
		
		linkedList.display();
		
		System.out.println(linkedList.getLength());
		
		
		System.out.println("node with data "+linkedList.removeNodeFromFront().getData()+" is removed");
		
		
		linkedList.display();
		
		System.out.println(linkedList.getLength());
		
		
		System.out.println("node with data "+linkedList.removeFromLast().getData()+" is removed");
		
		linkedList.display();
		
		System.out.println(linkedList.getLength());
	}

}
