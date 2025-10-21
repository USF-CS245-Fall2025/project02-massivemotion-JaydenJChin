//@name Jayden
//@date and version [10/20/2025 version 1.00]
//CS245 Project 2

public class DoublyLinkedList<T> implements List<T>{

    private class Node{
        T data;
        Node next;
        Node prev;
        public Node(T value){
            data = value;
            next = null;
            prev = null;
        }
    }

    int size;
    Node head;
    Node tail;

    /** 
    * DoublyLinkedList method
    * Initializes variable size to 0.
    * Initializes head to null.
    * Initializes tail to null.
    */ 
    public DoublyLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    /** 
    * size method
    * Returns how big the DoublyLinkedList is.
    * @return int size DoublyLinkedList
    */ 
    @Override
    public int size(){
        return size;
    }

    /** 
    * add method
    * Checks if size is 0, if it is then sets head to tail and sets to newNode.
    * If not, then the adds a new node to the end.
    * Increments size by 1 and returns true.
    * @param item element in the DoublyLinkedList
    * @return boolean true if added correctly
    */ 
    @Override
    public boolean add(T item){
        Node newNode = new Node(item);
        if(size == 0){
            head = tail = newNode;
        } 
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /** 
    * add method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Adds node at position.
    * If the position is 0 the element becomes the new head.
    * If the position is equal to the size the element becomes the new tail.
    * Increment size by 1.
    * @param pos position in the DoublyLinkedList
    * @param item element in the DoublyLinkedList
    * @throws IndexOutOfBoundsException if the list goes out of bounds in DoublyLinkedList
    */ 
    @Override
    public void add(int pos, T item){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }

        Node newNode = new Node(item);

        if(pos == 0){
            newNode.next = head;
            if(head != null){
                head.prev = newNode;
            }      
            head = newNode;
            if(size == 0){
                tail = newNode;                
            }
        } 
        else if(pos == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } 
        else{
            Node current = head;
            for(int i = 0; i < pos; i++)
                current = current.next;
            Node prevNode = current.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

     /** 
    * remove method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Removes node at position.
    * If the position is 0 the head node is removed.
    * If the position is the last index then the tail node is removed.
    * Decrement size by 1.
    * @param pos position in the DoublyLinkedList
    * @return removed.data data of the node removed
    * @throws IndexOutOfBoundsException if the list goes out of bounds in DoublyLinkedList
    */ 
    @Override
    public T remove(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }

        Node removed;

        if(pos == 0){
            removed = head;
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            if(size == 1){
                tail = null;
            }
        } 
        else if(pos == size - 1){
            removed = tail;
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            } 
            else {
                head = null;
            }
        } 
        else{
            Node current = head;
            for(int i = 0; i < pos; i++){
                current = current.next;
            }
            Node prevNode = current.prev;
            Node nextNode = current.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            removed = current;
        }

        size--;
        return removed.data;
    }

    /** 
    * get method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Returns element at position in the DoublyLinkedList.
    * @param pos position in the DoublyLinkedList
    * @return current.data data of the node
    * @throws IndexOutOfBoundsException if the list goes out of bounds in DoublyLinkedList
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
