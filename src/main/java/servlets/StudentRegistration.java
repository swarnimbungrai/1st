package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import databases.StudentDao;
@WebServlet("/registration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {          //service method gets req/res from frontend
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String studentID = request.getParameter("stdId");
		String name = request.getParameter("stdName");
		String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        
        System.out.println(studentID+name+gender+password);
        System.out.println("Successful");
       
       
	
        StudentDao sDao = new StudentDao();
        sDao.studentRegister(studentID, name, gender, password, response);
       
        
        
        response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       out.print(studentID);
       out.print(name);
       out.print(gender);
       out.print(password);
	}  
       
}
	

