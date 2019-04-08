package data_types;
import java.sql.Date;

public class Appointments {
	private int Apm_ID, 
	Patient_ID, 
	Recept_ID, 
	Dentist_ID, 
	Status_ID;
	private Date Apm_Date;
	private String Apm_Type;
	
	public Appointments(int Apm_ID, Date Apm_Date, String Apm_Type, int Patient_ID, int Recept_ID, int Dentist_ID, int Status_ID) {
		if(Meth.var_valid(Apm_Type,64)){
			this.Apm_ID = Apm_ID;
			this.Apm_Date = Apm_Date;
			this.Apm_Type = Apm_Type;
			this.Patient_ID = Patient_ID;
			this.Recept_ID = Recept_ID;
			this.Dentist_ID = Dentist_ID;
			this.Status_ID = Status_ID;
		}else{
			System.out.println("Error... input invalid");
		}
	}
	
	public Appointments(int Apm_ID, Date Apm_Date, int Patient_ID, int Recept_ID, int Dentist_ID, int Status_ID) {
		this.Apm_ID = Apm_ID;
		this.Apm_Date = Apm_Date;
		this.Apm_Type = null;
		this.Patient_ID = Patient_ID;
		this.Recept_ID = Recept_ID;
		this.Dentist_ID = Dentist_ID;
		this.Status_ID = Status_ID;
	}
	
	public Date getApm_Date() {
		return Apm_Date;
	}
	
	public int getApm_ID() {
		return Apm_ID;
	}
	
	public String getApm_Type() {
		return Apm_Type;
	}
	
	public int getDentist_ID() {
		return Dentist_ID;
	}
	
	public int getPatient_ID() {
		return Patient_ID;
	}
	
	public int getRecept_ID() {
		return Recept_ID;
	}
	
	public int getStatus_ID() {
		return Status_ID;
	}
	
	public void setApm_Date(Date apm_Date) {
		Apm_Date = apm_Date;
	}
	
	public void setApm_ID(int apm_ID) {
		Apm_ID = apm_ID;
	}
	
	public boolean setApm_Type(String apm_Type) {
		if(Meth.var_valid(apm_Type,64)){
			Apm_Type = apm_Type;
			return true;
		}
		return false;
	}
	
	public void setDentist_ID(int dentist_ID) {
		Dentist_ID = dentist_ID;
	}
	
	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}
	
	public void setRecept_ID(int recept_ID) {
		Recept_ID = recept_ID;
	}
	
	public void setStatus_ID(int status_ID) {
		Status_ID = status_ID;
	}
}

/* CREATE table Appointments(

	    Apm_ID          INT             NOT NULL,

	    Apm_Date        DATETIME        NOT NULL,

	    Apm_Type        VARCHAR(64),

	    Patient_ID      INT             NOT NULL,

	    Recept_ID       INT             NOT NULL,

	    Dentist_ID      INT             NOT NULL,

	    Status_ID       INT             NOT NULL,

	    

	    PRIMARY KEY (Apm_ID),

	    FOREIGN KEY (Dentist_ID)

	        REFERENCES Dentists (D_ID),

	    FOREIGN KEY (Patient_ID)

	        REFERENCES Users (U_ID),

	    FOREIGN KEY (Recept_ID)

	        REFERENCES Users (U_ID),

	    FOREIGN KEY (Status_ID)

	        REFERENCES Status (Status_ID),

	    UNIQUE(Dentist_ID,Apm_Date),

	    UNIQUE(Patient_ID,Apm_Date)

	    );*/