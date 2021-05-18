package myservlet.login;
import mybean.login.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class viewstaffServlet extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
	      super.init(config);
	      try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //加载驱动
	      }
	      catch(Exception e){
	     	   System.out.println(e);
	      } 
	  
	   }
	   
	   public String handleString(String s) {             //可调用处理乱码
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
		   Statement sql;
		   ResultSet rs = null;
		   
		  
		   HttpSession session =request.getSession(true);
		   showBean showBean =null;

		  
		   try {
			     showBean=(showBean)session.getAttribute("showBean");
			     if(showBean==null) {
			    	 showBean=new showBean();
			    	 session.setAttribute("showBean", showBean);
			     }
			   
		   }catch(Exception exp) {
			   showBean = new showBean();
			   session.setAttribute("showBean", showBean);
		   }
		   
		   
		
		 String houseNum =   request.getParameter("houserName");
	
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			   
			   if(houseNum!=null) //查询
				   rs = sql.executeQuery("SELECT * FROM staffTable where 姓名='"+houseNum+"'");
				   		   			   
			   else    
				   rs = sql.executeQuery("SELECT * FROM staffTable");	
			
		       		       
		       ResultSetMetaData metaData= rs.getMetaData();
		       int columnCount = metaData.getColumnCount();  //得到结果集的列数

		       String []columnName = new String[columnCount];
		       
		       for(int i=0;i<columnName.length;i++)
		       {
		    	   columnName[i] = metaData.getColumnName(i+1);  //得到列名
		       } 		      
		       showBean.setColumnName(columnName); //更新JavaBean数据
		       rs.last();
		       int rowNumber = rs.getRow();
		       String [][]tableRecord =showBean.getTableRecord();
		       tableRecord = new String[rowNumber][columnCount];
		       rs.beforeFirst();
		       int i= 0;
		       while(rs.next()) {
		    	   for(int k = 0;k<columnCount;k++)
		    	   {
		    		   tableRecord[i][k] = rs.getString(k+1);
		    	    
		    	   }
		    	   i++;
		       }
		       showBean.setTableRecord(tableRecord);
		       

		       
		       con.close();

		       RequestDispatcher dispatcher = 
				       request.getRequestDispatcher("viewStaff.jsp");
			       	   dispatcher.forward(request, response);            //转发
		       
		   }catch(SQLException e)
		   {
			   System.out.println(e);
		   }		   
		   
	   }
	   
	   
	   
	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
	       doPost(request,response);
	   }
}
