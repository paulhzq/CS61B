public  class LinkedListDeque<T> {
	private Node head;
	private Node tail;
	private int size;

	public class Node{
		private T item;
		private Node prev;
		private Node next;

		public Node(T item,Node p,Node n){
			this.item = item;
			this.prev = p;
			this.next = n;
		}
	}
		public LinkedListDeque(){
		size = 0;
		head = new Node(null,null,null);
		tail = new Node(null,null,null);
		head.next = tail;
		tail.prev = head;
		}
	
	public LinkedListDeque(T x){
		size = 1;
		head = new Node(null,null,null);
		tail = new Node(null,null,null);
		Node tmp = new Node(x,head,tail);
		head.next = tmp;
		tail.prev = tmp;
	}

	
	//Adds an item to the front of the Deque.
	public void addFirst(T item){
		
		Node add = new Node(item,head,null);
		Node tmp = head.next ;
		head.next = add ;
		tmp.prev = add;
		add.next = tmp;
		size +=1;
	}
	//Adds an item to the back of the Deque
	public void addLast(T item){
		//Todo
		Node add = new Node(item,null,tail);
		Node tmp = tail.prev ;
		tmp.next = add;
		add.prev = tmp;
		tail.prev = add;
		size +=1;
	}
	public boolean isEmpty(){
		return (size == 0);
	}
	public int size(){
		return size;
	}
	//Prints the items in the Deque from first to last, separated by a space.
	public void printDeque(){
		Node tmp = head;
		while (tmp.next != tail) {
			System.out.print(tmp.next.item + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
		
	
	//Removes and returns the item at the front of the Deque. If no such item exists, returns null.
	public T removeFirst(){
		if (isEmpty()) {
			return null;
		}
		Node tmp = head.next;
		head.next = tmp.next;
		tmp.next.prev = head;
		size--;
		return tmp.item;
	}
	public T removeLast(){
		if (isEmpty()) {
			return null;
		}
		Node tmp = tail.prev;
		tmp.prev.next = tail;
		tail.prev = tmp.prev;
		size--;
		return tmp.item;
	}

	public T get(int index){
		if (index > size-1) {
			return null;
		}
		Node tmp = head;
		while(index >0) {
			tmp = tmp.next;
			index--;
		}
		return tmp.next.item;
	}
	//
	public T getRecursive(int index){
		if (index >= size && index < 0) {
			return null;
		}
		return getHelper(head,index).item;
	}
	private Node getHelper(Node node, int index) {
		if (index == 0) {
			return node.next;
		}
		return getHelper(node.next,index-1);
	}

}