package data_types;

public class Status {
    private int Status_ID;
    private String Status_Name,
    Status_Type,
    Description;
    
    public Status(int Status_ID, String Status_Name, String Status_Type, String Description) {
    	if(Meth.var_valid(Status_Name,64) && Meth.var_valid(Status_Type,64)){
    		this.Status_ID = Status_ID;
			this.Status_Name = Status_Name;
			this.Status_Type = Status_Type;
			this.Description = Description;
    	}
		else{
			System.out.println("Error... input invalid");
		}
    }
    
    public String getDescription() {
		return Description;
	}
    
    public int getStatus_ID() {
		return Status_ID;
	}
    
    public String getStatus_Name() {
		return Status_Name;
	}
    
    public String getStatus_type() {
		return Status_Type;
	}
    
    public void setDescription(String description) {
		Description = description;
	}
    
    public void setStatus_ID(int status_ID) {
		Status_ID = status_ID;
	}
    
    public boolean setStatus_Name(String status_Name) {
    	if(Meth.var_valid(status_Name,64)){
    		Status_Name = status_Name;
    		return true;
    	}
    	return false;
	}
    
    public boolean setStatus_type(String status_Type) {
    	if(Meth.var_valid(status_Type,64)){
		Status_Type = status_Type;
		return true;
	}
	return false;
	}
}


/* CREATE table Status(

    Status_ID       INT             NOT NULL,

    Status_Name     VARCHAR(64)     NOT NULL,

    Status_type     VARCHAR(64)     NOT NULL,

    Description     TEXT            NOT NULL,

    

    PRIMARY KEY (Status_ID),

    UNIQUE (Status_Name)

    );*/