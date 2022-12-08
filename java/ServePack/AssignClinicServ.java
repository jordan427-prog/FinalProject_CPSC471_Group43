package ServePack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AssignClinicServ
 */
@WebServlet("/AssignClinicServ")
public class AssignClinicServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignClinicServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		nurse nur=new nurse();
		Boolean result=false;
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		
		try {
			String clinic=request.getParameter("ClinicName");
			HttpSession mysession=request.getSession();
			String usename=Objects.toString(mysession.getAttribute("user"));
			
			result=nur.AssignClinic(usename, clinic);
			if(result==true) {
				out.println("<br><b>Successfully assigned clinic: " +clinic + "To your profile!</b><br>");
			}
			if(result==false) {
				out.println("<br><b>Unsuccessfully assigned clinic: " + clinic + "To your profile</b><br><b>Clinic does not exist!</b>");

			}
			
		}catch(Exception e) {
			out.println("<br> Error Assigning Clinic!<br> <a href=AssignClinic.html>Try Again</a><a href=NurHome.jsp>Back Home</a>");

		}
		out.println("<br> <a href=AssignClinic.html>New Assignment</a>");
		out.println("<br> <a href=NurHome.jsp>Nurse Home</a>");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
