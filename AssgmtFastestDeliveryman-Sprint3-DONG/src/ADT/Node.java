/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 * Tutorial group: RSD2 G2
 * @author Lim Fang Chun
 */
public class Node<T> {
    private T data;
    private Node next;
    private Node previous;
    
    public Node(){
        this.data = null;
        this.next = null;
        this.previous = null;
    }
    
    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    
    public Node(T data, Node next){
        this.data = data;
        this.next = next;
        this.previous = null;
    }

    public Node(T data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
    
    public T getData(){
        return data;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setNext(Node next){
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
