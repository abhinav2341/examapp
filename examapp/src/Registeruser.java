import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;

import java.sql.*;
@WebServlet(description = "registers user store un login table of DB", urlPatterns = { "/Registeruser" })
public class Registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("register user servlet working");
			String first_name=request.getParameter("Fname");  
			String last_name=request.getParameter("Lname");  
			String mobile=request.getParameter("Mobile"); 
			String email=request.getParameter("Email"); 
			String role_id=request.getParameter("Role"); 
		 
			String message="";
			
			Connection con = null; 
			PreparedStatement ps1 = null;
			PreparedStatement ps2 = null;

			
			 try {
				 con = DB_utility.getDBConnection();
				 ps1=con.prepareStatement("select email from user_details where email=?");
		         ps1.setString(1,email);
		         ResultSet rs = ps1.executeQuery();
		          
		         if (rs.next()) {
		        	 System.out.println("email is already in use");
		        	 message= ""+email+" is already in use";
		             request.setAttribute("result",message);
		             request.getRequestDispatcher("./registeruser.jsp").forward(request, response);		             
		         }
		         con.close();
		         ps1.close();

		     } catch (Exception e) {
	        	 System.out.println("error in fetching email from user details table to validate duplicates");
	        	 e.printStackTrace();
		     }        
			try{  
				con = DB_utility.getDBConnection();
				ps1=con.prepareStatement("insert into user_details (`F_name`,`L_name`,`Mobile`,`Email`,`Role_id`) values(?,?,?,?,?)"); 
				ps1.setString(1,first_name);
				ps1.setString(2, last_name);
				ps1.setString(3,mobile);
				ps1.setString(4,email);
				ps1.setString(5,role_id);
				int i=ps1.executeUpdate();  	
			if(i>0)
			{
				System.out.println("user details updated in userdetails table");
				try {
					ps2=con.prepareStatement("select  U_id from user_details where email=?"); 
					ps2.setString(1,email);
					ResultSet rs = ps2.executeQuery();
					if(rs.next())
					{
						int U_id=rs.getInt("U_id");
						System.out.println("U_id from user details table-: "+U_id);
						PreparedStatement ps3 = null;
						try {
							ps3=con.prepareStatement("insert into login_table(`U_id`,`U_pass`,`Email`,`Role_id`) values(?,?,?,?)");
						
							ps3.setInt(1,U_id);
							String U_pass=first_name+"@123";
							ps3.setString(2,U_pass);
							ps3.setString(3,email);
							ps3.setInt(4,Integer.parseInt(role_id));
							System.out.println("updating login table with- userid "+U_id+" password- "+U_pass+" email- "+email+"roleid- "+Integer.parseInt(role_id));
							int j=ps3.executeUpdate();  	
							if(j>0)
							{
								System.out.println("User details updated in Login table");
					        	 message= "Registered Successfully";
					             request.setAttribute("result",message);
					           request.getRequestDispatcher("./registeruser.jsp").forward(request, response);
							}
							ps3.close();
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("error in updating User details in Login table");
							e.printStackTrace();
						}
					}
					ps2.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.print("error in fetching userid from user details table");
					e.printStackTrace();
				}
			}
			ps1.close();
			con.close();      
			}catch (Exception e) {
				System.out.print("error in updating user details in user details table");
				e.printStackTrace();
				message= "Something went wrong please check details";
	             request.setAttribute("result",message);
	             request.getRequestDispatcher("./registeruser.jsp").forward(request, response);
				}  
			}  
	}