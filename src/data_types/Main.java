package data_types;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

	
	public static void main(String[] arg){
		Users currentUser;				//This is where the user details are stored (when login)
		Connection connect = null;
		boolean loop = true;
		//Statement state;
		
		String url = "jdbc:mysql://localhost:3306/ICS_324_Project";                             
		String user = "root";
		String pass = "123321";
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
									+ "<5> Change the status of a customer.\n"
									+ "<6> Logout");
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
										Status.toStringStatus(connect,"Clinics");
										int temp1 = kb.nextInt();
										add = connect.prepareStatement("UPDATE Clinics SET Status_ID = "+temp1+" WHERE C_ID = "+temp+";");
										add.executeUpdate();
										System.out.println("Status Update Successful!");
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									break;
								case 4:
									try {
										PreparedStatement add;
										System.out.println("Choose clinic admin ID that you would like to change its status:");
										Users.toStringUsers(connect,1);
										int temp = kb.nextInt();
										System.out.println("Select the desired status:");
										Status.toStringStatus(connect,"Users");
										int temp1 = kb.nextInt();
										add = connect.prepareStatement("UPDATE Users SET Status_ID = "+temp1+" WHERE U_ID = "+temp+";");
										add.executeUpdate();
										System.out.println("Status Update Successful!");
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								
								case 5:
									try {
										PreparedStatement add;
										System.out.println("Choose customer ID that you would like to change its status:");
										Users.toStringUsers(connect,3);
										int temp = kb.nextInt();
										System.out.println("Select the desired status:");
										Status.toStringStatus(connect,"Users");
										int temp1 = kb.nextInt();
										add = connect.prepareStatement("UPDATE Users SET Status_ID = "+temp1+" WHERE U_ID = "+temp+";");
										add.executeUpdate();
										System.out.println("Status Update Successful!");
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								case 6:
									
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
									+ "<5> Add new dentist to clinic.\n"
									+ "<6> Enter dentist info.\n"
									+ "<7> Update dentist info.\n"
									+ "<8> Enter clinic advertisement.\n"
									+ "<9> Logout");
							choice = kb.nextInt();
							switch(choice){
							
								case 1:
									
									SignUp(connect,2,kb);
									break;
									
								case 2:
								
								try{
									PreparedStatement add;
									System.out.println("Choose clinic Receptionist ID that you would like to change its status:");
									Users.toStringUsers(connect,2);
									int temp = kb.nextInt();
									System.out.println("Select the desired status:");
									Status.toStringStatus(connect,"Users");
									int temp1 = kb.nextInt();
									add = connect.prepareStatement("UPDATE Users SET Status_ID = "+temp1+" WHERE U_ID = "+temp+";");
									add.executeUpdate();
									System.out.println("Status Update Successful!");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									
									break;
									
								case 3:
								try {
									Clinics.toStringClinics(connect,false);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									break;
								case 4:
									UpdateClinicInfo(connect,kb,currentUser);
									break;
								case 5:
									break;
								case 6:
									break;
								case 7:
									break;
								case 8:
									break;
								case 9:
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
				
				System.out.print("\nplease enter clinic profile (including clinic name):");
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
				Users.toStringUsers(connect,1);
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
				
				c.setRating(new Double(0));
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
	
	public static void ClinicUpdate(Connection connect,Scanner kb,String update,Clinics c){
		System.out.println("Enter Desired "+update+" info:");
		kb.nextLine();
		String temp = kb.nextLine();
		System.out.println("Modify?");
		if(Y_N(kb)){
			PreparedStatement add;
			if(update.equals("Profile"))
				update = "_Profile";
			try {
				add = connect.prepareStatement("UPDATE Clinics SET "+update+" = '"+temp+"' WHERE C_ID = "+c.getC_ID()+";");
				add.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Update success!");
		}else{
			System.out.println("Cancelled!");
		}
	}
	
	public static void UpdateClinicInfo(Connection connect,Scanner kb,Users currentUser){
		Pattern p1 = Pattern.compile("[^0-9]");
		boolean loop1 =true;
		while(loop1){
			PreparedStatement statement;
			try {
				statement = connect.prepareStatement("SELECT * FROM Clinics WHERE Clinic_ManID = "+currentUser.getU_ID()+";");
				ResultSet Result = statement.executeQuery();
				if(Result.next()){
					Clinics c = new Clinics(Result);
					System.out.println(c + "\n\nWhat would you like to update?\n<1> Profile\n<2> Location\n<3> E-Mail\n<4> Website\n<5> Contact Number\n<6> Exit");
					int choose = kb.nextInt();
					switch(choose){
					case 1:
						ClinicUpdate(connect,kb,"Profile",c);
						/*System.out.println("Enter Desired Profile info:");
						kb.nextLine();
						String temp = kb.nextLine();
						System.out.println("Modify?");
						if(Y_N(kb)){
							PreparedStatement add;
							add = connect.prepareStatement("UPDATE Clinics SET _Profile = "+temp+" WHERE C_ID = "+c.getC_ID()+";");
							add.executeUpdate();
							System.out.println("Update success!");
						}else{
							System.out.println("Cancelled!");
						}*/
						break;
					case 2:
						ClinicUpdate(connect,kb,"Location",c);
						/*System.out.println("Enter Desired Location info:");
						kb.nextLine();
						String temp1 = kb.nextLine();
						System.out.println("Modify?");
						if(Y_N(kb)){
							PreparedStatement add;
							add = connect.prepareStatement("UPDATE Clinics SET Location = "+temp1+" WHERE C_ID = "+c.getC_ID()+";");
							add.executeUpdate();
							System.out.println("Update success!");
						}else{
							System.out.println("Cancelled!");
						}*/
						break;
					case 3:
						ClinicUpdate(connect,kb,"EMail",c);
						break;
					case 4:
						ClinicUpdate(connect,kb,"Website",c);
						break;
					case 5:
						boolean loop2 = true;
						while(loop2){
						int contactCount = -1;
						Clinic_Contact_Numbers.toStringClinic(connect, c.getC_ID());
						System.out.println("<1> add\n<2> delete\n<3> modify\n<4> exit");
						choose = kb.nextInt();
						PreparedStatement ps1 = connect.prepareStatement("SELECT MAX(C_ID) From Clinics;");
						ResultSet r = connect.prepareStatement("SELECT MAX(_Order) From Clinic_Contact_Numbers WHERE Clinic_ID = "+c.getC_ID()+";").executeQuery();
						if(r.next()){
							contactCount = r.getInt("MAX(_Order)");
						}
							switch(choose){
							case 1:
								Clinic_Contact_Numbers tempContact = new Clinic_Contact_Numbers();
								boolean hasContact =true;
								while(hasContact){
									System.out.print("Please enter contact number:");
									boolean pass = true;
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
									tempContact.setClinic_ID(c.getC_ID());
									tempContact.addToDB(connect);
									System.out.print("Want to add more contacts? (y/n)");
									hasContact = Y_N(kb);
								}
								break;
							case 2:
								System.out.println("Select Order number of contact you want to delete.");
								int order = kb.nextInt();
								if(order<=contactCount && order>0)
									DeleteClinicContact(connect,order,c.getC_ID());
								else
									System.out.println("Wrong order number!");
								break;
							case 3:
								System.out.println("Select Order number of contact you want to modify.");
								int order1 = kb.nextInt();
								if(order1<=contactCount && order1>-1){
									boolean loop3 = true;
									while(loop3){
										System.out.println("What would you like to modify?\n<1> Number\n<2> Type\n<3> Exit2");
										choose = kb.nextInt();
										switch(choose){
										case 1:
											
											System.out.println("Enter the new number: ");
											String temp = kb.next();
											connect.prepareStatement("UPDATE Clinic_Contact_Numbers SET Number = '"+temp+"' WHERE Clinic_ID = "+c.getC_ID()+" AND _Order = "+order1+";").executeUpdate();
											System.out.println("Done!");
											break;
											
										case 2:
											System.out.println("Update the contact type: ");

											String temp1 = kb.next();
											connect.prepareStatement("UPDATE Clinic_Contact_Numbers SET Type = '"+temp1+"' WHERE Clinic_ID = "+c.getC_ID()+" AND _Order = "+order1+";").executeUpdate();
											System.out.println("Done!");
											break;
										case 3:
											loop3 = false;
											break;
										default:
											System.out.println("This choice doesnt exist. Please try again.");
										}
									}
								}
									
								break;
							case 4:
								loop2 = false;
								break;
							default:
								System.out.println("This choice doesnt exist. Please try again.");
							}
						}
						break;
					case 6:
						loop1 = false;
						break;
					default:
						System.out.println("This choice doesnt exist. Please try again.");
					}
				}else{
					System.out.println("You are not an adminstrator of a spicific clinic. Contact system admin for more details.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void DeleteClinicContact(Connection connect, int order,int C_ID) throws SQLException{
		connect.prepareStatement("DELETE FROM Clinic_Contact_Numbers WHERE Clinic_ID = "+C_ID+" AND _Order = "+order+";").executeUpdate();
		ResultSet r = connect.prepareStatement("SELECT COUNT(*) FROM Clinic_Contact_Numbers WHERE Clinic_ID = "+C_ID+";").executeQuery();
		r.next();
		int n = r.getInt("COUNT(*)");
		for(int i = order; i<=n;i++){
			connect.prepareStatement("UPDATE Clinic_Contact_Numbers SET _Order = "+i+" WHERE Clinic_ID = "+C_ID+" AND _Order = "+(i+1)+";").executeUpdate();
		}
		
	}

	/*public static void AddDentist(Connection connect,int u_type,Scanner kb,Users currentUser){
		boolean main_loop = true;
		boolean pass = true;
		Dentists d = new Dentists();
		Pattern p = Pattern.compile("[^a-zA-Z]");
		Pattern p1 = Pattern.compile("[^0-9]");
		String temp = null;
		boolean hasContact;
		int contactCount = 0;
		LinkedList<User_Contact_Numbers> contacts = new LinkedList<User_Contact_Numbers>();
			
		while(main_loop){
			try {
				
				while(pass){
					System.out.print("\nplease enter dentist's First Name:");
					temp = kb.next();
					pass = p.matcher(temp).find();
					if(pass){
						System.out.print("\ninvalid input,try again.");
					}
				}
				d.setFName(temp);
				pass = true;
				while(pass){
					System.out.print("\nplease enter dentist's Last Name:");
					temp = kb.next();
					pass = p.matcher(temp).find();
					if(pass){
						System.out.print("\nin valid input,try again.");
					}
				}
				d.setLName(temp);
				System.out.print("\nplease enter the dentist's profile");
				d.set_Profile(kb.nextLine());
				System.out.print("\nplease enter dentist's number of years of experience:");
				d.setYears_Active(kb.nextInt());
				System.out.print("\nplease enter dentist's EMail:");
				d.setEMail(kb.next());
				d.setClinic_Num(currentUser.getU_ID());////////////////////////////////////////////////////////////////////////////////////////////////
				d.setStatus_ID(0);				
				
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
	}*/

}