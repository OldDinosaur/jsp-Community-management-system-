package myservlet.login;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class loginServlet extends HttpServlet{
   private static final boolean NULL = false;



public void init(ServletConfig config) throws ServletException{
      super.init(config);
      try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //��������
      }
      catch(Exception e){
     	   System.out.println(e);
      } 
  
   }
   
   public String handleString(String s) {             //��������
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
         String condition ="select * from UserTable where �û���='"+usernumber+"'";
         sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    	 ResultSet rs = sql.executeQuery(condition);        	           	
         if(rs.next()!=NULL) {
        	rs.beforeFirst();
         if(usernumber.length()>0&&password.length()>0) {
        
          	 
        	 while(rs.next()) {
        		   String a=rs.getString("�û���");
        		   String b=rs.getString("����");
        		   String c=rs.getString("Ȩ��");
        		 if((a.equals(usernumber))&&(b.equals(password))) {       		
        			
            		 if(c.equals("ϵͳ����Ա")) {
            			 System.out.print("ϵͳ����Ա��¼�ɹ�"+"\n");
            			 response.sendRedirect("adminPage.jsp");
            			 break;
            		 }
            		 else if(c.equals("С������Ա")) {
            			 System.out.print("С������Ա��¼�ɹ�"+"\n"); 
            			 response.sendRedirect("userPage.jsp");
            			 break;
            		 }
            	           		           		 
            	 }else {

            		 System.out.print("�������"+"\n");
            		
            		 RequestDispatcher dispatcher = 
          	               request.getRequestDispatcher("login.jsp?error=no1");
          				   dispatcher.forward(request, response);            //ת��  
                	 
            	 }      	       		
        	 }        	         	        	
         }else {
			 System.out.print("����������"+"\n");
			 RequestDispatcher dispatcher = 
    	               request.getRequestDispatcher("login.jsp?error=no2");
    				   dispatcher.forward(request, response);            //ת��  
        	// response.sendRedirect("login.jsp?error=no2");
			 
		 }  
         }
        
         else {
        	 System.out.print("�������û���������\n");
        	 RequestDispatcher dispatcher = 
    	               request.getRequestDispatcher("login.jsp?error=no3");
    				   dispatcher.forward(request, response);            //ת��  
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




