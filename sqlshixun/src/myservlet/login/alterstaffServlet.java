package myservlet.login;
import mybean.login.staffBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterstaffServlet extends HttpServlet{
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
	   
	   
	   public void doPost(HttpServletRequest request,HttpServletResponse response)         //返回原本信息
       throws ServletException,IOException{
		   request.setCharacterEncoding("gb2312");
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		   staffBean staffBean =new staffBean();  //创建Javabean模型
		   request.setAttribute("staffBean",staffBean);
		   String u = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM staffTable Where 员工编号="+"'"+u+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	   String  staffNum=rs.getString("员工编号");
			       String staffName = rs.getString("姓名");
			       String staffSex = rs.getString("性别");
			       String staffAge = rs.getString("年龄");				       
			       String staffID = rs.getString("身份证号");
			       String staffLocation = rs.getString("户口所在地");				       
			       String staffPhong = rs.getString("联系电话");	
			       String jobType = rs.getString("工作类型");	
			       String staffPic = rs.getString("照片");	
			       staffBean.setStaffNum(staffNum);
			       staffBean.setStaffName(staffName);
			       staffBean.setStaffSex(staffSex);
			       staffBean.setStaffAge(staffAge);
			       staffBean.setStaffID(staffID);
			       staffBean.setStaffLocation(staffLocation);
			       staffBean.setStaffPhong(staffPhong);
			       staffBean.setJobType(jobType);
			       staffBean.setStaffPic(staffPic);
			      
			           if(staffSex.equals("男"))
			        	   staffBean.setXiangbie1("checked");
			           if(staffSex.equals("女"))
			        	   staffBean.setXingbie2("checked");

		      }
		  
		  
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
		   //response.sendRedirect("alterStaff.jsp");
		   RequestDispatcher dispatcher = 
	             request.getRequestDispatcher("alterStaff.jsp");
				   dispatcher.forward(request, response);            //转发      //转发
		   
	   }
		   
}
