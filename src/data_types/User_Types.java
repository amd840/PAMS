package data_types;

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
	
	
}


/* CREATE table User_Types(

    Type_ID         INT             NOT NULL,

    Entitlement     TEXT,

    
    PRIMARY KEY (Type_ID)

    );*/
