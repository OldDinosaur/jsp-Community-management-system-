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
<title>添加房产信息</title>
</head>
<%@ include file="user.txt" %>
<body>
<body bgcolor="cyan">
<div align="center">
<form action="houseServlet" method="post">
*注释的项必须填写。
<table >
    
    <tr>
        <td>*房屋号（格式：单元+0405）:</td><td><input type=text name="houseNum"></td>
        <td>*单元:</td><td><input type=text name="houseUnit"></td>      
    </tr>
    
     <tr>
        <td>*房屋面积(平方米):</td><td><input type=text name="houseArea"></td>
        <td>户主名:</td><td><input type=text name="houserName"></td>      
    </tr>
    
     <tr>
        <td>户主联系电话:</td><td><input type=text name="houserNum"></td>
        <td>户主身份证:</td><td><input type=text name="houserID"></td>      
    </tr>
     <tr>
        <td>迁入日期:</td><td><input type=text name="moveDate"></td>
        <td>产权状况:</td><td><input type=text name="housePro"></td>      
    </tr>
     <tr>
        <td>备注:</td><td><input type=text name="remarks"></td>
    </tr>
    <tr><td><input type=submit name="submit"  value="提交">
        </td><td></td><td><input type=reset name="reset"  value="重置"></td><td></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>反馈信息：
<jsp:getProperty name="houseBean" property="backNews"/>
<table border=3>
     <tr>
     <td>户主名：</td>
     <td><jsp:getProperty name="houseBean" property="houserName"/></td>
     </tr>
     <tr>
     <td>房屋号：</td>
     <td><jsp:getProperty name="houseBean" property="houseNum"/></td>
     </tr>
     <tr>
     <td>单元：</td>
     <td><jsp:getProperty name="houseBean" property="houseUnit"/></td>
     </tr>
     <tr>
     <td>联系电话：</td>
     <td><jsp:getProperty name="houseBean" property="houserNum"/></td>
     </tr>
</table>
</div>
</body>
</html>