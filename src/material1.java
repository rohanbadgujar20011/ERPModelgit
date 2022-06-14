

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
 * Servlet implementation class material1
 */
public class material1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public material1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mq=Integer.parseInt(request.getParameter("mq"));
		String mname=request.getParameter("mname");
		String roll=request.getParameter("Roll");
		int mqq=Integer.parseInt(request.getParameter("mqq"));
		Connection con=DbConnection.connect();
		String s="insert into mate values(?,?,?,?)";
		try {
			PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(s);
			pstmt.setString(1, mname);
			pstmt.setInt(2, mq);
			pstmt.setString(3, roll);
			pstmt.setInt(4, mqq);
			int i=pstmt.executeUpdate();
			if(i>0){
				System.out.println("hello");
				response.sendRedirect("managerdashbord.html");
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
