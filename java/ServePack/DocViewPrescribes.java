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
 * Servlet implementation class DocViewPrescribes
 */
@WebServlet("/DocViewPrescribes")
public class DocViewPrescribes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocViewPrescribes() {
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
		//String md_in=request.getParameter("docuser");	
		HttpSession md_mysession=request.getSession();
		String md_in=Objects.toString(md_mysession.getAttribute("user"));
		String pat_fname=request.getParameter("FNameReq");
		String pat_lname=request.getParameter("LNameReq");
		

		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		try {
			
			doctor docmd=new doctor();
			patient temp=new patient();
			int pat_id=temp.getPatientID(pat_fname, pat_lname);
			if(pat_id!=-1) {
				//success
				ResultSet rezmd=docmd.viewPrescriptions(pat_id, md_in);
				
				if(rezmd!=null) {
					
					out.println("<table border=1 width=50% height=50%>");
					out.println("<tr><th>Drug Name<th>Prescribed Date<th>Doctor Notes</th><th>Dosage</th>");
					while(rezmd.next()) {
						String mdd_name=rezmd.getString(1);
						String mdpdate=rezmd.getString(2);
						String mddocnotes=rezmd.getString(3);
						String mddose=rezmd.getString(4);
						
					

						out.println("<tr><td><b>"
								+ mdd_name + "</b></td>"+
								"<td>" + mdpdate + "</td>"+
								"<td>" + mddocnotes +"</td><td>"
								+ mddose 
								+"</td></tr>");
						
					}
					docmd.closeConn();
					out.println("</table>");
					out.println("<br> <a href=DocHome.jsp>Back to Home</a>");
			}
			else {
				//unsuccessful
				out.println("Patient not Found, Try Again<br> <a href=DocHome.jsp>Home</a>");
			}
			//int docmd_id=docmd.pgetID(user_inmd);
			//ResultSet rezmd=docmd.viewPrescriptions(pat_id_in,md_in);
			//to be continued...
			
				
				
				
				
			}
			else {
				//out.println("No Prescriptions found<br> <a href=PatHome.jsp>Home</a>");
				out.println("Sorry, this patient does not exist<br> <a href=DocHome.jsp>Home</a>");

			}
			
		}catch(Exception e) {
			//out.println("No Prescriptions found<br> <a href=PatHome.jsp>Home</a>");
			out.println("Not Found! Check that credentials entered are correct (May not exist)<br> <a href=DocHome.jsp>Home</a>");


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
