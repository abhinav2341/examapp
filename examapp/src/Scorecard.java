

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;

@WebServlet(description = "servlet to fetch score card details", urlPatterns = { "/Scorecard" })
public class Scorecard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Score card servlet working");
		String examId=request.getParameter("select_exam");
		System.out.println("selected exam ID:"+examId);
		Connection con=null;
		Map<Integer, List<String>> userMap = new HashMap<>();
		try {
			con=DB_utility.getDBConnection();
			PreparedStatement st=con.prepareStatement("select score_card.U_id,marks_scored,max_marks,percentage,F_name,L_name from  score_card, user_details where user_details.U_id=score_card.U_id and exam_id=?");
			st.setString(1, examId);
			ResultSet rs =st.executeQuery();
			while(rs.next())
			{
				List<String> tempList = new ArrayList<>();
				int candidateId=rs.getInt("U_id");
				String percentage=rs.getString("percentage");
				String name=rs.getString("F_name")+" "+rs.getString("L_name");
				String marks=rs.getString("marks_scored");
				String maxMarks=rs.getString("max_marks");
				System.out.println("CAndidateId:"+candidateId+"NAME:"+name+"marks Scored:"+marks+"Max Marks:"+maxMarks+"percentage:"+percentage);
				tempList.add(name);
				tempList.add(marks);
				tempList.add(maxMarks);
				tempList.add(percentage);
				userMap.put(candidateId,tempList);
			}
			System.out.println("USERMAP:"+userMap);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in fetching score card");
			e.printStackTrace();
		}
		request.setAttribute("userMap", userMap);
		RequestDispatcher rd = request.getRequestDispatcher("./scorecard.jsp");
		rd.forward(request, response);
	}

}
