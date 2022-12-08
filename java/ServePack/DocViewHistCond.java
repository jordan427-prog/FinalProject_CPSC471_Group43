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
 * Servlet implementation class DocViewHistCond
 */
@WebServlet("/DocViewHistCond")
public class DocViewHistCond extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocViewHistCond() {
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
		String option=request.getParameter("option");
		String pfn=request.getParameter("Fnamerecord");
		String lfn=request.getParameter("Lnamerecord");
		
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		try {
		if(option=="History"||option.equalsIgnoreCase("History")) {
			patient pa=new patient();
			int idto=pa.getPatientID(pfn, lfn);
			doctor don=new doctor();
			ResultSet result=don.viewHist(idto);
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>MedicalHistory<th></th>");
			while(result.next()) {
				String hist=result.getString(1);
				
				
			

				out.println("<tr><td><b>"
						+ hist + "</b></td></tr>");
				
			}
			//docmd.closeConn();
			out.println("</table>");
			don.closeConn();
			out.println("<br> <a href=DocHome.jsp>Back to Home</a>");
			
			
			
			
		}
		else if(option=="Conditions"||option.equalsIgnoreCase("Conditions")) {
			patient pa=new patient();
			int idto=pa.getPatientID(pfn, lfn);
			doctor don=new doctor();
			ResultSet result=don.getConditions(idto);
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>MedicalConditions<th></th>");
			while(result.next()) {
				String hist=result.getString(1);
				
				
			

				out.println("<tr><td><b>"
						+ hist + "</b></td></tr>");
				
			}
			//docmd.closeConn();
			out.println("</table>");
			don.closeConn();
			out.println("<br> <a href=DocHome.jsp>Back to Home</a>");
		}else {
		
		
		out.println("<br> Unsuccessful...Patient Name may not exist yet<br> <a href=DocHome.jsp>Go Home</a>");
		}
		
		}catch(Exception e) {
			out.println("<br> Unsuccessful...Patient Name may not exist<br> <a href=DocHome.jsp>Go Home</a>");

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
