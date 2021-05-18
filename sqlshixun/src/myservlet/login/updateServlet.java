package myservlet.login;
import mybean.login.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class updateServlet  extends HttpServlet{
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
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		   String username = request.getParameter("username");
		   String password = request.getParameter("password").trim();
		   String again_password = request.getParameter("again_password").trim();
		   String power = request.getParameter("power");
		   String name = request.getParameter("name").trim();
		   String sex = request.getParameter("sex");
		   String number = request.getParameter("number").trim();
		   if (username==null)
		   {
			   username="";
		   }
		   if (power==null)
		   {
			   power="";
		   }
		   if (sex==null)
		   {
			   sex="";
		   }
		   if(password==null)
		   {
			   password="";
		   }
		   if(!password.equals(again_password))
		   {
			   return;
		   }
		   
		   boolean u= true;
		   for(int i=0;i<username.length();i++)//�ж��û����Ƿ���ȷ
		   {
			   char c =username.charAt(i);
			   if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')||(c=='_')))
				   u=false;
			   
		   }
		   
		   boolean boo=username.length()>0&&password.length()>0&&power.length()>0&&u;
	    
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String insertCondition ="UPDATE UserTable SET �û���=?,����=?,Ȩ��=?,����=?,�Ա�=?,��ϵ�绰=? where �û���=?";
		
			   sql =con.prepareStatement(insertCondition);
			
			   if(boo)
			   {    
				   
				   sql.setString(1, handleString(username));
				   sql.setString(2, handleString(password));
				   sql.setString(3, handleString(power));
				   sql.setString(4, handleString(name));
				   sql.setString(5, handleString(sex));
				   sql.setString(6, handleString(number));
				   sql.setString(7, handleString(username));
				   int m=sql.executeUpdate();
				   if(m!=0) {

					   System.out.println("�޸ĳɹ�"); 
				   }
				   
				   
			   }
			   else {
				   System.out.print("��Ϣ��д���������������зǷ��ַ�");
				 
			   }
			   con.close();
		   }
		   catch(SQLException exp) {
                     System.out.println(exp);
		   }
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterUser.jsp");
				   dispatcher.forward(request, response);            //ת��      //ת��
	   }
	 
	   	   	   	  	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
	       doPost(request,response);
	   }

}
