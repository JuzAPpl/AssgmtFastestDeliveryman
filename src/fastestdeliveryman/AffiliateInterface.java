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
public interface AffiliateInterface extends Comparable<AffiliateInterface> {
    public int getID();
    public String getOwnerName();
    public void setOwnerName(String ownerName);
    public String getPassword();
    public void setPassword(String password);
    public String getAddress();
    public void setAddress(String address);
    public String getRestaurantName();
    public void setRestaurantName(String restaurantName);
    public String getContactNo();
    public void setContactNo(String contactNo);
    public void setMenu();
    public Menu getMenu();
    public String getAccStatus();
    public void setAccStatus(String accStatus);
}
