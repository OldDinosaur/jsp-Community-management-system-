<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="houseBean" class="mybean.login.houseBean" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�޸ķ�����Ϣ</title>
</head>
<%@ include file="user.txt" %>
<body>
<div align="center">
<form action="updatehouseServlet" method="post">
*ע�͵����޷����ġ�
<table >
    
<tr>
        <td>*���ݺţ���ʽ����Ԫ+0405��:</td><td><input type=text name="houseNum" readonly value="<jsp:getProperty name="houseBean" property="houseNum"/>"></td>
        <td>*��Ԫ:</td><td><input type=text name="houseUnit" readonly value="<jsp:getProperty name="houseBean" property="houseUnit"/>"></td>      
    </tr>
    
     <tr>
        <td>*�������(ƽ����):</td><td><input type=text name="houseArea" readonly value="<jsp:getProperty name="houseBean" property="houseArea"/>"></td>
        <td>������:</td><td><input type=text name="houserName" value="<jsp:getProperty name="houseBean" property="houserName"/>"></td>      
    </tr>
    
     <tr>
        <td>������ϵ�绰:</td><td><input type=text name="houserNum" value="<jsp:getProperty name="houseBean" property="houserNum"/>"></td>
        <td>�������֤:</td><td><input type=text name="houserID" value="<jsp:getProperty name="houseBean" property="houserID"/>"></td>      
    </tr>
     <tr>
        <td>Ǩ������:</td><td><input type=text name="moveDate" value="<jsp:getProperty name="houseBean" property="moveDate"/>"></td>
        <td>��Ȩ״��:</td><td><input type=text name="housePro" value="<jsp:getProperty name="houseBean" property="housePro"/>"></td>      
    </tr>
     <tr>
        <td>��ע:</td><td><input type=text name="remarks" value="<jsp:getProperty name="houseBean" property="remarks"/>"></td>
    </tr>
    <tr><td></td><td><input type=submit name="submit"  value="�ύ">
        </td><td><input type=button name="reset" onclick="f()" value="����"></td><td></td>
    </tr>
</table>
</form>
</div>
</body>
</html>
<script type="text/javascript">

      function f(){
    	  
    	  location.href="viewhouseServlet";
    		
      }
</script>