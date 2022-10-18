package Linkedlist;


public class doubly_linkedlist_insertion {
        Node head=null;
        Node tail=null;
    public class Node{
        int data;
        Node next;
        Node prev;

        Node(int data)
        {
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }
    
    //inserting in the start

    public void insertion(int data)
    {
        Node newNode=new Node(data);
        newNode.next=null;
        newNode.prev = null;
        if(head==null)
        {
            head=newNode;
            tail=newNode;
            head.prev=null;
            tail.next=null;

        }
        else
        {
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            newNode.prev=null;
        }

    }
    
    //inserting in the last
    
    public void insertEnd(int data)
    {
    	Node newNode=new Node(data);
    	Node curNode=head;
    	if(head==null)
    	{
    		head=newNode;
    		tail=newNode;
    		head.next=null;
    		return;
    	}
    	
    	while(curNode.next!=null)
    	{
    		curNode=curNode.next;
    	}
    	newNode.next=null;
    	curNode.next=newNode;	
    	newNode.prev=curNode;	
    }
    
    //insertion at the given position
    public void insertAtPos(int data,int pos)
    {
    	Node newNode=new Node(data);
    	Node curNode=head;
    	if(head==null)
    	{
    		head=newNode;
    		head.next=null;
    		tail.next=null;
            return;
    	}
    	
    	if(pos < 1) {
    	      System.out.print("\nposition should be >= 1.");
    	    } 
    	else if(pos==1)
    	{
    		 newNode.next = head;
    	      head.prev = newNode;
    	      head = newNode;
    	}
    	else
    	{
         for(int i = 1; i < pos-1; i++) {
           if(curNode != null) {
             curNode = curNode.next;
           }
         }
    	}
    	
    	if(curNode != null) {
            newNode.next = curNode.next; //for previous link
            newNode.prev=curNode;
            curNode.next=newNode; 
            if(newNode.next != null)
              newNode.next.prev = newNode;
          } else {
            System.out.print("\nThe previous node is null.");
          } 
    	}
    
        
   public void print()
    {
        Node curNode=head;
        if(head==null)
        {
            System.out.println("list is empty");
        }
        while(curNode!=null)
        {
            System.out.print("<--"+curNode.data+"-->");
            curNode=curNode.next;
        } 
        System.out.print("Null");
    }

    public static void main(String args[])
    {
        doubly_linkedlist_insertion list=new doubly_linkedlist_insertion();
        
        System.out.print("Insertion at the beginning:");
        System.out.print("\n");
        list.insertion(2);
        list.insertion(3);
        list.insertion(4);
        list.insertion(5);
        list.print();
        
        System.out.print("\n \nInsertion at the end:");
        System.out.print("\n");    
        list.insertEnd(2);
        list.insertEnd(7);
        list.insertEnd(8);
        list.print();
        
       
        
        System.out.print("\n \nInsertion at the given pos:");
        System.out.print("\n");    
        list.insertAtPos(17,3);
        list.print();

    }

}