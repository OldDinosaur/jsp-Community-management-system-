 <%@ page language="java" contentType="text/html; charset=gb2312"%>
 <script>                                      
  var errori='<%=request.getParameter("error") %>';
  switch(errori){
     case "no1": alert("�������");break;
     case "no2": alert("���������룡");break;
     case "no3": alert("�û������ڣ��������û��������룡");break;
  }
  function getData(){
		$.ajax({  
			url:"",//servlet�ļ�������
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
<title>��¼</title>
</head>
<body onload="getData()">

<form action="loginServlet" method="post">
<table  id="tt">
    <caption><strong><h2>С����ҵ����ϵͳ</h2></strong></caption>
   <tr><td> �û���:<input type=text name="usernumber"></td></tr>
   <tr><td> ����:&nbsp;&nbsp;<input type=password name="password"></td></tr>
    <tr><td><input type=submit name="submit"  value="��¼">&nbsp;&nbsp;&nbsp;&nbsp;<input type=reset name="reset"  value="ȡ��"></td></tr>
</table>
</form>
</body>
</html>
