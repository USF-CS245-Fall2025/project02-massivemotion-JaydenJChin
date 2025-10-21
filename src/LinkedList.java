//@name Jayden
//@date and version [10/20/2025 version 1.00]
//CS245 Project 2

public class LinkedList<T> implements List<T>{

    private class Node{
        T data;
        Node next;
        public Node(T value){
            data = value;
            next = null;
        }
    }

    int size;
    Node head;

    /** 
    * LinkedList method
    * Initializes variable size to 0.
    * Initiliazes head to null.
    */ 
    public LinkedList(){
        size = 0;
        head = null;
    }

    /** 
    * size method
    * Returns how big the LinkedList is.
    * @return int size LinkedList
    */ 
    @Override
    public int size(){
        return size;
    }

    /** 
    * add method
    * Checks if size is 0, if it is then create new head in node, increment size by 1, and return true.
    * Goes through the list and move to the next node until null.
    * Create new node at the end, increment size by 1, and return true.
    * @param item element in the LinkedList
    * @return boolean true if added correctly
    */ 
    @Override
    public boolean add(T item){
        if(size == 0){
            head = new Node(item);
            size++;
            return true;
        }
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new Node(item);
        size++;
        return true;
    }

    /** 
    * add method
    * Checks if out of bounds, if it is then throw exception OOB.
    * If the position is 0, create a new node at the head.     
    * Iterates through the LinkedList to the node just before the insertion, adds node, increments size by 1.
    * @param pos position in the LinkedList
    * @param item element in the LinkedList
    * @throws IndexOutOfBoundsException if the list goes out of bounds in LinkedList
    */ 
    @Override
    public void add(int pos, T item){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        if(pos == 0){
            Node newNode = new Node(item);
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node prev = head;
        for(int i = 0; i < pos - 1; i++){
            prev = prev.next;
        }
        Node newNode = new Node(item);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    /** 
    * remove method
    * Checks if out of bounds, if it is then throw exception OOB.
    * If the position is 0, remove the node at the head.
    * Iterates through the LinkedList to the node before the removal, removes node, then decrements the size by 1.
    * @param pos position in the LinkedList
    * @return node.data data of the node
    * @throws IndexOutOfBoundsException if the list goes out of bounds in LinkedList
    */ 
    @Override
    public T remove(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        if(pos == 0){
            Node node = head;
            head = head.next;
            size--;
            return node.data;
        }
        Node prev = head;
        for(int i = 0; i < pos - 1; i++){
            prev = prev.next;
        }
        Node current = prev.next;
        prev.next = current.next;
        size--;
        return current.data;
    }

    /** 
    * get method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Returns element at position in the LinkedList.
    * @param pos position in the LinkedList
    * @return current.data data of the node
    * @throws IndexOutOfBoundsException if the list goes out of bounds in LinkedList
    */ 
    @Override
    public T get(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        Node current = head;
        for(int i = 0; i < pos; i++){
            current = current.next;
        }
        return current.data;
    }

    /** 
    * iterator method
    * Returns a new iterator over the elements in the list.
    * @return null for iterator
    */
    public Iterator<T> iterator(){
        return null;
    }
}