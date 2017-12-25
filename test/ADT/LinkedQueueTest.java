/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class LinkedQueueTest {
    
    public LinkedQueueTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of enqueue method, of class LinkedQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object newEntry = 123;
        LinkedQueue instance = new LinkedQueue();
        instance.enqueue(newEntry);
        assertEquals(1, instance.getNumberOfEntries());
        assertEquals(newEntry, instance.getFront());
    }

    /**
     * Test of dequeue method, of class LinkedQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        LinkedQueue instance = new LinkedQueue();
        Object expResult = 123;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        assertEquals(0, instance.getNumberOfEntries());
        assertEquals(null, instance.getFront());
    }

    /**
     * Test of getFront method, of class LinkedQueue.
     */
    @Test
    public void testGetFront() {
        System.out.println("getFront");
        LinkedQueue instance = new LinkedQueue();
        Object expResult = 123;
        Object result = instance.getFront();
        assertEquals(expResult, result);
        assertEquals(1, instance.getNumberOfEntries());
    }

    /**
     * Test of isEmpty method, of class LinkedQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedQueue instance = new LinkedQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        assertEquals(1, instance.getNumberOfEntries());
        assertEquals(123, instance.getFront());
    }

    /**
     * Test of clear method, of class LinkedQueue.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        LinkedQueue instance = new LinkedQueue();
        instance.clear();
        assertEquals(true, instance.isEmpty());
    }

    /**
     * Test of getNumberOfEntries method, of class LinkedQueue.
     */
    @Test
    public void testGetNumberOfEntries() {
        System.out.println("getNumberOfEntries");
        LinkedQueue instance = new LinkedQueue();
        int expResult = 0;
        int result = instance.getNumberOfEntries();
        assertEquals(expResult, result);
        
    }
    
}
