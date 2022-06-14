

import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Accountser1
 */
public class Accountser1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accountser1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=(Connection) DbConnection.connect();
		String ename=request.getParameter("ename");
		int eid=0;
		String eage=request.getParameter("eage");
		String enu =request.getParameter("enum");
		int esal=Integer.parseInt(request.getParameter("esal"));
		String s="insert into empl values(?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) con.prepareStatement(s);
			pst.setString(1, ename);
			pst.setInt(2, eid);
			pst.setString(3, eage);
			pst.setString(4, enu);
			pst.setInt(5, esal);
			int i=pst.executeUpdate();
			if(i>0){
				response.sendRedirect("accountantdashbord.html");
			}
			else{
				response.sendRedirect("account1.html");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
