package lab7;

import java.util.RandomAccess;

public class MyCollections  {

	//В случае RandomAccess вызывать быструю сортировку, иначе - сортировку пузырьком.
	//Порядок элементов определяется результатом работы метода compareTo, если объект
	//массива реализует интерфейс Comparable
	
	public static void sort(MyList list){
		if (!(list.get(0) instanceof Integer)||!(list.get(0) instanceof Comparable)) throw new IllegalArgumentException("non comparable object found. Integer expected ");
		if (list instanceof RandomAccess) quickSort (list, 0, (list.size()-1)); 
		  else  bubleSort(list);
	}
	
	//Если объект массива не реализует интерфейс Comparable, то должен передаваться объект,
	//реализующий интерфейс Comparator
	public static void sort(MyList list, IntComparator c){
		if (c==null)
		{
			if (!(list.get(0) instanceof Comparable)) throw new IllegalArgumentException("non comparable object found. Integer expected ");
			bubleSort(list);
		}
		for (int i=0; i<list.size(); i++)
		{
				for (int j=0; j<list.size()-1-i; j++)
				{
					 if (c.compare(list.get(j),list.get(j+1))>0) 
					   	MyCollections.swap(list, j, j+1);
				
				}	
		}	
	}
	
	public static void swap(MyList list, int i, int j){
		Object tempElem = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tempElem);
	}
	
		public static void copy(MyList dest, MyList src) {
		Object[] tempArr = src.toArray();
		dest.addAll(tempArr);
	}
	
	public static void reverse(MyList list) {
		Object [] tempArr = list.toArray();
		list.removeAll();
		for (int i=tempArr.length-1; i>=0;i--)
			list.add(tempArr[i]);
	}
	
	// additional method for array quick sorting 
	private static void quickSort(MyList list, int left, int right) {
	    int i = left;
	    int j = right;
	    Integer x = (Integer) list.get((i+j)/2);
	    	while (i <= j) {
	        while (x.compareTo((Integer) list.get(i)) > 0) {
	            i++;
	        	}
	        while (x.compareTo((Integer) list.get(j)) < 0) {
	            j--;
	        	}
	        if (i <= j) {
	        	swap(list,i,j);
	            i++;
	            j--;
	        	}
	    }
	    if (left<j){
	    	quickSort(list, left, j);
	    	}
	    
	    if(i<right){
	    	quickSort(list, i, right);
	    	}
	}
	
	  private static void bubleSort(MyList list)
	  {
		  for (int i=0; i<list.size(); i++)
		  {
				for (int j=0; j<list.size()-i-1; j++)
				{
					Integer val = (Integer) list.get(j);
				    if (val.compareTo((Integer) list.get(j+1))>0) 
			     		 swap(list, j, j+1);  
					 
			        	     	
				 }	
		  }
	  }
	 
	
	
}
