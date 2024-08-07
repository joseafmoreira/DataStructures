package dev.joseafmoreira.abstractdatatypes.lists.ordered;

import dev.joseafmoreira.abstractdatatypes.lists.ArrayList;
import pt.ipp.estg.ed.OrderedListADT;

/**
 * Resizable-array implementation of the {@code UnorderedListADT} interface 
 * using the {@code ArrayList} abstract class as a base code
 * 
 * <h3>UnorderedArrayList</h3>
 * @param <T> the type of element stored in this ordered list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedListADT
 * @see ArrayList
 */
public class OrderedArrayList<T> extends ArrayList<T> implements OrderedListADT<T> {

}
