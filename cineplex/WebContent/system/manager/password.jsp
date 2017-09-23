<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<html>
<head>
	  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>

</head>
<body>

<%@ include file="header.jsp" %>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  	<%@ include file="sidebar.jsp" %>
  <!-- sidebar end -->

 
  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">密码</strong> / <small>password</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#modify">修改</a></li>
	        
	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="modify">
	              	<div class="modify_panel am-u-lg-8 am-u-md-8 am-u-sm-centered am-g-collapse">
		                 <br/>
		                 <form action="" class="am-form" data-am-validator>
		                   <div class="am-form-group">
		                      <label for="old_password">旧密码：</label>
		                      <input  class="modify_input" type="password" id="old_password" name="old_password" minlength="6"
		                             placeholder="" required/>
		                    </div>
		                    <div class="am-form-group">
		                      <label for="new_password">密码：</label>
		                      <input class="modify_input"  type="password" id="new_password" name="new_password" placeholder="" minlength="6" required/>
		                    </div>
		
		                    <div class="am-form-group">
		                      <label for="confirm_new_password">确认密码：</label>
		                      <input class="modify_input" type="password" id="confirm_new_password" new="confirm_new_password" placeholder="" data-equal-to="#new_password" required/>
		                    </div>
		                    <br/>
		                    <div>
		                        <input type="submit" name="modify_password" value="修 改" class="am-btn am-btn-primary am-btn-sm modify_button am-fr">
		                    </div>
		                      <br/>
		                 </form>
		            </div>
			    </div>
			 
	       </div>     
      </div>
    </div>
  </div>


  <!-- content end -->

</div>
<%@ include file="footer.jsp" %>

</body>
</html>
