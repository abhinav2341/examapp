

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
import java.util.*;
import java.util.Date;

import com.util.DB_utility;
/**
 * Servlet implementation class Scheduleexam
 */
@WebServlet(description = "servlet to populate candidates and dipatch addexam jsp", urlPatterns = { "/Scheduleexam" })
public class Scheduleexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Schedule exam servlet working....");
		Connection con = null;
		PreparedStatement ps = null;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1=dateFormat.format(date);
		request.setAttribute("currentDate", date1);
		System.out.println("date is: "+date1);
		
		Map<Integer, List<String>> userMap = new HashMap<>();
		try {
		con = DB_utility.getDBConnection();
		ps = con.prepareStatement("select * from user_details where Role_id='2' ");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		List<String> tempList = new ArrayList<>();
		int candidate_id = rs.getInt("U_id");
		String First_name = rs.getString("F_name");
		tempList.add(First_name);
		String lastName = rs.getString("L_name");
		tempList.add(lastName);
		long mobile = rs.getLong("Mobile");
		tempList.add("" + mobile);
		String email = rs.getString("Email");
		tempList.add(email);
//		String test_name = rs.getString("test_name");
//		tempList.add(test_name);
		 
		userMap.put(candidate_id, tempList);

		}
		System.out.println("User Map:" + userMap);
		rs.close(); 
		ps.close(); ps = null;
		con.close();con = null;	
		} catch(Exception e) {
		e.printStackTrace();
		} finally {

		}
		request.setAttribute("userMap", userMap);
		
		
		
		//population for sections
		Map<Integer, List<String>> userMap1 = new HashMap<>();
		try {
		con = DB_utility.getDBConnection();
		ps = con.prepareStatement("select * from section_table");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		List<String> tempList1 = new ArrayList<>();
		int section_id = rs.getInt("Section_id");
		String section = rs.getString("Section");
		tempList1.add(section);
		userMap1.put(section_id,tempList1);

		}
		System.out.println("SectionList:" + userMap1);
		rs.close(); 
		ps.close(); ps = null;
		con.close();con = null;	
		} catch(Exception e) {
		e.printStackTrace();
		} finally {

		}
		request.setAttribute("SectionList", userMap1);
		RequestDispatcher rd1 = request.getRequestDispatcher("./addexam.jsp");
		rd1.forward(request, response);
		
	}

}
