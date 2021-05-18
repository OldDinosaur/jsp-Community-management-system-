package myservlet.login;
import mybean.login.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class inputServlet extends HttpServlet{
	 
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
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		   inputBean inputBean =new inputBean();  //创建Javabean模型
		   request.setAttribute("inputBean", inputBean);
		   String username = request.getParameter("username").trim();
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
			   inputBean.setBackNews("两次密码不同，添加失败。");
			   RequestDispatcher dispatcher = 
               request.getRequestDispatcher("inputUser.jsp");
			   dispatcher.forward(request, response);            //转发
			   return;
		   }
		   
		   boolean u= true;
		   for(int i=0;i<username.length();i++)//判断用户名是否正确
		   {
			   char c =username.charAt(i);
			   if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')||(c=='_')))
				   u=false;
			   
		   }
		   
		   boolean boo=username.length()>0&&password.length()>0&&power.length()>0&&u;
		   String backNews="";
	    
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String insertCondition ="INSERT INTO UserTable VALUES(?,?,?,?,?,?)";
		
			   sql =con.prepareStatement(insertCondition);
			
			   if(boo)
			   {    
				   sql.setString(1, handleString(username));
				   sql.setString(2, handleString(password));
				   sql.setString(3, handleString(power));
				   sql.setString(4, handleString(name));
				   sql.setString(5, handleString(sex));
				   sql.setString(6, handleString(number));
				   int m=sql.executeUpdate();
				   if(m!=0) {

					   backNews="添加成功";
					   inputBean.setBackNews(backNews);
					   inputBean.setUsername(handleString(username));
					   inputBean.setName(handleString(name));
					   inputBean.setSex(handleString(sex));
					   inputBean.setNumber(handleString(number));
				   }
			   }
			   else {
				   backNews="信息填写不完整或名字中有非法字符";
				   inputBean.setBackNews(backNews);
			   }
			   con.close();
		   }
		   catch(SQLException exp) {
			   backNews="该用户名已被使用，请重新输入";
			   inputBean.setBackNews(backNews);
		   }
		   RequestDispatcher dispatcher = 
	       request.getRequestDispatcher("inputUser.jsp");
       	   dispatcher.forward(request, response);            //转发
		   
		  		   
	   }
	 
	   
	   
	   
	  	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
	       doPost(request,response);
	   }
}
