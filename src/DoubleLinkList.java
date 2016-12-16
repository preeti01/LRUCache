/**
 * DoubleLinkList class to define a double linked list
 * Construct to initialize max size and head and tail pointer
 * Methods :
 */

public class DoubleLinkList 
{

	int maxSize;
	int size=0;
	Node head;
	Node tail;
	
	/**
	 * Constructor to set max size 
	 * initialize head, tail pointer 
	 * and set initial size of list
	 *
	 */
	
	public DoubleLinkList(int maxSize)
	{
		this.maxSize=maxSize;
		this.head=null;
		this.tail=null;
		this.size=0;
	}
    
	/**
	 * Function: To insert specified node at head of list
	 * @param node
	 */
	
	public void insertAtHead(Node node)
	{
		node.next=head;
		node.previous=null;
		if(head!=null)
		{
			head.previous=node;
		}
		head=node;
		if(tail==null)
		{
			tail=head;
		}
		size++;
	}
	
	/**
	 * Function : To remove a specified node
	 * @param node
	 */
	
	public void remove(Node node)
	{
		if(node.previous!=null)
		{
			node.previous.next=node.next;
		}
		else
		{
			head=node.next;
		}
		 if(node.next!=null){
	            node.next.previous = node.previous;
		 }
		 else
		 {
			 tail=node.previous;
		 }
	}
    
	/**
	 * Function: To search the list for a given key 
	 * @param key
	 * @return node
	 */
	
	public Node searchList(String key)
	{
		Node current=head;
		while(current!=null)
		{
			if(current.key==key)
			{
				return current;
			}
		current=current.next;
		}
	 return null;
	}
	
	/**
	 * Function: To return the size of the list
	 * @return size
	 */
	
	public int size()
	{
		return size;
	}
	
	/**
	 * Function : To return the end node of list
	 * @return node
	 */
	
	public Node getTail()
	{
		return tail;
	}
}
