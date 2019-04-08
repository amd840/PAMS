package data_types;

public class Clinics {
	    private int C_ID;
	    private String Profile,
	    Services,
	    Location,
	    Website,
	    EMail,
	    Clinic_ManID,
	    Status_ID;
	    private double Rating;
	    
	    public Clinics(int C_ID, String Profile, String Services, String Location, String Website, String EMail, double Rating, String Clinic_ManID, String Status_ID) {
	    	if(Meth.var_valid(EMail,64)){
		    	this.C_ID = C_ID;
		    	this.Profile = Profile;
		    	this.Services = Services;
		    	this.Location = Location;
		    	this.Website = Website;
		    	this.EMail = EMail;
		    	this.Rating = Meth.round(Rating, 2);
		    	this.Clinic_ManID = Clinic_ManID;
		    	this.Status_ID = Status_ID;
	    	}else{
				System.out.println("Error... input invalid");
			}
		}
	    
	    public Clinics(int C_ID, String Profile, String Services, String Location,  String EMail, String Clinic_ManID, String Status_ID) {
	    	if(Meth.var_valid(EMail,64)){
		    	this.C_ID = C_ID;
		    	this.Profile = Profile;
		    	this.Services = Services;
		    	this.Location = Location;
		    	this.Website = null;
		    	this.EMail = EMail;
		    	this.Rating = -1;
		    	this.Clinic_ManID = Clinic_ManID;
		    	this.Status_ID = Status_ID;
	    	}else{
				System.out.println("Error... input invalid");
			}
		}
	    
	    public int getC_ID() {
			return C_ID;
		}
	    
	    public String getClinic_ManID() {
			return Clinic_ManID;
		}
	    
	    public String getEMail() {
			return EMail;
		}
	    
	    public String getLocation() {
			return Location;
		}
	    
	    public String getProfile() {
			return Profile;
		}
	    
	    public double getRating() {
			return Rating;
		}
	    
	    public String getServices() {
			return Services;
		}
	    
	    public String getStatus_ID() {
			return Status_ID;
		}
	    
	    public String getWebsite() {
			return Website;
		}
	    
	    public void setC_ID(int c_ID) {
			C_ID = c_ID;
		}
	    
	    public void setClinic_ManID(String clinic_ManID) {
			Clinic_ManID = clinic_ManID;
		}
	    
	    public boolean setEMail(String eMail) {
			if(Meth.var_valid(eMail,64)){
				EMail = eMail;
				return true;
			}
			return false;
		}
	    
	    public void setLocation(String location) {
			Location = location;
		}
	    
	    public void setProfile(String profile) {
			Profile = profile;
		}
	    
	    public void setRating(double rating) {
			Rating = Meth.round(rating, 2);
		}
	    
	    public void setServices(String services) {
			Services = services;
		}
	    
	    public void setStatus_ID(String status_ID) {
			Status_ID = status_ID;
		}
	    
	    public void setWebsite(String website) {
			Website = website;
		}

}


/* CREATE table Clinics(

    C_ID            INT             NOT NULL,

    _Profile        TEXT            NOT NULL,

    Services        TEXT            NOT NULL,

    Location        TEXT            NOT NULL,

    Website         TEXT,

    EMail           VARCHAR(64)     NOT NULL,

    Rating          DECIMAL(4,2),

    Clinic_ManID    INT             NOT NULL,

    Status_ID       INT             NOT NULL,

    

    PRIMARY KEY (C_ID),

    FOREIGN KEY (Clinic_ManID)
 
        REFERENCES Users (U_ID),

    FOREIGN KEY (Status_ID)

        REFERENCES Status (Status_ID),

    UNIQUE (EMail)

    );*/