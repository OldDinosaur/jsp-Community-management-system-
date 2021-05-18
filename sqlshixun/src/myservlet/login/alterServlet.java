package myservlet.login;
import mybean.login.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterServlet extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
	      super.init(config);
	      try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //加载驱动
	      }
	      catch(Exception e){
	     	   System.out.println(e);
	      } 
	  
	   }
	   
	   public String handleString(String s) {             //处理乱码
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
		   ResultSet rs;
		   inputBean inputBean =new inputBean();  //创建Javabean模型
		   request.setAttribute("inputBean", inputBean);
		   String username = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM UserTable Where 用户名="+"'"+username+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	     String user_name=rs.getString("用户名");
				       String password = rs.getString("密码");
				       String again_password = rs.getString("密码");
				       String power = rs.getString("权限");				       
				       String name = rs.getString("姓名");
				       String sex = rs.getString("性别").trim();				       
				       String number = rs.getString("联系电话");
				
				       inputBean.setUsername(user_name);
				       inputBean.setPassword(password);
				       inputBean.setAgain_password(again_password);

				       if(sex.equals("男"))
		               {

				    	   inputBean.setXingbie1("checked");
				       }
		               if(sex.equals("女"))
		               {
				    	   inputBean.setXingbie2("checked");
				       }
				       if(power.equals("系统管理员"))
				       {

				    	   inputBean.setQuanxian1("checked");
				       }
				       if(power.equals("小区管理员"))
				       {
				    	   inputBean.setQuanxian2("checked");
				       }
				       inputBean.setName(name);

				       inputBean.setNumber(number);	
		      }
		  
		  
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterUser.jsp");
				   dispatcher.forward(request, response);            //转发      //转发
		   
	   }

}
