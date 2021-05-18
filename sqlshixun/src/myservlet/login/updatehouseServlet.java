package myservlet.login;
import mybean.login.houseBean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class updatehouseServlet extends HttpServlet{
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
		   String uri= "jdbc:sqlserver://localhost:1433;DatabaseName=JSPsx";
		   
		   Connection con;
		   PreparedStatement sql;
		   ResultSet rs;
		 
		   String houseNum = request.getParameter("houseNum").trim();         
		   String houseUnit = request.getParameter("houseUnit").trim();
		   String houseArea = request.getParameter("houseArea").trim();
		   String houserName = request.getParameter("houserName").trim();
		   String houserNum = request.getParameter("houserNum").trim();
		   String houserID= request.getParameter("houserID").trim();
		   String moveDate = request.getParameter("moveDate").trim();
		   String housePro= request.getParameter("housePro").trim();
		   String remarks = request.getParameter("remarks").trim();
		   if (houseNum==null)
		   {
			   houseNum="";
		   }
		   if (houseUnit==null)
		   {
			   houseUnit="";
		   }
		   if (houserNum==null)
		   {
			   houserNum="";
		   }
		   if(houseArea==null)
		   {
			   houseArea="";
		   }
		   
		   boolean u= true;
		   for(int i=0;i<houseNum.length();i++)//�ж��û����Ƿ���ȷ
		   {
			   char c =houseNum.charAt(i);
			   if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')||(c=='_')))
				   u=false;
			   
		   }
		   boolean boo=houseNum.length()>0&&houseUnit.length()>0&&houseArea.length()>0&&u;
	    
		   try {
			   con=DriverManager.getConnection(uri,"sa","cjj123456789");
			   String insertCondition ="UPDATE ProInformation SET ���ݺ�=?,��Ԫ=?,�������=?,������=?,������ϵ�绰=?,�������֤=?,Ǩ������=?,��Ȩ״��=?,��ע=? where ���ݺ�=?";
		
			   sql =con.prepareStatement(insertCondition);
			
			   if(boo)
			   {    
				   
				   sql.setString(1, handleString(houseNum));
				   sql.setString(2, handleString(houseUnit));
				   sql.setString(3, handleString(houseArea));
				   sql.setString(4, handleString(houserName));
				   sql.setString(5, handleString(houserNum ));
				   sql.setString(6, handleString(houserID));
				   sql.setString(7, handleString(moveDate));
				   sql.setString(8, handleString(housePro));
				   sql.setString(9, handleString(remarks));
				   sql.setString(10, handleString(houseNum));
				   int m=sql.executeUpdate();
				   if(m!=0) {

					   System.out.println("�޸ĳɹ�"); 
				   }
				   
				   
			   }
			   else {
				   System.out.print("��Ϣ��д���������������зǷ��ַ�");
				 
			   }
			   con.close();
		   }
		   catch(SQLException exp) {
                   System.out.println(exp);
		   }
		   
		   RequestDispatcher dispatcher = 
	               request.getRequestDispatcher("alterhouse.jsp");
				   dispatcher.forward(request, response);            //ת��      //ת��
	   }
	 
	   	   	   	  	   
	   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
	           throws ServletException,IOException{
	       doPost(request,response);
	   }
}
