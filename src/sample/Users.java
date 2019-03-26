package sample;

import java.util.Date;

public class Users {
    private String userName;
    private String hashPassword;
    private String email;
    private String FName;
    private String Lname;
    private String date;
    private int UID;
    private int typeID;
    private int statusID;

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
        this.UID=UID;
        this.typeID=typeID;
        this.statusID=statusID;
    }

    public int getUID() {
        return UID;
    }

    public String getDate() {
        return date;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getEmail() {
        return email;
    }

    public String getFName() {
        return FName;
    }

    public String getLname() {
        return Lname;
    }

    public String getUserName() {
        return userName;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getHashPassword() {
        return hashPassword;
    }
}
