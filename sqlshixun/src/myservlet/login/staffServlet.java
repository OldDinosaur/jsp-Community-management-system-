package myservlet.login;
import mybean.login.staffBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class staffServlet extends HttpServlet {
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
	   private static final long serialVersionUID = 1L;	   
	   public void doPost(HttpServletRequest request,HttpServletResponse response)
         throws ServletException,IOException{
		   
		   
		   
		   
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		   staffBean staffBean =new staffBean();  //创建Javabean模型
		   request.setAttribute("staffBean", staffBean);
		   String staffNum= request.getParameter("staffNum");         
		   String staffName = request.getParameter("staffName");
		   String staffSex = request.getParameter("staffSex");
		   String staffAge = request.getParameter("staffAge");
		   String staffID = request.getParameter("staffID");
		   String staffLocation= request.getParameter("staffLocation");
		   String staffPhong = request.getParameter("staffPhong");
		   String jobType = request.getParameter("jobType");
		   String staffPic = request.getParameter("staffPic");
 
		   if (staffNum==null)
		   {
			   staffNum="";
		   }
		   if (staffID==null)
		   {
			   staffID="";
		   }
		   if (staffPhong==null)
		   {
			   staffPhong="";
		   }
		   if (jobType==null)
		   {
			   jobType="";
		   }

           
		   boolean boo=staffNum.length()>0&&staffID.length()>0&&staffPhong.length()>0&&jobType.length()>0;
		   String backNews="";
		   
		  
		   try {
			   
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String insertCondition ="INSERT INTO staffTable VALUES(?,?,?,?,?,?,?,?,?)";
		
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
				   sql.setString(9,handleString(staffPic));
				   int m=sql.executeUpdate();
				   if(m!=0) {

					   backNews="添加成功";
					   staffBean.setBackNews(backNews);
					   staffBean.setStaffNum(staffNum);
					   staffBean.setStaffName(handleString(staffName));
					   staffBean.setStaffSex(handleString(staffSex));
					   staffBean.setJobType(handleString(jobType)
							   );
				   }
			   }
			   else {
				   backNews="信息填写不完整";
				   staffBean.setBackNews(backNews);
			   }
			   con.close();
		   }
		   catch(Exception exp) {
			   System.out.println(exp);
			   backNews="输入有错,信息填写不完整,请重新输入";
			   staffBean.setBackNews(backNews);
		   }
		   RequestDispatcher dispatcher = 
	       request.getRequestDispatcher("inputStaff.jsp");
 	   dispatcher.forward(request, response);            //转发
		   
		  		   
	   }
	 
	   
	   
	   
	  	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
		   request.setCharacterEncoding("gb2312");
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";		   
		   Connection con;
		   PreparedStatement sql;
		    int rs=0;
		   String u = request.getParameter("delete");

		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String sql_delete="delete from staffTable where 员工编号="+"'"+u+"'"+"";		
			   sql=con.prepareStatement(sql_delete);
			   rs=sql.executeUpdate();
			   if(rs!=0) {
				   
				   System.out.println("删除成功");
				   response.sendRedirect("viewStaff.jsp?e=no1");
			   }
		   }catch(Exception e){
			   
			   System.out.println(e);
		   }
		   
	   }
	   

}
