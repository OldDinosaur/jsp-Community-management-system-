<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="chargeBean" class="mybean.login.chargeBean" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�޸��շ���Ϣ</title>
</head>
<%@ include file="user.txt" %>
<body>
<div align="center">
<form action="updatechargeServlet" method="post">
*ע�͵����޷����ġ�
<table >
    
 <tr>
        <td>*���ݱ��:</td><td><input type=text name="chargeNum" readonly value="<jsp:getProperty name="chargeBean" property="chargeNum"/>"></td>
        <td>���ݺ�:</td><td><input type=text name="houseNum" value="<jsp:getProperty name="chargeBean" property="houseNum"/>"></td>      
    </tr>
    
     <tr>
        <td>������:</td><td><input type=text name="houserName" value="<jsp:getProperty name="chargeBean" property="houserName"/>"></td>
        <td>������ϵ�绰:</td><td><input type=text name="houserNum" value="<jsp:getProperty name="chargeBean" property="houserNum"/>"></td>      
    </tr>
    
     <tr>
        <td>�շ��ܶ�:</td><td><input type=text name="totalCharge" value="<jsp:getProperty name="chargeBean" property="totalCharge"/>"></td>
        <td>�շ�ʱ��:</td><td><input type=text name="chargeTime" value="<jsp:getProperty name="chargeBean" property="chargeTime"/>"></td>      
    </tr>
     <tr>
        <td>�շ����:</td><td><input type=radio name="chargeSit" value="���շ�" <jsp:getProperty name="chargeBean" property="shoufei1"/>>���շ�<input type=radio name="chargeSit" value="δ�շ�" <jsp:getProperty name="chargeBean" property="shoufei2"/>>δ�շ�</td>
        <td></td><td></td>      
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
    	  
    	  location.href="viewchargeServlet";
    		
      }
</script>