package sample;
import data_types.*;
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
    public Users getClinicAdmin(String ID) throws Exception{
        //statement = connection.createStatement();
        String datainfo = ("SELECT * FROM Users where U_ID = "+ID+"");
        PreparedStatement statement1 = connection.prepareStatement(datainfo);
        ResultSet Result = statement1.executeQuery();

       // ResultSet Result =statement.executeQuery(datainfo);
        String Result2 = "";

        //if (!Result.next()) {}

        Result.next();
        Users user = new Users(Result.getString("UserName"),Result.getString("Hashed_PW"),Result.getString("EMail"),Result.getString("FName"),Result.getString("LName"),Result.getString("Reg_Date"),Result.getInt("U_ID"),Result.getInt("Type_ID"),Result.getInt("Status_ID"));

        String breakstr;
        return user;
    }
    public void addUser(Users users)throws Exception{


        PreparedStatement add = connection.prepareStatement("INSERT INTO Users () values ("+users.getU_ID()+",'"+users.getUserName()+"','"+users.getFName()+"','"+users.getLName()+"','"+users.getHashPassword()+"','"+users.getEMail()+"',CURRENT_TIMESTAMP,'"+users.getType_ID()+"',7)");
        add.executeUpdate();


    }
    public void addAppointment(Appointments appo)throws Exception{


        PreparedStatement add = connection.prepareStatement("INSERT INTO Appointments () values ("+appo.getApm_ID()+",CURRENT_TIMESTAMP,'"+appo.getApm_Type()+"',"+appo.getPatient_ID()+","+appo.getRecept_ID()+","+appo.getDentist_ID()+",8)");
        add.executeUpdate();


    }
    public void addAd(Advertisements ad)throws Exception{


        PreparedStatement add = connection.prepareStatement("INSERT INTO `Advertisements` (`Ad_ID`, `Start_Date`, `End_Date`, `Content`, `Fees`, `SysAdmin_ID`) VALUES ('"+ad.getAd_ID()+"', '"+ad.getStart_Date()+"', '"+ad.getEnd_Date()+"', '"+ad.getContent()+"', '"+ad.getFees()+"', '"+ad.getSysAdmin_ID()+"');");
        add.executeUpdate();
        //INSERT INTO `Advertisements` (`Ad_ID`, `Start_Date`, `End_Date`, `Content`, `Fees`, `SysAdmin_ID`) VALUES ('222', '2019-04-15', '2019-04-03', 'text', '1.5', '1');


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

    public ArrayList<Advertisements> getAdvertisment(Users CAdmin) throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Advertisements WHERE SysAdmin_ID ="+CAdmin.getU_ID()+";");
        ResultSet Result = statement1.executeQuery();

        ArrayList<Advertisements> arrayList = new ArrayList<Advertisements>();

        //if (!Result.next())
         //   throw new Exception("There is no Advertisements");
        while(Result.next()){

            //Users users = new Users(Result.getString("UserName"),Result.getString("Hashed_PW"),Result.getString("EMail"),Result.getString("FName"),Result.getString("LName"),Result.getString("Reg_Date"),id,1,0);
            Advertisements advert = new Advertisements(Integer.parseInt(Result.getString("Ad_ID")),Result.getString("Start_Date"),Result.getString("End_Date"),Result.getString("Content"),Result.getDouble("Fees"),Result.getInt("SysAdmin_ID"));
            arrayList.add(advert);

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
    public String getUserType(Users user)throws Exception{
        PreparedStatement statementUserType = connection.prepareStatement("SELECT Type_ID FROM Users WHERE U_ID ="+user.getU_ID()+";");
        ResultSet usertype = statementUserType.executeQuery();
        usertype.next();

        return usertype.getString("Type_ID");

    }
    public String getUserType(String userid)throws Exception{
        PreparedStatement statementUserType = connection.prepareStatement("SELECT Type_ID FROM Users WHERE U_ID ="+userid+";");
        ResultSet usertype = statementUserType.executeQuery();
        usertype.next();

        return usertype.getString("Type_ID");

    }


    public ArrayList<Appointments> getAppointments(Users RA) throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Appointments WHERE Recept_ID ="+RA.getU_ID()+";");
        ResultSet Result = statement1.executeQuery();

        PreparedStatement statementUserType = connection.prepareStatement("SELECT Type_ID FROM Users WHERE U_ID ="+RA.getU_ID()+";");
        ResultSet usertype = statementUserType.executeQuery();
        usertype.next();

        ArrayList<Appointments> arrayList = new ArrayList<Appointments>();

        //if (!Result.next())
        //   throw new Exception("There is no Advertisements");
        while(Result.next()){

            Appointments appointment = new Appointments(Result.getInt("Apm_ID"),Result.getString("Apm_Date"),Result.getString("Apm_Type"),Result.getInt("Patient_ID"),Result.getInt("Recept_ID"),Result.getInt("Dentist_ID"),Result.getInt("Status_ID"),usertype.getString("Type_ID"));
            arrayList.add(appointment);

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
    public ArrayList<Appointments> getAppointmentsForP(String Pa) throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Appointments WHERE Patient_ID ="+Pa+";");
        ResultSet Result = statement1.executeQuery();

        PreparedStatement statementUserType = connection.prepareStatement("SELECT Type_ID FROM Users WHERE U_ID ="+Pa+";");
        ResultSet usertype = statementUserType.executeQuery();
        usertype.next();

        ArrayList<Appointments> arrayList = new ArrayList<Appointments>();

        //if (!Result.next())
        //   throw new Exception("There is no Advertisements");
        while(Result.next()){

            Appointments appointment = new Appointments(Result.getInt("Apm_ID"),Result.getString("Apm_Date"),Result.getString("Apm_Type"),Result.getInt("Patient_ID"),Result.getInt("Recept_ID"),Result.getInt("Dentist_ID"),Result.getInt("Status_ID"),usertype.getString("Type_ID"));
            arrayList.add(appointment);

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
    public void updateAppointment(String APM,String value)throws SQLException{
        PreparedStatement add = null;
        if (value=="deleted")
             add = connection.prepareStatement("UPDATE `Appointments` SET Status_ID = '"+2+"' WHERE Apm_ID = "+APM);
        else if (value=="deleted")
             add = connection.prepareStatement("UPDATE `Appointments` SET Status_ID = '"+1+"' WHERE Apm_ID = "+APM);
        try {
            add.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

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


    /*public ArrayList<Clinics> ClinicAdd(Connection connect, Scanner kb){
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
    }*/
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
    public ArrayList<Clinics> getClinics()throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Clinics ");
        ResultSet Result =statement1.executeQuery();
        ArrayList<Clinics> clinicsArrayList = new ArrayList<>();

        while(Result.next()){
            Clinics clinic = new Clinics();

            clinic.setC_ID(Result.getInt("C_ID"));
            clinic.setEMail(Result.getString("EMail"));
            clinic.set_Profile(Result.getString("Profile"));
            clinic.setLocation(Result.getString("Location"));
            clinic.setRating(Result.getDouble("Rating"));
            clinic.setServices(Result.getString("Services"));
            clinic.setClinic_ManID(Result.getInt("Clinic_ManID"));
            clinic.setWebsite(Result.getString("Website"));
            clinic.setStatus_ID(Result.getInt("Status_ID"));
            clinicsArrayList.add(clinic);
        }
        return clinicsArrayList;
    }
    public ArrayList<Dentists> getDentists()throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Dentists ");
        ResultSet Result =statement1.executeQuery();
        ArrayList<Dentists> dentistsArrayList = new ArrayList<>();

        while(Result.next()){
            Dentists dentists = new Dentists();

            dentists.setD_ID(Result.getInt("D_ID"));
            dentists.setEMail(Result.getString("EMail"));
            dentists.set_Profile(Result.getString("_Profile"));
            dentists.setYears_Active(Result.getInt("Years_Active"));
            dentists.setRating(Result.getDouble("Rating"));
            dentists.setFName(Result.getString("FName"));
            dentists.setLName(Result.getString("LName"));
            dentists.setWebsite(Result.getString("Website"));
            dentists.setClinic_Office(Result.getString("Clinic_Office"));
            dentists.setClinic_ID(Result.getInt("Clinic_ID"));
            dentists.setClinic_Num(Result.getInt("Clinic_Num"));
            dentists.setSpecialty_ID(Result.getInt("Specialty_ID"));
            dentists.setStatus_ID(Result.getInt("Status_ID"));

            dentistsArrayList.add(dentists);
        }
        return dentistsArrayList;
    }
    public ArrayList<Dentists> getDentists(Users rec)throws Exception{
        try {
            PreparedStatement clinicID = connection.prepareStatement("SELECT * FROM Clinics where Clinic_ManID = " + rec.getU_ID());
            ResultSet Resultcid = clinicID.executeQuery();
            Resultcid.next();
            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Dentists where " + Resultcid.getString("C_ID"));
            ResultSet Result = statement1.executeQuery();
            ArrayList<Dentists> dentistsArrayList = new ArrayList<>();
            //Result.next();

            while (Result.next()) {
                Dentists dentists = new Dentists();

                dentists.setD_ID(Result.getInt("D_ID"));
                dentists.setEMail(Result.getString("EMail"));
                dentists.set_Profile(Result.getString("_Profile"));
                dentists.setYears_Active(Result.getInt("Years_Active"));
                dentists.setRating(Result.getDouble("Rating"));
                dentists.setFName(Result.getString("FName"));
                dentists.setLName(Result.getString("LName"));
                dentists.setWebsite(Result.getString("Website"));
                dentists.setClinic_Office(Result.getString("Clinic_Office"));
                dentists.setClinic_ID(Result.getInt("Clinic_ID"));
                dentists.setClinic_Num(Result.getInt("Clinic_Num"));
                dentists.setSpecialty_ID(Result.getInt("Specialty_ID"));
                dentists.setStatus_ID(Result.getInt("Status_ID"));

                dentistsArrayList.add(dentists);
            }
            return dentistsArrayList;
        }catch (Exception e){
            return  new ArrayList<Dentists>();

        }
    }
    public Clinics getClinic(Users admin)throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Clinics where Clinic_ManID = "+admin.getU_ID());
        ResultSet Result =statement1.executeQuery();
        //ArrayList<Clinics> clinicsArrayList = new ArrayList<>();

        //while(Result.next()){
            Clinics clinic = new Clinics();

            clinic.setC_ID(Result.getInt("C_ID"));
            clinic.setEMail(Result.getString("EMail"));
            clinic.set_Profile(Result.getString("Profile"));
            clinic.setLocation(Result.getString("Location"));
            clinic.setRating(Result.getDouble("Rating"));
            clinic.setServices(Result.getString("Services"));
            clinic.setClinic_ManID(Result.getInt("Clinic_ManID"));
            clinic.setWebsite(Result.getString("Website"));
            clinic.setStatus_ID(Result.getInt("Status_ID"));
            return clinic;
            //clinicsArrayList.add(clinic);
        //}
       // return clinicsArrayList;
    }
    public Clinics getClinic(String ID)throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Clinics where Clinic_ManID = "+ID);
        ResultSet Result =statement1.executeQuery();
        //ArrayList<Clinics> clinicsArrayList = new ArrayList<>();

        //while(Result.next()){
        Clinics clinic = new Clinics();
        if(!Result.next())
            throw new Exception("No Clinic is there");
        clinic.setC_ID(Result.getInt("C_ID"));
        clinic.setEMail(Result.getString("EMail"));
        clinic.set_Profile(Result.getString("Profile"));
        clinic.setLocation(Result.getString("Location"));
        clinic.setRating(Result.getDouble("Rating"));
        clinic.setServices(Result.getString("Services"));
        clinic.setClinic_ManID(Result.getInt("Clinic_ManID"));
        clinic.setWebsite(Result.getString("Website"));
        clinic.setStatus_ID(Result.getInt("Status_ID"));
        return clinic;
        //clinicsArrayList.add(clinic);
        //}
        // return clinicsArrayList;
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
    public void ClinicUpdate(Clinics clinic) throws Exception{

        PreparedStatement add = connection.prepareStatement("UPDATE `Clinics` SET `C_ID`="+clinic.getC_ID()+",`Profile`='"+clinic.getProfile()+"',`Services`='"+clinic.getServices()+"',`Location`='"+clinic.getLocation()+"',`Website`='"+clinic.getWebsite()+"',`EMail`='"+clinic.getEMail()+"',`Rating`='"+clinic.getRating()+"',`Clinic_ManID`="+clinic.getClinic_ManID()+",`Status_ID`="+clinic.getStatus_ID()+" WHERE C_ID = "+clinic.getC_ID());
        add.executeUpdate();

    }
    public void clinicUpdate(Clinics clinic,String values,String value) throws Exception{

        PreparedStatement add = connection.prepareStatement("UPDATE `Clinics` SET "+values+" = '"+value+"' WHERE C_ID = "+clinic.getC_ID());
        add.executeUpdate();

    }
    public void clinicUpdate(Clinics clinic,String values,int value) throws Exception{

        PreparedStatement add = connection.prepareStatement("UPDATE `Clinics` SET "+values+" = "+value+" WHERE C_ID = "+clinic.getC_ID());
        add.executeUpdate();

    }
    public void userUpdate(Users user,String values,int value) throws Exception{

        PreparedStatement add = connection.prepareStatement("UPDATE `Users` SET "+values+" = "+value+" WHERE U_ID = "+user.getU_ID());
        add.executeUpdate();

    }

    public void UpdateWholeCA(Users user) throws Exception{

        PreparedStatement add = connection.prepareStatement("UPDATE `Users` SET `U_ID`="+user.getU_ID()+",`UserName`='"+user.getUserName()+"',`FName`='"+user.getFName()+"',`LName`='"+user.getLName()+"',`HashPassword`='"+user.getHashPassword()+"',`EMail`='"+user.getEMail()+"',`Reg_Date`='CURRENT_TIMESTAMP',`Type_ID`= 2,`Status_ID`="+user.getStatus_ID()+" WHERE C_ID = "+user.getU_ID());
        add.executeUpdate();

    }
    public void UpdateWholeRA(Users user) throws Exception{

        PreparedStatement add = connection.prepareStatement("UPDATE `Users` SET `U_ID`="+user.getU_ID()+",`UserName`='"+user.getUserName()+"',`FName`='"+user.getFName()+"',`LName`='"+user.getLName()+"',`HashPassword`='"+user.getHashPassword()+"',`EMail`='"+user.getEMail()+"',`Reg_Date`='CURRENT_TIMESTAMP',`Type_ID`= 3,`Status_ID`="+user.getStatus_ID()+" WHERE C_ID = "+user.getU_ID());
        add.executeUpdate();

    }
    public void userUpdate(Users user,String values,String value) throws Exception{

        PreparedStatement add = connection.prepareStatement("UPDATE `Users` SET "+values+" = '"+value+"' WHERE U_ID = "+user.getU_ID());
        add.executeUpdate();

    }
    public void addClinic(Clinics clinic) throws Exception{

        PreparedStatement add = connection.prepareStatement("insert into `Clinics`(`C_ID`, `Profile`, `Services`, `Location`, `Website`, `EMail`, `Rating`, `Clinic_ManID`, `Status_ID`) VALUES ("+clinic.getC_ID()+",'"+clinic.getProfile()+"','"+clinic.getServices()+"','"+clinic.getLocation()+"','"+clinic.getWebsite()+"','"+clinic.getEMail()+"','"+clinic.getRating()+"', "+clinic.getClinic_ManID()+" ,"+clinic.getStatus_ID()+")");
        add.executeUpdate();

    }
    public ArrayList<Users> getCAdmins() throws Exception{
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users where Type_ID = 2 ;");
        ResultSet Result = statement1.executeQuery();

        ArrayList<Users> arrayList = new ArrayList<Users>();

        //if (!Result.next())
            //throw new Exception("There is no Users");
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
            Users users = new Users(Result.getString("UserName"),Result.getString("Hashed_PW"),Result.getString("EMail"),Result.getString("FName"),Result.getString("LName"),Result.getString("Reg_Date"),id,2,Result.getInt("Status_ID"));

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
        public ArrayList<Users> getCRec() throws Exception{
            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM Users where Type_ID = 3 ;");
            ResultSet Result = statement1.executeQuery();

            ArrayList<Users> arrayList = new ArrayList<Users>();

            //if (!Result.next())
            //throw new Exception("There is no Users");
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
                Users users = new Users(Result.getString("UserName"),Result.getString("Hashed_PW"),Result.getString("EMail"),Result.getString("FName"),Result.getString("LName"),Result.getString("Reg_Date"),id,3,Result.getInt("Status_ID"));

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
