package myservlet.login;
import mybean.login.staffBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterstaffServlet extends HttpServlet{
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
	   
	   
	   public void doPost(HttpServletRequest request,HttpServletResponse response)         //����ԭ����Ϣ
       throws ServletException,IOException{
		   request.setCharacterEncoding("gb2312");
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		   staffBean staffBean =new staffBean();  //����Javabeanģ��
		   request.setAttribute("staffBean",staffBean);
		   String u = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM staffTable Where Ա�����="+"'"+u+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	   String  staffNum=rs.getString("Ա�����");
			       String staffName = rs.getString("����");
			       String staffSex = rs.getString("�Ա�");
			       String staffAge = rs.getString("����");				       
			       String staffID = rs.getString("���֤��");
			       String staffLocation = rs.getString("�������ڵ�");				       
			       String staffPhong = rs.getString("��ϵ�绰");	
			       String jobType = rs.getString("��������");	
			       String staffPic = rs.getString("��Ƭ");	
			       staffBean.setStaffNum(staffNum);
			       staffBean.setStaffName(staffName);
			       staffBean.setStaffSex(staffSex);
			       staffBean.setStaffAge(staffAge);
			       staffBean.setStaffID(staffID);
			       staffBean.setStaffLocation(staffLocation);
			       staffBean.setStaffPhong(staffPhong);
			       staffBean.setJobType(jobType);
			       staffBean.setStaffPic(staffPic);
			      
			           if(staffSex.equals("��"))
			        	   staffBean.setXiangbie1("checked");
			           if(staffSex.equals("Ů"))
			        	   staffBean.setXingbie2("checked");

		      }
		  
		  
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
		   //response.sendRedirect("alterStaff.jsp");
		   RequestDispatcher dispatcher = 
	             request.getRequestDispatcher("alterStaff.jsp");
				   dispatcher.forward(request, response);            //ת��      //ת��
		   
	   }
		   
}
