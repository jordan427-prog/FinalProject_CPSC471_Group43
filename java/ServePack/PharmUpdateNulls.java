package ServePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PharmUpdateNulls
 */
@WebServlet("/PharmUpdateNulls")
public class PharmUpdateNulls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmUpdateNulls() {
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
		String drugname=request.getParameter("NullDrug");
		String companyname=request.getParameter("NullCompany");
		String effects=request.getParameter("NullEffects");
		
		
		

		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		try {
			pharmacist ph=new pharmacist();
			boolean live=ph.dataDrugs(drugname, effects, companyname);
			if(live==true) {
				out.println("<br> Drug Update Success. Changes should be reflected in your inventory!<br> <a href=PharmHome.jsp>Home</a>");

			}
			else {
				out.println("<br> Drug not null -> no need to update<br> <a href=PharmHome.jsp>Home</a>");

			}
		}catch(Exception e) {
			out.println("<br> Error updating drugs<br> <a href=PharmHome.jsp>Home</a>");

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
