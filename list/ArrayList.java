// package list;
interface List<E> {
    int size();

    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;

    void getData();

    E set(int i, E e) throws IndexOutOfBoundsException;

    void add(int i, E e) throws IndexOutOfBoundsException;

    E remove(int i) throws IndexOutOfBoundsException;

}

public class ArrayList<E> implements List<E> {
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public void getData() {
        for (int i = 0; i < data.length; i++) {
            int j = i + 1;
            System.out.println("Element at: " + (j) + " is: " + data[i]);
        }
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);
        if (size == data.length) {
            throw new IllegalStateException("Array is full!");
        }
        for (int j = size - 1; j >= i; j--) {
            data[j + 1] = data[j];
        }
        data[i] = e;
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int j = i; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    public static void main(String[] args) {
        System.out.println("hello rajendra Pancholi.");
        ArrayList<String> AL = new ArrayList<String>(6);
        AL.add(0, "aa");
        AL.add(1, "bb");
        AL.add(2, "cc");
        AL.add(3, "dd");
        AL.add(4, "ee");
        AL.add(5, "ff");
        // AL.add(6, "gg");
        AL.getData();
        System.out.println("remove : " + AL.remove(0));
        System.out.println("After remove");
        AL.getData();

    }
}
