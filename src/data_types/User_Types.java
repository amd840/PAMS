package data_types;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class User_Types {
	private int Type_ID;
	private String Entitlement;
	
	public User_Types(int Type_ID, String Entitlement) {
		this.Type_ID = Type_ID;
		this.Entitlement = Entitlement;
	}
	
	public String getEntitlement() {
		return Entitlement;
	}
	
	public int getType_ID() {
		return Type_ID;
	}
	
	public void setEntitlement(String entitlement) {
		Entitlement = entitlement;
	}
	
	public void setType_ID(int type_ID) {
		Type_ID = type_ID;
	}
	
    public static ArrayList<User_Types> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<User_Types> al = new ArrayList<User_Types>();
    	ResultSet r = connect.prepareStatement("SELECT * From User_types;").executeQuery();
    	
    	while(r.next())
    		al.add(new User_Types(r.getInt("Type_ID"),r.getString("Entitlement")));
    	return al;
    }
    
    
}


/* CREATE table User_Types(

    Type_ID         INT             NOT NULL,

    Entitlement     TEXT,

    
    PRIMARY KEY (Type_ID)

    );*/
