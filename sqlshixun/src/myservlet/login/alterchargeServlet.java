package myservlet.login;
import mybean.login.chargeBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterchargeServlet extends HttpServlet{
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
		   chargeBean chargeBean =new chargeBean();  //����Javabeanģ��
		   request.setAttribute("chargeBean",chargeBean);
		   String u = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM chargeTable Where ���ݱ��="+"'"+u+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	   String chargeNum=rs.getString("���ݱ��");
			       String houseNum = rs.getString("���ݺ�");
			       String houserName = rs.getString("������");
			       String houserNum = rs.getString("������ϵ�绰");				       
			       Float totalCharge = rs.getFloat("�շ��ܶ�");
			       String chargeTime = rs.getString("�շ�ʱ��");				       
			       String chargeSit = rs.getString("�շ����");	
				       
			           chargeBean.setChargeNum(chargeNum);
			           chargeBean.setHouseNum(houseNum);
			           chargeBean.setHouserName(houserName);
			           chargeBean.setHouserNum(houserNum);
			           chargeBean.setTotalCharge(totalCharge);
			           chargeBean.setChargeTime(chargeTime);
			           if(chargeSit.equals("���շ�"))
			              chargeBean.setShoufei1("checked");
			           if(chargeSit.equals("δ�շ�"))
				              chargeBean.setShoufei2("checked");

		      }
		  
		  
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterCharge.jsp");
				   dispatcher.forward(request, response);            //ת��      //ת��
		   
	   }

}
