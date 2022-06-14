

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saleserver
 */
public class Saleserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saleserver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DbConnection.connect();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		System.out.println(email);
		System.out.println(pass);
		String s="select * from manager where email=? and pass=?";
		try {
			PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(s);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			System.out.println("hello");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				System.out.println("hello2");
				response.sendRedirect("salesdashbord.html");
				}
			else{
				System.out.println("print");
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
