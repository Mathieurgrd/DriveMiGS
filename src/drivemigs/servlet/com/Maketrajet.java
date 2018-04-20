package drivemigs.servlet.com;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import drivemigs.bean.com.TrajetBean;
import drivemigs.bean.com.UserBean;

/**
 * Servlet implementation class Maketrajet
 */
@WebServlet("/Maketrajet")
public class Maketrajet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_PAGES_URL="/maketrajet.jsp";
	//Redirection to the first user page
	private static final String VIEW_INDEX_URL="/index.jsp";
	private String url ="";
	public static final String FIELD_DATE="dateDepart";
	public static final String FIELD_HOUR="wakeup";
	public static final String FIELD_ADDRESS="user_input_autocomplete_address";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Maketrajet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Redirecting ...");
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		url = VIEW_INDEX_URL;
		if(user!= null) {
			
			
			/**
			DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
			Date dateDep=new Date();
			try {
				dateDep = df.parse(request.getParameter(FIELD_DATE));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			**/
			String addressDepart= request.getParameter(FIELD_ADDRESS);
			String hour=request.getParameter(FIELD_HOUR);
			
			TrajetBean trajet = new TrajetBean(user,addressDepart,hour);
			if(addressDepart==""||hour=="") {
				request.setAttribute("trajetStatus",false);	
			}
			request.setAttribute("user",user);
			session.setAttribute("user",user);
			request.setAttribute("lastTrajet",trajet);	
			request.setAttribute("trajetStatus",true);	
			request.setAttribute("userStatus", true);
			
		}
		
		this.getServletContext().getRequestDispatcher(url).include(request, response);
		
		//doGet(request, response);
	}

}
