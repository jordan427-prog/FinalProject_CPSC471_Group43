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
 * Servlet implementation class NurGetClinicServ
 */
@WebServlet("/NurGetClinicServ")
public class NurGetClinicServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurGetClinicServ() {
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
		String username_in=request.getParameter("param");
		
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		nurse nur=new nurse();
		
		out.println("<b>Below is the clinic assigned to username: " + username_in+"in our system</b><br><br>");
		ResultSet result = nur.getClinic(username_in);
		out.println("<table border=1 width=50% height=50%>");
		out.println("<tr><th>Address<th>Email<th>Phone</th><th>Name</th>");
		try {
		while(result.next()) {
			String addr=result.getString(1);
			
			String mail=result.getString(2);
//	String =result.getString(3);
			String pho=result.getString(3);
			String name=result.getString(4);
			//String days=result.getString(6);

			out.println("<tr><td><b>"
					+ addr + "</b></td>"+
					"<td>" + mail + "</td>"+
					"<td>" + pho +"</td><td>"
					+ name + "</td><td></tr>");
		}
		out.println("</table>");
		nur.closeConn();
		out.println("<br> <a href=NurHome.jsp>Back to Home</a>");
		}catch(Exception e) {
		//.println("<br> Error finding Schedule<br> <a href=NurHome.jsp>Home</a>");
		//ut.println(e.getMessage());
			out.println("Error finding Clinic<br> <a href=NurHome.jsp>Home</a>");
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
