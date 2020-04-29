

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import com.util.DB_utility;

/**
 * Servlet implementation class Addquestion1
 */
@WebServlet(description = "servlet for populating sections in addquestions servlet", urlPatterns = { "/Addquestion1" })
public class Addquestion1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Addquestion1() {
        super();
        // TODO Auto-generated constructor stub
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	System.out.println("Add section to add question servlet working....");
	Connection con = null;
	PreparedStatement ps = null;
	
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
	} 
	request.setAttribute("SectionList", userMap1);
	RequestDispatcher rd1 = request.getRequestDispatcher("/addquestion.jsp");
	rd1.forward(request, response);
	}

	
}
