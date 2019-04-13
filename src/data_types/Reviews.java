package data_types;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Reviews {
    private int Apm_ID,
    Dent_Rating,
    Clinic_Rating;
    private Date Rev_Date;
    private String Review;
    
    public Reviews(int Apm_ID, Date Rev_Date, int Dent_Rating, int Clinic_Rating, String Review) {
        this.Apm_ID = Apm_ID;
        this.Rev_Date = Rev_Date;
        this.Dent_Rating = Dent_Rating;
        this.Clinic_Rating = Clinic_Rating;
        this.Review = Review;
	}
    
    public Reviews(int Apm_ID, Date Rev_Date, int Dent_Rating, int Clinic_Rating) {
        this.Apm_ID = Apm_ID;
        this.Rev_Date = Rev_Date;
        this.Dent_Rating = Dent_Rating;
        this.Clinic_Rating = Clinic_Rating;
        this.Review = null;
	}
    
    public int getApm_ID() {
		return Apm_ID;
	}
    
    public int getClinic_Rating() {
		return Clinic_Rating;
	}
    
    public int getDent_Rating() {
		return Dent_Rating;
	}
    
    public Date getRev_Date() {
		return Rev_Date;
	}
    
    public String getReview() {
		return Review;
	}
    
    public void setApm_ID(int apm_ID) {
		Apm_ID = apm_ID;
	}
    
    public void setClinic_Rating(int clinic_Rating) {
		Clinic_Rating = clinic_Rating;
	}
    
    public void setDent_Rating(int dent_Rating) {
		Dent_Rating = dent_Rating;
	}
    
    public void setRev_Date(Date rev_Date) {
		Rev_Date = rev_Date;
	}
    
    public void setReview(String review) {
		Review = review;
	}
    
    public static ArrayList<Reviews> getAllArrayList(Connection connect) throws Exception{
    	ArrayList<Reviews> al = new ArrayList<Reviews>();
    	ResultSet r = connect.prepareStatement("SELECT * From Reviews;").executeQuery();
    	
    	while(r.next())
    	al.add(new Reviews(r.getInt("Apm_ID"), r.getDate("Rev_Date"), r.getInt("Dent_Rating"), r.getInt("Clinic_Rating"), r.getString("Review")));
    	return al;
    }
}


/* CREATE table Reviews(

    Apm_ID          INT             NOT NULL,

    Rev_Date        DATETIME        NOT NULL,

    Dent_Rating     INT             NOT NULL,

    Clinic_Rating   INT             NOT NULL,

    Review          TEXT,

    

    PRIMARY KEY (Apm_ID)

    );*/