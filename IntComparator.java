package lab7;

import java.util.Comparator;

public class IntComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		
		return (Integer) o1 -(Integer) o2;
	}

}
