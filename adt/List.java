package adt;

public class List {

	  // the reference to the first node is enough
	  // to characterize a list
	  protected Node first;
	  private int size;

	  // a list is created in an empty state
	  public List() {
	    first = null;
	  }

	  // the new element is located before the
	  // former first node
	  public void insert(Object o) {

	    // step by step code. Could be done in less lines
	    // a node that stores the object and links nowhere
	    Node tmp = new Node(o, null);

	    // the following sentence has no problem with null values of "first"
	    tmp.setNext(first);
	    // we move the "first" reference
	    first = tmp;
	    this.size++;
	  }

	  // extracts the first element and returns its object
	  public Object extract() {
	    Object out = null;

	    // if first is null, you cannot call its methods
	    if (!isEmpty()) {
	      out = first.getInfo();
	      first = first.getNext();
	    }
	    this.size--;

	    // if the list is empty, null should be returned, but this is
	    // the default value of "out"
	    return out;
	  }

	  public void print(int n) {
	    // if the list is empty, do nothing
	    if (!isEmpty()) {
	      Node tmp = first;

	      // iterates until i reaches n or the list is finished.
	      for (int i = 0; i < n; i++) {
	        tmp = tmp.getNext();
	        if (tmp == null)
	          return; // the list is finished
	      }
	      System.out.println(tmp.getInfo());
	    }
	  }

	  public void print() {
	    // if the list is empty, do nothing
		 System.out.print("[");
	    if (!isEmpty()) {
	      Node tmp = first;
	      // iterates until the list is finished
	      
	      while (tmp != null) {
	        System.out.print(tmp.getInfo()+",");
	        tmp = tmp.getNext();
	      }
	      
	    }
	    System.out.print("]");
	  }

	  public boolean isEmpty() {
	    if (first == null)
	      return true;
	    else
	      return false;
	  }
	  
	  public Node getFirst() {
			return first;
		}
	  
	  public int getSize() {
			return size;
		}
	  
	  public void setFirst(Node first) {
			this.first=first;
		}
	  
	  
	  public Object get(int n) {
		  Node tmp=first;
		  for (int i=0;i<n;i++) {
			  tmp=tmp.getNext();
		  }
		  return tmp.getInfo();
	  }
	  
	  public List copy() {
		  List l1=new List();
		  Node tmp=this.first;
		  while (tmp!=null) {
			  l1.insert(tmp.getInfo());
			  tmp=tmp.getNext();
		  }
		  return l1;
	  }
	  
	  public boolean in(Object o) {
		  Node tmp=this.first;
		  while (tmp!=null) {
			  if (tmp.getInfo()==o) {
				  return true;
			  }
			  tmp=tmp.getNext();
		  }
		  return false;
	  }
	  
	  public void extract_o(Object o) {
		    Node tmp=this.first;
		    while (tmp.getNext().getInfo()!=o) {
		    	tmp=tmp.getNext();
		    }
		    tmp.setNext(tmp.getNext().getNext());
		    this.size--;

		  }
          public void berga(){
          System.out.println("Tome esta thomas");
          }
	}



