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

        String user = "root";
        String user1 = "amd840";


        String user4 = "sql12285138";

        String pass = "asd123123";
        String pass4 = "wcjfeGj8QN";

        Class.forName(driver);
        try {

            //try url4, user4, pass
            //try url3, user, password

            connection = DriverManager.getConnection(url4, user4, pass4);
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
    public ArrayList<String> getUser() throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users;");
        ResultSet Result = statement1.executeQuery();

        ArrayList<String> arrayList = new ArrayList<String>();

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

            arrayList.add(Result.getString("U_ID"));

            arrayList.add(Result.getString("UserName"));
            arrayList.add(Result.getString("FName + LName"));

            arrayList.add(Result.getString("Hashed_PW"));
            arrayList.add(Result.getString("EMail"));
            arrayList.add(Result.getString("Reg_Date"));
            arrayList.add(Result.getString("Type_ID"));



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






}
