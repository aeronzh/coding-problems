package problems;

import java.lang.reflect.Array;

/**
 * There following Java code shows how to implement a queue without using any
 * extra data structures in Java. We can implement a queue by using an array.
 * 
 * @author lucas
 *
 */
public class ArrayQueue {

	public static class MyArrayQueue<T> {
		private T[] data;
		private int size;
		private Class<T> clazz;

		@SuppressWarnings("unchecked")
		public MyArrayQueue(Class<T> clazz, int capacity) {
			this.clazz = clazz;
			data = (T[]) Array.newInstance(this.clazz, capacity);
			size = 0;
		}

		public void add(T obj) {
			if (size >= data.length) {
				T[] newData = (T[]) Array.newInstance(clazz, data.length * 2);
				for (int i = 0; i < data.length; i++) {
					newData[i] = data[i];
				}
				data = newData;
			}

			data[size] = obj;
			size++;
		}

		public T poll() {
			if (size > 0) {
				T obj = data[0];

				if (size - 1 <= data.length / 2) {
					T[] newData = (T[]) Array.newInstance(clazz, data.length / 2);
					for (int i = 1; i <= newData.length; i++) {
						newData[i-1] = data[i];
					}
					data = newData;
				} else {
					// shift
					for (int i = 1; i < size; i++) {
						data[i - 1] = data[i];
						data[i] = null;
					}
					
					if (size == 1) {
						data[0] = null;
					}
				}

				size--;
				return obj;
			} else {
				throw new IllegalArgumentException("Queue is empty! Nothing to poll.");
			}
		}

		public T peek() {
			if (size > 0) {
				T obj = data[0];
				return obj;
			} else {
				throw new IllegalArgumentException("Queue is empty! Nothing to peek.");
			}
		}

		public int size() {
			return size;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < size - 1; i++) {
				if (data[i] != null) {
					sb.append(data[i] + ", ");
				}
			}
			
			if (size > 0) {
				if (data[size - 1] != null) {
					sb.append(data[size - 1]);
				}
			}
			sb.append("]");

			return sb.toString();
		}

	}

	public static void main(String[] args) {
		MyArrayQueue<Integer> q = new MyArrayQueue<Integer>(Integer.class, 5);
		System.out.println(q.toString());
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		System.out.println(q.toString());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.toString());
		System.out.println(q.size());

	}

}
