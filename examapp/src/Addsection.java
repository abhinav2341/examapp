

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;
import com.util.CommonUtil;
import java.sql.*;
/**
 * Servlet implementation class Addsection
 */
@WebServlet(description = "Servlet to store section in section table", urlPatterns = { "/Addsection" })
public class Addsection extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Add section servlet working");
        	
        	Connection con;
            // Initialize the database 
            String sectionName = request.getParameter("section") != null ? request.getParameter("section"): null;
            if(sectionName != null) 
            	{
            		try {
	         			con = DB_utility.getDBConnection();
	                    
	                    // Create a SQL query to insert data into demo table 
	                    // demo table consists of two columns, so two '?' is used 
	                  
	                    PreparedStatement ps = con.prepareStatement("insert into section_table(Section) values(?)"); 
	          
	                    // For the first parameter, 
	                    // get the data using request object 
	                    // sets the data to st pointer 
	          
	                    // Same for second parameter 
	                    ps.setString(1, request.getParameter("section")); 
	          
	                    // Execute the insert command using executeUpdate() 
	                    // to make changes in database 
	                    ps.executeUpdate(); 
	          
	                    // Close all the connections 
	                    ps.close(); 
	                    con.close();
	                    request.setAttribute("result", "Section Inserted successfully");
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("error in updating");
						e.printStackTrace();
					}
	         		      // Get a writer pointer  
                 // to display the succesful result  
        		}
            
			RequestDispatcher rd = request.getRequestDispatcher("./addsection.jsp");
            rd.forward(request, response);  
	}
}

	
	
	
	/*if(util.checkDuplicateSection(sectionName)) {
		//Duplicate value found
		request.setAttribute("result", "Section Name already exist!");
		//out.println("Section Name already exist!");
		RequestDispatcher rd = request.getRequestDispatcher("./addsection.jsp");
		rd.forward(request, response);
	} */
/*
try {
	con = DB_utility.getDBConnection();
    out = response.getWriter();
	st = con.createStatement();
	String query = "select * from section_table where section='"+sectionName+"'";
	System.out.println("Query:" + query);
	ResultSet rs = st.executeQuery(query);  // this is for name
	 if(rs.next())
		{    
		    out.println("<font color=red>");
		    out.println("Name already taken");
		    out.println("</font>");
		    con.close();
		    st.close();
		}*/
	
