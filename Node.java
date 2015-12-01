public class Node<T> {
	private Node next;
	private T val;
	
	public Node(T val){
		this.val = val;
	}
	 
	public Node getNext(){
		return next;
	}
	
	public boolean hasNext(){
		return !(next==null);
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public T getVal(){
		return val;
	}
	
	public void setVal(T val){
		this.val = val;
	}
}
