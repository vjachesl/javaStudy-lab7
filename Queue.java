package lab7;

public interface Queue {
	public void offer(Object e); //- добавить в конец очереди
	public Object peek(); //- взять без удаления, элемент из очереди
	public Object poll(); //- взять и удалить элемент из очереди
}
