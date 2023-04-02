package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;

public class StudentDao {
	
	public void studentRegister(String studentID, String name, String gender, String password, HttpServletResponse res ) throws IOException {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");                                                                    //registering sql connector in driver manager(javaside code) so that it can work
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");//1
			String query = "insert into student_registration values(?,?,?,?)";
			PreparedStatement pst =  con.prepareStatement(query);   //executes query //2
			pst.setString(1,studentID); 
			pst.setString(2,name); 
			pst.setString(3,gender); 
			pst.setString(4,password);
		    pst.executeUpdate(); //3 me
		    
			System.out.println("Data has been inserted");
			res.sendRedirect("successful.html");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.sendRedirect("problem.html");
		}  
		
	}
} 
