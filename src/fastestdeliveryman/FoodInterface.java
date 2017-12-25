/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

/**
 *
 * @author Leo
 */
public interface FoodInterface {
public interface FoodInterface extends Comparable<FoodInterface> {
    public int getID();
    public void setName(String name);
    public String getName();
    public void setPrice(double price);
    public double getPrice();
    public void setPreparationTime(double preparationTime);
    public String getPreparationTime();
    public String getStatusString();
    public void setStatus(int status);
}
