package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarController implements Initializable{
    @FXML
    private DatePicker datePicker1;
    @FXML
    private String d1;
    @FXML
    private String name, phone;
    int amount;
    @FXML
    private String d2;
    @FXML
    private DatePicker datePicker2;

    @FXML
    private Label roomLabel; //available rooms
    @FXML

    //Table setup
    private  TableView<Reservation> roomTable;//main table
    @FXML
    private TableColumn<Reservation, String> nameColumn;
    @FXML
    private TableColumn<Reservation, String> statusColumn;
    @FXML
    private TableColumn<Reservation, Integer> sizeColumn;

    ObservableList<Reservation> resList = FXCollections.observableArrayList(
            new Reservation("John Doe", "yes", 5),
            new Reservation("Alex Smith", "yes", 4)
    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Table for displaying reservation info
        nameColumn.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Name"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Reservation, String>("BookStatus"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("RoomSize"));
        //test addReservation
        addReservation(name,"Yes",amount,d1,d2);

        roomTable.setItems(resList);

    }
    public void addReservation(String name, String isBook, int partySize, String d1, String d2)
    {

        Reservation y = new Reservation(name,isBook,partySize);
        resList.add(y);
        if(resList.size()>9)
        {
            resList.remove(9);
            System.out.print("The hotel is full");
        }

    }
    // get check-in date and store it in d1
    public void getDate1(ActionEvent event){
        LocalDate myDate1 = datePicker1.getValue();
        d1 = myDate1.format(DateTimeFormatter.ofPattern("MM/DD/YYYY"));
    }
    // get check-out date and store it in d2
    public void getDate2(ActionEvent event){
        LocalDate myDate2 = datePicker2.getValue();
        d2 = myDate2.format(DateTimeFormatter.ofPattern("MM/DD/YYYY"));
    }


}