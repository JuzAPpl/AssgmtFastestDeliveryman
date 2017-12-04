/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Leo
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private static int countEntry = 0;

    public LinkedList() {
        clear();
        ++countEntry;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (firstNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        ++countEntry;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        if (newPosition >= 1 && newPosition <= countEntry + 1) {
            Node newNode = new Node(newEntry);

            if (isEmpty() || newPosition == 1) {
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.getNext();
                }
                newNode.setNext(nodeBefore.getNext());
                nodeBefore.setNext(newNode);
            }
            ++countEntry;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T remove(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public final void clear() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public boolean replace(int givenPosition, Object newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getEntry(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object anEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfEntries() {
        return countEntry;
    }

    @Override
    public boolean isEmpty() {
        return countEntry == 0;
    }
}
