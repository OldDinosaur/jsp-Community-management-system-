<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="showBean" class="mybean.login.showBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<br>
<head>
<title>系统用户信息</title>
<%@ include file="head.txt" %>
</head>
<script language="javascript">
function getData(){
	$.ajax({  
		url:"",//servlet文件的名称
		type:"GET",
		}
	);
}
</script>
<body bgcolor=cyan onload="getData()"><div align="center">
 <br>
 <form action="queryAllServlet" method=post id="formid"><input type="submit" name="b" value="刷新"></form>
 <br>当前显示的内容是：
 <jsp:setProperty name="showBean" property="pageSize" param="pageSize"/>  <!-- 记录数 -->
 <jsp:setProperty name="showBean" property="currentPage" param="currentPage"/>  <!-- 当前显示页 -->


 <table border = 1>
 <%
    String [][] table =showBean.getTableRecord();
    if(table==null){
    	out.print("没有记录");
    	return;
    }
    String []columnName = showBean.getColumnName();
    if(columnName!=null){
    	out.print("<tr>");
    	for(int i=0;i<columnName.length;i++){
    		out.print("<th>"+columnName[i]+"</th>");
    	}
    	out.print("</th>");
    }
   int totalRecord =table.length; 
   out.println("全部记录数"+totalRecord);   //全部记录数
   int pageSize =showBean.getPageSize();
   int totalPages =showBean.getTotalPages();
      if(totalRecord%pageSize==0)
	      totalPages = totalRecord/pageSize;   //总页数
	   else
		   totalPages = totalRecord/pageSize+1;
      
  showBean.setPageSize(pageSize);    
  showBean.setTotalPages(totalPages); 
  if(totalPages>=1){
	  if(showBean.getCurrentPage()<1)
		  showBean.setCurrentPage(showBean.getTotalPages());
	  if(showBean.getCurrentPage()>showBean.getTotalPages())
		  showBean.setCurrentPage(1);
	  
      int index =(showBean.getCurrentPage()-1)*pageSize;
      int start = index;

      for(int i=index;i<pageSize +index;i++){
    	  if(i==totalRecord)
    		  break;
    	  out.print("<tr>");
    	  for(int j=0;j<columnName.length;j++){
    		  out.print("<td>"+table[i][j]+"</td>");
   
    	    		
    	  }
    	  //删除
 	      String del="<form action='deleteServlet' method='post'>"+
	    		  "<input type='hidden' name='delete' value="+table[i][0]+">"+"<input type='submit' value='删除'></form>";	    		 
    	  out.print("<td>"+del+"</td>");
    	  //修改
 	      String alter="<form action='alterServlet' method='post'>"+
	    		  "<input type='hidden' name='alter' value="+table[i][0]+">"+"<input type='submit' value='修改'></form>";	    		 
    	  out.print("<td>"+alter+"</td>");
    	  out.print("</tr>");
    	  
      }
		 	  
  }

 %>
 </table>

 <br>每页最多显示<jsp:getProperty name="showBean" property="pageSize"/>条信息
 <br>当前显示第<font color=blue>
     <jsp:getProperty name="showBean" property="currentPage"/>
     </font>页，共有
     <font color==blue>
             <jsp:getProperty name="showBean" property="totalPages"/>
     </font>页。
 </div>
 <div align="center">    
  <table>
     <tr>
     
     <td>
             <form action="" method=post>
                 <input type=hidden name="currentPage" value="<%= showBean.getCurrentPage()-1 %>">
                 <input type=submit name="g" value="上一页">
              </form>
     </td>
     <td></td>
     <td>
           <form action="" method =post>
               <input type=hidden name="currentPage" value="<%= showBean.getCurrentPage()+1 %>">
               <input type=submit name="g" value="下一页">
           </form>
     </td>
     </tr>
 
     <tr>
       <td>
         <form action="" method="post">
           每页显示<input type=text name="pageSize" size =3>
           条记录<input type=submit name="g" value="确定">
         </form>
       </td>
           <td>
         <form action="" method="post">
         输入页码：<input type=text name="currentPage"  size =2>
          <input type=submit name="g" value="提交">
         </form>
       </td>

     </tr>
 </table> 
 <br>
   <form action="" method=post>
         输入姓名：<input type=text name="uname" value="" >    
          <input type=submit name="g" value="查询">
                    
 </form>
 
</div></body>
</html>
<script>                                        //返回提示窗
  var errori='<%=request.getParameter("e") %>';
  switch(errori){
     case "no1": alert("删除成功");document.getElementById("formid").submit();break;
  }
</script>