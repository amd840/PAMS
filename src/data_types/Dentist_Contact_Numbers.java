package data_types;

public class Dentist_Contact_Numbers {
    private int Number,
    Dentist_ID,
    Order;
    private String Type;
    
    public Dentist_Contact_Numbers(int Number, int Dentist_ID, String Type, int Order) {
    	if(Meth.var_valid(Type,32)){
	    	this.Number = Number;
	    	this.Dentist_ID = Dentist_ID;
	    	this.Type = Type;
	    	this.Order = Order;
    	}
		else{
			System.out.println("Error... input invalid");
		}
	}
    
    public Dentist_Contact_Numbers(int Number, int Dentist_ID, int Order) {
    	this.Number = Number;
    	this.Dentist_ID = Dentist_ID;
    	this.Type = null;
    	this.Order = Order;
	}
    
    public int getDentist_ID() {
		return Dentist_ID;
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
    
    public void setDentist_ID(int dentist_ID) {
		Dentist_ID = dentist_ID;
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
}
 

/* CREATE table Dentist_Contact_Numbers(

    Number          INT             NOT NULL,

    Dentist_ID      INT             NOT NULL,

    Type            VARCHAR(32),

    _Order          INT             NOT NULL,

    

    PRIMARY KEY (Number, Dentist_ID),

    FOREIGN KEY (Dentist_ID)

        REFERENCES Dentists (D_ID)

    );*/