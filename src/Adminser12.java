

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminser12
 */
public class Adminser12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminser12() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello man");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		Connection con=DbConnection.connect();
		String s="select * from admin where username=? and pass=? ";
		try {
			PreparedStatement pstmt= con.prepareStatement(s);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			
			ResultSet rt=pstmt.executeQuery();
			if(rt.next()){
				System.out.println("hello");
				response.sendRedirect("admindashbord.jsp");
				
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
