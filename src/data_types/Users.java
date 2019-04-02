package data_types;
import java.sql.Date;

public class Users {
    private int U_ID;			//INT             NOT NULL,
    private String UserName;        //VARCHAR(32)     NOT NULL,
    private String FName;           //VARCHAR(24)     NOT NULL,
    private String LName;           //VARCHAR(24)     NOT NULL,
    private String Hashed_PW;       //CHAR            NOT NULL,
    private String EMail;           //VARCHAR(64)     NOT NULL,
    private Date Reg_Date;        //DATETIME        NOT NULL,
    private int Type_ID;         //INT             NOT NULL,
    private int Status_ID;       //INT             NOT NULL,
    
    public Users(int U_ID, String UserName, String FName, String LName, String Hashed_PW, String EMail, Date Reg_Date, int Type_ID, int Status_ID) {
		this.U_ID = U_ID;
		this.UserName = UserName;
		this.FName = FName;
		this.LName = LName;
		this.Hashed_PW = Hashed_PW;
		this.EMail = EMail;
		this.Reg_Date = Reg_Date;
		this.Type_ID = Type_ID;
		this.Status_ID = Status_ID;
	}
    
    public String getEMail() {
		return EMail;
	}
    
    public String getFName() {
		return FName;
	}
    
    public String getHashed_PW() {
		return Hashed_PW;
	}
    
    public String getLName() {
		return LName;
	}
    
    public Date getReg_Date() {
		return Reg_Date;
	}
    
    public int getStatus_ID() {
		return Status_ID;
	}
    
    public int getType_ID() {
		return Type_ID;
	}
    
    public int getU_ID() {
		return U_ID;
	}
    
    public String getUserName() {
		return UserName;
	}
    
    public void setEMail(String eMail) {
		EMail = eMail;
	}
    
    public void setFName(String fName) {
		FName = fName;
	}
    
    public void setHashed_PW(String hashed_PW) {
		Hashed_PW = hashed_PW;
	}
    
    public void setLName(String lName) {
		LName = lName;
	}
    
    public void setReg_Date(Date reg_Date) {
		Reg_Date = reg_Date;
	}
    
    public void setStatus_ID(int status_ID) {
		Status_ID = status_ID;
	}
    
    public void setType_ID(int type_ID) {
		Type_ID = type_ID;
	}
    
    public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
    
    public void setUserName(String userName) {
		UserName = userName;
	}
}


/* 
CREATE table Users(

    U_ID            INT             NOT NULL,

    UserName        VARCHAR(32)     NOT NULL,

    FName           VARCHAR(24)     NOT NULL,

    LName           VARCHAR(24)     NOT NULL,

    Hashed_PW       VARCHAR(64)     NOT NULL,

    EMail           VARCHAR(64)     NOT NULL,

    Reg_Date        DATETIME        NOT NULL,

    Type_ID         INT             NOT NULL,

    Status_ID       INT             NOT NULL,

    

    PRIMARY KEY (U_ID),

    FOREIGN KEY (Type_ID)
 
        REFERENCES User_Types (Type_ID),

    FOREIGN KEY (Status_ID)

        REFERENCES Status (Status_ID),

    UNIQUE (UserName),

    UNIQUE (EMail)

    );*/
