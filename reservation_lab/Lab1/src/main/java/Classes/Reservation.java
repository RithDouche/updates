package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private String name;
    private String roomNum;
    private String isBooked;
    private int partySize;
    private long nights;

    private String date1,date2; // dates should be in this format "dd/mm/yyyy"




    //Default constructor
    public Reservation(){
    }
    //Constructor
    public Reservation(String n, String j, int s,String date1,String date2){
        this.roomNum = n;
        this.isBooked = j;
        this.partySize = s;
        this.date1 = date1;
        this.date2 = date2;
    }
    public Reservation(String n, String j, int s){
        this.roomNum = n;
        this.isBooked = j;
        this.partySize = s;
    }
    //Getters
    public String getName(){
        return roomNum;
    }
    public String getBookStatus(){
        return isBooked;
    }
    public int getRoomSize(){
        return partySize;
    }
    //Setters
    public void setRoomName(String name) {
        this.roomNum = roomNum;
    }
    public void setBookStatus(String bookStatus) {this.isBooked = bookStatus;}
    public void setRoomSize(int roomSize) {
        this.partySize = roomSize;
    }
    //calculate nights between check-in and check-out
    public void calulcateNights(String d1, String d2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = sdf.parse(d1);
        Date date2 = sdf.parse(d2);
        long difference_In_Time = date2.getTime()- date1.getTime();

        nights = (difference_In_Time
                / (1000 * 60 * 60 * 24))
                % 365;
    }


    //adding reservation method
    public Reservation addReservation(){
        Reservation x = new Reservation("Rith Douche","Yes",2);
        return x;
    }
}




