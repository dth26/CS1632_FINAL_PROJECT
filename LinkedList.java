
public class LinkedList<T>{
	
	Node<T> root;
	
	
	
	public static void main(String[]args){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Dan");
		list.add("Tyler");
		list.add("Kevin");
		list.printList();
	}
	
	
	
	public void printList(){
		Node<T> curr = root;
		
		if(curr!=null){
			do{
				System.out.print(curr.getVal() + "->");
				curr = curr.getNext();
			}while(curr!=null);
		}
	}
	
	
	
	public int size(){
		Node<T> curr = root;
		int size = 0;
		
		if(curr!=null){
			do{
				size++;
				curr = curr.getNext();
			}while(curr!=null);
		}
		
		return size;
	}
	
	
	
	public Node<T> getLast(){
		Node<T> curr = root;
		Node<T> last = null;
		
		if(curr!=null){
			do{
				last = curr;
				curr = curr.getNext();
			}while(curr!=null);
		}
		
		return last;
	} 
	

	
	public void add(Node<T> n){
		if(root==null){
			root = n;
		}else{
			Node<T> curr = getLast();
			curr.setNext(n);
		}
	}
	
	
	
	public void add(T val){
		
		if(root==null){
			root = new Node<T>(val);
		}else{
			Node<T> curr = getLast();
			Node<T> newNode = new Node<T>(val);
			curr.setNext(newNode);
		}
	}
	
	
	
	public void addFirst(T val){
		Node newNode = new Node(val);
		
		if(root == null){
			root = newNode;
		}else{
			Node next = root;
			root = newNode;
			newNode.setNext(next);
		}
	}
	
	
	
	public void addLast(T val){
		Node newNode = new Node(val);
		
		if(root == null){
			root = newNode;
		}else{
			Node last = getLast();
			last.setNext(newNode);
		}

	}
	
	
	
	public int indexOf(T val){
		int result = -1;
		int index = 0;
		Node curr = root;
		
		if(curr!=null){
			do{
				
				if(curr.getVal().equals(val)){
					result = index;
					break;
				}
						
				curr = curr.getNext();
				index++;
			}while(curr!=null);
		}
		
		return result;
	}
	
	
	
	// Removes the first occurrence of the specified element in this list. 
	public void remove(T val){
		Node curr = root;
		Node prev = curr;
		Node next = null;
		
		if(curr!=null){
			
			// check if element being removed is the first element
			if(curr.getVal().equals(val)){
				next = curr.getNext();
				root = next;
			}else{
				do{
					
					if(curr.getVal().equals(val)){
						next = curr.getNext();
						prev.setNext(next);
						break;
					}
					prev = curr;
					curr = curr.getNext();
				}while(curr!=null);
			}
		}
	}
	
	
	public void addAtIndex(T val, int index){
		Node next = root, before = null;
		Node newNode = new Node(val);
		
		
		if(index==0){
			
			if(next.hasNext()){
				next = next.getNext();
				root = newNode;
				root.setNext(next);
			}else{
				root = newNode;
			}
		
			
		}else if( index==size()-1){
			
			Node last = getLast();
			last.setNext(newNode);
			
		}else{
			
			for(int i=0; i<index; i++){
				before = next;
				next = next.getNext();
			}
			
			newNode.setNext(next);
			before.setNext(newNode);
		}
		

	}
	
	
	public Object get(int index){
		
		Node curr = root;
		Object name = null;
		int i = 0;
		int size = size();
		
		//System.out.println(index);
		
		if(index >= size || index < 0){
			//System.out.println("outofbounds");
			throw new IndexOutOfBoundsException();
		}else{
			
			do{
				name = curr.getVal();
				curr = curr.getNext();
				
				i++;
				
			}while(i<=index);				
		
		}
		
		return name;
	}
	
	
	
	public void clear(){
		root = null;
	}
}




























