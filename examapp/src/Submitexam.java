import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.*;
import com.util.*;
  
@WebServlet(description = "servlet to submit exam details in DB", urlPatterns = { "/Submitexam" })
public class Submitexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Submit exam Servlet working");
		Map<Integer, String> userMap = new HashMap<>();
		HttpSession session=request.getSession(false);
		int candidateId=(int)session.getAttribute("userId");
		System.out.println("candidateId:"+candidateId);
		int totalQuestion=Integer.parseInt(request.getParameter("totalQuestion"));
		int examId=Integer.parseInt(request.getParameter("examId"));
		//int questionId=Integer.parseInt(request.getParameter("questionId"));
		System.out.println("Total question:"+totalQuestion);
		System.out.println("Exam id :"+examId);
		int marks=0,maxMarks;
		maxMarks=totalQuestion;
		boolean b1=false,b2=false;
		Connection con=null;
		double percentage=0;
		for (int i = 1; i <= totalQuestion; i++) {
			String selectedOption=request.getParameter("Q"+i);
			String questionId=request.getParameter("question"+i+"Id");
			System.out.println("Question"+i+"Id:"+questionId);
			System.out.println("selected option:"+selectedOption);
			try {
				con=DB_utility.getDBConnection();
				PreparedStatement stm=con.prepareStatement("Select Correct from candidate_question where Q_id=?");
				stm.setString(1, questionId);
				ResultSet rs=stm.executeQuery();
				rs.next();
				String correct=rs.getString("correct");
				if(selectedOption!=null) {
					if(selectedOption.equals(correct))
					{
						marks++;
					}
				}
				System.out.println("MARKS SCORED in loop "+i+": "+marks);
				con.close();
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error in candidate question Query");
				e.printStackTrace();
			}
			
			
			try {
				con=DB_utility.getDBConnection();
				PreparedStatement st=con.prepareStatement("Update candidate_question set Selected_answer=?,Completed='yes' where Q_id=? and U_id=? and exam_id=?");
				st.setString(1, selectedOption);
				st.setString(2, questionId);
				st.setInt(3, candidateId);
				st.setInt(4, examId);
				int k=st.executeUpdate();
				con.close();
				if (k>0) {
					System.out.println(k+"rows inserted");
					
					b2=true;
//					
					
				} else {
					System.out.println("Insert failed");	
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error in inserting into candidate_question table");
				e.printStackTrace();
			}
			
		}
		System.out.println("MARKS SCORED:"+marks);
		System.out.println("Max MARKS :"+maxMarks);
		percentage=(marks*1.0/maxMarks)*100;
		
		System.out.println("percentage"+percentage);
		try {
			con=DB_utility.getDBConnection();
			PreparedStatement pstm=con.prepareStatement("insert into score_card values(?,?,?,?,?)");
			pstm.setInt(1, candidateId);
			pstm.setInt(2, examId);
			pstm.setInt(3, marks);
			pstm.setInt(4, maxMarks);
			pstm.setDouble(5, percentage);
			int j=pstm.executeUpdate();
			if(j>0)
			{
				System.out.println(j+"rows affected in scorecard");
				b1=true;
			}
			else {
				System.out.println("Scorecard Insert failed ");	
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Scorecard query error ");
			e.printStackTrace();
		}
		if(b1&b2)
		{
			request.setAttribute("result", "Thank you");
			RequestDispatcher rd=request.getRequestDispatcher("./Student_page.jsp");  
		    rd.forward(request, response);
		}
		
//		String correct=
	}

}
