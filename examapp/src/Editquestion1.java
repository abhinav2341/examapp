

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

@WebServlet(description = "servlet to update question in Question bank in DB", urlPatterns = { "/Editquestion1" })
public class Editquestion1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Editquestion1 servlet Working!!!!");
		
		Connection con = null; 
		PreparedStatement ps = null;
		String questionId=request.getParameter("questionId");
		String question=request.getParameter("Question_ip");
		String option1=request.getParameter("option_ip1");
		String option2=request.getParameter("option_ip2");
		String option3=request.getParameter("option_ip3");
		String option4=request.getParameter("option_ip4");
		String correct=request.getParameter("correct");
		System.out.println("Update question"+question+" op1-"+option1+"op2-"+option2+"op3-"+option3+"op4-"+option4+"correct-"+correct);		
		try {
		con = DB_utility.getDBConnection();		
//		String question_id=request.getParameter("question_id");
		String sql = "UPDATE `question_bank` SET `question`=?,`op_1`=?,`op_2`=?,`op_3`=?,`op_4`=?,`correct`=? WHERE Q_id=?";
		ps=con.prepareStatement(sql);
		        ps.setString(1,question);
		        ps.setString(2,option1);
		        ps.setString(3,option2);
		        ps.setString(4,option3);
		        ps.setString(5,option4);
		        ps.setString(6,correct);
		        ps.setString(7,questionId);
		        
		        int i=ps.executeUpdate();
		        if(i!=0) {
		         System.out.println("Data update sucessfully");
		         request.setAttribute("result","Update successful");
		        }
		        else
		        {
			         System.out.println("Data update failed");
			         request.setAttribute("result","Update failed");
		        }
				
		       
		        ps.close();
		        ps=null;   
		        con.close();

		    } catch (Exception e) {
		        System.out.println("Error in updating ");
		        e.printStackTrace();
		    } 

		RequestDispatcher rd = request.getRequestDispatcher("./Admin_page.jsp");
		rd.forward(request, response);
		
		
	}

}
