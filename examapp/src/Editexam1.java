

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;
import java.util.*;

@WebServlet("/Editexam1")
public class Editexam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Editexam1 Servlet Working....");
		Connection con = null; 
		PreparedStatement ps = null;
		String examId=request.getParameter("examId");
		String start_date=request.getParameter("startDate");
		System.out.println("exam id:"+examId+"startdate:"+start_date);
		
		try {
			con = DB_utility.getDBConnection();
			String sql = "UPDATE exam_schedule "+ "SET Start = ? "+ "WHERE Exam = ?";
			ps=con.prepareStatement("UPDATE exam_schedule SET Start = ? WHERE Exam_id = ?");
			        ps.setString(1,start_date);
			        ps.setString(2,examId);
			        
			        int i=ps.executeUpdate();
			        if(i!=0)
			        {
			        	System.out.println(i+"rows affected");
			        	request.setAttribute("result","Edit Successful");
			        }
			        else {
			        	System.out.println("update failed");
			        }
					
			        con.close();
			        ps.close();
			                 

			    } catch (Exception e) {
			        System.out.println("error in query");
			        e.printStackTrace();
			    }

		RequestDispatcher rd = request.getRequestDispatcher("./editexam.jsp");
		rd.forward(request, response);
	}

}
