<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="houseBean" class="mybean.login.houseBean" scope="request"/>
<style type="text/css">
td{

   text-align:right;
}
</style>
<html>
<br>
<head>
<title>��ӷ�����Ϣ</title>
</head>
<%@ include file="user.txt" %>
<body>
<body bgcolor="cyan">
<div align="center">
<form action="houseServlet" method="post">
*ע�͵��������д��
<table >
    
    <tr>
        <td>*���ݺţ���ʽ����Ԫ+0405��:</td><td><input type=text name="houseNum"></td>
        <td>*��Ԫ:</td><td><input type=text name="houseUnit"></td>      
    </tr>
    
     <tr>
        <td>*�������(ƽ����):</td><td><input type=text name="houseArea"></td>
        <td>������:</td><td><input type=text name="houserName"></td>      
    </tr>
    
     <tr>
        <td>������ϵ�绰:</td><td><input type=text name="houserNum"></td>
        <td>�������֤:</td><td><input type=text name="houserID"></td>      
    </tr>
     <tr>
        <td>Ǩ������:</td><td><input type=text name="moveDate"></td>
        <td>��Ȩ״��:</td><td><input type=text name="housePro"></td>      
    </tr>
     <tr>
        <td>��ע:</td><td><input type=text name="remarks"></td>
    </tr>
    <tr><td><input type=submit name="submit"  value="�ύ">
        </td><td></td><td><input type=reset name="reset"  value="����"></td><td></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>������Ϣ��
<jsp:getProperty name="houseBean" property="backNews"/>
<table border=3>
     <tr>
     <td>��������</td>
     <td><jsp:getProperty name="houseBean" property="houserName"/></td>
     </tr>
     <tr>
     <td>���ݺţ�</td>
     <td><jsp:getProperty name="houseBean" property="houseNum"/></td>
     </tr>
     <tr>
     <td>��Ԫ��</td>
     <td><jsp:getProperty name="houseBean" property="houseUnit"/></td>
     </tr>
     <tr>
     <td>��ϵ�绰��</td>
     <td><jsp:getProperty name="houseBean" property="houserNum"/></td>
     </tr>
</table>
</div>
</body>
</html>