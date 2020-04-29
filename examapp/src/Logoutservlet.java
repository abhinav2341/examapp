

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "servlet for session invalidation", urlPatterns = { "/Logoutservlet" })
public class Logoutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LOGOUT servlet working....");
		HttpSession session=request.getSession(false);
//		if(session !=null) {
//		System.out.println("ID:"+session.getAttribute("userId"));
//		}
		session.invalidate();
		
		request.getRequestDispatcher("./").forward(request, response);
		
		/*
		 if(session.getAttribute("Logged").equals("Yes")) {
		 session.setAttribute("Logged", "No"); session.invalidate();
		 request.getRequestDispatcher("./").forward(request, response); } else {
		 System.out.println("LOGIN first..");
		 request.getRequestDispatcher("./").forward(request, response); }
		*/
		
//		String Logged=session.getAttribute("Logged")!=null?(String)session.getAttribute("Logged"):"No"
//			if(name)
	}

}
