<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="inputBean" class="mybean.login.inputBean" scope="session"/>
<style type="text/css">
td{

   text-align:right;
}
</style>
<html>
<br>
<head>
<title>���ϵͳ�û�</title>
<%@ include file="head.txt" %>
</head>
<body bgcolor="cyan">
<div align="center">
<form action="inputServlet" method="post">
�˺������֡���ĸ���»��߹��ɣ�*ע�͵��������д��
<table >
    
    <tr>
        <td>*�û���:</td><td><input type=text name="username"></td>
        <td>*����:</td><td><input type=password name="password"></td>      
    </tr>
     <tr>
        <td></td> <td></td>
        <td>*�ظ�����:</td><td><input type=password name="again_password"></td>      
    </tr>
    <tr>
        <td>*Ȩ��:</td><td><input type=radio name="power" value="ϵͳ����Ա">ϵͳ����Ա<input type=radio name="power" value="С������Ա">С������Ա</td>
        <td>����:</td><td><input type=text name="name"></td>      
    </tr>
    <tr>
        <td>�Ա�:</td><td><input type=radio name="sex" value="��">��<input type=radio name="sex" value="Ů">Ů</td>
        <td>��ϵ�绰:</td><td><input type=text name="number"></td>      
    </tr>
    <tr><td></td><td><input type=submit name="submit"  value="�ύ">
        </td><td><input type=reset name="reset"  value="����"></td><td></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>������Ϣ��
<jsp:getProperty name="inputBean" property="backNews"/>
<table border=3>
     <tr>
     <td>�û�����</td>
     <td><jsp:getProperty name="inputBean" property="username"/></td>
     </tr>
     <tr>
     <td>������</td>
     <td><jsp:getProperty name="inputBean" property="name"/></td>
     </tr>
     <tr>
     <td>�ձ�</td>
     <td><jsp:getProperty name="inputBean" property="sex"/></td>
     </tr>
     <tr>
     <td>��ϵ�绰��</td>
     <td><jsp:getProperty name="inputBean" property="number"/></td>
     </tr>
</table>
</div>
</body>
</html>