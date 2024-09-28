interface Stack<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E top();

    E pop();

    void getData();

    void reverse();
}

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 5;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return (t + 1);
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full!");
        }
        data[++t] = e;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void reverse() {
        Stack<E> buffer = new ArrayStack<>();
        for (int i = 0; i < data.length; i++) {
            buffer.push(data[i]);
            // System.out.println(data[i]);
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = buffer.pop();
        }
    }

    public void getData() {
        for (int i = 0; i < size(); i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void main(String[] args) {
        // Integer[] myArr = { 5, 4, 3, 2, 1 };
        // Integer[] myArr1 = { 1, 2, 3, 4, 5 };
        Stack<Integer> S = new ArrayStack<>();
        S.push(5);
        S.push(4);
        S.push(3);
        S.push(2);
        S.push(1);
        System.out.println("Size is: " + S.size());
        System.out.println("Top is: " + S.top());
        System.out.println(S.pop());
        System.out.println("After pop Top is: " + S.top());
        S.getData();
        System.out.println("\nAfter reverse: ");
        S.reverse();
        S.getData();
    }

}
