<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="houseBean" class="mybean.login.houseBean" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改房产信息</title>
</head>
<%@ include file="user.txt" %>
<body>
<div align="center">
<form action="updatehouseServlet" method="post">
*注释的项无法更改。
<table >
    
<tr>
        <td>*房屋号（格式：单元+0405）:</td><td><input type=text name="houseNum" readonly value="<jsp:getProperty name="houseBean" property="houseNum"/>"></td>
        <td>*单元:</td><td><input type=text name="houseUnit" readonly value="<jsp:getProperty name="houseBean" property="houseUnit"/>"></td>      
    </tr>
    
     <tr>
        <td>*房屋面积(平方米):</td><td><input type=text name="houseArea" readonly value="<jsp:getProperty name="houseBean" property="houseArea"/>"></td>
        <td>户主名:</td><td><input type=text name="houserName" value="<jsp:getProperty name="houseBean" property="houserName"/>"></td>      
    </tr>
    
     <tr>
        <td>户主联系电话:</td><td><input type=text name="houserNum" value="<jsp:getProperty name="houseBean" property="houserNum"/>"></td>
        <td>户主身份证:</td><td><input type=text name="houserID" value="<jsp:getProperty name="houseBean" property="houserID"/>"></td>      
    </tr>
     <tr>
        <td>迁入日期:</td><td><input type=text name="moveDate" value="<jsp:getProperty name="houseBean" property="moveDate"/>"></td>
        <td>产权状况:</td><td><input type=text name="housePro" value="<jsp:getProperty name="houseBean" property="housePro"/>"></td>      
    </tr>
     <tr>
        <td>备注:</td><td><input type=text name="remarks" value="<jsp:getProperty name="houseBean" property="remarks"/>"></td>
    </tr>
    <tr><td></td><td><input type=submit name="submit"  value="提交">
        </td><td><input type=button name="reset" onclick="f()" value="返回"></td><td></td>
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