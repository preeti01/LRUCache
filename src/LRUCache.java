import java.util.Scanner;

/**
 * 
 * @Main Class : LRUCache which provides the functionality for 
 * Least Recently used cache.
 * Constructor to initialize cache size
 * Methods: get method, add or update method , main
 */

public class LRUCache 
{

	int maxSize;
	DoubleLinkList list;
	
	/** 
	 * LRUcache Constructor : set the max cache size  
	 * @param maxSize
	 */
	
	public LRUCache(int maxSize)
	{  
		this.maxSize=maxSize;
	    list=new DoubleLinkList(maxSize);
		
	}
	
	/**
	 * Function: To get items from the cache
	 * @param key
	 * @return value of specified key
	 */
	
	public String get(String key)
	{ 
		 Node node;
		 node=list.searchList(key);
		 if(node!=null)
		 {	 
			list.remove(node);
			list.insertAtHead(node);
			return node.value;
		}
		else
		{
			return "NOTFOUND";
		}
	}
	
	/**
	 * Function: To set or update items (that already exist)in cache
	 * @param key, value
	 * 
	 */
	
	public void addOrUpdate(String key,String value)
	{
		Node old;
		old=list.searchList(key);
		if(old!=null)
		{
			old.value=value;
			list.remove(old);
			list.insertAtHead(old);
		}
		else
		{
			Node newnode = new Node(key,value);
			if(list.size()>=maxSize)
			{			
		        list.remove(list.getTail());
			    list.insertAtHead(newnode);
			}
			else
			{
				list.insertAtHead(newnode);
				
			}

		}
	}
	
	/**
	 * Main Method from where the program execution begins
	 * @param args Unused
	 */
	
	public static void main(String[] args) 
	{
		int cacheSize = 0;
	
		Scanner input = new Scanner(System.in);
	    String sizeCommand = input.next().trim();
	    if(!sizeCommand.equalsIgnoreCase("Size"))
	    {
	    	System.out.println("Error,first enter size");
	    	System.exit(0);
	    }
			
		try
		{
			cacheSize = Integer.parseInt(input.nextLine().trim());
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Invalid input, it should be a number,try again");
			System.exit(0);
		}
		
        LRUCache cache = new LRUCache(cacheSize);
        System.out.println("Size ok");
        String command;
		
        do
		{
			command=input.next().toLowerCase();
			switch(command)
			{
			 case "get":
				String str =input.nextLine();
				String[] parts= str.split(" ");
				
				if(parts.length>2)
				{
					System.out.println("ERROR");
					break;
				}
				String key=parts[1];
				String value=cache.get(key);
				if(!value.equals("NOTFOUND"))
				{
					System.out.println("GOT" + " " + value);
				}
				else
				{
					System.out.println(value);
				}
				
			 break;
			
			case "set":
				String s =input.nextLine();
				String[] part= s.split(" ");
				if(part.length>=4)
				{
					System.out.println("ERROR");
					break;
				}
				String keytoset=part[1];
				String valuetoset=part[2];
				cache.addOrUpdate(keytoset, valuetoset);
				System.out.println("set ok");
				break;
				
			case "exit":
				System.exit(0);
			}
			
		}while(input.hasNext());
			
	}

}
