/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import fastestdeliveryman.ScheduledOrder;

/**
 *
 * @author User
 * @param <T>
 */
public class ScheduledOrderList<T> implements SOrderListInterface<T> {

    private Node firstNode;

    public int countNode(Node temp) {
        if (temp != null) {
            return countNode(temp.next) + 1;
        } else {
            return 0;
        }
    }

    @Override
    public void addNew(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node temp = firstNode;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (!isEmpty()) {
            Node temp = firstNode;
            int count = 0;
            while (temp != null) {
                count += 1;
                if (count == index) {
                    if (temp.previous == null) {
                        firstNode = firstNode.next;
                    } else if (temp.next == null) {
                        temp.previous.next = null;
                    } else {
                        temp.next.previous = temp.previous;
                        temp.previous.next = temp.next;
                    }
                }
                temp = temp.next;
            }
        } else {
            System.out.println("Error, the Scheduled Order List is empty!");
        }
    }

    @Override
    public Object getObject(int index) {
        Object obj = new Object();
        Node temp = firstNode;
        int count = 0;
        if (!isEmpty()) {
            while (temp != null) {
                count += 1;
                if (count == index) {
                    obj = temp.data;
                }
                temp = temp.next;
            }
        }
        return obj;
    }

    @Override
    public void clear() {
        firstNode = null;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public String displaySchduledOrders() {
        String msg = "";
        int count = 0;
        Node currentNode = firstNode;
        if (!isEmpty()) {
            String title = "\n============================================================"
                    + "\nScheduledOrder"
                    + "\n============================================================\n";
            String str = "|| no. || OrderNumber ||          Ordered Food          ||         Location        || Next Delivery Date || Delivery left ||\n";
            System.out.println(title + str);
        }
        while (currentNode != null) {
            if (currentNode.data != null) {
                msg += ++count + ". " + (currentNode.data).toString();
            }
            //msg += "\n";
            currentNode = currentNode.next;
        }
        return msg;
    }

    @Override
    public int countNode(ADT.Node temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getFirstList() {
        getFirstNode();
    }

    public Node getFirstNode() {
        return firstNode;
    }

    private class Node {

        private T data;
        private Node next;
        private Node previous;

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
