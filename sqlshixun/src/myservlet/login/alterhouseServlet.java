package myservlet.login;
import mybean.login.houseBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterhouseServlet extends HttpServlet{
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
		   request.setCharacterEncoding("gb2312");
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		  houseBean houseBean =new houseBean();  //����Javabeanģ��
		   request.setAttribute("houseBean",houseBean);
		   String u = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM ProInformation Where ���ݺ�="+"'"+u+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	       String houseNum=rs.getString("���ݺ�").trim();
				       String houseUnit = rs.getString("��Ԫ").trim();
				       String houseArea = rs.getString("�������").trim();
				       String houserName = rs.getString("������").trim();				       
				       String houserNum = rs.getString("������ϵ�绰").trim();
				       String houserID = rs.getString("�������֤").trim();				       
				       String moveDate = rs.getString("Ǩ������").trim();
				       String housePro = rs.getString("��Ȩ״��").trim();
				       String remarks = rs.getString("��ע");
				       
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
				   dispatcher.forward(request, response);            //ת��      //ת��
		   
	   }
}
