
public class LinkedList<T>{
	
	Node<T> root;
	
	public static void main(String[]args){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Dan");
		list.add("Tyler");
		list.add("Kevin");
		list.printList();
	} 
	
	public String printList(){
		Node<T> curr = root;
		StringBuilder result = new StringBuilder();
		
		if(curr!=null){
			do{
				result.append(curr.getVal());
				System.out.print(curr.getVal());
				
				if(curr.hasNext()){
					result.append(" -> ");
					System.out.print(" -> ");
				}
				curr = curr.getNext();
			}while(curr!=null);
		}
		System.out.println();
		System.out.println();
		
		return result.toString();
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
			root = newNode;
			root.setNext(next);
		}else if( index==size()-1){
			Node lastNode = getLast();
			T lastVal =  (T)lastNode.getVal();
			
			newNode.setVal(lastVal);
			lastNode.setVal(val);
			lastNode.setNext(newNode);
			
		}else{
			for(int i=0; i<index; i++){
				before = next;
				next = next.getNext();
			}
			newNode.setNext(next);
			before.setNext(newNode);
		}
	}
	
	/*
	 * 	return object at index
	 */
	public Object get(int index){
		Node curr = root;
		Object name = null;
		int i = 0;
		int size = size();
		
		if(index >= size || index < 0){
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

