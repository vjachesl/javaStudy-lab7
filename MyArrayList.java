package lab7;

import java.util.RandomAccess;

public class MyArrayList implements MyList, Queue, Stack, RandomAccess {
	private Object [] elementData;
	private int size;
	
	// Two constructors - one without size, another with specific size;
	public MyArrayList(){
		elementData = new Object[10];
		size=0;
	} 
	public MyArrayList(int size){
		elementData = new Object[size];
		size=0;
	}
	// adding elements methods;
	public void add(Object element){
		ensureCapacity(1);
		elementData[size]=element;
		size++;
	}
	
	public void add(int index, Object element){
		isCorrectIndexCheck(index);
		isEmptyCheck();
		ensureCapacity(1);
		Object[] tempData= new Integer [elementData.length];
		System.arraycopy(elementData, 0, tempData, 0, index);
		tempData[index]=element;
		System.arraycopy(elementData , index, tempData, index+1, size-index);
		elementData=tempData;
		size++;
	}
	
	public void addAll(Object[] elements){
		ensureCapacity(elements.length);
		System.arraycopy(elements, 0, elementData, size, elements.length);
		size=size+elements.length;
	}
	
	public void addAll(int index, Object[] elements){
		isCorrectIndexCheck(index);
		isEmptyCheck();
		ensureCapacity(elements.length);
		Integer[] tempData= new Integer [elementData.length];
		System.arraycopy(elementData, 0, tempData, 0, index);
		System.arraycopy(elements, 0, tempData, index, elements.length);
		System.arraycopy(elementData, index, tempData, index+elements.length, size-index);
		size=size+elements.length;
		elementData = tempData;

	}
	// Increases the capacity of this ArrayList instance, if necessary, to
	//  ensure that it can hold at least the number of elements specified by the minimum capacity argument;
	public void ensureCapacity(int minCapacity){
		Object[] tempData;
		if (elementData.length-size>minCapacity) return;
		else tempData = new Integer[((elementData.length+minCapacity)/10*10)+10];
			System.arraycopy(elementData, 0, tempData, 0, elementData.length);
			elementData=tempData;
	}
	
	public Object get(int index){
		isCorrectIndexCheck(index);
		isEmptyCheck();
		return elementData[index];
	}
	
	public Object remove(int index){
		isCorrectIndexCheck(index);
		isEmptyCheck();
		Integer[] tempData= new Integer [elementData.length];
		System.arraycopy(elementData, 0, tempData, 0, index);
		Object toreturn = elementData[index];
		System.arraycopy(elementData , index+1, tempData, index, size-index-1);
		elementData=tempData;
		size--;
		return toreturn;
	}
	
	public void removeAll(){
		elementData[0]=0;
		size=0;
	}	
	
	public void set(int index, Object element){
		isCorrectIndexCheck(index);
		if (index !=0)isEmptyCheck();
		elementData[index]=element;
	}
	
	public int size(){
		return size;
	}	
	
	// stack realization
	@Override
	public void push(Object e) {
		this.add(e);
	}
	
	@Override
	public Object pop() {
		return this.remove(size-1);
	}
	
	//Queue realization
	@Override
	public void offer(Object e) {
		this.add(e);
	}
	
	@Override
	public Object peek() {
		return this.get(0);
	}
	
	@Override
	public Object poll() {
		return this.remove(0);
	}
	
	@Override
	public int indexOf(Object o) {
		for (int i = 0; i<size();i++){
			if (o.equals(this.get(i))) return i;
		}
		return -1;
	}
	@Override
	public Object[] toArray() {
		Object [] array = new Object[size()];
		for (int i = 0; i<size();i++)
			array [i]= this.get(i);
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
	// additional method for printing
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		for (int i=0; i<size; i++){
		str.append("["+elementData[i]+"] ");
	 }
		return str.toString();
		}
}
