

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager1
 */
public class Manager1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		String uname=request.getParameter("uname");

		String email=request.getParameter("email");
		String mo_nu=request.getParameter("mo_nu");
		String roll=request.getParameter("Roll");
		
		String pass=request.getParameter("pass");
		Connection con=DbConnection.connect();
		String s="insert into manager values(?,?,?,?,?,?)";
		try{
			PreparedStatement pt=con.prepareStatement(s);
			pt.setString(1, uname);
			pt.setInt(2, id);
			pt.setString(3, email);
			pt.setString(4, mo_nu);
			pt.setString(5, pass);
			pt.setString(6, roll);
			int i=pt.executeUpdate();
			if(i>0){
				response.sendRedirect("admindashbord.jsp");
			}
			else{
				response.sendRedirect("ManagerRagister.html");
				
			}
			
			
		}catch(Exception e){
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
