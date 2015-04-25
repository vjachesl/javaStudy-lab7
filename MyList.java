package lab7;

public interface MyList {
	public void add(Object e);
	public void add(int index, Object element);
	public void addAll(Object[] c);
	public void addAll(int index, Object[] c);
	public Object get(int index);
	public Object remove(int index);
	public void removeAll();
	void set(int index, Object element);
	public int indexOf(Object o); // - поиск индекса по значению
	public int size(); // - размер списка
	public Object[] toArray(); // - преобразует список в массив объектов
}
