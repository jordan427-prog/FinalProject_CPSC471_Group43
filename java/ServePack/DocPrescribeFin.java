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
 * Servlet implementation class DocPrescribeFin
 */
@WebServlet("/DocPrescribeFin")
public class DocPrescribeFin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocPrescribeFin() {
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
			HttpSession mysession=request.getSession();
			String req_user=Objects.toString(mysession.getAttribute("user"));
			String dName=request.getParameter("Drug_name");
			String prescrib=request.getParameter("Month");
			prescrib+="/";
			prescrib+=request.getParameter("Day");
			prescrib+="/";
			prescrib+=request.getParameter("Year");
			int pid=Integer.parseInt(request.getParameter("Pat_Name"));
			String docNotes=request.getParameter("DocNotes");
			String dose=request.getParameter("Dosage");
			doctor dr=new doctor();
			int did=dr.getdocID(req_user);
			if(did!=-1) {
				//fetched
				boolean prescribed=dr.docPrescribes(did, dName, req_user, prescrib, pid, docNotes, dose);
				if(prescribed==true) {
					out.println("<center><br>Successful Prescrption<br> "+"<br>Patient:"+pid+"<br> Drug: "+dName+" <br>Date:"+prescrib
							+"<br> Notes:"+docNotes+
							" <br>Dosage: "+dose + "</center>"
							+ "<br><a href=DocHome.jsp>Go Home</a>");

				}
				else {
					out.println("<br> Error prescribing <i>(possible duplicate request)</i><br> <a href=DocHome.jsp>Go Home</a>");

				}
			}
			else {
				//not fetched
				out.println("<br> Selected Patient unavailable for prescriptions<br> <a href=DocHome.jsp>Go Home</a>");

			}
		}catch(Exception e) {
			out.println("<br> Error fetching credentials<br> <a href=DocHome.jsp>Go Home</a>");

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
