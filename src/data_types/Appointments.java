package data_types;

public class Appointments {

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