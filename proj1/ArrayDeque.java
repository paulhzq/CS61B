public class ArrayDeque<T> {

	private T[] items;
	private int size;
	// index of the head of the deque to be added or delete.
	// index of the tail of the deque to be added or delete.
	private int head, tail;
	// private static int RFACTOR = 8;
	private static double ratio = 0.25;

	/** Creates an empty list. */
	public ArrayDeque() {
		size = 0;
		items = (T[]) new Object[8];
		head = tail = 0;
	}

	private void resize(int capacity) {
		T[] newArr = (T[]) new Object[capacity];
		int p = head;
		int n = items.length;
		int r = n - p;// number of elements in the right of the p.
		System.arraycopy(items, p, newArr, 0, r);
		System.arraycopy(items, 0, newArr, r, p);
		head = 0;
		tail = size;
		items = newArr;
	}

	// addfirst to the deque
	public void addFirst(T item) {
		if (size == items.length) {
			resize(items.length * 2);
		}
		items[head = (head - 1) & (items.length - 1)] = item;
		size += 1;
	}

	// addLast to the deque
	public void addLast(T item) {
		if (size == items.length) {
			resize(items.length * 2);
		}
		items[tail] = item;
		tail = (tail + 1) & (items.length - 1);
		size += 1;
	}

	public T removeFirst() {
		if (isEmpty())
			return null;
		//when the size/items.length<=ratio decrease the array size by half.
		if (items.length >= 16 && (size <= ratio * items.length)) {
			T[] newArr = (T[]) new Object[items.length / 2];
			if (head < tail) {
				System.arraycopy(items, head, newArr, 0, size);
			} else if (head > tail) {
				int headPortionLen = items.length - head;
				System.arraycopy(items, head, newArr, 0, headPortionLen);
				System.arraycopy(items, 0, newArr, headPortionLen, tail);
			}
			items = newArr;
			head = 0;
			tail = size;
		}
		T result = items[head];
		items[head] = null;
		head = (head + 1) & (items.length - 1);
		size -= 1;
		return result;
	}

	public T removeLast() {
		if (isEmpty())
			return null;
		if (items.length >= 16 && (size <= ratio * items.length)) {
			T[] newArr = (T[]) new Object[items.length / 2];
			if (head < tail) {
				System.arraycopy(items, head, newArr, 0, size);
			} else if (head > tail) {
				int headPortionLen = items.length - head;
				System.arraycopy(items, head, newArr, 0, headPortionLen);
				System.arraycopy(items, 0, newArr, headPortionLen, tail);
			}
			items = newArr;
			head = 0;
			tail = size;
		}
		int t = (tail - 1) & (items.length - 1);
		T result = items[t];
		items[t] = null;
		tail = t;
		size -= 1;
		return result;
	}

	public void printDeque() {
		for (int i = 0, current = head % items.length; i < size; i++) {
			if (items[current] != null)
				System.out.print(items[current] + " ");
			current = (current + 1) % items.length;
		}
		System.out.println();
	}

	/** Returns the number of items in the list. */
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T get(int index) {
		if (index > size - 1)
			return null;
		if (index < items.length - head) {
			// System.out.println("index"+index+"is"+items[head+index]);
			return items[head + index];
		} else {
			// System.out.println("index"+index+"is"+items[(head+index)%items.length]);
			return items[(head + index) % items.length];
		}
	}

}
