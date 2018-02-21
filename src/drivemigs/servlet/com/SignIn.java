package drivemigs.servlet.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_MAIL1 = "Trop court !";
	private static final String ERROR_MAIL2 = "Ne corresponde pas !";
	private static final String ERROR_MAIL3 = "Password vide";
	private static final String ERROR_MAIL4 = "Je sais pas regarde le code !";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
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
		// doGet(request, response);
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
