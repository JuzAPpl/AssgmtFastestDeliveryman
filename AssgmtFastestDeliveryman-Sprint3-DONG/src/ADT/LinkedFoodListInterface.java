/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import fastestdeliveryman.Food;

/**
 *
 * @author Leo
 * @param <T>
 */
public interface LinkedFoodListInterface<T> extends ListInterface<T> {
    public void displayMenuItemWithStatusOrder();
    public Food getFoodByID(int ID);
}
