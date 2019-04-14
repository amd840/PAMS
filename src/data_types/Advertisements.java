package data_types;
import java.math.BigDecimal;
import data_types.Meth;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Advertisements{
	private int Ad_ID;
	private String Start_Date,
	End_Date;
	private String Content;
	private double Fees;
	private int SysAdmin_ID;
	
	public Advertisements(int Ad_ID, String Start_Date, String End_Date, String Content, double Fees,int SysAdmin_ID) {
		this.Ad_ID = Ad_ID;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
		this.Content = Content;
		this.Fees = Fees;
		this.SysAdmin_ID=SysAdmin_ID;
	}
	
	public int getAd_ID() {
		return Ad_ID;
	}
	
	public String getContent() {
		return Content;
	}
	
	public String getEnd_Date() {
		return End_Date;
	}
	
	public double getFees() {
		return Fees;
	}
	
	public String getStart_Date() {
		return Start_Date;
	}
	
	public int getSysAdmin_ID() {
		return SysAdmin_ID;
	}
	
	public void setAd_ID(int ad_ID) {
		Ad_ID = ad_ID;
	}
	
	public void setContent(String content) {
		Content = content;
	}
	
	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}
	
	public void setFees(double fees) {
		Fees = fees;
	}
	
	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}
	
	public void setSysAdmin_ID(int sysAdmin_ID) {
		this.SysAdmin_ID = sysAdmin_ID;
	}
	
   /* public static ArrayList<Advertisements> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<Advertisements> al = new ArrayList<Advertisements>();
    	ResultSet r = connect.prepareStatement("SELECT * From Advertisements;").executeQuery();
    	
    	while(r.next())
    		al.add(new Advertisements(r.getInt ("Ad_ID"), r.getString ("Start_Date"), r.getString ("End_Date"), r.getString ("Content"), r.getDouble ("Fees")));
    	return al;
    }*/
	
}

/* CREATE table Advertisements(

	    Ad_ID           INT             NOT NULL,

	    Start_Date      DATETIME        NOT NULL,

	    End_Date        DATETIME        NOT NULL,

	    Content         TEXT            NOT NULL,

	    Fees            DECIMAL(11,2)   NOT NULL,

	    SysAdmin_ID     INT             NOT NULL,

	    

	    PRIMARY KEY (Ad_ID),

	    FOREIGN KEY (SysAdmin_ID)

	        REFERENCES Users (U_ID)

	    );*/


