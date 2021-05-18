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
<title>添加系统用户</title>
<%@ include file="head.txt" %>
</head>
<body bgcolor="cyan">
<div align="center">
<form action="inputServlet" method="post">
账号由数字、字母、下划线构成，*注释的项必须填写。
<table >
    
    <tr>
        <td>*用户名:</td><td><input type=text name="username"></td>
        <td>*密码:</td><td><input type=password name="password"></td>      
    </tr>
     <tr>
        <td></td> <td></td>
        <td>*重复密码:</td><td><input type=password name="again_password"></td>      
    </tr>
    <tr>
        <td>*权限:</td><td><input type=radio name="power" value="系统管理员">系统管理员<input type=radio name="power" value="小区管理员">小区管理员</td>
        <td>姓名:</td><td><input type=text name="name"></td>      
    </tr>
    <tr>
        <td>性别:</td><td><input type=radio name="sex" value="男">男<input type=radio name="sex" value="女">女</td>
        <td>联系电话:</td><td><input type=text name="number"></td>      
    </tr>
    <tr><td></td><td><input type=submit name="submit"  value="提交">
        </td><td><input type=reset name="reset"  value="重置"></td><td></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>反馈信息：
<jsp:getProperty name="inputBean" property="backNews"/>
<table border=3>
     <tr>
     <td>用户名：</td>
     <td><jsp:getProperty name="inputBean" property="username"/></td>
     </tr>
     <tr>
     <td>姓名：</td>
     <td><jsp:getProperty name="inputBean" property="name"/></td>
     </tr>
     <tr>
     <td>姓别：</td>
     <td><jsp:getProperty name="inputBean" property="sex"/></td>
     </tr>
     <tr>
     <td>联系电话：</td>
     <td><jsp:getProperty name="inputBean" property="number"/></td>
     </tr>
</table>
</div>
</body>
</html>