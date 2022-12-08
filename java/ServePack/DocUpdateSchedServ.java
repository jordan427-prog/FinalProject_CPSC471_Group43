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
 * Servlet implementation class DocUpdateSchedServ
 */
@WebServlet("/DocUpdateSchedServ")
public class DocUpdateSchedServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocUpdateSchedServ() {
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
		int doc_hours=Integer.parseInt(request.getParameter("DocHours"));
		String doc_days=request.getParameter("DocDays");
		String doc_vac=request.getParameter("DocVac");
		HttpSession mysession=request.getSession();
		String usename=Objects.toString(mysession.getAttribute("user"));

		
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		doctor doc=new doctor();
		try {
		Boolean updated=doc.updateSchedule(usename, doc_hours, doc_vac, doc_days);
		if(updated==true) {
			out.println("Updated schedule!<br> <a href=DocHome.jsp>Home</a>");
		}
		else {
			out.println("DID NOT Update schedule!<br> <a href=DocHome.jsp>Home</a>");

		}
		} catch(Exception e) {
			out.println("Error updating Schedule<br> <a href=DocHome.jsp>Home</a>");
		}
		
		//ResultSet result = nur.getSchedule(username_in);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
