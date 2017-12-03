package ADT;

/**
 *
 * @author Lim Fang Chun
 * @param <T>
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private static int countEntry = 0;

    public LinkedList() {
        firstNode = new Node();
        firstNode.setNext(lastNode);
        lastNode = new Node();
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
            
            lastNode = newNode;
        } else {
            newNode.setPrevious(lastNode);
            lastNode.setNext(newNode);
            lastNode = lastNode.getNext();
        }
        ++countEntry;
    }

    @Override
    public boolean add(T newEntry, int newPosition) {
        if (newPosition >= 1 && newPosition <= countEntry + 1) {
            Node newNode = new Node(newEntry);

            if(newPosition == 1){
                newNode.setNext(firstNode);
                firstNode = newNode;
            }
            else if (newPosition == countEntry + 1) {
                newNode.setPrevious(lastNode);
                lastNode.setNext(newNode);
                lastNode = newNode;
            } else {
                Node nodeBefore;
                if (newPosition <= countEntry / 2) {
                    nodeBefore = firstNode;
                    for (int i = 1; i <= newPosition-1; ++i) {
                        nodeBefore = nodeBefore.getNext();
                    }
                } else {
                    nodeBefore = lastNode;
                    for (int i = countEntry; i >= countEntry - newPosition+1; --i) {
                        nodeBefore = nodeBefore.getPrevious();
                    }
                }

                Node nodeAfter = nodeBefore.getNext();

                newNode.setPrevious(nodeBefore);
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
                nodeAfter.setPrevious(newNode);
            }
            ++countEntry;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if (givenPosition >= 1 && givenPosition <= countEntry) {
            if (givenPosition == 1) {
                result = (T) firstNode.getData();
                firstNode = firstNode.getNext();
                firstNode.setPrevious(null);
            } else if (givenPosition == countEntry) {
                result = (T) lastNode.getData();
                lastNode = lastNode.getPrevious();
                lastNode.setNext(null);
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.getNext();
                }

                Node nodeAfter = nodeBefore.getNext();

                result = (T) nodeAfter.getData();
                nodeAfter = nodeAfter.getNext();
                nodeAfter.setPrevious(nodeBefore);
                nodeBefore.setNext(nodeAfter);
            }
            
            --countEntry;
        }
        return result;

    }

    @Override
    public final void clear() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        if (givenPosition >= 1 && givenPosition <= countEntry) {
            if (givenPosition == 1) {
                firstNode.setData(newEntry);
            } else if (givenPosition == countEntry) {
                lastNode.setData(newEntry);
            } else {
                Node currentNode;
                //if given position is less than half of total entries
                //start the loop from beginnning
                //else start the loop from the end
                //eg. total entries = 100
                //    given position = 90
                //if the loop starts from the end
                //the loop will iterate for 10 times only
                if (givenPosition <= countEntry / 2) {
                    currentNode = firstNode;
                    for (int i = 1; i <= givenPosition; ++i) {
                        currentNode = currentNode.getNext();
                    }
                } else {
                    currentNode = lastNode;
                    for (int i = countEntry; i >= countEntry - givenPosition; --i) {
                        currentNode = currentNode.getPrevious();
                    }
                }
                currentNode.setData(newEntry);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition >= 1 && givenPosition <= countEntry) {
            if (givenPosition == 1) {
                return (T) firstNode.getData();
            } else if (givenPosition == countEntry) {
                return (T) lastNode.getData();
            } else {
                Node currentNode;
                //if given position is less than half of total entries
                //start the loop from beginnning
                //else start the loop from the end
                //eg. total entries = 100
                //    given position = 90
                //if the loop starts from the end
                //the loop will iterate for 10 times only
                if (givenPosition <= countEntry / 2) {
                    currentNode = firstNode;
                    for (int i = 1; i < givenPosition; ++i) {
                        currentNode = currentNode.getNext();
                    }
                } else {
                    currentNode = lastNode;
                    for (int i = 1; i < countEntry - givenPosition + 1; ++i) {
                        currentNode = currentNode.getPrevious();
                    }
                }
                
                return (T) currentNode.getData();
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(T entry) {
        Node currentNode = firstNode;

        while (currentNode != null) {
            if (currentNode.getData().equals(entry)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }

        return false;
    }

    @Override
    public int getNumberOfEntries() {
        return countEntry;
    }

    @Override
    public boolean isEmpty() {
        return countEntry == 0;
    }
    
//    @Override
//    public String toString(){
//        String msg ="";
//        Node currentNode = firstNode;
//        while(currentNode != null){
//            msg += (T)(currentNode.getData()).toString();
//            //msg += "\n";
//            currentNode = currentNode.getNext();
//        }
//        return msg;
//    }
}
