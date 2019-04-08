package data_types;

public class Clinics {

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