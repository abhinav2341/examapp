

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;

/**
 * Servlet implementation class Checkduplicatemails
 */
@WebServlet(description = "ajax called servlet to check duplicate email in DB", urlPatterns = { "/Checkduplicatemails" })
public class Checkduplicatemails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ajax called servlet working");
		PrintWriter out = null;
		Connection con = null;
		Statement st = null;
		try {
		out = response.getWriter();
		String email = request.getParameter("Email") != null ? request.getParameter("Email") : null;
		if(email == null || email.trim().length() <= 1) {
		return;
		}
		con = DB_utility.getDBConnection();
		st = con.createStatement();
		String query = "select * from user_details where Email='"+email+"'";
		System.out.println("Query:" + query);
		ResultSet rs = st.executeQuery(query);  // this is for name
		if(rs.next())
		{   
			System.out.println("Email exists already");
			out.print("FAILURE");
		    
		}else {
			System.out.println("email available");
		    out.println("SUCCESS");
		}

		rs.close();
		st.close(); st = null;
		con.close(); con=null;
		} 
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
		  
	}
	}

	

