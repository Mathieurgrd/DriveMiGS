package drivemigs.servlet.com;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import drivemigs.bean.com.UserBean;

/**
 * Servlet implementation class SignOut
 */
@WebServlet("/SignOut")
public class SignOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_PAGES_URL="/index.jsp";
	HashMap<String,UserBean> users = new HashMap<String,UserBean>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		 
		final HttpSession session = request.getSession();
		request.setAttribute("userStatus", false);
		request.setAttribute("errorStatus", true);
		users = (HashMap<String, UserBean>) session.getAttribute("users");
		UserBean user = (UserBean)session.getAttribute("user");
		if(users!=null && user != null) {
			users.remove(user.getEmailAdress());
			session.setAttribute("user",null);			
		}

		response.getWriter().append("Redirecting ...");
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
