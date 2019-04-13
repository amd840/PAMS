package data_types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Clinics {
	    private int C_ID,
	    Clinic_ManID,
	    Status_ID;
	    private String _Profile,
	    Services,
	    Location,
	    Website,
	    EMail;

	    private BigDecimal Rating;
	    
	    public Clinics(int C_ID, String Profile, String Services, String Location, String Website, String EMail, BigDecimal Rating, int Clinic_ManID, int Status_ID) {
	    	if(Meth.var_valid(EMail,64)){
		    	this.C_ID = C_ID;
		    	this._Profile = Profile;
		    	this.Services = Services;
		    	this.Location = Location;
		    	this.Website = Website;
		    	this.EMail = EMail;
		    	this.Rating = Rating;
		    	this.Clinic_ManID = Clinic_ManID;
		    	this.Status_ID = Status_ID;
	    	}else{
				System.out.println("Error... input invalid");
			}
		}
	    
	    public Clinics(int C_ID, String Profile, String Services, String Location,  String EMail, int Clinic_ManID, int Status_ID) {
	    	if(Meth.var_valid(EMail,64)){
		    	this.C_ID = C_ID;
		    	this._Profile = Profile;
		    	this.Services = Services;
		    	this.Location = Location;
		    	this.Website = null;
		    	this.EMail = EMail;
		    	this.Rating = null;
		    	this.Clinic_ManID = Clinic_ManID;
		    	this.Status_ID = Status_ID;
	    	}else{
				System.out.println("Error... input invalid");
			}
		}
	    
	    public Clinics() {
		    	this.C_ID = -1;
		    	this._Profile = null;
		    	this.Services = null;
		    	this.Location = null;
		    	this.Website = null;
		    	this.EMail = null;
		    	this.Rating = null;
		    	this.Clinic_ManID = -1;
		    	this.Status_ID = -1;
		}
	    
	    public Clinics(ResultSet r) {
				try {
			    	this.C_ID = r.getInt("C_ID");
			    	this._Profile = r.getString("_Profile");
			    	this.Services = r.getString("Services");
			    	this.Location = r.getString("Location");
			    	this.Website = r.getString("Website");
			    	this.EMail = r.getString("EMail");
			    	this.Rating = r.getBigDecimal("Rating");
			    	this.Clinic_ManID = r.getInt("Clinic_ManID");
			    	this.Status_ID = r.getInt("Status_ID");
			    	
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	    
	    
	    public int getC_ID() {
			return C_ID;
		}
	    
	    public int getClinic_ManID() {
			return Clinic_ManID;
		}
	    
	    public String getEMail() {
			return EMail;
		}
	    
	    public String getLocation() {
			return Location;
		}
	    
	    public String get_Profile() {
			return _Profile;
		}
	    
	    public BigDecimal getRating() {
			return Rating;
		}
	    
	    public String getServices() {
			return Services;
		}
	    
	    public int getStatus_ID() {
			return Status_ID;
		}
	    
	    public String getWebsite() {
			return Website;
		}
	    
	    public void setC_ID(int c_ID) {
			C_ID = c_ID;
		}
	    
	    public void setClinic_ManID(int clinic_ManID) {
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
	    
	    public void set_Profile(String profile) {
			_Profile = profile;
		}
	    
	    public void setRating(BigDecimal rating) {
			Rating = rating;
		}
	    
	    public void setServices(String services) {
			Services = services;
		}
	    
	    public void setStatus_ID(int status_ID) {
			Status_ID = status_ID;
		}
	    
	    public void setWebsite(String website) {
			Website = website;
		}

	    public boolean addToDB(Connection connect){
	    	PreparedStatement add;
			try {
				add = connect.prepareStatement("Select C_ID From Clinics WHERE C_ID = "+C_ID+";");
				ResultSet r = add.executeQuery();
				if(r.next()){
					System.out.println("C_ID already taken.");
					return false;
				}
				add = connect.prepareStatement("Select EMail From Clinics WHERE EMail = '"+EMail+"';");
				r = add.executeQuery();
				if(r.next()){
					System.out.println("EMail already taken.");
					return false;
				}
				add = connect.prepareStatement("INSERT INTO Clinics () values ("+C_ID+",'"+_Profile+"','"+Services+"','"+Location+"','"+Website+"','"+EMail+"',"+Rating+","+Clinic_ManID+","+Status_ID+");");
				add.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} 
	    }
	    
	    public static void toStringClinics(Connection connect,boolean pick) throws Exception{
	    	PreparedStatement statement;
	    	if(pick){
	    		statement = connect.prepareStatement("SELECT * FROM Clinics WHERE Status_ID = 0;");
	    	}else{
	    		statement = connect.prepareStatement("SELECT * FROM Clinics;");
	    	}
	        
			ResultSet Result = statement.executeQuery();

	        if (!Result.next())
	        	System.out.println("Empty Set");
	        do{
	            System.out.println("C_ID: " + Result.getInt("C_ID"));

	            System.out.println("Profile: " + Result.getString("_Profile"));
	            
	            System.out.println("Location: " + Result.getString("Location"));
	            
	            System.out.println("E-Mail: " + Result.getString("EMail"));
	            
	            System.out.println("Website: " + Result.getString("Website"));
	            
	            System.out.println("Rating: " + Result.getBigDecimal("Rating"));
	            
	            System.out.println("Clinic_ManID: " + Result.getInt("Clinic_ManID"));
	            
	            System.out.println("Status_ID: " + Result.getInt("Status_ID"));
	            
	        }while(Result.next());
	        System.out.println("Done");
	        
	    }
	    
	    public String toString() {
	    return "C_ID: " + C_ID + "\nProfile: " + _Profile + "\nLocation: " + Location + "\nE-Mail: " + EMail + "\nWebsite: " + Website + "\nRating: " + Rating + "\nClinic_Admin_ID: " + Clinic_ManID + "Status_ID: " + Status_ID;
	    }
	    
	    public static ArrayList<Clinics> getAllArrayList(Connection connect) throws Exception{
	    	ArrayList<Clinics> al = new ArrayList<Clinics>();
	    	ResultSet r = connect.prepareStatement("SELECT * From Clinics;").executeQuery();
	    	
	    	while(r.next())
	    		al.add(new Clinics(r.getInt("C_ID"), r.getString("_Profile"), r.getString("Services"), r.getString("Location"), r.getString("Website"), r.getString("EMail"), r.getBigDecimal("Rating"), r.getInt("Clinic_ManID"), r.getInt("Status_ID")));
	    	return al;
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