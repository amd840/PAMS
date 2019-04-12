package data_types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dentist_Contact_Numbers {
	private int Dentist_ID,
	_Order;
	private String Number,Type;
	
	public Dentist_Contact_Numbers(String Number, int Dentist_ID, String Type, int _Order) {
		if(Meth.var_valid(Type,32)){
			this.Number = Number;
			this.Dentist_ID = Dentist_ID;
			this._Order = _Order;
			this.Type = Type;
		}
		else{
			System.out.println("Error... input invalid");
		}
	}
	
	public Dentist_Contact_Numbers(Dentist_Contact_Numbers d) {
		this.Number = d.getNumber();
		this.Dentist_ID = d.getDentist_ID();
		this._Order = d.getOrder();
		this.Type = d.getType();
	}
	
	public Dentist_Contact_Numbers(ResultSet r) throws NumberFormatException, SQLException {
		this.Number = r.getString("Number");
		this.Dentist_ID = Integer.parseInt(r.getString("Dentist_ID"));
		this._Order = Integer.parseInt(r.getString("_Order"));
		this.Type = r.getString("Type");
	}
	
	
	public Dentist_Contact_Numbers() {
		this.Number = null;
		this.Dentist_ID = -1;
		this._Order = -1;
		this.Type = null;
	}
	
	public Dentist_Contact_Numbers(String Number, int Dentist_ID, int _Order) {
		this.Number = Number;
		this.Dentist_ID = Dentist_ID;
		this._Order = _Order;
		this.Type = null;
	}
	
	public String getNumber() {
		return Number;
	}
	
	public int getOrder() {
		return _Order;
	}
	
	public String getType() {
		return Type;
	}
	
	public int getDentist_ID() {
		return Dentist_ID;
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
	
	public void setDentist_ID(int dentist_ID) {
		Dentist_ID = dentist_ID;
	}
	
    public boolean addToDB(Connection connection){
    	PreparedStatement add;
		try {
			add = connection.prepareStatement("Select Dentist_ID From Dentist_Contact_Numbers WHERE Dentist_ID = "+Dentist_ID+" AND Number = '" + Number + "';");
			ResultSet r = add.executeQuery();
			if(r.next()){
				System.out.println("Dentist_ID/Number combination already exists.");
				return false;
			}
			add = connection.prepareStatement("INSERT INTO Dentist_Contact_Numbers () values ('"+Number+"','"+Dentist_ID+"','"+Type+"',"+_Order+");");
			add.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }
}
 

/* CREATE table Dentist_Contact_Numbers(

    Number          VARCHAR(16)             NOT NULL,

    Dentist_ID      INT             NOT NULL,

    Type            VARCHAR(32),

    _Order          INT             NOT NULL,

    

    PRIMARY KEY (Number, Dentist_ID),

    FOREIGN KEY (Dentist_ID)

        REFERENCES Dentists (D_ID)

    );*/