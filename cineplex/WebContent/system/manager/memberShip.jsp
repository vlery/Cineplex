<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="membershipVO" 
    type="net.cineplex.webmodel.stat.MembershipVO"
    scope="session">
</jsp:useBean>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">会员权限</strong> / <small>customer</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#memberShip">权限变更</a></li>
	          
	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="memberShip">
	               <br/>
                        <div class="am-u-sm-8 am-u-md-10 am-u-sm-centered">
                       		<table class="am-table am-table-striped am-table-hover">
                                  <tbody>
                                        
                                      	<tr>
                                            <td>新增人数</td>
                                            <td><jsp:getProperty name="membershipVO" property="start" /></td>
                                            
                                        </tr>
                                        <tr>
                                            <td>暂停人数</td>
                                            <td><jsp:getProperty name="membershipVO" property="pause" /></td>
                                            
                                        </tr>
                                        <tr>
                                            <td>注销人数</td>
                                            <td><jsp:getProperty name="membershipVO" property="cancel" /></td>
                                            
                                        </tr>
                                       
                                        
                                  </tbody>
                              </table>
                        </div>
			            <br/>
			            <br/>
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