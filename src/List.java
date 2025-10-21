//@name Jayden
//@date and version [10/20/2025 version 1.00]
//CS245 Project 2

public interface List<T> {

    /** 
    * add method
    * Declares interface for add method in list.
    * @param index for index
    * @param element for element
    */
    public void add (int index, T element);

    /** 
    * add method
    * Declares interface for add method in list.
    * @param element for element
    * @return boolean if added correctly
    */
    public boolean add (T element);

    /** 
    * get method
    * Declares interface for get method in list.
    * @param index for index
    * @return T element in list
    */
    public T get (int index);

    /** 
    * remove method
    * Declares interface for remove method in list.
    * @param index for index
    * @return T element in list
    */
    public T remove (int index);

    /** 
    * size method
    * Declares interface for size method in list.
    * @return int of how big the list is
    */
    public int size ();
}
