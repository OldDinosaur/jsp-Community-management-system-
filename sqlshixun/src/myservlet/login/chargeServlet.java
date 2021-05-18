package myservlet.login;
import mybean.login.chargeBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class chargeServlet extends HttpServlet{
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
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		   chargeBean chargeBean =new chargeBean();  //创建Javabean模型
		   request.setAttribute("chargeBean", chargeBean);
		   String chargeNum= request.getParameter("chargeNum");         
		   String houseNum = request.getParameter("houseNum");
		   String houserName = request.getParameter("houserName");
		   String houserNum = request.getParameter("houserNum");
		   String totalCharge = request.getParameter("totalCharge");
		   String chargeTime= request.getParameter("chargeTime");
		   String chargeSit = request.getParameter("chargeSit");
		   if (chargeNum==null)
		   {
			   chargeNum="";
		   }
		   if (houseNum==null)
		   {
			   houseNum="";
		   }
		   if (houserName==null)
		   {
			   houserName="";
		   }
		   if( houserNum==null)
		   {
			   houserNum="";
		   }
		   if (totalCharge==null)
		   {
			   totalCharge="";
		   }
		   if (chargeTime==null)
		   {
			   chargeTime="";
		   }
		   if (chargeSit==null)
		   {
			   chargeSit="";
		   }
		   
		   boolean boo=houseNum.length()>0&&houseNum.length()>0;
		   String backNews="";
	    
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String insertCondition ="INSERT INTO chargeTable VALUES(?,?,?,?,?,?,?)";
		
			   sql =con.prepareStatement(insertCondition);
			
			   if(boo)
			   {    
				   sql.setString(1, handleString(chargeNum));
				   sql.setString(2, handleString(houseNum));
				   sql.setString(3, handleString(houserName));
				   sql.setString(4, handleString(houserNum));
				   sql.setFloat(5, Float.parseFloat(handleString(totalCharge)));
				   sql.setString(6, handleString(chargeTime));
				   sql.setString(7, handleString(chargeSit));
				   int m=sql.executeUpdate();
				   if(m!=0) {

					   backNews="添加成功";
					   chargeBean.setBackNews(backNews);
					   chargeBean.setChargeNum(chargeNum);
					   chargeBean.setHouseNum(houseNum);
					   chargeBean.setTotalCharge(Float.parseFloat(totalCharge));
					   chargeBean.setChargeSit(handleString(chargeSit));
				   }
			   }
			   else {
				   backNews="信息填写不完整";
				   chargeBean.setBackNews(backNews);
			   }
			   con.close();
		   }
		   catch(SQLException exp) {
			   backNews="输入有错，请重新输入";
			   chargeBean.setBackNews(backNews);
		   }
		   RequestDispatcher dispatcher = 
	       request.getRequestDispatcher("inputCharge.jsp");
   	   dispatcher.forward(request, response);            //转发
		   
		  		   
	   }
	 
	   
	   
	   
	  	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
	       doPost(request,response);
	   }
}
