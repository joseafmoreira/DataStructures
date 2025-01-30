package pt.ipp.estg.ed.abstractdatatype;

/**
 * A min-heap is a type of heap in which every parent node is smaller or equal
 * in comparison to it's left and right child.
 * <p>
 * 
 * The common operations for a min-heap include:
 * <p>
 * <ul>
 * <li>{@link #removeMin()}: Removes the element from the root of this
 * min-heap</li>
 * <li>{@link #findMin()}: Returns the element from the root of this
 * min-heap</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>MinHeapADT</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 * @see HeapADT
 */
public interface MinHeapADT<T> extends HeapADT<T> {
    /**
     * Removes the element from the root of this min-heap.
     * 
     * @return the element from the root of this min-heap
     * @throws EmptyCollectionException if this min-heap is empty
     */
    T removeMin();

    /**
     * Returns the element from the root of this min-heap.
     * 
     * @return the element from the root of this min-heap
     * @throws EmptyCollectionException if this min-heap is empty
     */
    T findMin();
}
