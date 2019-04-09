package sample;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    Connection  connection;
    Statement statement;

    // Connect to The DataBase
    DataBase() throws Exception {


        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ICS_324_P";
        String url2 = "jdbc:mysql://localhost:8080/PAMS?zeroDataTimeBehavior=convertToNull";
        String url3 = "jdbc:mysql://pams.cknp9z0b9nmv.us-east-2.rds.amazonaws.com:3306/pams";
        String url4 = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12285138";
        String url5 = "jdbc:mysql://db4free.net:3306/ics324";
                                    

        String user = "root";
        String user1 = "amd840";


        String user4 = "sql12285138";

        String pass = "asd123123";
        String pass4 = "wcjfeGj8QN";

        Class.forName(driver);
        try {

            //try url4, user4, pass
            //try url3, user, password

            connection = DriverManager.getConnection(url5, user1, pass);
        }catch(Exception e){
            System.out.println("Error ------"+e.getMessage());
        }
    }
    public String getData() throws Exception{
        statement = connection.createStatement();
        String datainfo = ("SELECT * FROM Status;");

        ResultSet Result =statement.executeQuery(datainfo);
        String Result2 = "";

        if (!Result.next()) {
            String Name = Result.getString("Status_ID");
            String GPA = Result.getString("Status_Name");
            String Major = Result.getString("Status_type");
            Result2 = Name+GPA+Major;
        }

        return Result2;
    }
    public void addUser(Users users)throws Exception{


        PreparedStatement add = connection.prepareStatement("INSERT INTO Users () values ("+users.getUID()+",'"+users.getUserName()+"','"+users.getFName()+"','"+users.getLname()+"','"+users.getHashPassword()+"','"+users.getEmail()+"',CURRENT_TIMESTAMP,'"+users.getTypeID()+"',1)");
        add.executeUpdate();


    }

    public void createTable() throws Exception{
        try {
            PreparedStatement create = connection.prepareStatement(" CREATE TABLE");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public ArrayList<Users> getUser() throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users;");
        ResultSet Result = statement1.executeQuery();

        ArrayList<Users> arrayList = new ArrayList<Users>();

        if (!Result.next())
            throw new Exception("There is no Users");
        while(Result.next()){
            System.out.println(Result.getString("U_ID"));
            System.out.println(" ");

            System.out.println(Result.getString("UserName"));
            System.out.println(" ");


            System.out.println(Result.getString("FName"));
            System.out.println(" ");

            System.out.println(Result.getString("LName"));
            System.out.println(" ");
            int id = Integer.valueOf(Result.getString("U_ID"));
            Users users = new Users(Result.getString("UserName"),Result.getString("Hashed_PW"),Result.getString("EMail"),Result.getString("FName"),Result.getString("LName"),Result.getString("Reg_Date"),id,1,0);

            arrayList.add(users);

            /*
            arrayList.add(Result.getString("U_ID"));

            arrayList.add(Result.getString("UserName"));
            arrayList.add(Result.getString("FName + LName"));

            arrayList.add(Result.getString("Hashed_PW"));
            arrayList.add(Result.getString("EMail"));
            arrayList.add(Result.getString("Reg_Date"));
            arrayList.add(Result.getString("Type_ID"));
            */


        }
        System.out.println("Done");
        return arrayList;




    }

    public ArrayList<String> getStatus() throws Exception{
            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Status;");
            ResultSet Result =statement1.executeQuery();

            ArrayList<String> arrayList = new ArrayList<String>();

            if (!Result.next())
                throw new Exception("There is no input");
            while(Result.next()){
                System.out.println(Result.getString("Status_ID"));
                System.out.println(" ");

                System.out.println(Result.getString("Status_Name"));
                System.out.println(" ");


                System.out.println(Result.getString("Status_type"));
                System.out.println(" ");

                System.out.println(Result.getString("Description"));
                System.out.println(" ");

                arrayList.add(Result.getString("Status_ID"));

                arrayList.add(Result.getString("Status_Name"));
                arrayList.add(Result.getString("Status_type"));


            }
            System.out.println("Done");
            return arrayList;

    }

    ////////////////////////////////////////////////////////
    
    public ArrayList<String> Login(Users user,String username, String password) throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users WHERE UserName = '" + username + "';");
        ResultSet Result =statement1.executeQuery();

        ArrayList<String> arrayList = new ArrayList<String>();

        if (!Result.next())
            throw new Exception("User doesnt exist");
        while(Result.next()){
        	if(Result.getString("Hashed_PW").
            System.out.println(Result.getString("Status_ID"));
            System.out.println(" ");

            System.out.println(Result.getString("Status_Name"));
            System.out.println(" ");


            System.out.println(Result.getString("Status_type"));
            System.out.println(" ");

            System.out.println(Result.getString("Description"));
            System.out.println(" ");

            arrayList.add(Result.getString("Status_ID"));

            arrayList.add(Result.getString("Status_Name"));
            arrayList.add(Result.getString("Status_type"));
        }
        System.out.println("Done");
        return arrayList;

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///// login.... enter the password and username in the method to check if the user exist and the enter password is correct... null will be returned if password or username are wrong.
    public Users U_Login(String username, String password) throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users WHERE UserName = '" + username + "';");
        ResultSet Result =statement1.executeQuery();
        Users u = null;
        if (!Result.next())
            throw new Exception("User doesnt exist");
        
        if(Result.getString("Hashed_PW").equals(password)){
        	System.out.println("Login Success");
        	u = new Users(Result);
        }
        return u;
    }
    ///// signup... it checks if the username or email is used before or not... if they are unique... user is created... true is returned if the signuo is sucessful... if it failed, false will be returned.
    ///// note: a method to create an apropriate ID for a new user is needed before using this method.
    public boolean U_SignUp(Users u) throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users WHERE UserName = '" + u.getUserName() + "';");
        PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM Users WHERE EMail = '" + u.getEMail() + "';");
        ResultSet Result1 =statement1.executeQuery();
        ResultSet Result2 =statement2.executeQuery();
        if (!Result1.next()){
        	if(!Result2.next()){
        		u.addToDB(connection);
        	}else{
            	throw new Exception("Email already used");
            	return false;
        	}
        }else{
        	throw new Exception("user already exist");
        	return false;
        }
    }
    
    public boolean addNewClinic(Clinics c,ArrayList<Clinic_Contact_Numbers> ccn) throws Exception{

    }


}
