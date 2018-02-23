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
 * Servlet implementation class Update
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Back to sign Up because of a mistake
	private static final String VIEW_PAGES_URL="/userMgt.jsp";
	//Redirection to the first user page
	private static final String VIEW_BACK_URL="/index.jsp";
	
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
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url1;
		final HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		if(user!=null) {
			url1=VIEW_PAGES_URL;
		}else {
			url1=VIEW_BACK_URL;
		}
		
		response.getWriter().append("Redirecting ...");
		this.getServletContext().getRequestDispatcher(url1).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
		HashMap<String,String> errors = new HashMap<String, String>();
		UserBean user = (UserBean) session.getAttribute("user");
		String oldEmail = user.getEmailAdress();
		String pwd1 =request.getParameter(FIELD_PWD1);
		String pwd2 =request.getParameter(FIELD_PWD2);
		String eMail=request.getParameter(FIELD_EMAIL);
		String name=request.getParameter(FIELD_NAME);
		String firstName= request.getParameter(FIELD_FIRSTNAME);
		String location = request.getParameter(FIELD_LOCATION);
		String userName = name+firstName;
		String url;
		String actionMessage;
		int fail=0;
		int changes=0;
		int key=0;
		


		// faut-il récupérer une liste utilisateur? Quel est son format 
		
	
		
		if(!eMail.equals("")) {
			String errorMail = validateEmail(eMail);
			if (errorMail!=null) {
				errors.put(FIELD_EMAIL,errorMail);
				fail++;			
			}else {
				changes++;
				key++;
			}
		}
		
		if(!pwd1.equals("")) {
			String errorPwd = validatePwd(pwd1,pwd2);
			if(errorPwd!=null){
				errors.put(FIELD_PWD1,errorPwd);
				fail++;
			}else {
				changes++;
				if(key==0) {
					((HashMap<String, UserBean>) session.getAttribute("users")).get(oldEmail).setPassword(pwd1);
				}
			}
		}else{
			pwd1=user.getPassword();
		}
		
		if(!name.equals("")) {
			changes++;
			if(	key==0) {
				((HashMap<String, UserBean>) session.getAttribute("users")).get(oldEmail).setName(name);	
			}
		}else {
			name=user.getName();
		}
		
		if(!firstName.equals("")) {
			changes++;
			if(	key==0) {
				((HashMap<String, UserBean>) session.getAttribute("users")).get(oldEmail).setFirstName(firstName);	
			}
		}else {
			firstName=user.getFirstName();
		}
		if(!location.equals("")) {
				changes++;
				if(	key==0) {
					((HashMap<String, UserBean>) session.getAttribute("users")).get(oldEmail).setLocation(location);	
				}
		}else {
			location = user.getLocation();
		}
	
			
		if(fail==0) {
			if(key>0) {
				UserBean newUser = new UserBean(firstName+name,pwd1,name, firstName,eMail,location);
				((HashMap<String, UserBean>) session.getAttribute("users")).put(eMail,newUser);
				((HashMap<String, UserBean>) session.getAttribute("users")).remove(oldEmail);			
				request.setAttribute("users", users);
				request.setAttribute("user", user);
				request.setAttribute("userStatus", true);

				//ADD USER TO DATABASE HERE//////
				//CHECK IF USER ALREADY EXISTS///
				//(HashMap<String, User>) session.getAttribute("users").put(user.getEmail(),user);
				session.setAttribute("user",newUser);					
			}
			url = VIEW_BACK_URL;
			actionMessage="Succès des changements";

		}else {
			actionMessage="Echec des modifications";
			request.setAttribute("errorStatus", true);
			url = VIEW_PAGES_URL;
		}
		
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
		if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
			return(ERROR_MAIL2);
		}else {
			return null;
		}
	} 		
	
	
	

}
