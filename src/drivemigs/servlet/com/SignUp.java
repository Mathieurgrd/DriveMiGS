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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Back to sign Up because of a mistake
	private static final String VIEW_PAGES_URL="/SignUp.jsp";
	//Redirection to the first user page
	private static final String VIEW_SUCCESS_URL="/index.jsp";
	
	//private static final String VIEW_USERS_URL="/WEB-INF/users.jsp";
	
	public static final String FIELD_EMAIL="email";
	public static final String FIELD_PWD1="pwd1";
	public static final String FIELD_PWD2="pwd2";
	public static final String FIELD_NAME="name";
	public static final String FIELD_FIRSTNAME="firstname";
	public static final String FIELD_LOCATION="location";
	public static final String ERROR_PWD1="Le mot de passe doit contenir au moins 8 caractères<br>";
	public static final String ERROR_PWD2="Les 2 mots de passe ne sont pas les mêmes<br>";
	public static final String ERROR_PWD3="Merci de confirmer le mot de passe<br>";
	public static final String ERROR_PWD4="Le mot de passe est obligatoire<br>";
	public static final String ERROR_UN1="Le nom est trop court<br>";
	public static final String ERROR_UN2="Merci de renseigner ton nom<br>";
	public static final String ERROR_FN1="Le prénom est trop courts<br>";
	public static final String ERROR_FN2="Merci de renseigner ton prénom<br>";
	public static final String ERROR_MAIL1="L'adresse mail est obligatoire<br>";
	public static final String ERROR_MAIL2="Veuillez saisir une adresse mail valide<br>";
	HashMap<String,UserBean> users = new HashMap<String,UserBean>();
//	public HashMap<String,User> users = new HashMap<String,User>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("userStatus", false);
		request.setAttribute("errorStatus", true);
	
		response.getWriter().append("Redirecting ...");
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pwd1 =request.getParameter(FIELD_PWD1);
		String pwd2 =request.getParameter(FIELD_PWD2);
		String eMail=request.getParameter(FIELD_EMAIL);
		String name=request.getParameter(FIELD_NAME);
		String firstName= request.getParameter(FIELD_FIRSTNAME);
		String location = request.getParameter(FIELD_LOCATION);
		String userName = name+firstName;
		String url;
		
		final HttpSession session = request.getSession();
		// faut-il récupérer une liste utilisateur? Quel est son format 
		session.setAttribute("users",users);
		
		if(userName.equals(null)) {
			name=eMail;
		}
		HashMap<String,String> form = new HashMap<String, String>();
		HashMap<String,String> errors = new HashMap<String, String>();
		
		String actionMessage/**, url**/;
		int fail =0;

		

		String errorMail = validateEmail(eMail);
		if (errorMail!=null) {
			errors.put(FIELD_EMAIL,errorMail);
			fail++;			
		}
	
		String errorName = validateUserName(name);
		if(errorName!=null) {
			fail++;
			errors.put(name, errorName);
		}
		
		String errorFName = validateUserFN(firstName);
		if(errorFName !=null) {
			errors.put(firstName, errorFName);
			fail++;
		}
		
		String errorPwd = validatePwd(pwd1,pwd2);
		if (errorPwd!=null) {
			errors.put(FIELD_PWD1,errorPwd);
			fail++;
		}
		
		if(fail==0) {
			UserBean user = new UserBean(userName,pwd1,name,firstName,eMail,location);
			((HashMap<String, UserBean>) session.getAttribute("users")).put(eMail,user);
			request.setAttribute("users", users);
			request.setAttribute("user", user);
			actionMessage="Succès de l'inscription";
			request.setAttribute("userStatus", true);

			//ADD USER TO DATABASE HERE//////
			//CHECK IF USER ALREADY EXISTS///
			//(HashMap<String, User>) session.getAttribute("users").put(user.getEmail(),user);
			session.setAttribute("user",user);
			url = VIEW_SUCCESS_URL;

		}else {
			actionMessage="Echec de l'inscription";
			request.setAttribute("errorStatus", true);
			url = VIEW_PAGES_URL;
		}
		
		request.setAttribute("form", form);
		request.setAttribute("errors", errors);
		request.setAttribute("actionMessage", actionMessage);
		

		
		this.getServletContext().getRequestDispatcher(url).include(request, response);
	}
		
		
		private String validatePwd(String pwd1, String pwd2) {
			if(pwd1 != null && pwd1.trim().length() != 0) {
				if(pwd1.trim().length()<8) {
					return(ERROR_PWD1);
				}else if(pwd2 != null && pwd2.trim().length() != 0) {
						if(!pwd1.trim().equals(pwd2.trim())) {
							return(ERROR_PWD2);
						}else {
							return null;
						}
				}else {
					return ERROR_PWD3;
				}
			}else {	
				return ERROR_PWD4;
			}
		}
	
		
		private String validateEmail(String email) {
			if( email != null && email.trim().length()!=0) {
				if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
					return(ERROR_MAIL2);
				}else {
					return null;
				}
			} else { 
				return(ERROR_MAIL1);		

			}		
						
		}
		
		private String validateUserName(String name) {
			if(name != null && name.trim().length() != 0) {
				if(name.trim().length()<3) {
					return(ERROR_UN1);
				}else {
						return null;
				}
			}else {	


			}	
			return null; 
		}
	
		private String validateUserFN(String firstName) {
			if(firstName != null && firstName.trim().length() != 0) {
				if(firstName.trim().length()<3) {
					return(ERROR_FN1);
				}else {
						return null;
				}
			}else {	
				return ERROR_FN2;
			}		
		}
		
}





