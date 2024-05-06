class DoublyLL<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p;}
        public void setNext(Node<E> n) { next = n;}
    }
    private Node<E> header;
    private Node<E> tailer;
    private int size = 0;
    //constructor a new empty list
    public DoublyLL(){
        header = new Node<>(null, null, null);
        tailer = new Node<>(null, header, null);
        header.setNext(tailer);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }
    public E last(){
        if (isEmpty()) {
            return null;
        }
        return tailer.getPrev().getElement();
    }
    //update methods
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e){
        addBetween(e, tailer.getPrev(), tailer);
    }
    public E removeFirst(){
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }
    public E removeLast(){
        if (isEmpty()) return null;
        return remove(tailer.getPrev());
    }
    private void addBetween(E e, Node<E> predecessor, Node<E> successor ){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public void display(){
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node<E> current = header.getNext();
        while(current != null){
            System.out.print(current.getElement()+ " ");
            current = current.getNext();
            if (current.getElement() ==null) {
                return;
            }
        }
    }

}
public class DoublyLinkedList{
    public static void main(String[] args){
        DoublyLL<Integer> dll = new DoublyLL<>();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        System.out.println("First element: "+dll.first());
        System.out.println("Last element: "+dll.last());
        System.out.println("Total element: "+dll.size());
        System.out.println("Doubly Linked List: ");
        dll.display();
    }
}