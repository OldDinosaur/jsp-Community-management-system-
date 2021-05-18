<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="chargeBean" class="mybean.login.chargeBean" scope="request"/>
<style type="text/css">
td{

   text-align:right;
}
</style>
<html>
<br>
<head>
<title>添加收费单信息</title>
</head>
<%@ include file="user.txt" %>
<body bgcolor="cyan">
<div align="center">
<form action="chargeServlet" method="post">
*注释的项必须填写。
<table >
    
    <tr>
        <td>*单据编号:</td><td><input type=text name="chargeNum"></td>
        <td>*房屋号:</td><td><input type=text name="houseNum"></td>      
    </tr>
    
     <tr>
        <td>户主名:</td><td><input type=text name="houserName"></td>
        <td>户主联系电话:</td><td><input type=text name="houserNum"></td>      
    </tr>
    
     <tr>
        <td>收费总额:</td><td><input type=text name="totalCharge"></td>
        <td>收费时间:</td><td><input type=text name="chargeTime"></td>      
    </tr>
     <tr>
        <td>收费情况:</td><td><input type=radio name="chargeSit" value="已收费">已收费<input type=radio name="chargeSit" value="未收费">未收费</td>
        <td></td><td></td>      
    </tr>
    <tr><td><input type=submit name="submit"  value="提交">
        </td><td></td><td><input type=reset name="reset"  value="重置"></td><td></td>
    </tr>
</table>
</form>
</div>
<div align="center">
<p>反馈信息：
<jsp:getProperty name="chargeBean" property="backNews"/>
<table border=3>
     <tr>
     <td>单据编号：</td>
     <td><jsp:getProperty name="chargeBean" property="chargeNum"/></td>
     </tr>
     <tr>
     <td>房屋号：</td>
     <td><jsp:getProperty name="chargeBean" property="houseNum"/></td>
     </tr>
     <tr>
     <td>收费总额：</td>
     <td><jsp:getProperty name="chargeBean" property="totalCharge"/></td>
     </tr>
     <tr>
     <td>收费情况：</td>
     <td><jsp:getProperty name="chargeBean" property="chargeSit"/></td>
     </tr>
</table>
</div>
</body>
</html>