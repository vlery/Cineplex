<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="alert" uri="/WEB-INF/tlds/alert.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="log_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
        			<alert:show/>
        			<form method="post" class="am-form" action="enter" >
          				<label  for="nickname" >用户名:</label>
          				<input class="log_input" type="text" name="nickname" id="nickname" value=""  required />
         				<label for="password">密码:</label>
          				<input class="log_input" type="password" name="password" id="password" value="" required/>
          				
          				<br/>
          
          				<label for="remember_me" class="am-fr">
          			  		<input id="remember_me" name="remember_me" type="checkbox" value="remeber_me">记住密码
          				</label>
          				
          				<br/>
          				<br/>
			      	
			      	    <div class="am-cf" >
			            	<div class="am-u-lg-4 am-u-md-4 am-u-sm-5">
			                	<input type="submit" name="admin_login" value="管理员入口" class="am-btn am-btn-default am-btn-sm am-fl">
			           		</div>
			            	<div class="am-u-lg-8 am-u-md-8 am-u-sm-7">
			                	<input type="submit" name="login" value="&nbsp; &nbsp;登 录&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
			                	<label class="am-fr">&nbsp;&nbsp;</label>
			             		<input type="submit" name="register" value="&nbsp; &nbsp;注 册&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
			            	</div>
			         	</div>
			        </form>
			    </div>
			    
			    <br/>
    			<br/>