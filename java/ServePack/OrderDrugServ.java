package ServePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderDrugServ
 */
@WebServlet("/OrderDrugServ")
public class OrderDrugServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDrugServ() {
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
		String DName;
		String DSides;
		String DComp;
		Boolean result=false;
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		
		try {
			DName=request.getParameter("DrugName");
			DSides=request.getParameter("SideEffects");
			DComp=request.getParameter("DrugComp");
			
			pharmacist pharm=new pharmacist();
			result=pharm.orderDrug(DName, DSides, DComp);
			if(result==true) {
				out.println("<br><b>Successfully ordered drug" + DName + "</b><br>");
			}
			if(result==false) {
				out.println("<br><b>Unsuccessfully ordered drug" + DName + "</b><br>");

			}
		}catch(Exception e) {
			out.println("<br> Error ordering the drug!<br> <a href=OrderDrug.html>Try Again</a><a href=PharmHome.jsp>Back Home</a>");

		}
		
		out.println("<br> <a href=OrderDrug.html>New Order</a>");
		out.println("<br> <a href=PharmHome.jsp>Pharmacist Home</a>");
		out.println("<br> <a href=SearchDrug.html>New Drug Search</a>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
