package data_types;
import java.sql.Date;

public class News {
    private int News_ID,
    SysAdmin_ID;
    private Date Pub_Date,
    End_Date;
    private String Content;

    public News(int News_ID, Date Pub_Date, Date End_Date, String Content, int SysAdmin_ID) {
        this.News_ID = News_ID;
        this.Pub_Date = Pub_Date;
        this.End_Date = End_Date;
        this.Content = Content;
        this.SysAdmin_ID = SysAdmin_ID;
	}
    
    public String getContent() {
		return Content;
	}
    
    public Date getEnd_Date() {
		return End_Date;
	}
    
    public int getNews_ID() {
		return News_ID;
	}
    
    public Date getPub_Date() {
		return Pub_Date;
	}
    
    public int getSysAdmin_ID() {
		return SysAdmin_ID;
	}
    
    public void setContent(String content) {
		Content = content;
	}
    
    public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}
    
    public void setNews_ID(int news_ID) {
		News_ID = news_ID;
	}
    
    public void setPub_Date(Date pub_Date) {
		Pub_Date = pub_Date;
	}
    
    public void setSysAdmin_ID(int sysAdmin_ID) {
		SysAdmin_ID = sysAdmin_ID;
	}
}


/* CREATE table News(

    News_ID         INT             NOT NULL,

    Pub_Date        DATETIME        NOT NULL,

    End_Date        DATETIME        NOT NULL,

    Content         TEXT            NOT NULL,

    SysAdmin_ID     INT             NOT NULL,

    

    PRIMARY KEY (News_ID),

    FOREIGN KEY (SysAdmin_ID)

        REFERENCES Users (U_ID)

    );*/