class SignlyLL<E>{
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public void SignlyLinkedList(){}
    // access methods
    public int size(){return size;}
    public boolean isEmpty() {return size==0;}

    public static class Node<E> {
        private E element;
        private Node<E> next;
        public Node (E e, Node<E> n){
            element = e;
            next =n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public void display() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public E first(){
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }
    public E last(){
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
    //upadate methods
    public void addFirst(E e){
        head = new Node<>(e, head);
        if (size==0) {
            tail=head;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e,null);
        if (isEmpty()) {
            head = newest;
        }
        else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }
    public E removeFirst(){
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size==0) {
            tail=null;
        }
        return answer;
    }
}
public class SignlyLinkedList{
    public static void main(String[] args){
        // SignlyLL<Integer> sll = new SignlyLL<>();
        // sll.addFirst(5);
        // sll.addFirst(6);
        // sll.addFirst(7);
        // sll.addFirst(8);
        // sll.addFirst(9);
        // sll.addFirst(10);
        // sll.addFirst(4);
        // System.out.println("Head"+sll.first());
        // System.out.println("Tail: "+sll.last());
        // System.out.println("Total Element: "+sll.size());
        // System.out.println("All element in this SLL list");
        // sll.display();
        SignlyLL<String> sll = new SignlyLL<>();
        sll.addFirst("Hello");
        sll.addFirst("Rajendra");
        sll.addFirst("Pancholi");
        sll.addFirst("!");
        sll.addLast("last element.");
        System.out.println("Head Element: "+sll.first());
        System.out.println("Tail Element: "+sll.last());
        System.out.println("Total Element: "+sll.size());
        System.out.println("All element in this SLL list");
        sll.display();
    }
}