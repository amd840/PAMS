package data_types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User_Contact_Numbers {
	private int U_ID,
	_Order;
	private String Number,Type;
	
	public User_Contact_Numbers(String Number, int U_ID, String Type, int _Order) {
		if(Meth.var_valid(Type,32)){
			this.Number = Number;
			this.U_ID = U_ID;
			this._Order = _Order;
			this.Type = Type;
		}
		else{
			System.out.println("Error... input invalid");
		}
	}
	
	public User_Contact_Numbers(User_Contact_Numbers u) {
		this.Number = u.getNumber();
		this.U_ID = u.getU_ID();
		this._Order = u.getOrder();
		this.Type = u.getType();
	}
	
	public User_Contact_Numbers(ResultSet r) throws NumberFormatException, SQLException {
		this.Number = r.getString("Number");
		this.U_ID = Integer.parseInt(r.getString("U_ID"));
		this._Order = Integer.parseInt(r.getString("_Order"));
		this.Type = r.getString("Type");
	}
	
	
	public User_Contact_Numbers() {
		this.Number = null;
		this.U_ID = -1;
		this._Order = -1;
		this.Type = null;
	}
	
	public User_Contact_Numbers(String Number, int U_ID, int _Order) {
		this.Number = Number;
		this.U_ID = U_ID;
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
	
	public int getU_ID() {
		return U_ID;
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
	
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	
    public boolean addToDB(Connection connection){
    	PreparedStatement add;
		try {
			add = connection.prepareStatement("Select U_ID From User_Contact_Numbers WHERE U_ID = "+U_ID+" AND _Order = " + _Order + ";");
			ResultSet r = add.executeQuery();
			if(r.next()){
				System.out.println("U_ID/Number combination already exists.");
				return false;
			}
			add = connection.prepareStatement("INSERT INTO User_Contact_Numbers () values ('"+Number+"','"+U_ID+"','"+Type+"',"+_Order+");");
			add.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }
    
    
    public static ArrayList<User_Contact_Numbers> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<User_Contact_Numbers> al = new ArrayList<User_Contact_Numbers>();
    	ResultSet r = connect.prepareStatement("SELECT * From User_Contact_Numbers;").executeQuery();
    	
    	while(r.next())
    		al.add(new User_Contact_Numbers(r.getString("Number"), r.getInt("U_ID"), r.getString("Type"), r.getInt("_Order")));
    	return al;
    }
}


/* CREATE table User_Contact_Numbers(
 
   Number           VARCHAR(16)     NOT NULL,

    U_ID            INT             NOT NULL,

    Type            VARCHAR(32),

    _Order          INT             NOT NULL,


    
PRIMARY KEY (Number, U_ID),

    FOREIGN KEY (U_ID)

        REFERENCES Users (U_ID)

    );*/