<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="staffBean" class="mybean.login.staffBean" scope="session"/>
<style type="text/css">
td{

   text-align:right;
}
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�޸�Ա����Ϣ</title>
</head>
<%@ include file="user.txt" %>
<body bgcolor="cyan">
<div align="center">
<form action="updatestaffServlet" method="post">
      <img src="<jsp:getProperty name="staffBean" property="staffPic"/>" width=60><br>
*ע�͵����޷����ġ�
<table >
    
    <tr>
        <td>*Ա�����:<input type=text name="staffNum" readonly value="<jsp:getProperty name="staffBean" property="staffNum"/>"></td>
        <td>����:<input type=text name="staffName" value="<jsp:getProperty name="staffBean" property="staffName"/>"></td>
      
    </tr>
    
     <tr>
     
        <td>�Ա�:<input type=radio name="staffSex" value="��" <jsp:getProperty name="staffBean" property="xiangbie1"/>>��<input type=radio name="staffSex" value="Ů" <jsp:getProperty name="staffBean" property="xingbie2"/>>Ů</td>
        <td>����:<input type=text name="staffAge" value="<jsp:getProperty name="staffBean" property="staffAge"/>"></td>      
    </tr>

     <tr>
        <td>���֤��:<input type=text name="staffID" value="<jsp:getProperty name="staffBean" property="staffID"/>"></td>
        <td>�������ڵ�:<input type=text name="staffLocation" value="<jsp:getProperty name="staffBean" property="staffLocation"/>"></td>      
    </tr>
    
       <tr>
        <td>��ϵ�绰:<input type=text name="staffPhong" value="<jsp:getProperty name="staffBean" property="staffPhong"/>"></td>
        <td>��������:<input type=text name="jobType" value="<jsp:getProperty name="staffBean" property="jobType"/>"></td>      
    </tr>
       <tr>
       <td></td>
        <td>��Ƭ:<input type="file" name="staffPic" size="40" ></td> 
    </tr>
    
    <tr><td><input type=submit name="submit"  value="�ύ">
        </td><td><input type=button name="reset" onclick="f()" value="����"></td>
    </tr>
</table>
</form>
</div>
</body>
</html>
<script type="text/javascript">

      function f(){
    	  
    	  location.href="viewstaffServlet";
    		
      }
</script>