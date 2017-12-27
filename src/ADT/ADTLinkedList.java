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
public class ADTLinkedList<T> implements ADTLinkedListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int count = 0;

    private class Node {

        T data;
        Node next;
        Node previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
            this.previous = null;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public ADTLinkedList() {
        clear();
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
        ++count;
        // to count the entry each time added
    }

    @Override
    public void add(T newEntry, int newPosition) {
        Node newNode = new Node(newEntry);
        Node Temp = null;
        //Make sure the new position is no smaller than 1.
        //Make sure the new position is no larger than total entries.
        if (newPosition <= count + 1 && newPosition >= 1) {
            if (newPosition == 1) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else if (newPosition == count + 1) {
                lastNode.next = newNode;
                lastNode = newNode;
            } else {
            //Declare to find which position is given position
                Temp = firstNode;
                for (int i = 1; i < newPosition; i++) {
                    Temp = Temp.next;
                }

                Temp.previous.next = newNode;
                newNode.next = Temp;
                newNode.previous = Temp.previous;
                Temp.previous = newNode;
            }
            ++count;
           // to count the entry each time added
        }
    }

    @Override
    public T remove(int givenPosition) {
        T removeData = null;
        //Make sure the new position is no smaller than 1.
        //Make sure the new position is no larger than total entries.
        if (givenPosition >= 1 && givenPosition <= count) {
            if (givenPosition == 1) {
                removeData = firstNode.data;
                firstNode = firstNode.next;
            } else if (givenPosition == count) {
                removeData = lastNode.data;
                lastNode = lastNode.previous;
                lastNode.next = null;
            } else {
        //Declare to find which position is given position
                Node temp = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    temp = temp.next;
                }
                removeData = temp.next.data;
                temp.next = temp.next.next;
                temp.next.previous = temp;
            }
            --count;
        // to count the entry each time minus.
        }
        return removeData;

    }

    @Override
    public void replace(T newEntry, int givenPosition) {
        //Make sure the new position is no smaller than 1.
        //Make sure the new position is no larger than total entries.
        if (givenPosition >= 1 && givenPosition <= count) {
            if (givenPosition == 1) {
                firstNode.data = newEntry;
            } else if (givenPosition == count) {
                lastNode.data = newEntry;
            } else {
        //Declare to find which position is given position
                Node temp = firstNode;
                for (int i = 1; i < givenPosition; ++i) {
                    temp = temp.next;
                }
                temp.data = newEntry;
            }

        }
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return firstNode.data;
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        T entry;
         //Make sure the new position is no smaller than 1.
         //Make sure the new position is no larger than total entries.
        if (givenPosition >= 1 && givenPosition <= count) {
            if (givenPosition == 1) {
                entry = getFirst();
            } else if (givenPosition == count) {
                entry = getLast();
            } else {
         //Declare to find which position is given position
                Node temp = firstNode;
                for (int i = 1; i < givenPosition; ++i) {
                    temp = temp.next;
                }
                entry = temp.data;
            }
        } else {
            entry = null;
        }
        return entry;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        } else {
            return lastNode.data;
        }
    }

    @Override
    public int getTotalEntries() {
        return count;
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
        count = 0;
    }

}