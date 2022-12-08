package ServePack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocGetNursesWithClinicServ
 */
@WebServlet("/DocGetNursesWithClinicServ")
public class DocGetNursesWithClinicServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocGetNursesWithClinicServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<String> toSend=new ArrayList<String>();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String clinic_in=request.getParameter("ClinicName");
		String nurse_in=request.getParameter("NurseName");
		int nurseid=Integer.parseInt(nurse_in);
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");

			try {
			doctor doc=new doctor();
			boolean tryassign=doc.assignNurses(nurseid, clinic_in);
			//String rr=doc.assignNurses(nurseid, clinic_in);
			if(tryassign==true) {
				out.println("<div class=header>Assignment successful </div>");
				out.println("<br> Successful assignment for nurse id"+nurseid+" at clinic:"+clinic_in);
				out.println("<br> Successful Nurse Assignment<br> <a href=DocHome.jsp>Go Home</a>");

			}
			else {
			//	out.println(rr);
				out.println("<br> Unsuccessful Nurse Assignment<br> <a href=DocHome.jsp>Go Home</a>");

			}
			}catch (Exception e) {
				out.println("<br> Error Assigning Nurse<br> <a href=DocHome.jsp>Go Home</a>");
				
				
			}
			
			/*finally{
				
				request.setAttribute("Nurses", toSend);
				request.setAttribute("ClinicNameEntered", clinic_in);
				request.getRequestDispatcher("DocClins2.jsp").forward(request, response);
				//response.sendRedirect("PatHome.jsp");
			}*/
		
	
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
