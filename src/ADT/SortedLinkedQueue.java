/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author ASUS
 * @param <T>
 */
public class SortedLinkedQueue<T extends Comparable<T>> implements QueueInterface<T> {

    private Node firstNode;
    private int countEntry = 0;

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        Node currentNode = firstNode;

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            while (newEntry.compareTo(currentNode.data) > 0) {
                if (currentNode.next == null || !(newEntry.compareTo(currentNode.next.data) > 0)) {
                    break;
                }
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        ++countEntry;
    }

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
            firstNode = firstNode.next;
        }
        --countEntry;
        return front;
    }

    @Override
    public T getFront() {        
        if (isEmpty()) {
            return null;
        } else {
            return firstNode.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public void clear() {
        firstNode = null;
        countEntry = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return countEntry;
    }

    private class Node {

        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
