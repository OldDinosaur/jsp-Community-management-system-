package myservlet.login;
import mybean.login.staffBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class updatestaffServlet  extends HttpServlet{
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
		   String staffNum= request.getParameter("staffNum");         
		   String staffName = request.getParameter("staffName");
		   String staffSex = request.getParameter("staffSex");
		   String staffAge = request.getParameter("staffAge");
		   String staffID = request.getParameter("staffID");
		   String staffLocation= request.getParameter("staffLocation");
		   String staffPhong = request.getParameter("staffPhong");
		   String jobType = request.getParameter("jobType");
		   String staffPic = request.getParameter("staffPic");
		   System.out.println(staffPic);
		   boolean boo=staffNum.length()>0&&staffID.length()>0&&staffPhong.length()>0&&jobType.length()>0;
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
   if(staffPic==null||staffPic=="") {
				   
				   String insertCondition ="UPDATE staffTable SET Ա�����=?,����=?,�Ա�=?,����=?,���֤��=?,�������ڵ�=?,��ϵ�绰=?,��������=?   where Ա�����=?";
				   
				   sql =con.prepareStatement(insertCondition);
				   
				   if(boo)
				   {    
					   
					   sql.setString(1, handleString(staffNum));
					   sql.setString(2, handleString(staffName));
					   sql.setString(3, handleString(staffSex));
					   sql.setString(4, handleString(staffAge));
					   sql.setString(5, handleString(staffID));
					   sql.setString(6, handleString(staffLocation));
					   sql.setString(7, handleString(staffPhong));
					   sql.setString(8, handleString(jobType));					 
					   sql.setString(9, handleString(staffNum));
					   int m=sql.executeUpdate();
					   if(m!=0) {

						   System.out.println("�޸ĳɹ�"); 
					   }
					   
					   
				   }
				   else {
					   System.out.print("��Ϣ��д������");
					 
				   }
				   con.close();
				   
				   
				   
				   
				   
				   
			   }
   else {
			   String insertCondition ="UPDATE staffTable SET Ա�����=?,����=?,�Ա�=?,����=?,���֤��=?,�������ڵ�=?,��ϵ�绰=?,��������=?,��Ƭ=?   where Ա�����=?";
			   
			   sql =con.prepareStatement(insertCondition);
			   
			   if(boo)
			   {    
				   
				   sql.setString(1, handleString(staffNum));
				   sql.setString(2, handleString(staffName));
				   sql.setString(3, handleString(staffSex));
				   sql.setString(4, handleString(staffAge));
				   sql.setString(5, handleString(staffID));
				   sql.setString(6, handleString(staffLocation));
				   sql.setString(7, handleString(staffPhong));
				   sql.setString(8, handleString(jobType));
				   sql.setString(9, handleString(staffPic));
				   sql.setString(10, handleString(staffNum));
				   int m=sql.executeUpdate();
				   if(m!=0) {

					   System.out.println("�޸ĳɹ�"); 
				   }
				   
				   
			   }
			   else {
				   System.out.print("��Ϣ��д������");
				 
			   }
			   con.close();
		   }
			
		   }
		   catch(SQLException exp) {
                 System.out.println(exp);
		   }
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterStaff.jsp");
				   dispatcher.forward(request, response);            //ת��      //ת��
				   
	   }
	 
	   	   	   	  	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
	       doPost(request,response);
	   }
}
