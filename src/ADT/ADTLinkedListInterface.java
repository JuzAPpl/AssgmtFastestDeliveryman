/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Chow Swee Tung
 */
public interface ADTLinkedListInterface<T> {
    public void add(T newEntry);
    public void add(T newEntry, int newPosition);
    public T remove(int givenPosition);
    public void replace(T newEntry,int givenPosition);   
    public T getFirst();
    public T getEntry(int givenPosition); 
    public T getLast();
    public int getTotalEntries();
    public boolean isEmpty();
    public void clear();
}