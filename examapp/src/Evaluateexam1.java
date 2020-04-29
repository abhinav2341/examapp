

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;

@WebServlet(description = "Servlet to populate exam for evaluate jsp page", urlPatterns = { "/Evaluateexam1" })
public class Evaluateexam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Evaluateexam1 servlet working");
		Connection con=null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String currentDate=dateFormat.format(date);
		System.out.println("date is: "+currentDate);
		boolean b;
		Map<Integer, String> userMap = new HashMap<>();
		int eId;
		String e;
		try {
			con=DB_utility.getDBConnection();
			PreparedStatement st=con.prepareStatement("select exam_schedule.`Exam_id`,`Exam`,`Start`,candidate_question.`Completed` from exam_schedule right join candidate_question on exam_schedule.Exam_id=candidate_question.Exam_id where `Start`<=? ");
			st.setString(1, currentDate);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				int examId=rs.getInt("Exam_id");
				String Exam=rs.getString("Exam");
				String start=rs.getString("Start");
				String completed=rs.getString("completed");
				if(start.equals(currentDate))
				{
					//System.out.println("Date same");
					if(completed.equals("YES"))
					{
						b=true;
						examId=rs.getInt("Exam_id");
					}
					else
					{
						b=false;
					}
				}
				else {
					System.out.println("Date not same");
				}
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR in fetching details from join");
			e.printStackTrace();
		}
//		RequestDispatcher rd = request.getRequestDispatcher("./evaluateexam.jsp");
//		rd.forward(request, response);	
	}

}
