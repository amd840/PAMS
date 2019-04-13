package data_types;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Specialties {
    private int Specialty_ID;
    private String Spec_Name,
    Description;
    
    public Specialties(int Specialty_ID, String Spec_Name, String Description) {
		if(Meth.var_valid(Spec_Name,64)){
			this.Specialty_ID = Specialty_ID;
			this.Spec_Name = Spec_Name;
			this.Description = Description;
		}
		else{
			System.out.println("Error... input invalid");
		}
	}
    
    public String getDescription() {
		return Description;
	}
    
    public String getSpec_Name() {
		return Spec_Name;
	}
    
    public int getSpecialty_ID() {
		return Specialty_ID;
	}
    
    public void setDescription(String description) {
		Description = description;
	}
    
    public boolean setSpec_Name(String spec_Name) {
    	if(Meth.var_valid(spec_Name,64)){
    		Spec_Name = spec_Name;
    		return true;
    	}
    	return false;
	}
    
    public void setSpecialty_ID(int specialty_ID) {
		Specialty_ID = specialty_ID;
	}
    
    public static ArrayList<Specialties> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<Specialties> al = new ArrayList<Specialties>();
    	ResultSet r = connect.prepareStatement("SELECT * From Specialties;").executeQuery();
    	
    	while(r.next())
    		al.add(new Specialties(r.getInt("Specialty_ID"), r.getString("Spec_Name"), r.getString("Description")));
    	return al;
    }
    
}


/* CREATE table Specialties(

    Specialty_ID    INT             NOT NULL,

    Spec_Name       VARCHAR(64)     NOT NULL,

    Description     TEXT            NOT NULL,

    

    PRIMARY KEY (Specialty_ID),

    UNIQUE (Spec_Name)

    );*/