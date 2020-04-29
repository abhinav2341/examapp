
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.util.DB_utility;
import java.util.Date;



@WebServlet("/Testdate")
public class Testdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet for testing the exam date is working...");
		Connection con = null; 
		PreparedStatement ps = null;
		String userId = request.getParameter("userId");
		String examId=request.getParameter("examId");
		request.setAttribute("examId", examId);
		request.setAttribute("userId", userId);
		System.out.println("Exam ID-"+examId);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String date1=dateFormat.format(date);
		request.setAttribute("currentDate", date1);
		System.out.println("date is: "+date1);
		try {
		con = DB_utility.getDBConnection();
		ps=con.prepareStatement("select `exam`,`start` from `exam_schedule` where Exam_id=?");
		ps.setString(1,examId);
		ResultSet rs = ps.executeQuery();
		String startDate=null;
		String exam=null;
		while (rs.next()) {
		        
				exam = rs.getString("Exam");
		        request.setAttribute("Exam",exam);
		       	System.out.println("Exam-"+exam);
		     	
		       	
		       	startDate = rs.getString("Start");
		        request.setAttribute("startDate",startDate);
		       	System.out.println("start date-"+startDate);
		       	
		       	if(date1.compareTo(startDate)==0)//same date
		       	{
		       		System.out.println("Test begins");
		    		RequestDispatcher rd = request.getRequestDispatcher("./instructions.jsp");
		    		rd.forward(request, response);
		       	}
		       	else if(date1.compareTo(startDate)<0)//not yet begun
		       	{
		       		System.out.println("Test not begun");
		       		RequestDispatcher rd = request.getRequestDispatcher("./testfail.jsp");
		    		rd.forward(request, response);
		       		
		       	}
		       	else if(date1.compareTo(startDate)>0)//test expired
		       	{
		       		System.out.println("Test expired");
		       		RequestDispatcher rd = request.getRequestDispatcher("./testexpire.jsp");
		    		rd.forward(request, response);
		       		
		       	}
		     	
		       	
		        }
		        rs.close();
		        ps.close();
		        ps=null;          

		    } catch (Exception e) {
		    	System.out.println("error in fetching exam details");
		        e.printStackTrace();
		    } 
		


		
	}
}