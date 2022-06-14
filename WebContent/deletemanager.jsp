<%@page import="java.sql.*"%>
<%
String name=request.getParameter("name");
Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/erp", "root","");
			System.out.println("Connection Established.......");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	String s1="delete from mate where mname=?";
	PreparedStatement pstmt=con.prepareStatement(s1);
	pstmt.setString(1, name);
	int j=pstmt.executeUpdate();
	if(j>0){
		response.sendRedirect("Viewmanager.jsp");
	}
	
	
	
%>