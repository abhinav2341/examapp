

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;
import com.util.DB_utility;
@WebServlet(description = "servlet to populate question", urlPatterns = { "/Editquestion" })
public class Editquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("edit question servlet working");
		String questionId=request.getParameter("questionId");
		request.setAttribute("questionId", questionId);
		System.out.println("Question ID:"+questionId);
		Connection con=null;
		PreparedStatement ps = null;

		try {
			con = DB_utility.getDBConnection();
			ps=con.prepareStatement("select * from question_bank where Q_id=?");
			       ps.setString(1,questionId);
			       ResultSet rs = ps.executeQuery();
			       String question=null;
			       String option1=null;
			       String option2=null;
			       String option3=null;
			       String option4=null;
			       String correctanswer=null;
			        while (rs.next()) {
			        	question = rs.getString("Question");
				        request.setAttribute("question",question);
				       	System.out.println("question-"+question);
			        	
			        	
			        option1 = rs.getString("op_1");
			        request.setAttribute("option1",option1);
			       	System.out.println("option1-"+option1);
			     	
			       	option2 = rs.getString("op_2");
			        request.setAttribute("option2",option2);
			       	System.out.println("option2-"+option2);
			       	
			       	option3 = rs.getString("op_3");
			        request.setAttribute("option3",option3);
			       	System.out.println("option3-"+option3);
			       	
			       	option4 = rs.getString("op_4");
			        request.setAttribute("option4",option4);
			       	System.out.println("option4-"+option4);
			       	
			       	correctanswer = rs.getString("correct");
			       	request.setAttribute("correct",correctanswer);
			       	System.out.println("correct-"+correctanswer);
			        }
			        rs.close();
			        ps.close();
			        ps=null;
			    } catch (Exception e) {
			        System.out.println("Error in fetching data from question bank");
			        e.printStackTrace();
			    }	
				RequestDispatcher rd = request.getRequestDispatcher("./editquestion1.jsp");
				rd.forward(request, response);
	}
}


