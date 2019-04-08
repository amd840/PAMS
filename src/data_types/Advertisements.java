package data_types;
import java.math.BigDecimal;
import data_types.Meth;
import java.math.RoundingMode;
import java.sql.Date;

public class Advertisements{
	private int Ad_ID, 
	sysAdmin_ID;
	private Date Start_Date, 
	End_Date;
	private String Content;
	private double Fees;
	
	public Advertisements(int Ad_ID, Date Start_Date, Date End_Date, String Content, double Fees) {
		this.Ad_ID = Ad_ID;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
		this.Content = Content;
		this.Fees = Meth.round(Fees,2);
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
	
	public double getFees() {
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
	
	public void setFees(double fees) {
		Fees = Meth.round(fees,2);
	}
	
	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}
	
	public void setSysAdmin_ID(int sysAdmin_ID) {
		this.sysAdmin_ID = sysAdmin_ID;
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


