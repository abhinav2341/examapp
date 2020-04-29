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

import com.util.*;
import java.util.*;
import java.util.Date;


@WebServlet(description = "store exam scheduled data in DB", urlPatterns = { "/Addexam" })
public class Addexam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("add exam servlet working");
		String exam=request.getParameter("exam");
		String start_date=request.getParameter("startDate");
		
		String duration=request.getParameter("duration");
		String desc=request.getParameter("description");
		String difficulty=request.getParameter("selectdifficulty");
		String section_ip="";
		String section_enc="$";
		String Ques_persection_ip="";
		String Ques_persection_enc="$";
		String query_validation="";
		int count=1;
		int total_sections;
		int marks=0;
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		String date1=dateFormat.format(date);
//		request.setAttribute("currentDate", date1);
//		System.out.println("date is: "+date1);
		
		while((request.getParameter("selectsection"+count)!=null)&&(request.getParameter("Question_per_section"+count)!=null))
		{
			section_ip=request.getParameter("selectsection"+count);
			Ques_persection_ip=request.getParameter("Question_per_section"+count);
			//System.out.println(section_ip);
			marks=marks+Integer.parseInt(Ques_persection_ip);
			section_enc=section_enc+section_ip+"$";
			Ques_persection_enc=Ques_persection_enc+Ques_persection_ip+"$";
			count=count+1;
		}
		total_sections=count-1;
		System.out.println("section enc -"+section_enc);
		System.out.println("Ques_persection_enc -"+Ques_persection_enc);
		System.out.println("no. of sections-"+total_sections);
		System.out.println("Exam - "+exam+"Date - "+start_date+" duration -"+duration+" difficulty -"+difficulty+" description -"+desc);
		
		Connection con=null;
		String query=null;
		
		try {
			//try block here
			con=DB_utility.getDBConnection();
			query_validation="select Start from `exam_schedule` where Exam=?";
			PreparedStatement st=con.prepareStatement(query_validation);
			st.setString(1, exam);
			ResultSet rs = st.executeQuery();

            if(rs.next()) {
				request.setAttribute("result", "Exam already Scheduled");
            }
            else {
					query="INSERT INTO `exam_schedule`(`Exam`,`Remarks_Q`,`Start`,`Time_duration`,`No_of_section`,`Section_id`,`Question_per_section`,`Competency_id`,`Max_marks`) VALUES (?,?,?,?,?,?,?,?,?)";
					System.out.println(query);
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setString(1, exam);
					stmt.setString(2, desc);
					stmt.setString(3, start_date);
					stmt.setString(4, duration);
					stmt.setInt(5, total_sections);
					stmt.setString(6, section_enc);
					stmt.setString(7, Ques_persection_enc);
					stmt.setString(8, difficulty);
					stmt.setInt(9, marks);
					int i=stmt.executeUpdate();
					System.out.println(i+":-rows affected");
					if(i!=0)
					{
						request.setAttribute("result", "submit successful");
					}
					else
					{
						System.out.println("insert failed");
					}
						con.close();
						st.close();
						rs.close();
            	}
            }
		catch (Exception e) {
			// TODO: handle exception.
			System.out.println(e);
		}
		String[] names = request.getParameterValues("candidate_id");
		List<String> candidiateIdlist = Arrays.asList(names);
		System.out.println("candidiateIdlist :"+candidiateIdlist);
		int examId=0;
		try {
			con=DB_utility.getDBConnection();
			PreparedStatement stm= con.prepareStatement("select `Exam_id` from `exam_schedule` where Exam=?");
			stm.setString(1, exam);
			ResultSet rs = stm.executeQuery();
			rs.next();
			examId=rs.getInt(1);
			
			try {
				//code to store data in test_mst
				int size = candidiateIdlist.size();
	             for(int i=0;i<size;i++)
	             {
	                 System.out.println(candidiateIdlist.get(i));
	                 stm=con.prepareStatement("insert into test_mst(Exam_id,U_id) values(?,?)");
	                 stm.setInt(1, examId);
	                 stm.setString(2, candidiateIdlist.get(i));
	                 int recordUpdate=stm.executeUpdate();
	                 if(recordUpdate>0){
	                	 System.out.println(recordUpdate+" record updated successfully");
	                 }else{
	                	 System.out.println("Some error in record updation");
	                 }
	             }
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}
			//code to fetch exam id 
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("examId", examId);
		RequestDispatcher rd=request.getRequestDispatcher("Createquestionset");  
	    rd.forward(request, response);
//		RequestDispatcher rd=request.getRequestDispatcher("./addexam.jsp");  
//	    rd.forward(request, response);
}
}
