/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;
import ADT.*;

/**
 *
 * @author Ng Pei Xiang
 */
public class Station {
    private String stationName;
    private int stationIndex;
    private QueueInterface<DeliveryOrder> pendingDeliveryQueue = new LinkedQueue<>();

    public Station(String stationName, int stationIndex) {
        this.stationName = stationName;
        this.stationIndex = stationIndex;
    }
    public void enqueueOrder(DeliveryOrder newOrder){
        pendingDeliveryQueue.enqueue(newOrder);
    }
    
    public DeliveryOrder requestForOrder(){
        return pendingDeliveryQueue.dequeue();        
    }
    
}
