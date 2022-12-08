package ServePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocDrugNowServ
 */
@WebServlet("/DocDrugNowServ")
public class DocDrugNowServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocDrugNowServ() {
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
			
			doctor docreque=new doctor();
			String requested=request.getParameter("RequestedDName");
			
			boolean itworked=docreque.insertDrug(requested);
			if(itworked==true) {
			out.println("<br> Successful...drug may now be prescribed <i>Take caution, However, as drug details must first be entered by notified pharmacist</i><br> <a href=DocHome.jsp>Go Home</a>");
			}
			else {
				out.println("<br> Unsuccessful, check the inventory first<br> <a href=DocHome.jsp>Go Home</a>");

			}
		}catch(Exception e) {
			out.println("<br> Unsuccessful...Check drug inventory first<br> <a href=DocHome.jsp>Go Home</a>");

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
