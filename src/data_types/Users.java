package data_types;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		if(Meth.var_valid(UserName, 32) && Meth.var_valid(FName, 24) && Meth.var_valid(LName, 24) && Meth.var_valid(Hashed_PW, 64) && Meth.var_valid(EMail, 64)){
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
		else{
			System.out.println("Error... input invalid");
		}
	}
    
    public Users(ResultSet r) {
			try {
				this.U_ID = Integer.parseInt(r.getString("U_ID"));
				this.UserName = r.getString("UserName");
				this.FName = r.getString("FName");
				this.LName = r.getString("FLName");
				this.Hashed_PW = r.getString("Hashed_PW");
				this.EMail = r.getString("EMail");
				this.Reg_Date = r.getDate("Reg_Date");
				this.Type_ID = Integer.parseInt(r.getString("Type_ID"));
				this.Status_ID = Integer.parseInt(r.getString("Status_ID"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
    
    public boolean setEMail(String eMail) {
    	if(Meth.var_valid(eMail, 64)){
    		EMail = eMail;
    		return true;
    	}
    	return false;
	}
    
    public boolean setFName(String fName) {
    	if(Meth.var_valid(fName, 24)){
    		FName = fName;
    		return true;
    	}
    	return false;
	}
    
    public boolean setHashed_PW(String hashed_PW) {
    	if(Meth.var_valid(hashed_PW, 64)){
    		Hashed_PW = hashed_PW;
    		return true;
    	}
    	return false;
	}
    
    public boolean setLName(String lName) {
    	if(Meth.var_valid(lName, 24)){
    		LName = lName;
    		return true;
    	}
    	return false;
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
    
    public boolean setUserName(String userName) {
    	if(Meth.var_valid(userName, 32)){
    		UserName = userName;
    		return true;
    	}
    	return false;
	}
    
    public boolean addToDB(Connection connection){
    	PreparedStatement add;
		try {
			add = connection.prepareStatement("INSERT INTO Users () values ("+U_ID+",'"+UserName+"','"+FName+"','"+LName+"','"+Hashed_PW+"','"+EMail+"',CURRENT_TIMESTAMP,'"+Type_ID+"',1)");
			add.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
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
