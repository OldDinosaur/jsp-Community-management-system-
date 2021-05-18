<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="staffBean" class="mybean.login.staffBean" scope="request"/>
<style type="text/css">
td{

   text-align:right;
}
</style>
<html>
<br>
<head>
<title>添加员工信息</title>
</head>
<%@ include file="user.txt" %>
<body bgcolor="cyan">
<div align="center">
<form action="staffServlet" method="post" >
*注释的项必须填写。
<table >
    
    <tr>
        <td>*员工编号:<input type=text name="staffNum"></td>
        <td>*姓名:<input type=text name="staffName"></td>      
    </tr>
    
     <tr>
     
        <td>性别:<input type=radio name="staffSex" value="男">男<input type=radio name="staffSex" value="女">女</td>
        <td>年龄:<input type=text name="staffAge"></td>      
    </tr>
    
     <tr>
        <td>*身份证号:<input type=text name="staffID"></td>
        <td>户口所在地:<input type=text name="staffLocation"></td>      
    </tr>
    
       <tr>
        <td>*联系电话:<input type=text name="staffPhong"></td>
        <td>*工作类型:<input type=text name="jobType"></td>      
    </tr>
       <tr>
        <td>*照片:</td><td><input type="file" name="staffPic" size="40"></td> 
    </tr>
    

    <tr><td><input type=submit name="submit"  value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
       </td><td> <input type=reset name="reset"  value="重置"></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>反馈信息：
<jsp:getProperty name="staffBean" property="backNews"/>
<table border=3>
     <tr>
     <td>员工编号：</td>
     <td><jsp:getProperty name="staffBean" property="staffNum"/></td>
     </tr>
     <tr>
     <td>姓名：</td>
     <td><jsp:getProperty name="staffBean" property="staffName"/></td>
     </tr>
     <tr>
        <td>性别:</td>
        <td><jsp:getProperty name="staffBean" property="staffSex"/></td>
      
     </tr>
     <tr>
     <td>工作类型：</td>
     <td><jsp:getProperty name="staffBean" property="jobType"/></td>
     </tr>
</table>
</div>
</body>
</html>
<style type="text/css">
function preview(file) {
    var prevDiv = document.getElementById('preview');
     if (file.files && file.files[0]) {
         // 支持大多数浏览器， 谷歌， 火狐， 360 ， 欧朋  IE10.
       var reader = new FileReader();
        // $(function(){})  ==> window.οnlοad= function(){}
        reader.onload = function(evt) {
          prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100" height="100"/>';
         }
        reader.readAsDataURL(file.files[0]);
    }
}
</style>