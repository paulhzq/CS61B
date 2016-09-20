package lab2;

public class IntList {
	public int head;
	public IntList tail;

	public IntList(int h, IntList t) {
		/* your code here */
		head = h;
		tail = t;
	}

	/** Retuns the size of this IntList */
	public int size() {
		/* your code here */
		if (tail == null)
			return 1;
		else
			return 1 + tail.size();
		
	}

	/** Returns the size of this IntList. */
	public int iterativeSize() {
		/* your code here */
		// int i = 1;
		// while (tail != null) {
		// tail = tail.tail;
		// i++;
		// }
		// return i;
		
		IntList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.tail;
        }
        return size;
	}

	/**
	 * In class exercise 1: Returns ith item of this IntList. For simplicity,
	 * assume the item exists.
	 */
	public int get(int i) {
		if (i == 0) {
			return this.head;
		} else {
			return tail.get(i - 1);
		}
		// IntList p = this;
		// if (i == 0)
		// return this.head;
		// else {
		// for (int index = 1; index <= i; index++) {
		// p = p.tail;
		// }
		// return p.head;
		// }
	}

		

	/**
	 * Returns the Intlist as a string. Automatically called whenever you try to
	 * print an IntList.
	 */
	public String toString() {
		/* your code here */
		if(tail == null)
			return Integer.toString(head);
		
		return Integer.toString(head)+" "+tail.toString();
	}

	public static Intlist list(){
		
	}
	/**
	 * Returns an IntList identical to L, but with each element incremented by
	 * x. L is not allowed to change.
	 */
	public static IntList incrList(IntList L, int x) {
		/* Your code here. */
		return L;
	}

	/**
	 * Returns an IntList identical to L, but with each element incremented by
	 * x. Not allowed to use the 'new' keyword.
	 */
	public static IntList dincrList(IntList L, int x) {
		/* Your code here. */
		return L;
	}

	public static void main(String[] args) {

		// Test your answers by uncommenting. Or use the Visualizer.
		IntList L = new IntList(5, null);
		L.tail = new IntList(7, null);
		L.tail.tail = new IntList(9, null);
		System.out.println(L.size());
		System.out.println(L.iterativeSize());
		System.out.println(L.get(0));
		System.out.println(L.get(1));
		System.out.println(L.toString());
		System.out.println();
		
		// System.out.println(incrList(L, 3));
		// System.out.println(dincrList(L, 3));

	}

}
