package pt.ipp.estg.ed.abstractdatatype;

/**
 * A max-heap is a type of heap in which every parent node is bigger or equal 
 * in comparison to it's left and right child. <p>
 * 
 * The common operations for a max-heap include: <p>
 * <ul>
 *  <li>{@link #removeMax()}: Removes the element from the root of this max-heap</li>
 *  <li>{@link #findMax()}: Returns the element from the root of this max-heap</li>
 * </ul> 
 * 
 * This interface is a member of the 
 * <i>Data Structures Framework</i>
 * 
 * <h3>MaxHeapADT</h3>
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 * @see HeapADT
 */
public interface MaxHeapADT<T> extends HeapADT<T> {
    /**
     * Removes the element from the root of this max-heap.
     * 
     * @return the element from the root of this max-heap
     */
    T removeMax();

    /**
     * Returns the element from the root of this max-heap.
     * 
     * @return the element from the root of this max-heap
     */
    T findMax();
}
