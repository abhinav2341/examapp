

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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


@WebServlet(description = "Servlet to show upcoming exam for students", urlPatterns = { "/viewexamSt" })
public class viewexamSt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Student view exam servlet working...");
		Connection con = null;
		PreparedStatement ps = null;
		String U_id=request.getParameter("userId");
		System.out.println("candidate ID="+U_id);
		Statement st2 = null;
		int count;
		Map<Integer, List<String>> userMap = new HashMap<>();
		try {
			con = DB_utility.getDBConnection();
			ps = con.prepareStatement("select exam_schedule.Exam_id,Exam,Section_id,Competency_id,Start,Time_duration,Max_marks,Remarks_Q from exam_schedule right join test_mst on exam_schedule.Exam_id = test_mst.Exam_id where test_mst.U_id= ?");
			ps.setString(1,U_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				List<String> tempList = new ArrayList<>();
				int examId = rs.getInt("Exam_id");
				
				String examName = rs.getString("Exam");
				tempList.add(examName);
				String secIds=rs.getString("Section_id");
				int length=secIds.length();
				
				System.out.println("length:"+length);
				System.out.println("SectionID enc:"+secIds);
				//String ques_persection = rs.getString("Question_per_section");
				
				List<String> sectionIdList = Arrays.asList(secIds.split("\\$"));
				//List<String> quesPerSectionList = Arrays.asList(ques_persection.split("\\$"));

				System.out.println("Section Id List:" + sectionIdList);
//				System.out.println("ques Per Section List:" + quesPerSectionList);
				//for loop code
				StringBuilder sections = new StringBuilder();
				/*
				 * StringBuilder quesPerSections = new StringBuilder();
				 * 
				 * for(String quesPerSection : quesPerSectionList) { if(quesPerSection != null
				 * && quesPerSection.trim().length() > 0) {
				 * quesPerSections.append(quesPerSection+" "); } }
				 * System.out.println("Question per section:-"+quesPerSections);
				 * tempList.add(quesPerSections.toString());
				 */
				for(String sectionId : sectionIdList) {
					if(sectionId != null && sectionId.trim().length() > 0) {
						String query="Select Section from section_table where Section_id="+sectionId;
						Statement st = null;
						try {
							st=con.createStatement();
							ResultSet rset =st.executeQuery(query);
							if(rset.next()) {
								sections.append(" "+rset.getString(1));
							}
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("error in query 1");
							e.printStackTrace();
						}
					}
				}//End For Loop
				System.out.println("Section name :-"+sections);
				tempList.add(sections.toString());//adding sections after processing section id
				int difficulty_id = rs.getInt("Competency_id");
				String difficulty="";
				//difficulty logic here
				try {
					String query2="Select Competency from competency_table where Competency_id=\""+difficulty_id+"\"";
					st2=con.createStatement();
					ResultSet RS_2 =st2.executeQuery(query2);
					RS_2.next();
					difficulty=RS_2.getString("Competency");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("error in query 2");
					e.printStackTrace();
				}
				tempList.add(difficulty);
				String date = rs.getString("Start");
				tempList.add(date);
				String duration = rs.getString("Time_duration");
				tempList.add(duration);
				/*int no_of_section=rs.getInt("No_of_section");
				tempList.add(""+no_of_section);//add after converting to string
				String ques_persection = rs.getString("Question_per_section");
				System.out.println("ques Per Section enc:" + ques_persection);
				List<String> quesPerSectionList = Arrays.asList(ques_persection.split("\\$"));
				System.out.println("ques Per Section List:" + quesPerSectionList);
				StringBuilder quesPerSections = new StringBuilder();
				int i=1;
				for(String quesPerSection : quesPerSectionList) {
					if(quesPerSection != null && quesPerSection.trim().length() > 0) {
						quesPerSections.append("Section"+i+": "+quesPerSection+" ");
						i++;
					}
				}
				System.out.println("Question per section:-"+quesPerSections);
				tempList.add(quesPerSections.toString());*/
				int max = rs.getInt("Max_marks");
				tempList.add(""+max);
				String remarks = rs.getString("Remarks_Q");
				tempList.add(remarks != "" ? remarks : "N/A");
				userMap.put(examId, tempList);
			}
			//System.out.println("User Map:" + userMap);
			rs.close(); 
			ps.close(); ps = null;
			con.close();con = null;		
		} catch(Exception e) {
			System.out.println("err in outermost query");
			e.printStackTrace();
		}
		System.out.println("User Map:" + userMap);
		request.setAttribute("userMap", userMap);

		RequestDispatcher rd = request.getRequestDispatcher("./viewexamSt.jsp");
		rd.forward(request, response);	
	}

}
