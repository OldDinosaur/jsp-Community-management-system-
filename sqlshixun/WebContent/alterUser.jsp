<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="inputBean" class="mybean.login.inputBean" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<br>
<head>
<title>�޸��û���Ϣ</title>
</head>
<%@ include file="head.txt" %>
<body bgcolor=cyan>
<div align="center">
<form action="updateServlet" method="post">
�û����޷��޸ģ�*ע�͵�����뱣������д��
<table >
    
    <tr>
        <td>*�û���:</td><td><input type=text name="username" readonly value="<jsp:getProperty name="inputBean" property="username"/>"></td>
        <td>*����:</td><td><input type=password name="password" value="<jsp:getProperty name="inputBean" property="password"/>"></td>      
    </tr>
     <tr>
        <td></td> <td></td>
        <td>*�ظ�����:</td><td><input type=password name="again_password" value="<jsp:getProperty name="inputBean" property="again_password"/>"></td>      
    </tr>
    <tr>
        <td>*Ȩ��:</td><td><input type=radio name="power" value="ϵͳ����Ա" <jsp:getProperty name="inputBean" property="quanxian1"/> >ϵͳ����Ա<input type=radio name="power" value="С������Ա" <jsp:getProperty name="inputBean" property="quanxian2"/>>С������Ա</td>
        <td>����:</td><td><input type=text name="name" value="<jsp:getProperty name="inputBean" property="name"/>"></td>      
    </tr>
    <tr>
        <td>�Ա�:</td><td><input type=radio name="sex" value="��"  <jsp:getProperty name="inputBean" property="xingbie1"/>>��<input type=radio name="sex" value="Ů" <jsp:getProperty name="inputBean" property="xingbie2"/>>Ů</td>
        <td>��ϵ�绰:</td><td><input type=text name="number" value="<jsp:getProperty name="inputBean" property="number"/>"></td>      
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
    	  
    	  location.href="queryAllServlet";
    		
      }
</script>