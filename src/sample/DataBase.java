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
        String username = "root";
        String pass = "asd123123";
        Class.forName(driver);
        connection = DriverManager.getConnection(url,username,pass);

    }
    public String getData() throws SQLException{
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
    public void createTable() throws SQLException{
        try {
            PreparedStatement create = connection.prepareStatement(" CREATE TABLE");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<String> get() throws SQLException{
        try {
            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Status;");
            ResultSet Result =statement1.executeQuery();

            ArrayList<String> arrayList = new ArrayList<String>();

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


            }
            System.out.println("Done");
            return arrayList;






        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }






}
