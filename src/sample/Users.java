package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.Date;

public class Users {
    private String userName;
    private String hashPassword;
    private String email;
    private String FName;
    private String Lname;
    private String date;
    private int U_ID;
    private int typeID;
    private int statusID;
    private ComboBox<String> State;


    public Users(){}
    public Users( String userName,
             String hashPassword,
             String email,
             String FName,
             String Lname,
             String date,
             int UID,
             int typeID,
             int statusID){
        this.userName=userName;
        this.hashPassword=hashPassword;
        this.email=email;
        this.FName=FName;
        this.Lname=Lname;
        this.date=date;
        this.U_ID=UID;
        this.typeID=typeID;
        this.statusID=statusID;
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "valid","not valid"
                );
        this.State = new ComboBox<String>(options);
        if(statusID==7)
            this.State.setPromptText("valid");
        else
            this.State.setPromptText("not valid");
    }

    public int getU_ID() {
        return U_ID;
    }
    public ComboBox<String> getState() {
        return State;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setUID(int UID) {
        this.U_ID = UID;
    }

    public int getType_ID() {
        return typeID;
    }

    public String getEMail() {
        return email;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return Lname;
    }

    public String getUserName() {
        return userName;
    }

    public int getStatus_ID() {
        return statusID;
    }

    public String getReg_Date() {
        return date;
    }

    public String getHashPassword() {
        return hashPassword;
    }
}
