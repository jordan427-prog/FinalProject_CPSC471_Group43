package ServePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientSearchServ
 */
@WebServlet("/PatientSearchServ")
public class PatientSearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientSearchServ() {
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
		String firstname=request.getParameter("potentialF");
		String lastname=request.getParameter("potentialL");
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		try {
			patient potential=new patient();
			int fetched_id=potential.getPatientID(firstname, lastname);
			if(fetched_id!=-1) {
				out.println("<br><center>Patient found!"+"<br>First Name: "+firstname+"<br>Last Name: "+lastname+"<br><b>ID: "+fetched_id+"</b></center>");

				out.println("<br>Go back home here:<br> <a href=DocHome.jsp>Go Home</a></center>");

			}
			else {
				out.println("<center><br>Patient Does Not Exist!<br> <a href=DocHome.jsp>Go Home</a></center>");

			}
		}catch(Exception e) {
			out.println("<center><br>Unable to find patient<br> <a href=DocHome.jsp>Go Home</a></center>");

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
