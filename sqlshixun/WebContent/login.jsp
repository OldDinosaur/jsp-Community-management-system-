 <%@ page language="java" contentType="text/html; charset=gb2312"%>
 <script>                                      
  var errori='<%=request.getParameter("error") %>';
  switch(errori){
     case "no1": alert("密码错误！");break;
     case "no2": alert("请输入密码！");break;
     case "no3": alert("用户不存在，请输入用户名和密码！");break;
  }
  function getData(){
		$.ajax({  
			url:"",//servlet文件的名称
			type:"GET",
			}
		);
	}
</script>

<style type="text/css" >
html{
      height:100%
}
body{
   background-image:url(timg2.jpg);
   background-size:100% 100%;
   padding: 0;
   margin: 0;
}
td{

   text-align:right;
}
#tt{
height:200px;
width:300px;
top:40%;
left:50%;
position:absolute;
margin-top:-100px;
margin-left:-100px;
}
td{
text-align:center;
vertical-align:middle;
}
</style>
<html>
<head>
<title>登录</title>
</head>
<body onload="getData()">

<form action="loginServlet" method="post">
<table  id="tt">
    <caption><strong><h2>小区物业管理系统</h2></strong></caption>
   <tr><td> 用户名:<input type=text name="usernumber"></td></tr>
   <tr><td> 密码:&nbsp;&nbsp;<input type=password name="password"></td></tr>
    <tr><td><input type=submit name="submit"  value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<input type=reset name="reset"  value="取消"></td></tr>
</table>
</form>
</body>
</html>
