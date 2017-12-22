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
public class LinkedPriorityQueue<T> implements PriorityQueueInterface<T> {

    public Node firstNode;
    public Node currentNode;
    public Node lastNode;
    int MaxPriority = 0;
    public static int size = 0;

    private class Node {

        T data;
        Node next;
        Node previous;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public LinkedPriorityQueue(Node firstNode, Node lastNode) {
        clear();
    }

    @Override
    public void enqueue(T newEntry, int Priority) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
            MaxPriority = Priority;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
        ++size;
    }

    @Override
    public T dequeue() {
        T firstEntry = null;
        if (isEmpty()) {
            lastNode = null;
            return firstEntry;
        } else {
            setPriority(firstEntry, MaxPriority);
            firstEntry = firstNode.data;
            firstNode = firstNode.next;
            --size;
            return firstEntry;
        }
    }

    @Override
    public void setPriority(T Entry, int Priority) {
        Entry = currentNode.data;
        for (int k = 0; k < size; k++) {
            if (MaxPriority < Priority) {
                MaxPriority = Priority;
                currentNode = firstNode;
                currentNode.next = firstNode.previous;
                currentNode.previous.next = currentNode.next.next;
                firstNode.data = Entry;
            }
        }
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
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

}
