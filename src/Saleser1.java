

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Saleser1
 */
public class Saleser1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saleser1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("Name");
		String city=request.getParameter("city");
		String bnum=request.getParameter("bnum");
		String Roll=request.getParameter("Roll");
		int quan=Integer.parseInt(request.getParameter("quan"));
		Connection con=(Connection) DbConnection.connect();
		String s="insert into sale values(?,?,?,?,?)";
		try {
			PreparedStatement pt=con.prepareStatement(s);
			pt.setString(1, Name);
			pt.setString(2, city);
			pt.setString(3, bnum);
			pt.setString(4, Roll);
			pt.setInt(5, quan);
			int i=pt.executeUpdate();
			if(i>0){
				String s2="select * from mate where mname=?";
				PreparedStatement ptm=con.prepareStatement(s2);
				ptm.setString(1, Roll);
				ResultSet rt =ptm.executeQuery();
				if(rt.next()){
					
					int a=rt.getInt("mqq");
					int updatevalue=(rt.getInt("quantity"))-quan;
					
					String up="UPDATE mate SET quantity=? WHERE mname=?";
					PreparedStatement ps=con.prepareStatement(up);
					ps.setInt(1, updatevalue);
					ps.setString(2, Roll);
					int j=ps.executeUpdate();
					if(j>0){
						
					
					
					int fi=a*quan;
					CratePdf c2=new CratePdf();
	                c2.calaculate2(Name,city,bnum,Roll,fi,quan,a);
							
				}
				}
				
				response.sendRedirect("salesdashbord.html");
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
