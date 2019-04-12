package sample;
import data_types.Clinic_Contact_Numbers;
import data_types.Clinics;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

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


        PreparedStatement add = connection.prepareStatement("INSERT INTO Users () values ("+users.getU_ID()+",'"+users.getUserName()+"','"+users.getFName()+"','"+users.getLName()+"','"+users.getHashPassword()+"','"+users.getEMail()+"',CURRENT_TIMESTAMP,'"+users.getType_ID()+"',1)");
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
        	//if(Result.getString("Hashed_PW"))
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
    public ArrayList<Clinics> ClinicAdd(Connection connect, Scanner kb){
        boolean main_loop = true;
        boolean pass = true;
        Pattern p1 = Pattern.compile("[^0-9]");
        data_types.Clinics c = new Clinics();
        String temp = null;
        boolean hasContact;
        int contactCount = 0;
        LinkedList<Clinic_Contact_Numbers> contacts = new LinkedList<Clinic_Contact_Numbers>();

        while(main_loop){
            try {

                System.out.print("\nplease enter clinic  profile (including clinic name):");
                kb.nextLine();
                c.set_Profile(kb.nextLine());
                System.out.print("\nplease enter clinic services:");
                c.setServices(kb.nextLine());
                System.out.print("\nplease enter the clinic location:");
                c.setLocation(kb.nextLine());
                System.out.print("\nplease enter the clinic Web (optional, type \"null\" if clinic doesnt have):");
                temp =kb.nextLine();
                if(!temp.equals("null")){
                    c.setWebsite(temp);
                }
                System.out.print("\nplease enter the clinic official customer support E-mail:");
                c.setEMail(kb.next());
                c.setStatus_ID(0);
                System.out.print("\nList of All Clinic Admins, Please enter the C_ID of the desired Clinic admin to have control rights on the clinic:-\n\n");
                data_types.Users.toStringClinicAdminUsers(connect);
                c.setClinic_ManID(kb.nextInt());
                System.out.println("Does the clinic have any contact numbers? (y/n)");
                hasContact = Y_N(kb);
                Clinic_Contact_Numbers tempContact = new Clinic_Contact_Numbers();

                while(hasContact){
                    System.out.print("Please enter contact number:");
                    pass = true;
                    while(pass){
                        tempContact.setNumber(kb.next());
                        pass = p1.matcher(tempContact.getNumber()).find();
                        if(pass){
                            System.out.print("wrong input\nPlease enter contact number:");
                        }
                    }
                    System.out.print("Please enter contact type (mobile/landline/fax etc.):");
                    tempContact.setType(kb.next());
                    contactCount += 1;
                    tempContact.set_Order(contactCount);
                    contacts.add(new Clinic_Contact_Numbers(tempContact));
                    System.out.print("Want to add more contacts? (y/n)");
                    hasContact = Y_N(kb);
                }

                c.setRating(new BigDecimal(0));
                PreparedStatement ps1 = connect.prepareStatement("SELECT MAX(C_ID) From Clinics;");
                ResultSet rs1 = ps1.executeQuery();

                if(!rs1.next())
                    c.setC_ID(rs1.getInt("MAX(C_ID)") + 1);
                else
                    c.setC_ID(1);

                pass = c.addToDB(connect);

                for(int i=0; i<contactCount;i++){
                    contacts.get(i).setClinic_ID(c.getC_ID());
                    pass = pass & contacts.get(i).addToDB(connect);
                }

                //"INSERT INTO Users () values ("+users.getUID()+",'"+users.getUserName()+"','"+users.getFName()+"','"+users.getLname()+"','"+users.getHashPassword()+"','"+users.getEmail()+"',CURRENT_TIMESTAMP,'"+users.getTypeID()+"',1)"
                main_loop = false;
                while(!pass){
                    System.out.print("What do you want to do?\n<1> Change EMail\n<2> Start over\n<3> Exit Signup\n");
                    int x = kb.nextInt();
                    switch(x){
                        case 1:
                            System.out.print("\nplease enter your EMail:");
                            c.setEMail(kb.next());
                            break;
                        case 2:
                            main_loop = true;
                            pass = true;
                            break;
                        case 3:
                            main_loop = false;
                            pass = true;
                            break;
                    };


                }
            }catch(Exception e){
                System.out.println("Error ------"+e.getMessage());
                System.out.println("\ntry again? (y/n)");
                main_loop = Y_N(kb);
            }
        }
        return null;
    }
    public static boolean Y_N(Scanner kb){
        while(true){
            String k = kb.next();
            if(k.equals("n")){
                return false;
            }else if(k.equals("y")){
                return true;
            }else{
                System.out.println("Wrong Input.");
            }
        }
    }

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///// login.... enter the password and username in the method to check if the user exist and the enter password is correct... null will be returned if password or username are wrong.
    public Users U_Login(String username, String password) throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users WHERE UserName = '" + username + "';");
        ResultSet Result =statement1.executeQuery();
        Users u = new Users();
        if (!Result.next())
            throw new Exception("User doesnt exist");
        
        if(Result.getString("Hashed_PW").equals(password)){
        	System.out.println("Login Success");
        	u.setUID((Result.getInt("U_ID")));
        	u.setFName(Result.getString("FName"));
            u.setLname(Result.getString("LName"));
            u.setDate(Result.getString("Reg_Date"));
            u.setUserName(Result.getString("UserName"));
            u.setEmail(Result.getString("EMail"));
            u.setHashPassword(Result.getString("Hashed_PW"));

            u.setStatusID((Result.getInt("Status_ID")));
            u.setTypeID((Result.getInt("Type_ID")));



            //u = new Users(Result);

        }
        return u;
    }
    ///// signup... it checks if the username or email is used before or not... if they are unique... user is created... true is returned if the signuo is sucessful... if it failed, false will be returned.
    ///// note: a method to create an apropriate ID for a new user is needed before using this method.
    /*public boolean U_SignUp(Users u) throws Exception{
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

    }*/


}
