package myservlet.login;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class loginServlet extends HttpServlet{
   private static final boolean NULL = false;



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
	   Connection con;
	   Statement sql;
	   String usernumber=request.getParameter("usernumber").trim(),
	          password=request.getParameter("password").trim();
	   usernumber=handleString(usernumber);
	   password=handleString(password);
	   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
	   
     try{     	        
         con=DriverManager.getConnection(uri,"sa","cjj123456789");    
         String condition ="select * from UserTable where 用户名='"+usernumber+"'";
         sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    	 ResultSet rs = sql.executeQuery(condition);        	           	
         if(rs.next()!=NULL) {
        	rs.beforeFirst();
         if(usernumber.length()>0&&password.length()>0) {
        
          	 
        	 while(rs.next()) {
        		   String a=rs.getString("用户名");
        		   String b=rs.getString("密码");
        		   String c=rs.getString("权限");
        		 if((a.equals(usernumber))&&(b.equals(password))) {       		
        			
            		 if(c.equals("系统管理员")) {
            			 System.out.print("系统管理员登录成功"+"\n");
            			 response.sendRedirect("adminPage.jsp");
            			 break;
            		 }
            		 else if(c.equals("小区管理员")) {
            			 System.out.print("小区管理员登录成功"+"\n"); 
            			 response.sendRedirect("userPage.jsp");
            			 break;
            		 }
            	           		           		 
            	 }else {

            		 System.out.print("密码错误"+"\n");
            		
            		 RequestDispatcher dispatcher = 
          	               request.getRequestDispatcher("login.jsp?error=no1");
          				   dispatcher.forward(request, response);            //转发  
                	 
            	 }      	       		
        	 }        	         	        	
         }else {
			 System.out.print("请输入密码"+"\n");
			 RequestDispatcher dispatcher = 
    	               request.getRequestDispatcher("login.jsp?error=no2");
    				   dispatcher.forward(request, response);            //转发  
        	// response.sendRedirect("login.jsp?error=no2");
			 
		 }  
         }
        
         else {
        	 System.out.print("请输入用户名和密码\n");
        	 RequestDispatcher dispatcher = 
    	               request.getRequestDispatcher("login.jsp?error=no3");
    				   dispatcher.forward(request, response);            //转发  
        	 //response.sendRedirect("login.jsp?error=no3");
         }
     }
     catch(SQLException e){
          System.out.println(e);
     }  
   }
   
   
   
   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
           throws ServletException,IOException{
       doPost(request,response);
   }
   


   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}




