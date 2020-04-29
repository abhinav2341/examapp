

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.util.DB_utility;

import java.sql.*;

@WebServlet(description = "servlet where a candidate can start a exam", urlPatterns = { "/Startexam" })
public class Startexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Start exam servlet working");
		String examId=request.getParameter("examId");
		request.setAttribute("examId", examId);
		HttpSession session=request.getSession(false);
		int candidateId=(int)session.getAttribute("userId");
		System.out.println("Exam ID: "+examId);
		System.out.println("Candidate ID: "+candidateId);
		Connection con=null;
		Map<Integer, List<String>> userMap = new HashMap<>();		
		try {
			con=DB_utility.getDBConnection();
			
			PreparedStatement st=con.prepareStatement("select `Q_id`,`Question`,`Op1`,`Op2`,`Op3`,`Op4`,`Remarks` from candidate_question where Exam_id=? and U_id=?;");
			st.setString(1, examId);
			st.setInt(2, candidateId);
			ResultSet rs = st.executeQuery();
			int i=1;
			while(rs.next())
			{
				List<String> tempList = new ArrayList<>();
				String qId=rs.getString("Q_id");
				tempList.add(qId);
				String question=rs.getString("Question");
				tempList.add(question);
				String op1=rs.getString("Op1");
				tempList.add(op1);
				String op2=rs.getString("Op2");
				tempList.add(op2);
				String op3=rs.getString("Op3");
				tempList.add(op3);
				String op4=rs.getString("Op4");
				tempList.add(op4);
				String remarks=rs.getString("Remarks");
				tempList.add(remarks);
//				System.out.println("tempList:"+tempList);
				userMap.put(i, tempList);
				i=i+1;
				
			}
			request.setAttribute("totalQuestion", (i-1));
			System.out.println("Usermap:"+userMap);
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in fetching data from candidate_question table");
			e.printStackTrace();
		}
		try {
			con=DB_utility.getDBConnection();
			
			PreparedStatement stm=con.prepareStatement("select `time_duration` from exam_schedule where Exam_id=?");
			stm.setString(1, examId);
			ResultSet rset=stm.executeQuery();
			rset.next();
			int duration=rset.getInt("time_duration");
			System.out.println("time Duration:"+duration);
			request.setAttribute("duration", duration);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in fetching duration");
			e.printStackTrace();			
		}
		request.setAttribute("userMap", userMap);
		RequestDispatcher rd = request.getRequestDispatcher("./Startexam.jsp");
		rd.forward(request, response);
		
	}

	
	
}
