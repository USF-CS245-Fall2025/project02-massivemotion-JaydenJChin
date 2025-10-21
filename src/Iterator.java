//@name Jayden
//@date and version [10/20/2025 version 1.00]
//CS245 Project 2

public interface Iterator<T>{

	/** 
    * hasNext method
    * Declares interface for hasNext method in iterator.
    * @return boolean if it has next or not
    */ 
	public boolean hasNext();

	/** 
    * next method
    * Declares interface for next method in iterator.
    * @return T element in list
    */
	public T next();
}
