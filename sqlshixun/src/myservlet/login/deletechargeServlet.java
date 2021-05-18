package myservlet.login;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class deletechargeServlet extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
	      super.init(config);
	      try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //加载驱动
	      }
	      catch(Exception e){
	     	   System.out.println(e);
	      } 
	 
	   }
	   
	   public String handleString(String s) {             //可调用处理乱码
		   try {
			       byte bb[]=s.getBytes("iso-8859-1");
			       s=new String(bb);
			   
		   }catch(Exception e) {}
		return s;
	   }
	   
	   public void doPost(HttpServletRequest request,HttpServletResponse response)
           throws ServletException,IOException{

		   request.setCharacterEncoding("gb2312");
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";		   
		   Connection con;
		   PreparedStatement sql;
		    int rs=0;
		   String u = request.getParameter("delete");

		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String sql_delete="delete from chargeTable where 单据编号="+"'"+u+"'"+"";		
			   sql=con.prepareStatement(sql_delete);
			   rs=sql.executeUpdate();
			   if(rs!=0) {
				   
				   System.out.println("删除成功");
				  
				   response.sendRedirect("viewCharge.jsp?e=no1");
			   }
		   }catch(Exception e){
			   
			   System.out.println(e);
		   }
		   
	   }
}
