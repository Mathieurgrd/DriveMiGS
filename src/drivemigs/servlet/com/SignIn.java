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
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_PAGES_URL="/SignIn.jsp";
	//Redirection to the first user page
	private static final String VIEW_SUCCESS_URL="/index.jsp";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_PWD2 = "pwd2";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_FIRSTNAME = "firstname";
	public static final String ERROR_PWD1 = "Le mot de passe doit contenir au moins 8 caractères<br>";
	public static final String ERROR_PWD2 = "Erreur mot de passe";
	public static final String ERROR_PWD3 = "Merci d'indiquer le mot de passe<br>";
//	public static final String ERROR_PWD4 = "Le mot de passe est obligatoire<br>";
	public static final String ERROR_UN1 = "Le nom est trop court<br>";
	public static final String ERROR_UN2 = "Merci de renseigner ton nom<br>";
	public static final String ERROR_FN1 = "Le prénom est trop courts<br>";
	public static final String ERROR_FN2 = "Merci de renseigner ton prénom<br>";
	HashMap<String,UserBean> users = new HashMap<String,UserBean>();

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	*      response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("userStatus", false);
		request.setAttribute("errorStatus", true);
	
		response.getWriter().append("Redirecting ...");
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String pwd1 =request.getParameter(FIELD_PWD1);
		String eMail=request.getParameter(FIELD_EMAIL);
		String url;
		
		
		final HttpSession session = request.getSession();
		users = (HashMap<String, UserBean>) session.getAttribute("users");
		// faut-il récupérer une liste utilisateur? Quel est son format 
		HashMap<String,String> form = new HashMap<String, String>();
		HashMap<String,String> errors = new HashMap<String, String>();
		
		String actionMessage="";/**, url**/;
		int fail =0;		

		if(users.size()==0) {
			errors.put("noUser","Aucun utilisateur");
			request.setAttribute("errorStatus", true);
			url = VIEW_PAGES_URL;
		}else {
			String errorMail = validateEmail(eMail);
			if (errorMail!=null) {
				errors.put(FIELD_EMAIL,errorMail);
				fail++;			
			}
		
			String errorPwd = validatePwd(pwd1);
			if (errorPwd!=null) {
				errors.put(FIELD_PWD1,errorPwd);
				fail++;
			}
			
			if(fail==0) {
				//ADD USER TO DATABASE HERE//////
				//CHECK IF USER ALREADY EXISTS///
				//(HashMap<String, User>) session.getAttribute("users").put(user.getEmail(),user);
				UserBean user = users.get(eMail);
				if(user !=null) {
					if(user.getPassword().equals(pwd1)) {
						actionMessage="Succès de la connexion";
						user.setEmailAdress(eMail);
						user.setPassword(pwd1);
						request.setAttribute("user", user);
						request.setAttribute("userStatus", true);
						session.setAttribute("user",user);
						url = VIEW_SUCCESS_URL;
					}else {
						errors.put(FIELD_PWD1,"Mauvais mot de passe");
						actionMessage="Echec de l'authentification";
						request.setAttribute("errorStatus", true);
						url = VIEW_PAGES_URL;
					}
				} else {
					actionMessage="Echec de l'authentification";
					errors.put("noUser","Aucun compte");
					request.setAttribute("errorStatus", true);
					url = VIEW_PAGES_URL;
				}
				


			}else {
				actionMessage="Echec de l'authentification";
				request.setAttribute("errorStatus", true);
				url = VIEW_PAGES_URL;
			}
	
		}
		
	
				
		request.setAttribute("form", form);
		request.setAttribute("errors", errors);
		request.setAttribute("actionMessage", actionMessage);
		

		
		this.getServletContext().getRequestDispatcher(url).include(request, response);
	}

	private String validatePwd(String pwd1) {
		if (pwd1.trim().length() < 8) {
			return ERROR_PWD1;
		} 
			return null;					
	}

	private String validateEmail(String email) {
		if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			return ("Veuillez saisir une adresse mail valide<br>");
		}else {
			return null;			
		}

	}
	
}