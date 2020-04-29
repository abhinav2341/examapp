

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.util.DB_utility;

@WebServlet(description = "servlet to fetch user details from DB", urlPatterns = { "/Viewregisteruser" })
public class Viewregisteruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("view register user working....");
		
		Connection con = null;
		PreparedStatement ps = null;
		Map<Integer, List<String>> userMap = new HashMap<>();
		List<String> tempList = null;
		try {
		con = DB_utility.getDBConnection();
		ps = con.prepareStatement("select user.U_ID, user.F_NAME, user.L_NAME, user.MObile, user.email, role.role_type from user_details user, role_master role where user.role_id = role.role_id;");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			tempList = new ArrayList<>();	
			int user_id = rs.getInt("U_id");
	//		tempList.add(""+user_id);
			String firstName = rs.getString("F_name");
			tempList.add(firstName);
			String lastName = rs.getString("L_name");
			tempList.add(lastName);
			String mobile = rs.getString("Mobile");
			tempList.add(mobile);
			String email = rs.getString("Email");
			tempList.add(email);
			String roleType = rs.getString("ROLE_TYPE");
			tempList.add(roleType);
			userMap.put(user_id, tempList);
		}
		System.out.println("User Map:" + userMap);
		rs.close(); 
		ps.close(); ps = null;
		con.close();con = null;	
		} catch(Exception e) {
			System.out.println("error in fetching records from user_details table");
		e.printStackTrace();
		} finally {

		}
		request.setAttribute("userMap", userMap);
		RequestDispatcher rd = request.getRequestDispatcher("./viewregisteruser.jsp");
		rd.forward(request, response);
	}
}