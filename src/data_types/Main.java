package data_types;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

	
	public static void main(String[] arg){
		Users currentUser;
		Connection connect = null;
		boolean loop = true;
		//Statement state;
		
		String url = "jdbc:mysql://localhost:3306/ICS_324_Project";                             
		String user = "root";
		String pass = "Mot1mot2fir3@";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, pass);
			//state = connect.createStatement();
		}catch(Exception e){
			System.out.println("Error -"+e.getMessage());
		}
		boolean isRunning = true;
		System.out.print("Welcome to Clinic Rating!\n\n\n");
		while(isRunning){
			System.out.print("\nMain Menu:-\n\n<1> Login\n<2> SignUp\n<3> Guest Mode\nPlease enter the number of the desired option: ");
			Scanner kb = new Scanner(System.in);
			int choice = kb.nextInt();
			switch(choice){
			case 1:
				try {
					currentUser = Login(connect,kb);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					break;
				}
				if(currentUser.getStatus_ID() == 1){
					System.out.println("Unfortunetly, your account is currently suspended. Contact the System Adminstrator for more details.");
					currentUser = null;
					break;
				}
				
				System.out.println("Welcome " + currentUser.getFName() + " " + currentUser.getLName() + "!\n");
				
				switch(currentUser.getType_ID()){	
					case 0:										//System Admin

						
						loop = true;
						while(loop){
							System.out.println("\nSystem Admin Menu:-\n\n"
									+ "<1> Create a new clinic.\n"
									+ "<2> Create a new clinic admin.\n"
									+ "<3> Change the status of a clinic.\n"
									+ "<4> Change the status of a clinic admin.\n"
									+ "<5> Logout");
							choice = kb.nextInt();
							switch(choice){
							
								case 1:
									
									ClinicAdd(connect, kb);
									break;
									
								case 2:
									
									SignUp(connect,1,kb);
									break;
									
								case 3:
									
									try {
										PreparedStatement add;
										System.out.println("Choose clinic ID that you would like to change its status:");
										Clinics.toStringClinics(connect,false);
										int temp = kb.nextInt();
										System.out.println("Select the desired status:");
										Status.toStringStatus(connect);
										int temp1 = kb.nextInt();
										add = connect.prepareStatement("UPDATE Clinics SET Status_ID = "+temp1+" WHERE C_ID = "+temp+";");
										add.executeUpdate();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									break;
								case 4:
									try {
										PreparedStatement add;
										System.out.println("Choose admin clinic ID that you would like to change its status:");
										Users.toStringClinicAdminUsers(connect);
										int temp = kb.nextInt();
										System.out.println("Select the desired status:");
										Status.toStringStatus(connect);
										int temp1 = kb.nextInt();
										add = connect.prepareStatement("UPDATE Users SET Status_ID = "+temp1+" WHERE U_ID = "+temp+";");
										add.executeUpdate();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								case 5:
									
									currentUser = null;
									loop = false;
									break;
									
								default: 
									
									System.out.println("This choice doesnt exist. Please try again.");
							}
						}
						break;
					
					case 1:	
						//Clinic Admin
						

						loop = true;
						while(loop){
							System.out.println("\nClinic Admin Menu:-\n\n"
									+ "<1> Create a new clinic receptionist.\n"
									+ "<2> Change the status of a clinic receptionist.\n"
									+ "<3> Enter clinic info.\n"
									+ "<4> Update clinic info.\n"
									+ "<5> Enter dentist info.\n"
									+ "<6> Update dentist info.\n"
									+ "<7> Enter clinic advertisement.\n"
									+ "<8> Logout");
							choice = kb.nextInt();
							switch(choice){
							
								case 1:
									SignUp(connect,2,kb);
									break;
								case 2:
									break;
								case 3:
									break;
								case 4:
									break;
								case 5:
									break;
								case 6:
									break;
								case 7:
									break;
								case 8:
									currentUser = null;
									loop = false;
									break;
								default: 
									System.out.println("This choice doesnt exist. Please try again.");
							}
						}
						break;
					case 2:										//Clinic Recep

						loop = true;
						while(loop){
							System.out.println("\nClinic Receptionist Menu:-\n\n"
									+ "<1> Confirm customer appointments.\n"
									+ "<2> Update customer appointment.\n"
									+ "<3> Logout");
							choice = kb.nextInt();
							switch(choice){
								case 1:
									break;
								case 2:
									break;
								case 3:
									currentUser = null;
									loop = false;
									break;
								default: 
									loop = true;
									System.out.println("This choice doesnt exist. Please try again.");
							}
						}
						break;
					case 3:										//Customer.

						loop = true;
						while(loop){
							System.out.println("\nCustomer Menu:-\n\n"
									+ "<1> Request an appointment with a specific dentist or with any dentist.\n"
									+ "<2> Cancel appointment.\n"
									+ "<3> Logout");
							choice = kb.nextInt();
							switch(choice){	
								case 1:
									break;
								case 2:
									break;
								case 3:
									currentUser = null;
									loop = false;
									break;
								default: 
									System.out.println("This choice doesnt exist. Please try again.");
							}
						}
						break;
					default:
						System.out.println("Error..... Your account type is unknown. Logging out...");
						currentUser = null;
						System.out.println("Logged out.");
				}
				break;
			case 2:
				SignUp(connect,3,kb);
				break;
			case 3:
									//Guest

				loop = true;
				while(loop){
					System.out.println("\nGuest Menu:-\n\n"
							+ "<1> Browse Clinics and Doctors.\n"
							+ "<2> SignUp.\n"
							+ "<3> Exit guest mode");
					choice = kb.nextInt();
					switch(choice){	
						case 1:
							break;
						case 2:
							SignUp(connect,3,kb);
							break;
						case 3:
							loop = false;
							break;
						default: 
							System.out.println("This choice doesnt exist. Please try again.");
					}
				}
				break;
			case 4:
				System.out.println("FareWell, And see you again!");
				isRunning = false;
				break;
			default:
				System.out.println("Invalid Input... please Choose something from the menu.");
				break;
			}
		}
		
		try{
			connect.close();
		}catch(Exception e){
			System.out.println("Error ---"+e.getMessage());
		}

	}
	
	public static void SignUp(Connection connect,int u_type,Scanner kb){
		boolean main_loop = true;
		boolean pass = true;
		Users u = new Users();
		Pattern p = Pattern.compile("[^a-zA-Z]");
		Pattern p1 = Pattern.compile("[^0-9]");
		String temp = null;
		boolean hasContact;
		int contactCount = 0;
		LinkedList<User_Contact_Numbers> contacts = new LinkedList<User_Contact_Numbers>();
			
		while(main_loop){
			try {
				
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
				System.out.print("\nplease enter your Desired Username:");
				u.setUserName(kb.next());
				System.out.print("\nplease enter your Desired Password:");
				u.setHashed_PW(kb.next());
				System.out.print("\nplease enter your EMail:");
				u.setEMail(kb.next());
				u.setType_ID(u_type);
				u.setStatus_ID(0);				
				
				System.out.println("Do you have any contact numbers? (y/n)");
				hasContact = Y_N(kb);
				User_Contact_Numbers tempContact = new User_Contact_Numbers();
				
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
					contacts.add(new User_Contact_Numbers(tempContact));
					System.out.print("Want to add more contacts? (y/n)");
					hasContact = Y_N(kb);
				}
				
				
				PreparedStatement ps1 = connect.prepareStatement("SELECT MAX(U_ID) From Users;");
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				u.setU_ID(rs1.getInt("MAX(U_ID)") + 1);
				pass = u.addToDB(connect);
				for(int i=0; i<contactCount;i++){
					contacts.get(i).setU_ID(u.getU_ID());
					pass = pass & contacts.get(i).addToDB(connect);
				}
				
				//"INSERT INTO Users () values ("+users.getUID()+",'"+users.getUserName()+"','"+users.getFName()+"','"+users.getLname()+"','"+users.getHashPassword()+"','"+users.getEmail()+"',CURRENT_TIMESTAMP,'"+users.getTypeID()+"',1)"
				main_loop = false;
				while(!pass){
					System.out.print("What do you want to do?\n<1> Change Username\n<2> Change EMail\n<3> Start over\n<4> Exit Signup\n");
					int x = kb.nextInt();
					switch(x){
					case 1:
						System.out.print("\nplease enter your Desired Username:");
						u.setUserName(kb.next());
						break;
					case 2:
						System.out.print("\nplease enter your EMail:");
						u.setEMail(kb.next());
						break;
					case 3:
						main_loop = true;
						pass = true;
						break;
					case 4:
						main_loop = false;
						pass = true;
						break;
					}
					
					
				}
			}catch(Exception e){
				System.out.println("Error ------"+e.getMessage());
				System.out.println("\ntry again? (y/n)");
				main_loop = Y_N(kb);
			}
		}
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

	public static Users Login(Connection connect,Scanner kb) throws SQLException{
		Users u = new Users();
		PreparedStatement add;
		boolean temploop = true;
		while(temploop){
			System.out.print("Please Enter your username:");
			u.setUserName(kb.next());
			System.out.print("Please Enter your password:");
			u.setHashed_PW(kb.next());
		
			add = connect.prepareStatement("Select * From Users WHERE UserName = '"+u.getUserName()+"' AND Hashed_PW = '"+u.getHashed_PW()+"';");
			ResultSet r = add.executeQuery();
			if(r.next()){
				u = new Users(r);
				temploop = false;
			}else{
				System.out.println("Wrong Username or Password. Please try again.");
			}
		}
		return u;
	}
	
	public static void ClinicAdd(Connection connect,Scanner kb){
		boolean main_loop = true;
		boolean pass = true;
		Pattern p1 = Pattern.compile("[^0-9]");
		Clinics c = new Clinics();
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
				Users.toStringClinicAdminUsers(connect);
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
	}
	
	
}