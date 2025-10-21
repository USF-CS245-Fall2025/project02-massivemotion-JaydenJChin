//@name Jayden
//@date and version [10/20/2025 version 1.00]
//CS245 Project 2

public class DummyHeadLinkedList<T> implements List<T>{

    private class Node{
        T data;
        Node next;

        Node(T value){
            data = value;
            next = null;
        }
    }

    private Node head;
    private int size;

    /** 
    * DummyHeadLinkedList method
    * Initializes variable size to 0.
    * Initiliazes head to a new dummy node with null.
    */ 
    public DummyHeadLinkedList(){
        head = new Node(null);
        size = 0;
    }

    /** 
    * size method
    * Returns how big the DummyHeadLinkedList is.
    * @return int size DummyHeadLinkedList
    */ 
    @Override
    public int size(){
        return size;
    }

    /** 
    * add method
    * Sets the current to the head node, checks until the last node.
    * Creates new node at the end of the list.
    * Increments size by 1 and returns true.
    * @param item element in the DummyHeadLinkedList
    * @return boolean true if added correctly
    */
    @Override
    public boolean add(T item){
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(item);
        size++;
        return true;
    }

    /** 
    * add method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Iterates through the list to the node before the insertion position.
    * Adds a new node at the specified position.
    * Increments size by 1.
    * @param pos position in the DummyHeadLinkedList
    * @param item element in the DummyHeadLinkedList
    * @throws IndexOutOfBoundsException if the list goes out of bounds in DummyHeadLinkedList
    */ 
    @Override
    public void add(int pos, T item){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        Node current = head;
        for(int i = 0; i < pos; i++){
            current = current.next;
        }
        Node newNode = new Node(item);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /** 
    * remove method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Iterates through the DummyHeadLinkedList to the node before the removal, removes node, then decrements the size by 1.
    * @param pos position in the DummyHeadLinkedList
    * @return removed.data data of the removed node
    * @throws IndexOutOfBoundsException if the list goes out of bounds in DummyHeadLinkedList
    */ 
    @Override
    public T remove(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        Node current = head;
        for(int i = 0; i < pos; i++){
            current = current.next;
        }
        Node removed = current.next;
        current.next = removed.next;
        size--;
        return removed.data;
    }

    /** 
    * get method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Returns element at position in the DummyHeadLinkedList.
    * @param pos position in the DummyHeadLinkedList
    * @return current.data data of the node
    * @throws IndexOutOfBoundsException if the list goes out of bounds in DummyHeadLinkedList
    */ 
    @Override
    public T get(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        Node current = head.next;
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
