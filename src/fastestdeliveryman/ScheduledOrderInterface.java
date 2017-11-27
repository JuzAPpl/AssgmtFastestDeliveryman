/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

/**
 *
 * @author User
 */
public interface ScheduledOrderInterface {
    public ScheduledOrderInterface addScheduledOrder();
    public void editScheduledOrder(ScheduledOrderInterface S);
    public void cancelScheduledOrder();
    public void checkScheduledOrder();
}
