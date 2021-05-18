package myservlet.login;
import mybean.login.chargeBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterchargeServlet extends HttpServlet{
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
		   chargeBean chargeBean =new chargeBean();  //创建Javabean模型
		   request.setAttribute("chargeBean",chargeBean);
		   String u = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM chargeTable Where 单据编号="+"'"+u+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	   String chargeNum=rs.getString("单据编号");
			       String houseNum = rs.getString("房屋号");
			       String houserName = rs.getString("户主名");
			       String houserNum = rs.getString("户主联系电话");				       
			       Float totalCharge = rs.getFloat("收费总额");
			       String chargeTime = rs.getString("收费时间");				       
			       String chargeSit = rs.getString("收费情况");	
				       
			           chargeBean.setChargeNum(chargeNum);
			           chargeBean.setHouseNum(houseNum);
			           chargeBean.setHouserName(houserName);
			           chargeBean.setHouserNum(houserNum);
			           chargeBean.setTotalCharge(totalCharge);
			           chargeBean.setChargeTime(chargeTime);
			           if(chargeSit.equals("已收费"))
			              chargeBean.setShoufei1("checked");
			           if(chargeSit.equals("未收费"))
				              chargeBean.setShoufei2("checked");

		      }
		  
		  
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterCharge.jsp");
				   dispatcher.forward(request, response);            //转发      //转发
		   
	   }

}
