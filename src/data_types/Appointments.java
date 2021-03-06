package data_types;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Appointments {
	private int Apm_ID, 
	Patient_ID, 
	Recept_ID, 
	Dentist_ID, 
	Status_ID;
	private String Apm_Date;
	private String Apm_Type;
	private String UserType;

	private ComboBox<String> State;
	private ComboBox<String> Status;



	public Appointments(int Apm_ID, String Apm_Date, String Apm_Type, int Patient_ID, int Recept_ID, int Dentist_ID, int Status_ID,String userType) {
		if(Meth.var_valid(Apm_Type,64)){
			this.Apm_ID = Apm_ID;
			this.Apm_Date = Apm_Date;
			this.Apm_Type = Apm_Type;
			this.Patient_ID = Patient_ID;
			this.Recept_ID = Recept_ID;
			this.Dentist_ID = Dentist_ID;
			this.Status_ID = Status_ID;
			this.UserType=userType;
			ObservableList<String> options =
					FXCollections.observableArrayList(
							"Confirmed","Not Confirmed"
					);
			this.State = new ComboBox<String>(options);
			this.State.setPromptText(Apm_Type);
			//..
			ObservableList<String> options1;
			System.out.println(UserType);
			if (UserType.contains("3")) {
				 options1 =
						FXCollections.observableArrayList(
								"Confirmed","deleted"
						);
			}else{
				 options1 =
						FXCollections.observableArrayList(
								"deleted"
						);

			}

			this.Status = new ComboBox<String>(options1);
			if(Status_ID==1)
				this.Status.setPromptText("Confirmed");
			else if(Status_ID==2)
				this.Status.setPromptText("deleted");
			else
				this.Status.setPromptText("unknown");

		}else{
			System.out.println("Error... input invalid");
		}
	}
	
	public Appointments(int Apm_ID, String Apm_Date, int Patient_ID, int Recept_ID, int Dentist_ID, int Status_ID) {
		this.Apm_ID = Apm_ID;
		this.Apm_Date = Apm_Date;
		this.Apm_Type = null;
		this.Patient_ID = Patient_ID;
		this.Recept_ID = Recept_ID;
		this.Dentist_ID = Dentist_ID;
		this.Status_ID = Status_ID;
	}
	
	public String getApm_Date() {
		return Apm_Date;
	}
	public ComboBox<String> getState() {
		return State;
	}
	public ComboBox<String> getStatus() {
		return Status;
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
	
	public void setApm_Date(String apm_Date) {
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
	
    public static ArrayList<Appointments> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<Appointments> al = new ArrayList<Appointments>();
    	ResultSet r = connect.prepareStatement("SELECT * From Appointments;").executeQuery();
    	
    	while(r.next())
    		al.add(new Appointments(r.getInt("Apm_ID"), r.getString("Apm_Date"), r.getString("Apm_Type"), r.getInt("Patient_ID"), r.getInt("Recept_ID"), r.getInt("Dentist_ID"), r.getInt("Status_ID"),"2"));
    	return al;
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