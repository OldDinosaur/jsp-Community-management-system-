<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="showBean" class="mybean.login.showBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script language="javascript">
function getData(){
	$.ajax({  
		url:"",//servlet�ļ�������
		type:"GET",
		}
	);
}
</script>

<html>
<head>
<title>����շѵ�</title>
<%@ include file="user.txt" %>
</head>
<body  onload="getData()" bgcolor="cyan"><div  align="center">
 <br>
 <form action="viewstaffServlet" method=post id="formid"><input type="submit" name="b" value="ˢ��"></form>
 <br>��ǰ��ʾ�������ǣ�
 <jsp:setProperty name="showBean" property="pageSize" param="pageSize"/>  <!-- ��¼�� -->
 <jsp:setProperty name="showBean" property="currentPage" param="currentPage"/>  <!-- ��ǰ��ʾҳ -->


 <table  id="tt" border=1 >
 <%

 
    String [][] table =showBean.getTableRecord();
    if(table==null){
    	out.print("û�м�¼");
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
   out.println("ȫ����¼��"+totalRecord);   //ȫ����¼��
   int pageSize =showBean.getPageSize();
   int totalPages =showBean.getTotalPages();
      if(totalRecord%pageSize==0)
	      totalPages = totalRecord/pageSize;   //��ҳ��
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
    		  if(j<8)
                out.print("<td>"+table[i][j]+"</td>");  
    		  else
    			  out.print("<td><img src="+table[i][j]+" width='80'height='80' ></td>"); 
    	  }
    	  
    	  //ɾ��
 	      String del="<form action='staffServlet' method='get'>"+
	    		  "<input type='hidden' name='delete' value="+table[i][0]+">"+"<input type='submit' value='ɾ��'></form>";	    		 
    	  out.print("<td>"+del+"</td>");
    	  //�޸�
 	      String alter="<form action='alterstaffServlet' method='post'>"+
	    		  "<input type='hidden' name='alter' value="+table[i][0]+">"+"<input type='submit' value='�޸�'></form>";	    		 
    	  out.print("<td>"+alter+"</td>");
    	  out.print("</tr>");
    	  
      }
		 	  
  }

 %>
 </table>

 <br>ÿҳ�����ʾ<jsp:getProperty name="showBean" property="pageSize"/>����Ϣ
 <br>��ǰ��ʾ��<font color=blue>
     <jsp:getProperty name="showBean" property="currentPage"/>
     </font>ҳ������
     <font color==blue>
             <jsp:getProperty name="showBean" property="totalPages"/>
     </font>ҳ��
 </div>
 <div align="center">    
  <table>
     <tr>
     
     <td>
             <form action="" method=post>
                 <input type=hidden name="currentPage" value="<%= showBean.getCurrentPage()-1 %>">
                 <input type=submit name="g" value="��һҳ">
              </form>
     </td>
     <td></td>
     <td>
           <form action="" method =post>
               <input type=hidden name="currentPage" value="<%= showBean.getCurrentPage()+1 %>">
               <input type=submit name="g" value="��һҳ">
           </form>
     </td>
     </tr>
 
     <tr>
       <td>
         <form action="" method="post">
           ÿҳ��ʾ<input type=text name="pageSize" size =3>
           ����¼<input type=submit name="g" value="ȷ��">
         </form>
       </td>
           <td>
         <form action="" method="post">
         ����ҳ�룺<input type=text name="currentPage"  size =2>
          <input type=submit name="g" value="�ύ">
         </form>
       </td>

     </tr>
 </table> 
 <br>
   <form action="" method=post>
         ����������<input type=text name="houserName" value="" >    
          <input type=submit name="g" value="��ѯ">
                    
 </form>
 
</div>

</body>
</html>
<script>                                        //������ʾ��
  var errori='<%=request.getParameter("e") %>';
  switch(errori){
     case "no1": alert("ɾ���ɹ�");document.getElementById("formid").submit();break;
  }
</script>