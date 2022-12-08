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
 * Servlet implementation class DocGetSchedule
 */
@WebServlet("/DocGetSchedule")
public class DocGetSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocGetSchedule() {
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
		
		doctor doc=new doctor();
		
		
		ResultSet result = doc.getSchedule(username_in);
		out.println("<table border=1 width=50% height=50%>");
		out.println("<tr><th>FirstName,LastName<th>clinic<th>Hours</th><th>VacationDays</th><th>Days</th>");
		try {
		while(result.next()) {
			String name=result.getString(1);
			name+=",";
			name+=result.getString(2);
			String clin=result.getString(3);
//	String =result.getString(3);
			String hour=result.getString(4);
			String vacdays=result.getString(5);
			String days=result.getString(6);

			out.println("<tr><td><b>"
					+ name + "</b></td>"+
					"<td>" + clin + "</td>"+
					"<td>" + hour +"</td><td>"
					+ vacdays + "</td><td>"+ days
					
					+"</td></tr>");
		}
		out.println("</table>");
		doc.closeConn();
		out.println("<br> <a href=DocHome.jsp>Back to Home</a>");
		}catch(Exception e) {
		//.println("<br> Error finding Schedule<br> <a href=NurHome.jsp>Home</a>");
		//ut.println(e.getMessage());
			out.println("Error finding Schedule<br> <a href=DocHome.jsp>Home</a>");
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
