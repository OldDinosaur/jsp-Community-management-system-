package myservlet.login;
import mybean.login.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class alterServlet extends HttpServlet{
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
		   inputBean inputBean =new inputBean();  //����Javabeanģ��
		   request.setAttribute("inputBean", inputBean);
		   String username = request.getParameter("alter");
		   
		   
		   
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");			 
		      String update= "SELECT * FROM UserTable Where �û���="+"'"+username+"'"+"";
		      sql =con.prepareStatement(update);
		      rs =sql.executeQuery();
		      while(rs.next()) {
		    	     String user_name=rs.getString("�û���");
				       String password = rs.getString("����");
				       String again_password = rs.getString("����");
				       String power = rs.getString("Ȩ��");				       
				       String name = rs.getString("����");
				       String sex = rs.getString("�Ա�").trim();				       
				       String number = rs.getString("��ϵ�绰");
				
				       inputBean.setUsername(user_name);
				       inputBean.setPassword(password);
				       inputBean.setAgain_password(again_password);

				       if(sex.equals("��"))
		               {

				    	   inputBean.setXingbie1("checked");
				       }
		               if(sex.equals("Ů"))
		               {
				    	   inputBean.setXingbie2("checked");
				       }
				       if(power.equals("ϵͳ����Ա"))
				       {

				    	   inputBean.setQuanxian1("checked");
				       }
				       if(power.equals("С������Ա"))
				       {
				    	   inputBean.setQuanxian2("checked");
				       }
				       inputBean.setName(name);

				       inputBean.setNumber(number);	
		      }
		  
		  
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterUser.jsp");
				   dispatcher.forward(request, response);            //ת��      //ת��
		   
	   }

}
