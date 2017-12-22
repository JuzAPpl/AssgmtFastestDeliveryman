/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author S3113
 */
public interface PriorityQueueInterface<T> {

    public void enqueue(T newEntry,int Priority);
    public T dequeue();
    public void setPriority(T Entry,int Priority);
    public T getFront();
    public int getSize();
    public boolean isEmpty();
    public void clear();
}
