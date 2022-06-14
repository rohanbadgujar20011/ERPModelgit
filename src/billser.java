import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class billser
 */
public class billser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public billser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("eid"));
		Connection con=(Connection) DbConnection.connect();
		String s="select * from empl where Eidd=?";
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) con.prepareStatement(s);
			pst.setInt(1, id);
			ResultSet i=pst.executeQuery();
			if(i.next()){
				String na=i.getString("Ename");
				String age=i.getString("Eage");
				String Enum=i.getString("Enum");
				int sal=i.getInt("Ebal");
				CratePdf c=new CratePdf();
				c.calculateSalary(na,age,Enum,sal,id);
				response.sendRedirect("Generatedbill.html");
				
				
			}
			else{
				response.sendRedirect("empbill.html");
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
