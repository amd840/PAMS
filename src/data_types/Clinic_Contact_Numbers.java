package data_types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Clinic_Contact_Numbers {
	private int  Clinic_ID, 
	_Order;
	private String Number,Type;
	
	public Clinic_Contact_Numbers(String Number, int Clinic_ID, String Type, int Order) {
	    if(Meth.var_valid(Type,32)){
		this.Number = Number;
	    this.Clinic_ID = Clinic_ID;
	    this.Type = Type;
	    this._Order = Order;
	    }else{
			System.out.println("Error... input invalid");
		}
	}
	
	public Clinic_Contact_Numbers(String Number, int Clinic_ID, int Order) {
	    this.Number = Number;
	    this.Clinic_ID = Clinic_ID;
	    this.Type = null;
	    this._Order = Order;
	}
	
	public Clinic_Contact_Numbers() {
		this.Number = null;
		this.Clinic_ID = -1;
		this._Order = -1;
		this.Type = null;
	}
	
	public Clinic_Contact_Numbers(Clinic_Contact_Numbers c) {
		this.Number = c.getNumber();
		this.Clinic_ID = c.getClinic_ID();
		this._Order = c.get_Order();
		this.Type = c.getType();
	}
	
	public int getClinic_ID() {
		return Clinic_ID;
	}
	
	public String getNumber() {
		return Number;
	}
	
	public int get_Order() {
		return _Order;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setClinic_ID(int clinic_ID) {
		Clinic_ID = clinic_ID;
	}
	
	public void setNumber(String number) {
		Number = number;
	}
	
	public void set_Order(int order) {
		_Order = order;
	}
	
	public boolean setType(String type) {
		if(Meth.var_valid(type,32)){
			Type = type;
			return true;
		}
		return false;
	}
	
	
    public boolean addToDB(Connection connection){
    	PreparedStatement add;
		try {
			add = connection.prepareStatement("Select Clinic_ID From Clinic_Contact_Numbers WHERE Clinic_ID = "+Clinic_ID+" AND Number = '" + Number + "';");
			ResultSet r = add.executeQuery();
			if(r.next()){
				System.out.println("Clinic_ID/Number combination already exists.");
				return false;
			}
			add = connection.prepareStatement("INSERT INTO Clinic_Contact_Numbers () values ('"+Number+"','"+Clinic_ID+"','"+Type+"',"+_Order+");");
			add.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }
}

/* CREATE table Clinic_Contact_Numbers(

    Number          VARCHAR(16)     NOT NULL,

    Clinic_ID       INT             NOT NULL,

    Type            VARCHAR(32),

    _Order          INT             NOT NULL,

    

    PRIMARY KEY (Number, Clinic_ID),

    FOREIGN KEY (Clinic_ID)

        REFERENCES Clinics (C_ID)

    );*/