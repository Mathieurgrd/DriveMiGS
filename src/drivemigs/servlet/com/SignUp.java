package drivemigs.servlet.com;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import mfont.usermanager.com.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String VIEW_PAGES_URL="/WEB-INF/view/registration.jsp";
	//private static final String VIEW_USERS_URL="/WEB-INF/users.jsp";
	
	public static final String FIELD_EMAIL="email";
	public static final String FIELD_PWD1="pwd1";
	public static final String FIELD_PWD2="pwd2";
	public static final String FIELD_NAME="prenom";
	public static final String ERROR_MAIL1="Le mot de passe doit contenir au moins 8 caractères<br>";
	public static final String ERROR_MAIL2="Les 2 mots de passe ne sont pas les mêmes<br>";
	public static final String ERROR_MAIL3="Merci de confirmer le mot de passe<br>";
	public static final String ERROR_MAIL4="Le mot de passe est obligatoire<br>";
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}
		
		private String validatePwd(String pwd1, String pwd2) {
			if(pwd1 != null && pwd1.trim().length() != 0) {
				if(pwd1.trim().length()<8) {
					return(ERROR_MAIL1);
				}else if(pwd2 != null && pwd2.trim().length() != 0) {
						if(!pwd1.trim().equals(pwd2.trim())) {
							return(ERROR_MAIL2);
						}else {
							return null;
						}
				}else {
					return ERROR_MAIL3;
				}
			}else {	
				return ERROR_MAIL4;
			}
		}
	
		
		private String validateEmail(String email) {
			if( email != null && email.trim().length()!=0) {
				if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
					return("Veuillez saisir une adresse mail valide<br>");
				}else {
					return null;
				}
			} else { 
				return("L'adresse mail est obligatoire<br>");		
			}		

	}

}



