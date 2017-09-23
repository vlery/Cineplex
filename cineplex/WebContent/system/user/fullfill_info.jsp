<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="alert" uri="/WEB-INF/tlds/alert.tld" %>
<%@ taglib prefix="province" uri="/WEB-INF/tlds/provinceSelect.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="registerInfo" 
    type="net.cineplex.webmodel.RegisterInfo"
    scope="session">
</jsp:useBean>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院在线-完善信息</title>
	<%@ include file="import.jsp" %>
</head>
	
<body>
	<%@ include file="../header.jsp" %>
	<br/>
	
	<div class="am-g">
  		<div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
   			 <div class="register_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
    				<alert:show/>
       			 <form method="post" class="am-form" action="../../register" id="info_form" name="info_form" >

          				<label for="confirm_password">确认密码:</label>
        			    <input class="register_input" type="password" name="confirm_password" id="confirm_password" value="" required>
          

				        <label  for="name" >姓名:</label>
				        <input class="register_input" type="text" name="username" id="username" value="<jsp:getProperty name="registerInfo" property="name" />" required>
				
				        <label  for="gender" >性别:</label>
				        
				        <br/>
				         
				        <div class="am-u-sm-2 am-u-md-3 am-u-lg-3">
				        	<label class="am-radio">
				           		<input  type="radio" name="gender" value="男" data-am-ucheck required  
				           		
				           		<% if(registerInfo.checkGender("男")){
				           			  out.println("checked");	
				           			}
				           		%>
				           		> 男
				          	</label>
				        </div>
				         
				        <div class="am-u-sm-10 am-u-md-9 am-u-lg-9">
				         	 <label class="am-radio">
				           		<input type="radio" name="gender" value="女" data-am-ucheck
				           		<% if(registerInfo.checkGender("女")){
				           			  out.println("checked");	
				           			}
				           		%>
				           		> 女
				             </label>
				        </div>
				        <label  for="birthday" >出生日期:</label>
				          
				        <div class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'yyyy-mm-dd', viewMode: 'years'}" >
				              <input type="text" class="am-form-field" name="birthday" id="birthday" value="<jsp:getProperty name="registerInfo" property="birthday" />" required pattern="^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$">
				        	  <span class="am-input-group-btn am-datepicker-add-on">
				              	<button class="am-btn am-btn-default" type="button"><span class="am-icon-calendar"></span> </button>
				              </span>
				        </div>
				      
				        <br/>
				        
				        <div>
				          
				          <label  for="province" >所在省  : &nbsp; &nbsp; &nbsp; &nbsp; </label>
				                <province:select />
				        </div>
				         
				        <br/>
				          
				        <div>
				          <label  for="city" >所在市  : &nbsp; &nbsp; &nbsp; &nbsp;  </label>
				          <select  name="city" id="city" value="<jsp:getProperty name="registerInfo"  property="city" />"  required  />
				          	      
				          </select>     
				        </div>
				
				        <br/>
				        
				        
				        
				
				        <label  for="mail" >邮箱:</label>
				        <input class="register_input" type="email" name="mail" id="mail" value="<jsp:getProperty name="registerInfo" property="mail" />" required>
				
				        <label  for="tel" >电话:</label>
				        <input class="register_input" type="text" name="tel" id="tel" value="<jsp:getProperty name="registerInfo" property="tel" />" required>
				
				        <label  for="bankID" >银行卡号:</label>
				        <input class="register_input" type="text" name="bankID" id="bankID" value="<jsp:getProperty name="registerInfo" property="bankID" />" required>
				
				        <br/>
				         
				         
				         
				        <div class="am-u-sm-centered am-u-lg-12 am-u-md-12">
				              <input type="reset" name="reset" value="重 置" class="am-btn am-btn-primary am-btn-sm register_button am-fl">
				              <input type="submit" name="register" value="注 册" class="am-btn am-btn-primary am-btn-sm register_button am-fr">
				        </div>
				</form>
   			 </div>
   			 
   		</div>
   		<br/>
  		<br/>
   		<br/>
   		<%@ include file="../footer.jsp" %>
   	</div>
   
	

	
</body>
</html>