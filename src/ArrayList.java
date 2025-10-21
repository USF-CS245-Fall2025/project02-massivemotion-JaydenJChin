public class ArrayList<T> implements List<T>{

    private class ListIterator implements Iterator<T>{

        protected int pos = 0;


        /** 
        * hasNext method
        * checks if the size is greater than position to determine whether there is a next in the ArrayList.
        * @return boolean true there is another element next else returns false
        */ 
        public boolean hasNext(){
            if (pos < size){
                return true;
            }
            return false;
        }

        /** 
        * next method
        * returns the next element in the ArrayList.
        * @return T element in the list
        */ 
        public T next(){
            return arr[pos++];
        }
    }

    T[] arr;
    int size;

    /** 
    * ArrayList method
    * Initializes variable size to 0.
    * Creates a new ArrayList with an intial size of 10 elements and typecasts to T.
    */ 
    public ArrayList(){
        size = 0;
        arr = (T[]) new Object[10];
    }

    /** 
    * size method
    * Returns how big the ArrayList is.
    * @return int size ArrayList
    */ 
    @Override
    public int size(){
        return size;
    }

    /** 
    * grow_array method
    * Grows array and multiplies 2 if the maximum capacity has reached.
    * Copies old ArrayList into the new one.
    */ 
    protected void grow_array(){
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    /** 
    * add method
    * Checks if current size is equal to array length.
    * If it is then call grow array to increase array length.
    * Increment size by 1 after adding item.
    * @param item element in the ArrayList
    * @return boolean true if added correctly
    */ 
    @Override
    public boolean add(T item){
        if(size == arr.length){
            grow_array();
        }
        arr[size++] = item;
        return true;
    }

    /** 
    * add method
    * Checks if out of bounds, if it is then throw exception OOB.
    * If current size is equal to array length, grow array.
    * Add the element to the position and increment size by 1.
    * @param pos position in the ArrayList
    * @param item element in the ArrayList
    * @throws IndexOutOfBoundsException if the list goes out of bounds in ArrayList
    */ 
    @Override
    public void add(int pos, T item){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        if(size == arr.length){
            grow_array();
        }
        for(int i = size; i > pos; i--){
            arr[i] = arr[i - 1];
        }
        arr[pos] = item;
        size++;
    }

    /** 
    * remove method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Removes the element at the position in the ArrayList.
    * Shifts elements to the left.
    * @param pos position in the ArrayList
    * @return copy removed element
    * @throws IndexOutOfBoundsException if the list goes out of bounds in ArrayList
    */ 
    @Override
    public T remove(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("List index OOB");
        }
        T copy = arr[pos];
        for(int i = pos; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        return copy;
    }

    /** 
    * get method
    * Checks if out of bounds, if it is then throw exception OOB.
    * Returns element at position in the ArrayList.
    * @param pos position in the ArrayList
    * @return arry[pos] element in the ArrayList at the position.
    * @throws IndexOutOfBoundsException if the list goes out of bounds in ArrayList
    */ 
    @Override
    public T get(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
        return arr[pos];
    }

    /** 
    * iterator method
    * Returns a new iterator over the elements in the list.
    * @return null for iterator
    */   
    public Iterator<T> iterator(){
        return new ListIterator();
    }
}
