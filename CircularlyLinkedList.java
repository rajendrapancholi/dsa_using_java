class CircularLikedList<E> {
    // create a node
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularLikedList() {
    }

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }

    public E removeLast() {
        if (isEmpty()) {
            System.out.println("Empty!");
            return null;
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            E removedElement = tail.getElement();
            tail = null;
            size--;
            return removedElement;
        } else {
            Node<E> current = head;
            // Traverse until the second last node
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            E removedElement = tail.getElement();
            current.setNext(head);
            tail = current;
            size--;
            return removedElement;
        }
    }

    public void display() {
        if (tail == null) {
            System.out.print("Circular Linked List is empty!");
            return;
        }
        Node<E> temp = tail;
        do {
            System.out.print(temp.element + " ");
            temp = temp.next;
        } while (temp != tail);
        System.out.println();
    }
}

// main class
public class CircularlyLinkedList<E> {
    public static void main(String[] args) {
        CircularLikedList<Integer> cll = new CircularLikedList<>();
        cll.addFirst(4);
        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);
        cll.addLast(5);
        System.out.println("First Element: " + cll.getFirst());
        System.out.println("Last Element: " + cll.getLast());
        System.out.println("Total Element: " + cll.size());
        cll.display();
        System.out.println("remove Last Element: " + cll.removeLast());
        System.out.println("After remove first element.");
        System.out.println("Total Element: " + cll.size());
        cll.display();
    }
}