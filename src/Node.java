/**
 * Node class that defines a node which will be used in doubly linked list
 * Stores key, value pairs in node 
 * And have previous and next pointer
 */ 

public class Node {

	String key;
	String value;
    Node previous;
    Node next;
    public Node(String key,String value)
    {
    	this.key=key;
    	this.value=value;
    	this.previous=null;
    	this.next=null;
    }
}
