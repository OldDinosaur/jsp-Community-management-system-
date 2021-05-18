<%@ page language="java" contentType="text/html; charset=gb2312"%>
<jsp:useBean id="inputBean" class="mybean.login.inputBean" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<br>
<head>
<title>修改用户信息</title>
</head>
<%@ include file="head.txt" %>
<body bgcolor=cyan>
<div align="center">
<form action="updateServlet" method="post">
用户名无法修改，*注释的项必须保留或填写。
<table >
    
    <tr>
        <td>*用户名:</td><td><input type=text name="username" readonly value="<jsp:getProperty name="inputBean" property="username"/>"></td>
        <td>*密码:</td><td><input type=password name="password" value="<jsp:getProperty name="inputBean" property="password"/>"></td>      
    </tr>
     <tr>
        <td></td> <td></td>
        <td>*重复密码:</td><td><input type=password name="again_password" value="<jsp:getProperty name="inputBean" property="again_password"/>"></td>      
    </tr>
    <tr>
        <td>*权限:</td><td><input type=radio name="power" value="系统管理员" <jsp:getProperty name="inputBean" property="quanxian1"/> >系统管理员<input type=radio name="power" value="小区管理员" <jsp:getProperty name="inputBean" property="quanxian2"/>>小区管理员</td>
        <td>姓名:</td><td><input type=text name="name" value="<jsp:getProperty name="inputBean" property="name"/>"></td>      
    </tr>
    <tr>
        <td>性别:</td><td><input type=radio name="sex" value="男"  <jsp:getProperty name="inputBean" property="xingbie1"/>>男<input type=radio name="sex" value="女" <jsp:getProperty name="inputBean" property="xingbie2"/>>女</td>
        <td>联系电话:</td><td><input type=text name="number" value="<jsp:getProperty name="inputBean" property="number"/>"></td>      
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
    	  
    	  location.href="queryAllServlet";
    		
      }
</script>