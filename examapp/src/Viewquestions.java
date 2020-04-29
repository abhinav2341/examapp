

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import java.sql.*;

import com.util.DB_utility;

@WebServlet(description = "servlet to fetch question bank details from DB", urlPatterns = { "/Viewquestions" })
public class Viewquestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("View Question Servlet working....");
		Connection con = null;
		PreparedStatement ps = null;
		Map<Integer, List<String>> userMap = new HashMap<>();
		try {
			con = DB_utility.getDBConnection();
			ps = con.prepareStatement("select `Q_id`,`Section_id`,`Question`,`op_1`,`op_2`,`op_3`,`op_4`,`Correct`,`Remarks`from question_bank");
			ResultSet rs = ps.executeQuery();
			Integer quesId=null;
			List<String> dataList=null;
			//List<String> dataList1=null;
			while(rs.next()) {
					quesId = rs.getInt("Q_id");
					dataList = new ArrayList<>();
					int secId=rs.getInt("Section_id");
					try {
						PreparedStatement pStm=con.prepareStatement("select `section` from section_table where section_id=?");
						pStm.setInt(1, secId);
						ResultSet rSet=pStm.executeQuery();
						rSet.next();
						dataList.add(""+rSet.getString(1));
					} catch (Exception e) {
						// TODO: handle exception
					}
					String question = rs.getString("Question");
					dataList.add(question);
					String op1 = rs.getString("op_1");
					dataList.add(op1);
					String op2 = rs.getString("op_2");
					dataList.add(op2);
					String op3 = rs.getString("op_3");
					dataList.add(op3);
					String op4 = rs.getString("op_4");
					dataList.add(op4);
					String remarks = rs.getString("Remarks");
					dataList.add(remarks != null ? remarks : "N/A");
					userMap.put(quesId, dataList);
				}	
			
			
			System.out.println("User Map:" + userMap);
			rs.close(); 
			ps.close(); ps = null;
			con.close();con = null;		
			} 
		catch(Exception e) {
			System.out.println("Query not working");
			e.printStackTrace();
		} finally {
			
		}
		
		request.setAttribute("userMap", userMap);
		RequestDispatcher rd = request.getRequestDispatcher("./editquestion.jsp");
		rd.forward(request, response);
		
	}

}
