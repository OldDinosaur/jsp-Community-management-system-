package myservlet.login;
import mybean.login.houseBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterhouseServlet extends HttpServlet{
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
		  houseBean houseBean =new houseBean();  //创建Javabean模型
		   request.setAttribute("houseBean",houseBean);
		   String u = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM ProInformation Where 房屋号="+"'"+u+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	       String houseNum=rs.getString("房屋号").trim();
				       String houseUnit = rs.getString("单元").trim();
				       String houseArea = rs.getString("房屋面积").trim();
				       String houserName = rs.getString("户主名").trim();				       
				       String houserNum = rs.getString("户主联系电话").trim();
				       String houserID = rs.getString("户主身份证").trim();				       
				       String moveDate = rs.getString("迁入日期").trim();
				       String housePro = rs.getString("产权状况").trim();
				       String remarks = rs.getString("备注");
				       
				       houseBean.setHouseNum(houseNum);
				       houseBean.setHouseUnit(houseUnit);
				       houseBean.setHouseArea(houseArea);
				       houseBean.setHouserName(houserName);
				       houseBean.setHouserNum(houserNum);
				       houseBean.setHouserID(houserID);
				       houseBean.setMoveDate(moveDate);
				       houseBean.setHousePro(housePro);
				       houseBean.setRemarks(remarks);

		      }
		  
		  
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterhouse.jsp");
				   dispatcher.forward(request, response);            //转发      //转发
		   
	   }
}
