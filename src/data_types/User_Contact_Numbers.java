package data_types;

public class User_Contact_Numbers {
	private int Number,
	U_ID,
	Order;
	private String Type;
	
	public User_Contact_Numbers(int Number, int U_ID, String Type, int Order) {
		if(Meth.var_valid(Type,32)){
			this.Number = Number;
			this.U_ID = U_ID;
			this.Order = Order;
			this.Type = Type;
		}
		else{
			System.out.println("Error... input invalid");
		}
	}
	
	public User_Contact_Numbers(int Number, int U_ID, int Order) {
		this.Number = Number;
		this.U_ID = U_ID;
		this.Order = Order;
		this.Type = null;
	}
	
	public int getNumber() {
		return Number;
	}
	
	public int getOrder() {
		return Order;
	}
	
	public String getType() {
		return Type;
	}
	
	public int getU_ID() {
		return U_ID;
	}
	
	public void setNumber(int number) {
		Number = number;
	}
	
	public void setOrder(int order) {
		Order = order;
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
}


/* CREATE table User_Contact_Numbers(
 
   Number          INT             NOT NULL,

    U_ID            INT             NOT NULL,

    Type            VARCHAR(32),

    _Order          INT             NOT NULL,


    
PRIMARY KEY (Number, U_ID),

    FOREIGN KEY (U_ID)

        REFERENCES Users (U_ID)

    );*/