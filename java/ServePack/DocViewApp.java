package ServePack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocViewApp
 */
@WebServlet("/DocViewApp")
public class DocViewApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocViewApp() {
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
		String identity=request.getParameter("identity");
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		try {
			doctor don=new doctor();
			int identity_id=don.getdocID(identity);
			ResultSet result=don.viewAppointmentDoc(identity_id);
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>Appointment Number</th><th>Appointment Type</th><th>Date</th><th>Patient ID</th>");
			while(result.next()) {
				String num=result.getString(1);
				String type=result.getString(2);
				String Date=result.getString(3);
				String patientid=result.getString(4);
				
				
			

				out.println("<tr><td><b>"
						+ num
						+"</td><td>"+type+"</td><td>"+Date+"</td><td>"
						+ patientid+"</b></td></tr>");
				
			}
			//docmd.closeConn();
			out.println("</table>");
			don.closeConn();
			out.println("<br> <a href=DocHome.jsp>Back to Home</a>");
		}catch(Exception e) {
			out.println("<br> Unable to Fetch Records (may not exist)<br> <a href=DocHome.jsp>Go Home</a>");

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
