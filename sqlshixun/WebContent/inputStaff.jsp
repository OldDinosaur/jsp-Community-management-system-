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
<title>���Ա����Ϣ</title>
</head>
<%@ include file="user.txt" %>
<body bgcolor="cyan">
<div align="center">
<form action="staffServlet" method="post" >
*ע�͵��������д��
<table >
    
    <tr>
        <td>*Ա�����:<input type=text name="staffNum"></td>
        <td>*����:<input type=text name="staffName"></td>      
    </tr>
    
     <tr>
     
        <td>�Ա�:<input type=radio name="staffSex" value="��">��<input type=radio name="staffSex" value="Ů">Ů</td>
        <td>����:<input type=text name="staffAge"></td>      
    </tr>
    
     <tr>
        <td>*���֤��:<input type=text name="staffID"></td>
        <td>�������ڵ�:<input type=text name="staffLocation"></td>      
    </tr>
    
       <tr>
        <td>*��ϵ�绰:<input type=text name="staffPhong"></td>
        <td>*��������:<input type=text name="jobType"></td>      
    </tr>
       <tr>
        <td>*��Ƭ:</td><td><input type="file" name="staffPic" size="40"></td> 
    </tr>
    

    <tr><td><input type=submit name="submit"  value="�ύ">&nbsp;&nbsp;&nbsp;&nbsp;
       </td><td> <input type=reset name="reset"  value="����"></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>������Ϣ��
<jsp:getProperty name="staffBean" property="backNews"/>
<table border=3>
     <tr>
     <td>Ա����ţ�</td>
     <td><jsp:getProperty name="staffBean" property="staffNum"/></td>
     </tr>
     <tr>
     <td>������</td>
     <td><jsp:getProperty name="staffBean" property="staffName"/></td>
     </tr>
     <tr>
        <td>�Ա�:</td>
        <td><jsp:getProperty name="staffBean" property="staffSex"/></td>
      
     </tr>
     <tr>
     <td>�������ͣ�</td>
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
         // ֧�ִ����������� �ȸ裬 ����� 360 �� ŷ��  IE10.
       var reader = new FileReader();
        // $(function(){})  ==> window.��nl��ad= function(){}
        reader.onload = function(evt) {
          prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100" height="100"/>';
         }
        reader.readAsDataURL(file.files[0]);
    }
}
</style>