package ServePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatCancel
 */
@WebServlet("/PatCancel")
public class PatCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatCancel() {
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
		String identity=request.getParameter("pid");
		String aptnumber=request.getParameter("aptnumber");
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		try {
			int pid=Integer.parseInt(identity);
			int appno=Integer.parseInt(aptnumber);
			patient thepatient=new patient();
		boolean worx=	thepatient.deleteAppointment(pid, appno);
			if(worx==true) {
				out.println("<br> Appointment cancelled!<br> <a href=PatHome.jsp>Go Home</a>");

			}
			else {
				out.println("<br> Cannot cancel booking<br> <a href=PatHome.jsp>Go Home</a>");

			}
		}catch(Exception e) {
			out.println("<br> Unable to cancel booking<br> <a href=PatHome.jsp>Go Home</a>");

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
