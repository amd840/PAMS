package data_types;


public class Clinic_Contact_Numbers {
	private int Number, 
	Clinic_ID, 
	Order;
	private String Type;
	
	public Clinic_Contact_Numbers(int Number, int Clinic_ID, String Type, int Order) {
	    if(Meth.var_valid(Type,32)){
		this.Number = Number;
	    this.Clinic_ID = Clinic_ID;
	    this.Type = Type;
	    this.Order = Order;
	    }else{
			System.out.println("Error... input invalid");
		}
	}
	
	public Clinic_Contact_Numbers(int Number, int Clinic_ID, int Order) {
	    this.Number = Number;
	    this.Clinic_ID = Clinic_ID;
	    this.Type = null;
	    this.Order = Order;
	}
	
	public int getClinic_ID() {
		return Clinic_ID;
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
	
	public void setClinic_ID(int clinic_ID) {
		Clinic_ID = clinic_ID;
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

/* CREATE table Clinic_Contact_Numbers(

    Number          INT             NOT NULL,

    Clinic_ID       INT             NOT NULL,

    Type            VARCHAR(32),

    _Order          INT             NOT NULL,

    

    PRIMARY KEY (Number, Clinic_ID),

    FOREIGN KEY (Clinic_ID)

        REFERENCES Clinics (C_ID)

    );*/