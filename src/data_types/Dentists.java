package data_types;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dentists {
    private int D_ID,
    Clinic_Num,
    Status_ID,   
    Years_Active,   
    Specialty_ID,
    Clinic_ID;
    private String _Profile,
    Clinic_Office,
    Website,  
    FName,
    LName,
    EMail;
    private double Rating;

    public Dentists(int D_ID, String FName, String LName, String Profile, int Years_Active, String Website, String EMail, double Rating, int Specialty_ID, int Clinic_ID, String Clinic_Office, int Clinic_Num, int Status_ID) {
        if(Meth.var_valid(FName,24) && Meth.var_valid(LName,24) && Meth.var_valid(EMail,64)){
			this.D_ID = D_ID;
			this.FName = FName;
			this.LName = LName;
			this._Profile = Profile;
			this.Years_Active = Years_Active;
			this.Website = Website;
			this.EMail = EMail;
			this.Rating = Rating;
			this.Specialty_ID = Specialty_ID;
			this.Clinic_ID = Clinic_ID;
			this.Clinic_Office = Clinic_Office;
			this.Clinic_Num = Clinic_Num;
			this.Status_ID = Status_ID;
        }
		else{
			System.out.println("Error... input invalid");
		}
	}
    
    public Dentists(int D_ID, String FName, String LName, String Profile, int Specialty_ID, int Clinic_ID, int Status_ID) {
        if(Meth.var_valid(FName,24) && Meth.var_valid(LName,24)){
	    	this.D_ID = D_ID;
			this.FName = FName;
			this.LName = LName;
	        this._Profile = Profile;
	        this.Years_Active = -1;
	        this.Website = null;
	        this.EMail = null;
	        this.Rating = 0;
	        this.Specialty_ID = Specialty_ID;
	        this.Clinic_ID = Clinic_ID;
	        this.Clinic_Office = null;
	        this.Clinic_Num = -1;
	        this.Status_ID = Status_ID;
        }
		else{
			System.out.println("Error... input invalid");
		}
	}
    
    public Dentists() {
	    	this.D_ID = -1;
			this.FName = null;
			this.LName = null;
	        this._Profile = null;
	        this.Years_Active = -1;
	        this.Website = null;
	        this.EMail = null;
	        this.Rating = 0;
	        this.Specialty_ID = -1;
	        this.Clinic_ID = -1;
	        this.Clinic_Office = null;
	        this.Clinic_Num = -1;
	        this.Status_ID = -1;
	}
    
    public int getClinic_ID() {
		return Clinic_ID;
	}
    
    public int getClinic_Num() {
		return Clinic_Num;
	}
    
    public String getClinic_Office() {
		return Clinic_Office;
	}
    
    public int getD_ID() {
		return D_ID;
	}
    
    public String getEMail() {
		return EMail;
	}
    
    public String getFName() {
		return FName;
	}
    
    public String getLName() {
		return LName;
	}
    
    public String get_Profile() {
		return _Profile;
	}
    
    public double getRating() {
		return Rating;
	}
    
    public int getSpecialty_ID() {
		return Specialty_ID;
	}
    
    public int getStatus_ID() {
		return Status_ID;
	}
    
    public String getWebsite() {
		return Website;
	}
    
    public int getYears_Active() {
		return Years_Active;
	}
    
    public void setClinic_ID(int clinic_ID) {
		Clinic_ID = clinic_ID;
	}
    
    public void setClinic_Num(int clinic_Num) {
		Clinic_Num = clinic_Num;
	}
    
    public void setClinic_Office(String clinic_Office) {
		Clinic_Office = clinic_Office;
	}
    
    public void setD_ID(int d_ID) {
		D_ID = d_ID;
	}
    
    public boolean setEMail(String eMail) {
    	if(Meth.var_valid(eMail,64)){
    		EMail = eMail;
    		return true;
    	}
    	return false;
	}
    
    public boolean setFName(String fName) {
    	if(Meth.var_valid(fName,24)){
    		FName = fName;
    		return true;
    	}
    	return false;
	}
    
    public boolean setLName(String lName) {
    	if(Meth.var_valid(lName,24)){
    		LName = lName;
    		return true;
    	}
		return false;
	}
    
    public void set_Profile(String profile) {
		_Profile = profile;
	}
    
    public void setRating(double rating) {
		Rating = rating;
	}
    
    public void setSpecialty_ID(int specialty_ID) {
		Specialty_ID = specialty_ID;
	}
    
    public void setStatus_ID(int status_ID) {
		Status_ID = status_ID;
	}
    
    public void setWebsite(String website) {
		Website = website;
	}
    
    public void setYears_Active(int years_Active) {
		Years_Active = years_Active;
	}
    
    public boolean addToDB(Connection connection){
    	PreparedStatement add;
		try {
			add = connection.prepareStatement("Select D_ID From Dentists WHERE D_ID = "+D_ID+";");
			ResultSet r = add.executeQuery();
			if(r.next()){
				System.out.println("D_ID already taken.");
				return false;
			}
			add = connection.prepareStatement("Select EMail From Dentists WHERE EMail = '"+EMail+"';");
			r = add.executeQuery();
			if(r.next()){
				System.out.println("EMail already taken.");
				return false;
			}
			add = connection.prepareStatement("INSERT INTO Dentists () values ("+D_ID+",'"+FName+"','"+LName+"','"+_Profile+"',"+Years_Active+",'"+Website+"','"+EMail+"',"+Rating+"," +Specialty_ID+"," +Clinic_ID+",'" +Clinic_Office+"'," +Clinic_Num+","+Status_ID+");");
			add.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }
    
    public static ArrayList<Dentists> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<Dentists> al = new ArrayList<Dentists>();
    	ResultSet r = connect.prepareStatement("SELECT * From Dentists;").executeQuery();
    	
    	while(r.next())
    		al.add(new Dentists(r.getInt("D_ID"), r.getString("FName"), r.getString("LName"), r.getString("Profile"), r.getInt("Years_Active"), r.getString("Website"), r.getString("EMail"), r.getDouble("Rating"), r.getInt("Specialty_ID"), r.getInt("Clinic_ID"), r.getString("Clinic_Office"), r.getInt("Clinic_Num"), r.getInt("Status_ID")));
    	return al;
    }

}


/* CREATE table Dentists(

    D_ID            INT             NOT NULL,

    FName           VARCHAR(24)     NOT NULL,

    LName           VARCHAR(24)     NOT NULL,

    _Profile        TEXT            NOT NULL,

    Years_Active    INT,

    Website         TEXT,

    EMail           VARCHAR(64),

    Rating          DECIMAL(4,2),

    Specialty_ID    INT             NOT NULL,

    Clinic_ID       INT             NOT NULL,

    Clinic_Office   TEXT,

    Clinic_Num      INT,

    Status_ID       INT             NOT NULL,

    

    PRIMARY KEY (D_ID),

    FOREIGN KEY (Clinic_ID)

        REFERENCES Clinics (C_ID),

    FOREIGN KEY (Specialty_ID)

        REFERENCES Specialties (Specialty_ID),

    FOREIGN KEY (Status_ID)

        REFERENCES Status (Status_ID),

    UNIQUE (EMail)

    );*/