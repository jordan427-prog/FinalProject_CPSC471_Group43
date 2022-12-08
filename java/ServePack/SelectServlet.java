package ServePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	PrintWriter outgoing = null;
	
	
	response.setContentType("text/html");
	
	String selected="temp";
	
	try {
		//response.sendRedirect(url)
		outgoing=response.getWriter();
		
		
		
		selected=request.getParameter("Role");

		
		
		
	}catch(Exception e) {
		outgoing.println("Error: " + e.getMessage());
	} 
	finally {
		HttpSession mysession=request.getSession();
		
		mysession.setAttribute("Role", selected);
		
		if(selected=="Pharmacist"|| selected.equalsIgnoreCase("Pharmacist")) {
			response.sendRedirect("registration.html");
		}
		else if(selected=="Doctor"||selected.equalsIgnoreCase("Doctor")) {
			response.sendRedirect("docRegistration.html");
		}
		else if(selected=="Patient"||selected.equalsIgnoreCase("Patient")) {
			response.sendRedirect("patientRegistration.html");
		}
		else if(selected=="Nurse" || selected.equalsIgnoreCase("Nurse"))
		{
			response.sendRedirect("nurseRegistration.html");
		}
		else {
			response.sendRedirect("HomePage.html");
		}
		
		//response.sendRedirect("PharmHome.jsp");
	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
