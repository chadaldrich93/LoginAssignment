import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ArrayList<String> users = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	
    public LoginServlet() {
        super();
        addUserNames();
        addPasswords();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	                                                                                      IOException {
		   response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		    String username=request.getParameter("username");  
		    String password=request.getParameter("password");  
		    if(validate(username, password)){  
		        RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("input.html");  
		        rd.include(request,response);  
		    }         
		    out.close();  
	}
	
	private boolean validate(String username, String password){
		boolean validated = false;
		int index = -1;
        int runningIndex = 0;
		for (String s : users) {
			if (s.equals(username)) {
				index = runningIndex;
			}
			runningIndex++;
		}
		if (index != -1) {
			if (passwords.get(index).equals(password)) {
				validated = true;
			}
		}
	    return validated;
    }
	
	private void addUserNames() {
		users.add("Jeff");
	}
    
	private void addPasswords() {
		passwords.add("Blue");
	}
}
