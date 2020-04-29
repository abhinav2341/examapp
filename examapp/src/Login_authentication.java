import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DB_utility;

import java.sql.*;
@WebServlet(description = "servlet to check user (admin/student)", urlPatterns = { "/Login_authentication" })
public class Login_authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		System.out.println("entered uname - "+ email+" entered pass - " + pass);
		String Db_user=null;
		String Db_pass=null;
		int Db_roleid=0;
		int Db_uid=0;
		Connection con=null;
		String query=null;
		
		try {
			//try block here
			con=DB_utility.getDBConnection();
			query="select U_pass,Role_id,U_id from exam_app.login_table where Email=\""+email+"\";";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query); 
			while(rs.next())
			{
				
				Db_pass=rs.getString(1);
				Db_roleid=rs.getInt(2);
				Db_uid=rs.getInt(3);
				System.out.println(" db pass - "+ Db_pass +" db role - "+ Db_roleid+" db U_id - "+ Db_uid );
			}
				con.close();  
		} catch (Exception e) {
			// TODO: handle exception.
			System.out.println(e);
		}
		
		if(pass.equals(Db_pass))
		{
			System.out.println("pass validated");
			if(Db_roleid==1)
			{
				 HttpSession session=request.getSession();  
			     session.setAttribute("Logged","Yes");
//			     if(session.getAttribute("Logged").equals("Yes")) {
				 RequestDispatcher rd=request.getRequestDispatcher("./Admin_page.jsp");  
			     rd.forward(request, response);
//			     }
//			     else
//			     {
//			    	 System.out.println("LOgin first");
//			    	 RequestDispatcher rd=request.getRequestDispatcher("./");  
//				     rd.forward(request, response);
//			     }
			}
			else if(Db_roleid==2)
			{
				System.out.println("student page");
				//student
				HttpSession session=request.getSession();  
			    session.setAttribute("userId", Db_uid);
			     //if(session.getAttribute("userId").equals(Db_uid)) {
				//request.setAttribute("userId", Db_uid);
				RequestDispatcher rd=request.getRequestDispatcher("./Student_page.jsp");  
			    rd.forward(request, response);
			    // }
			}
			else if(Db_roleid==3)
			{
				//student
				System.out.println("super admin page");
				 RequestDispatcher rd=request.getRequestDispatcher("./Superadmin_page.jsp");  
			     rd.forward(request, response);
			}
			else
			{	
				System.out.println("Something went wrong");
				//error
				request.setAttribute("ERROR_MESSAGE","invalid credentials.");
				RequestDispatcher rd=request.getRequestDispatcher("./index.jsp");  
			    rd.forward(request, response);
			}
		}
		else
		{
			//error
			request.setAttribute("ERROR_MESSAGE","invalid credentials");
			RequestDispatcher rd=request.getRequestDispatcher("./index.jsp");  
		    rd.forward(request, response);
		}
	}
}
