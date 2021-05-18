package myservlet.login;
import mybean.login.houseBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class houseServlet extends HttpServlet{
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
		  houseBean houseBean =new houseBean();  //创建Javabean模型
		   request.setAttribute("houseBean", houseBean);
		   String houseNum = request.getParameter("houseNum").trim();         
		   String houseUnit = request.getParameter("houseUnit").trim();
		   String houseArea = request.getParameter("houseArea").trim();
		   String houserName = request.getParameter("houserName").trim();
		   String houserNum = request.getParameter("houserNum").trim();
		   String houserID= request.getParameter("houserID").trim();
		   String moveDate = request.getParameter("moveDate").trim();
		   String housePro= request.getParameter("housePro").trim();
		   String remarks = request.getParameter("remarks").trim();
		   if (houseNum==null)
		   {
			   houseNum="";
		   }
		   if (houseUnit==null)
		   {
			   houseUnit="";
		   }
		   if (houseArea==null)
		   {
			   houseArea="";
		   }
		   if(houserName==null)
		   {
			   houserName="";
		   }
		   if (houserNum==null)
		   {
			   houserNum="";
		   }
		   if (houserID==null)
		   {
			   houserID="";
		   }
		   if (moveDate==null)
		   {
			   moveDate="";
		   }
		   if(housePro==null)
		   {
			   housePro="";
		   }
		   if(remarks==null)
		   {
			   remarks="";
		   }
		   
		   boolean u= true;
		   for(int i=0;i<houseNum.length();i++)//判断用户名是否正确
		   {
			   char c =houseNum.charAt(i);
			   if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')||(c=='_')))
				   u=false;
			   
		   }
		   
		   boolean boo=houseNum.length()>0&&houseUnit.length()>0&&houseArea.length()>0&&u;
		   String backNews="";
	    
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String insertCondition ="INSERT INTO ProInformation VALUES(?,?,?,?,?,?,?,?,?)";
		
			   sql =con.prepareStatement(insertCondition);
			
			   if(boo)
			   {    
				   sql.setString(1, handleString(houseNum));
				   sql.setString(2, handleString(houseUnit));
				   sql.setString(3, handleString(houseArea));
				   sql.setString(4, handleString(houserName));
				   sql.setString(5, handleString(houserNum ));
				   sql.setString(6, handleString(houserID));
				   sql.setString(7, handleString(moveDate));
				   sql.setString(8, handleString(housePro));
				   sql.setString(9, handleString(remarks));
				   int m=sql.executeUpdate();
				   if(m!=0) {

					   backNews="添加成功";
					   houseBean.setBackNews(backNews);
					   houseBean.setHouserName(handleString(houserName));
					   houseBean.setHouseNum(houseNum);
					   houseBean.setHouseUnit(houseUnit);
					   houseBean.setHouserNum(houserNum);
				   }
			   }
			   else {
				   backNews="信息填写不完整或名字中有非法字符";
				   houseBean.setBackNews(backNews);
			   }
			   con.close();
		   }
		   catch(SQLException exp) {
			   backNews="请重新输入";
			   houseBean.setBackNews(backNews);
		   }
		   RequestDispatcher dispatcher = 
	       request.getRequestDispatcher("inputHouse.jsp");
     	   dispatcher.forward(request, response);            //转发
		   
		  		   
	   }
	 
	   
	   
	   
	  	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
	       doPost(request,response);
	   }
}
