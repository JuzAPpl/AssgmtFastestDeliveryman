/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author User
 */
public interface SOrderListInterface<T> {
    public int countNode(Node temp);
    public void addNew(T newEntry);
    public void getFirstList();
    public void remove(int index);
    public Object getObject(int index);
    public void clear();
    public boolean isEmpty();
    public String displaySchduledOrders();
}
