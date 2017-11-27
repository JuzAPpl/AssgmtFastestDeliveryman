/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Lim Fang Chun
 * @param <T>
 */
public class LinkedQueue<T> implements QueueInterface {

    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void enqueue(Object newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }

        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = (T) firstNode.getData();
            firstNode = firstNode.getNext();

            if (firstNode == null) {
                lastNode = null;
            }
        }

        return front;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) firstNode.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return firstNode.getData() == null;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

}
