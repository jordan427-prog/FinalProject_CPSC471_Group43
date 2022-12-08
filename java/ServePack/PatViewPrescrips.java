package ServePack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PatViewPrescrips
 */
@WebServlet("/PatViewPrescrips")
public class PatViewPrescrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatViewPrescrips() {
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
		String user_in=request.getParameter("param");	
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		try {
			patient pat=new patient();
			int pat_id=pat.pgetID(user_in);
			ResultSet rez=pat.viewPrescriptions(pat_id);
			if(rez!=null) {
				
				out.println("<table border=1 width=50% height=50%>");
				out.println("<tr><th>Drug Name<th>Prescribed Date<th>Doctor Notes</th><th>Dosage</th>");
				while(rez.next()) {
					String d_name=rez.getString(1);
					String pdate=rez.getString(2);
					String docnotes=rez.getString(3);
					String dose=rez.getString(4);
					
				

					out.println("<tr><td><b>"
							+ d_name + "</b></td>"+
							"<td>" + pdate + "</td>"+
							"<td>" + docnotes +"</td><td>"
							+ dose 
							+"</td></tr>");
					
				}
				pat.closeConn();
				out.println("</table>");
				out.println("<br> <a href=PatHome.jsp>Back to Home</a>");
				//out.println("<br><b>"+pat_id +"</b>");
				
				
				
			}
			else {
				out.println("No Prescriptions found<br> <a href=PatHome.jsp>Home</a>");

			}
			
		}catch(Exception e) {
			out.println("No Prescriptions found<br> <a href=PatHome.jsp>Home</a>");

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
