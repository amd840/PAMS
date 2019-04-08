package data_types;

public class Dentists {

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