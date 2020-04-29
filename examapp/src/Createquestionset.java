

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;


/**
 * Servlet implementation class Createquestionset
 */
@WebServlet(description = "Servlet to create question set for each candidate", urlPatterns = { "/Createquestionset" })
public class Createquestionset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("create question set servlet working");
		int examId=(int)request.getAttribute("examId");
		System.out.println("examID: "+examId);
		Connection con=null;
		String sectionId="",questionPerSection="",competencyId="";
		int candidate;
		try {
			con=DB_utility.getDBConnection();

			PreparedStatement st=con.prepareStatement("select exam_schedule.Exam_id,test_mst.U_id,Section_id,Question_per_section,Competency_id from exam_schedule right join test_mst on exam_schedule.Exam_id=test_mst.Exam_id where exam_schedule.Exam_id=?");
			st.setInt(1, examId);
			ResultSet rs = st.executeQuery();
			while(rs.next()) 
			{
				sectionId=rs.getString("Section_id");
				questionPerSection=rs.getString("Question_per_section");
				competencyId=rs.getString("Competency_id");
				candidate=rs.getInt("U_id");
				
			System.out.println("section Id:"+sectionId+"question per section: "+questionPerSection+"competency: "+competencyId+"candidateId: "+candidate);
			List<String> sectionIdList = Arrays.asList(sectionId.split("\\$"));
			System.out.println("Section Id List:" + sectionIdList);
			//StringBuilder sections = new StringBuilder();
			
			List<String> quesPerSectionList = Arrays.asList(questionPerSection.split("\\$"));
			System.out.println("ques Per Section List:" + quesPerSectionList);
			//StringBuilder quesPerSections = new StringBuilder();
			for (int i = 1; i < sectionIdList.size(); i++) {
				String sectionID=sectionIdList.get(i);
				String Qps=quesPerSectionList.get(i);
				System.out.println("section ID"+i+"- "+sectionID+" question per section"+i+"- "+Qps);
				
				try {
					//select * from question_bank where section_id=1 order by rand() limit 3;
					PreparedStatement ps=con.prepareStatement("select * from question_bank where section_id=? order by rand() limit "+Qps);//+quesPerSectionList.get(i));
					ps.setString(1,sectionID);
					ResultSet rset = ps.executeQuery();
					while(rset.next())
					{
						int quesId=rset.getInt("Q_id");
						int sectId=rset.getInt("Section_id");
						String ques=rset.getString("Question");
						String op1=rset.getString("op_1");
						String op2=rset.getString("op_2");
						String op3=rset.getString("op_3");
						String op4=rset.getString("op_4");
						String correct=rset.getString("Correct");
						int difficultyId=rset.getInt("Competency_id");
						String remarks=rset.getString("remarks");
						System.out.println(quesId+" "+sectId+" "+ques+" "+op1+" "+op2+" "+op3+" "+op4+" "+correct+" "+difficultyId+" "+remarks);
						try {
							PreparedStatement psta=con.prepareStatement("insert into candidate_question(`U_id`,`Exam_id`,`Section_id`,`Q_id`,`Question`,`Op1`,`Op2`,`Op3`,`Op4`,`Correct`,`Competency_id`,`Remarks`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
							psta.setInt(1,candidate);
							psta.setInt(2,examId);
							psta.setString(3,sectionID);
							psta.setInt(4,quesId);
							psta.setString(5,ques);
							psta.setString(6,op1);
							psta.setString(7,op2);
							psta.setString(8,op3);
							psta.setString(9,op4);
							psta.setString(10,correct);
							psta.setString(11,competencyId);
							psta.setString(12,remarks);
							
							int k= psta.executeUpdate();
							if(k>0)
							{
								System.out.println(k+" rows inserted");
							}
							else {
								System.out.println("insert failed");
							}
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("insert query error");
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("error in fetching random question");
					e.printStackTrace();
				}
			}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in fetching exam details ");
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("./Admin_page.jsp");  
	    rd.forward(request, response);
	}

}
