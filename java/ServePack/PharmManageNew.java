package ServePack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PharmManageNew
 */
@WebServlet("/PharmManageNew")
public class PharmManageNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmManageNew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<String> toSend=new ArrayList<String>();
		

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<style type=text/css> body{ background-color:#D2BD96;} </style> ");
		try {
			pharmacist pharm=new pharmacist();
			ResultSet nulls=pharm.getNullDrugs();
			if(nulls!=null) {
				while(nulls.next()) {
					toSend.add(nulls.getString(1));
				}
				pharm.closeConn();
				request.setAttribute("NullDrugs", toSend);
				

				request.getRequestDispatcher("FixDrugs.jsp").forward(request, response);
			}else {
				out.println("<br> Error finding drugs<br> <a href=PharmHome.jsp>Go Home</a>");

			}
		}catch(Exception e) {
			out.println("<br> Error finding drugs<br> <a href=PharmHome.jsp>Go Home</a>");

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
