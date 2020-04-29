

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;


@WebServlet(description = "ajax called servlet", urlPatterns = { "/Checkduplicatesection" })
public class Checkduplicatesection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ajax called servlet working");
		PrintWriter out = null;
		Connection con = null;
		Statement st = null;
		try {
		out = response.getWriter();
		String sectionName = request.getParameter("section") != null ? request.getParameter("section") : null;
		if(sectionName == null || sectionName.trim().length() <= 1) {
		return;
		}
		con = DB_utility.getDBConnection();
		st = con.createStatement();
		String query = "select * from section_table where section='"+sectionName+"'";
		System.out.println("Query:" + query);
		ResultSet rs = st.executeQuery(query);  // this is for name
		if(rs.next())
		{   
			System.out.println("Section exists already");
			out.print("FAILURE");
		    
		}else {
			System.out.println("Section available");
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

