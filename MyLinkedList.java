package lab7;

public class MyLinkedList  implements MyList, Queue, Stack {
	private Node header;
	private int size;
	
	MyLinkedList(){
		this.header = new Node (null, header, header);
		this.size=0;
	}
	public int size(){
		return this.size;
	}
	@Override
	public void set(int index, Object element){
		isEmptyCheck();
		isCorrectIndexCheck(index);
		Node temp = header.nextElement;
		int counter =0;
		while (counter<index){
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		temp.setElement(element);
	}
	
	public Object remove(int index){
		isEmptyCheck();
		isCorrectIndexCheck(index);
		int counter = 0;
		Node temp = header.nextElement;
		while (counter<index){
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		Object valueToReturn = temp.getElement();
		temp.remove();
		return valueToReturn;
		
	}
	public Object removeFirst(){
		isEmptyCheck();
		Node temp = header.nextElement;
		Object value = temp.getElement();
		temp.remove();
		return value;
	}
	public Node removeFirstNode(){
		isEmptyCheck();
		Node temp = header.nextElement;
		Node returnedNode = new Node (temp.getElement(),null,null);
		temp.remove();
		return returnedNode;
	}
	public Object removeLast(){
		isEmptyCheck();
		Node temp = header.previousElement;
		Object value = temp.getElement();
		temp.remove();
		return value;
	}
	
	public void removeAll(){
		header.nextElement = null;
		header.previousElement = null;
		size = 0;
		return;
	}
	
	
	public void add(Object e){
		if (size==0) addFirst(e);
		else {
			Node elem = new Node (e, header, header.previousElement);
			header.previousElement.nextElement = elem;
			header.previousElement = elem;
			size++;
		}
	}
	
	public void addLast(Object e){
		this.add(e);
	}
	
	public void addFirst(Object e){
		if (size==0) {
			Node elem = new Node (e, header, header);
			header.nextElement = header.previousElement = elem;
			size++;
		} else {
			Node elem = new Node (e, header.nextElement, header);
			header.nextElement.previousElement = elem;
			header.nextElement = elem;
			size++; 
		}
	}
	
	public Object getFirst() {
		isEmptyCheck();
		return header.nextElement.getElement();
		}
	public Node getFirstNode() {
		isEmptyCheck();
		return new Node(header.nextElement.getElement(),null,null);
		}
	
	
	public Object get(int index) {		
		isEmptyCheck();
		isCorrectIndexCheck(index);
		int counter = 0;
		Object valueToReturn;
		Node temp = header.nextElement;
		while (counter<size){
			valueToReturn = temp.getElement();
			if (counter==index) return valueToReturn;
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		return null;
	}	
		
	@Override
	public int indexOf(Object o) {
		isEmptyCheck();
		int counter = 0;
		Node temp = header.nextElement;
		while (counter<size){
			if (o.equals(temp.getElement())) return counter;
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		return -1;
	}
	
	public Object getLast() {
		isEmptyCheck();
		return header.previousElement.getElement();
		}	
	public Node getLastNode() {
		isEmptyCheck();
		return header.previousElement;
		}	
	
	public void print(){
		isEmptyCheck();
		for (int i=0; i<size; i++)
			System.out.print("["+get(i)+"] ");
		System.out.println();
	}

//Stack realization
@Override
public void push(Object e) {
	this.add(e);
}
@Override
public Object pop() {
	return this.removeLast() ;
}

//Queue realization
@Override
public void offer(Object e) {
	this.add(e);
}
@Override
public Object peek() {
	return this.getFirst();
}
@Override
public Object poll() {
	return this.removeFirst();
}

@Override
public void add(int index, Object element) {
	isEmptyCheck();
	isCorrectIndexCheck(index);
	int counter = 0;
	Node temp = header.nextElement;
	while (counter<index+1){
		if (temp.hasNext()) temp = temp.next();
		counter++;
	}
	Node elemNode = new Node (element, temp.previousElement, temp);
	temp.previousElement.nextElement = elemNode;
	temp.previousElement = elemNode;
	
}
@Override
public void addAll(Object[] c) {
	for (int i=0; i<c.length; i++){
		this.add(c[i]);
	}
}
@Override
public void addAll(int index, Object[] c) {
	for (int i=0; i<c.length; i++){
		this.add(index+i, c[i]);
	}
	
}

@Override
public Object[] toArray() {
	Object [] array = new Object [this.size()];
	for (int i=0; i<this.size(); i++)
		array[i]=this.get(i);
	return array;
}

//additional method for size check
	private void isEmptyCheck(){ 
		if (size==0)throw new NullPointerException("The array is empty");
	}
	// additional method for index validation
	private void isCorrectIndexCheck(int index){ 
		if (index >=size || index<0) throw new IndexOutOfBoundsException("incorrect index outs of Array bounds");
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		for (int i=0; i<size; i++){
		str.append("["+get(i)+"] ");
	 }
		return str.toString();
		}
	
public class Node {
	private	Object element;
	private Node nextElement;
	private Node previousElement;
	
	
	public Node (Object element){
		this.element=element;
		this.nextElement = null;
		this.previousElement = null;
	}
		
	
	public Node (Object element, Node nextElement, Node previousElement){
			this.element=element;
			this.nextElement = nextElement;
			this.previousElement = previousElement;
		}
	private boolean hasNext(){
			if (this.nextElement!=null) return true;
			else return false;
		}
		
	private Node next(){
			return this.nextElement;
		}
	public void remove(){
			this.previousElement.nextElement = this.nextElement;
			this.nextElement.previousElement = this.previousElement;
			this.nextElement = this.previousElement = null;
			this.element = null;
			size--;
		}
		
	public Object getElement(){
			return this.element;
			
		}
	private void setElement(Object element){
			this.element=element;
		}
	@Override
	public String toString(){
		return "["+this.getElement()+"] ";
		}
	}
	
}
