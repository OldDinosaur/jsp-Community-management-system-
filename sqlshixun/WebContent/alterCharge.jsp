<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="chargeBean" class="mybean.login.chargeBean" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改收费信息</title>
</head>
<%@ include file="user.txt" %>
<body>
<div align="center">
<form action="updatechargeServlet" method="post">
*注释的项无法更改。
<table >
    
 <tr>
        <td>*单据编号:</td><td><input type=text name="chargeNum" readonly value="<jsp:getProperty name="chargeBean" property="chargeNum"/>"></td>
        <td>房屋号:</td><td><input type=text name="houseNum" value="<jsp:getProperty name="chargeBean" property="houseNum"/>"></td>      
    </tr>
    
     <tr>
        <td>户主名:</td><td><input type=text name="houserName" value="<jsp:getProperty name="chargeBean" property="houserName"/>"></td>
        <td>户主联系电话:</td><td><input type=text name="houserNum" value="<jsp:getProperty name="chargeBean" property="houserNum"/>"></td>      
    </tr>
    
     <tr>
        <td>收费总额:</td><td><input type=text name="totalCharge" value="<jsp:getProperty name="chargeBean" property="totalCharge"/>"></td>
        <td>收费时间:</td><td><input type=text name="chargeTime" value="<jsp:getProperty name="chargeBean" property="chargeTime"/>"></td>      
    </tr>
     <tr>
        <td>收费情况:</td><td><input type=radio name="chargeSit" value="已收费" <jsp:getProperty name="chargeBean" property="shoufei1"/>>已收费<input type=radio name="chargeSit" value="未收费" <jsp:getProperty name="chargeBean" property="shoufei2"/>>未收费</td>
        <td></td><td></td>      
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
    	  
    	  location.href="viewchargeServlet";
    		
      }
</script>