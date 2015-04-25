package lab7;

import java.util.Random;

public class MyCollectionsRunner  {
	public static void main(String[] args) {
		MyList lList =  new MyLinkedList();
		MyList lListCopy =  new MyLinkedList();
		MyList arrList = new MyArrayList();
		MyList arrListCopy = new MyArrayList();
		Random rnd = new Random();
	
		// Working with MyLinkedList
		
		for (int i=0; i<rnd.nextInt(50); i++){
			Object temp = rnd.nextInt(100);
			lList.add(temp);
		}
		System.out.println("Source LinkedList \t\t\t"+lList);
		MyCollections.copy(lListCopy,lList);
		System.out.println("Copied LinkedList \t\t\t"+lListCopy);
		MyCollections.sort(lList);
		System.out.println("Sorted LinkedList1 \t\t\t"+lList);
		MyCollections.sort(lListCopy, new IntComparator());
		System.out.println("Sorted LinkedList2 with Comparator \t"+lListCopy);
		MyCollections.swap(lList,1,3);
		System.out.println("Swapped 1 and 3 elements \t\t"+lList);
	
		MyCollections.reverse(lList);
		System.out.println("Reversed LinkedList1 \t\t\t"+lList);
		
		System.out.println("------------------------------------------");
		// Working with MyArrayList
		for (int i=0; i<rnd.nextInt(50); i++){
			Object temp = rnd.nextInt(100);
			arrList.add(temp);
		}
		System.out.println("Source ArrayList \t\t\t"+arrList);
		MyCollections.copy(arrListCopy,arrList);
		System.out.println("Copied ArrayList \t\t\t"+arrListCopy);
		MyCollections.sort(arrList);
		System.out.println("Sorted ArrayList1 \t\t\t"+arrList);
		MyCollections.sort(arrListCopy, new IntComparator());
		System.out.println("Sorted ArrayList2 with Comparator \t"+arrListCopy);
		MyCollections.swap(arrList,1,3);
		System.out.println("Swapped 1 and 3 elements \t\t"+arrList);
	
		MyCollections.reverse(arrList);
		System.out.println("Reversed ArrayList1 \t\t\t"+arrList);
		
	}
	
}
