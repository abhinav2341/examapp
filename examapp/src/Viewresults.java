

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

/**
 * Servlet implementation class Viewresults
 */
@WebServlet(description = "to view the results of all the candidates.", urlPatterns = { "/Viewresults" })
public class Viewresults extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("viewresults servlet working");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String currentDate=dateFormat.format(date);
		//request.setAttribute("currentDate", date1);
		System.out.println("date is: "+currentDate);
		Connection con=null;
		Map<Integer, String> userMap = new HashMap<>();
		try {
			con=DB_utility.getDBConnection();
			PreparedStatement st=con.prepareStatement("select Exam_id,Exam from exam_schedule where `Start`<=?");
			st.setString(1, currentDate);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				int examId=rs.getInt("exam_id");
				String exam=rs.getString("exam");
				System.out.println("ExamID:"+examId+"exam:"+exam);
				userMap.put(examId,exam);
			}
			System.out.println("usermap: "+userMap);
			System.out.println("usermap size: "+userMap.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in fetching exam id and exam ");
			e.printStackTrace();
		}
		request.setAttribute("userMap", userMap);
		//int size=userMap.size();
		
//		for (int i = 1; i <=size; i++) {
//			System.out.println("key"+i+":"+userMap.get)
//		}
		RequestDispatcher rd = request.getRequestDispatcher("./viewresults.jsp");
        rd.forward(request, response);
	}

}
