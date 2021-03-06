
/**
 * The iterator interface provides a set of methods for traversing or modifying the collection that is in addition to next()/has Next()
 * It has method for fetching the next element from a collection. 
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public interface Iterator 
{
    /**
     * This function checks for element inside list and returns as boolean
     * @param None
     * @return  boolean if there is object in list, with true or false
     */
    boolean hasNext();
    
    /**
     * if we have hasNext functions as true then we get next object from list with this method.
     * @param None
     * @return the object from list and increase index by one for hasNext function.
     */
    Object next();
}
