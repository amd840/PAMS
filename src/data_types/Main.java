package data_types;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

	
	public static void main(String[] arg){
		Connection connect = null;
		Statement state;
		
		String url = "jdbc:mysql://localhost:3306/ICS_324_Project";                             
		String user = "root";
		String pass = "1234qwer";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, pass);
			state = connect.createStatement();
		}catch(Exception e){
			System.out.println("Error -"+e.getMessage());
		}
		SignUp(connect);
		try{
			connect.close();
		}catch(Exception e){
			System.out.println("Error ---"+e.getMessage());
		}

	}
	
	public static void SignUp(Connection connect){
		Scanner kb = new Scanner(System.in);
		boolean contenue = true;
		boolean pass = true;
		Users u = new Users();
		Pattern p = Pattern.compile("[^a-zA-Z]");
		String temp = null;
		while (contenue){
			try {
				PreparedStatement ps1 = connect.prepareStatement("SELECT MAX(U_ID) From Users;");
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				u.setU_ID(rs1.getInt("MAX(U_ID)") + 1);
				
				while(pass){
					System.out.print("\nplease enter your First Name:");
					temp = kb.next();
					pass = p.matcher(temp).find();
					if(pass){
						System.out.print("\nin valid input,try again.");
					}
				}
				u.setFName(temp);
				pass = true;
				while(pass){
					System.out.print("\nplease enter your Last Name:");
					temp = kb.next();
					pass = p.matcher(temp).find();
					if(pass){
						System.out.print("\nin valid input,try again.");
					}
				}
				u.setLName(temp);
				
				System.out.print("\nplease enter your E-Mail:");
				u.setEMail(kb.next());
				System.out.print("\nplease enter your Desired Username:");
				u.setUserName(kb.next());
				System.out.print("\nplease enter your Desired Password:");
				u.setHashed_PW(kb.next());
				u.setType_ID(3);
				u.setStatus_ID(0);
				
			
				pass = u.addToDB(connect);
				//"INSERT INTO Users () values ("+users.getUID()+",'"+users.getUserName()+"','"+users.getFName()+"','"+users.getLname()+"','"+users.getHashPassword()+"','"+users.getEmail()+"',CURRENT_TIMESTAMP,'"+users.getTypeID()+"',1)"
				contenue = false;
			}catch(Exception e){
				System.out.println("Error ------"+e.getMessage());
				System.out.println("\ntry again? (y/n)");
				if(kb.next().equals("n"))
					contenue = false;
			}
		}
	}
}