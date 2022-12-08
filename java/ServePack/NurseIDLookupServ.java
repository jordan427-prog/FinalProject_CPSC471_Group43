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
 * Servlet implementation class NurseIDLookupServ
 */
@WebServlet("/NurseIDLookupServ")
public class NurseIDLookupServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurseIDLookupServ() {
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
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");

		try {
			String fn=request.getParameter("NFN").toString();
			String ln=request.getParameter("NLN").toString();
			out.println("<center>Found the ID for nurse"+fn+","+ln);
		doctor md=new doctor();
		ResultSet resultz=md.findID(fn,ln);
		if(resultz!=null) {
			if(resultz.next()) {
			
			int idiz=resultz.getInt(1);
			out.println("<center>Found the ID for nurse"+fn+","+ln);
			out.println("<br><br> ID is: "+idiz + "</center>");
			}
			else {
				out.println("Nurse Does not exist!");
			}
		}
		else {
			out.println("Nurse Does not exist!");
		}
		md.closeConn();
		out.println("<br><a href=DocHome.jsp>Back Home</a>");
		out.println("<br><a href=NurseIDLookup.html>Try New Search</a>");

		
		//out.println(md.findID(fn, ln));
		}catch(Exception e) {
			//out.println(e.getMessage());
			out.println("<br> Nurse Does Not Exist...Check Credentials<br> <a href=DocHome.jsp>Go Home</a>");
			out.println("<br><a href=NurseIDLookup.html>Try New Search</a>");

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
