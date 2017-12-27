 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;


import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Ng Pei Xiang & Chow Swee Tung
 * RoutineRecord Class record the daily routines of a delivery man
 */
public class RoutineRecord {
 
    private Date routineDate;
    private String routineDateString = "";
    private String clockInTime = "Not Clocked In";
    private String clockOutTime = "Not Clocked Out";
    private String workHour = "No Working Hour";
    
    public RoutineRecord(){
        routineDate = new Date();
        routineDateString = convertDateToString();  
    }
    
    private String convertDateToString(){
        String datePattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(routineDate);
    }
    
    private String convertCurrentTimeToString(){
        String datePattern = "HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(new Date());
    }
    
    public void logClockInTime()
    {
        clockInTime = convertCurrentTimeToString();
    }
    public void logClockOutTime()
    {
        clockOutTime = convertCurrentTimeToString();
        calWorkingHour();
    }
    
    public String getClockInTime(){
        return clockInTime;
    }
    
    public String getClockOutTime(){
        return clockOutTime;
    }
    
    public void calWorkingHour() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(clockInTime);
            d2 = format.parse(clockOutTime);
            long diffTime = d2.getTime() - d1.getTime();
            long diffSeconds = diffTime / 1000 % 60;
            long diffMinutes = diffTime / (60 * 1000) % 60;
            long diffHours = diffTime / (60 * 60 * 1000) % 24;         
       
            workHour= diffHours+":"+diffMinutes+":"+diffSeconds;
        } catch (Exception e) {
            
        }
        
    }
    
    @Override
    public String toString(){
        return String.format("%-20s %-20s %-20s %-20s",routineDateString, clockInTime, clockOutTime, workHour);
    }
}
