package data_types;
import java.math.BigDecimal;
import data_types.Meth;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Advertisements{
	private int Ad_ID, 
	sysAdmin_ID;
	private Date Start_Date, 
	End_Date;
	private String Content;
	private BigDecimal Fees;
	
	public Advertisements(int Ad_ID, Date Start_Date, Date End_Date, String Content, BigDecimal Fees) {
		this.Ad_ID = Ad_ID;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
		this.Content = Content;
		this.Fees = Fees;
	}
	
	public int getAd_ID() {
		return Ad_ID;
	}
	
	public String getContent() {
		return Content;
	}
	
	public Date getEnd_Date() {
		return End_Date;
	}
	
	public BigDecimal getFees() {
		return Fees;
	}
	
	public Date getStart_Date() {
		return Start_Date;
	}
	
	public int getSysAdmin_ID() {
		return sysAdmin_ID;
	}
	
	public void setAd_ID(int ad_ID) {
		Ad_ID = ad_ID;
	}
	
	public void setContent(String content) {
		Content = content;
	}
	
	public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}
	
	public void setFees(BigDecimal fees) {
		Fees = fees;
	}
	
	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}
	
	public void setSysAdmin_ID(int sysAdmin_ID) {
		this.sysAdmin_ID = sysAdmin_ID;
	}
	
    public static ArrayList<Advertisements> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<Advertisements> al = new ArrayList<Advertisements>();
    	ResultSet r = connect.prepareStatement("SELECT * From Advertisements;").executeQuery();
    	
    	while(r.next())
    		al.add(new Advertisements(r.getInt ("Ad_ID"), r.getDate ("Start_Date"), r.getDate ("End_Date"), r.getString ("Content"), r.getBigDecimal ("Fees")));
    	return al;
    }
	
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


