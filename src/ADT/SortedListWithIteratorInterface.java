/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import java.util.Iterator;

/**
 *
 * @author Leo
 */
public interface SortedListWithIteratorInterface<T extends Comparable<? super T>> extends SortedListInterface<T> {
    Iterator getIterator();
}
