

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Accountant1
 */
public class Accountant1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accountant1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String roll="Accountant";
		Connection con=DbConnection.connect();
		String s="select * from manager where email=? and pass=? and roll=?";
		try {
			PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(s);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			pstmt.setString(3, roll);
			ResultSet i=pstmt.executeQuery();
			if(i.next()){
				System.out.println("hello");
				response.sendRedirect("accountantdashbord.html");
				}
			else{
	
				response.sendRedirect("account.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
