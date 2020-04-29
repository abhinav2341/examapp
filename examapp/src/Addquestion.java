

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB_utility;
import java.util.*;

@WebServlet(description = "Add question to Database", urlPatterns = { "/Addquestion" })
public class Addquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("ADD question servlet working");
    	String section_ip="";
    	String Ques_ip="";
    	String[] option_ip = new String[10]; 
    	String correctOp_ip="";
    	String remarks="";
    	String difficulty="";
    	Connection con=null;
    	String query="";
    	int k;
    	int qId=0;
    
    
    	difficulty=request.getParameter("selectdifficulty");
    	remarks=request.getParameter("description");
    	System.out.println("remarks- "+remarks);
    	section_ip=request.getParameter("select_section");
    	Ques_ip=request.getParameter("Question_ip");
    	for(k=0;k<4;k++)
    	{
    		option_ip[k]=request.getParameter("option_ip"+(k+1));
    		System.out.println(option_ip[k]);
    	}
    	
    	
    	correctOp_ip=request.getParameter("radios");
    	
    	
    	System.out.println("section- "+section_ip+"question-"+Ques_ip+" option1- "+option_ip[0]+" option2- "+option_ip[1]+" option3- "+option_ip[2]+" option4- "+option_ip[3]+" correct option- "+correctOp_ip);
    	try {
			//try block here
			con=DB_utility.getDBConnection();
			query="INSERT INTO `question_bank`(`Q_id`,`Section_id`,`Question`,`op_1`,`op_2`,`op_3`,`op_4`,`Correct`,`Competency_id`,`Remarks`) VALUES (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, qId);
			st.setString(2, section_ip);
			st.setString(3, Ques_ip);
			for(k=0;k<4;k++)
	    	{
	    		st.setString((k+4), option_ip[k]);
	    	}
			st.setString(8, correctOp_ip);
			st.setString(9, difficulty);
			if(remarks!="") {
				st.setString(10, remarks);
				}
			else {
				st.setString(10, "N/A");
			}
			int i=st.executeUpdate();
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
            }
		catch (Exception e) {
			// TODO: handle exception.
			System.out.println(e);
		}
    	
    	RequestDispatcher rd=request.getRequestDispatcher("./Admin_page.jsp");  
	    rd.forward(request, response);
	}

}
