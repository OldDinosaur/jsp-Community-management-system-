<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="chargeBean" class="mybean.login.chargeBean" scope="request"/>
<style type="text/css">
td{

   text-align:right;
}
</style>
<html>
<br>
<head>
<title>����շѵ���Ϣ</title>
</head>
<%@ include file="user.txt" %>
<body bgcolor="cyan">
<div align="center">
<form action="chargeServlet" method="post">
*ע�͵��������д��
<table >
    
    <tr>
        <td>*���ݱ��:</td><td><input type=text name="chargeNum"></td>
        <td>*���ݺ�:</td><td><input type=text name="houseNum"></td>      
    </tr>
    
     <tr>
        <td>������:</td><td><input type=text name="houserName"></td>
        <td>������ϵ�绰:</td><td><input type=text name="houserNum"></td>      
    </tr>
    
     <tr>
        <td>�շ��ܶ�:</td><td><input type=text name="totalCharge"></td>
        <td>�շ�ʱ��:</td><td><input type=text name="chargeTime"></td>      
    </tr>
     <tr>
        <td>�շ����:</td><td><input type=radio name="chargeSit" value="���շ�">���շ�<input type=radio name="chargeSit" value="δ�շ�">δ�շ�</td>
        <td></td><td></td>      
    </tr>
    <tr><td><input type=submit name="submit"  value="�ύ">
        </td><td></td><td><input type=reset name="reset"  value="����"></td><td></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>������Ϣ��
<jsp:getProperty name="chargeBean" property="backNews"/>
<table border=3>
     <tr>
     <td>���ݱ�ţ�</td>
     <td><jsp:getProperty name="chargeBean" property="chargeNum"/></td>
     </tr>
     <tr>
     <td>���ݺţ�</td>
     <td><jsp:getProperty name="chargeBean" property="houseNum"/></td>
     </tr>
     <tr>
     <td>�շ��ܶ</td>
     <td><jsp:getProperty name="chargeBean" property="totalCharge"/></td>
     </tr>
     <tr>
     <td>�շ������</td>
     <td><jsp:getProperty name="chargeBean" property="chargeSit"/></td>
     </tr>
</table>
</div>
</body>
</html>