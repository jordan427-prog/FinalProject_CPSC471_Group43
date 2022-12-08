package ServePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocInsertCondServ
 */
@WebServlet("/DocInsertCondServ")
public class DocInsertCondServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocInsertCondServ() {
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
		String fnamein=request.getParameter("Fnameinsert");
		String lnamein=request.getParameter("Lnameinsert");
		String stufftoadd=request.getParameter("history");
		
		
		

		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		try {
			patient under_examination=new patient();
			int id_examine=under_examination.getPatientID(fnamein, lnamein);
			doctor examining=new doctor();
			boolean truth=examining.insertConditions(id_examine, stufftoadd);
			if(truth==true) {
				out.println("<br> Success!<br> <a href=DocHome.jsp>Go Home</a>");

			}
			else {
				out.println("<br> Unsuccessful...Patient Name may not exist yet<br> <a href=DocHome.jsp>Go Home</a>");

			}
		}
		catch(Exception e) {
			out.println("<br> Unsuccessful...patient may not exist<br> <a href=DocHome.jsp>Go Home</a>");

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
